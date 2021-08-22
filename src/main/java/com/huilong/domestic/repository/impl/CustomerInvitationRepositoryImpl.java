package com.huilong.domestic.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huilong.domestic.dao.CustomerInvitationMapper;
import com.huilong.domestic.dao.CustomerMapper;
import com.huilong.domestic.dao.PromotionMapper;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.CustomerInvitationVO;
import com.huilong.domestic.service.domain.CustomerInvitationEntry;
import com.huilong.domestic.service.repository.CustomerInvitationRepository;
import com.huilong.domestic.table.CustomerInvitationTable;
import com.huilong.domestic.table.CustomerTable;
import com.huilong.domestic.table.PromotionTable;
import com.huilong.domestic.table.virtual.CustomerInvitationExt;
import com.huilong.domestic.utils.ListUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerInvitationRepositoryImpl implements CustomerInvitationRepository {
    private final CustomerInvitationMapper mapper;
    private final CustomerMapper customerMapper;
    private final PromotionMapper promotionMapper;


    public CustomerInvitationRepositoryImpl(CustomerInvitationMapper mapper, CustomerMapper customerMapper,
                                            PromotionMapper promotionMapper) {
        this.mapper = mapper;
        this.customerMapper = customerMapper;
        this.promotionMapper = promotionMapper;
    }


    @Override
    public XPage<List<CustomerInvitationVO>> pageList(Long inviteId, String inviteNickName, String invitePhone,
                                                      Long beInvitedId, String beInvitedNickName, String beInvitedPhone,
                                                      LocalDateTime enteredTime, long pageNumber, long pageSize) {
        IPage<CustomerInvitationExt> customerInvitationExtIPage = mapper.customerInvitationPageList(
                new Page(pageNumber, pageSize),
                inviteId, inviteNickName, invitePhone, beInvitedId, beInvitedNickName, beInvitedPhone,
                Objects.nonNull(enteredTime) ? LocalDateTime.of(enteredTime.toLocalDate(), LocalTime.MIN) : null,
                Objects.nonNull(enteredTime) ? LocalDateTime.of(enteredTime.toLocalDate(), LocalTime.MAX) : null);
        if (Objects.nonNull(customerInvitationExtIPage) && CollectionUtils.isNotEmpty(customerInvitationExtIPage.getRecords())) {
            List<CustomerInvitationVO> customerInvitations = ListUtils.copyPropertiesToList(customerInvitationExtIPage.getRecords(), CustomerInvitationVO.class);
            List<CustomerTable> customerTables = customerList(customerInvitations);
            if (CollectionUtils.isNotEmpty(customerTables)) {
                customerInvitations.forEach(x -> {
                    customerTables.forEach(c -> {
                        PromotionTable promotionTable = promotionMapper.selectById(x.getActivityId());
                        x.setActivityName(promotionTable.getName());
                        if (x.getInviteId().compareTo(c.getId()) == 0) {
                            x.setInviteNickName(c.getNickName());
                            x.setInvitePhone(c.getPhone());
                        }
                        if (x.getBeInvitedId().compareTo(c.getId()) == 0) {
                            x.setBeInvitedNickName(c.getNickName());
                            x.setBeInvitedPhone(c.getPhone());
                        }
                    });
                });
            }
            return new XPage(customerInvitations, pageNumber, pageSize, customerInvitationExtIPage.getTotal());
        }
        return new XPage(Collections.EMPTY_LIST, pageNumber, pageSize, 0);
    }

    @Override
    public Optional<CustomerInvitationEntry> customerInvitationEntry(Long beInvitedId) {
        LambdaQueryWrapper<CustomerInvitationTable> lambdaQuery = Wrappers.lambdaQuery(CustomerInvitationTable.class);
        lambdaQuery.eq(CustomerInvitationTable::getBeInvitedId, beInvitedId);
        List<CustomerInvitationTable> customerInvitationTables = mapper.selectList(lambdaQuery);
        if (CollectionUtils.isNotEmpty(customerInvitationTables)) {
            CustomerInvitationTable customerInvitationTable = customerInvitationTables.get(0);
            return Optional.of(new CustomerInvitationEntry(customerInvitationTable.getId(), customerInvitationTable.getInviteId(), customerInvitationTable.getBeInvitedId(), customerInvitationTable.getEntered(), customerInvitationTable.getActivityId(), customerInvitationTable.getEnteredTime(), customerInvitationTable.getEnteredTime()));
        }
        return Optional.empty();
    }

    @Override
    public boolean updateInvitedActivity(CustomerInvitationEntry customerInvitationEntry) {
        CustomerInvitationTable customerInvitationTable = mapper.selectById(customerInvitationEntry.getId());
        customerInvitationTable.setActivityId(customerInvitationEntry.getActivityId());
        customerInvitationTable.setEntered(true);
        customerInvitationTable.setEnteredTime(customerInvitationEntry.getEnteredTime());
        return mapper.updateById(customerInvitationTable) == 1;
    }

    private List<CustomerTable> customerList(List<CustomerInvitationVO> customerInvitations) {
        List<Long> inviteIds = customerInvitations.stream().map(CustomerInvitationVO::getInviteId).collect(Collectors.toList());
        List<Long> beInvitedIds = customerInvitations.stream().map(CustomerInvitationVO::getBeInvitedId).collect(Collectors.toList());
        List<Long> customerIds = new ArrayList<>();
        customerIds.addAll(inviteIds);
        customerIds.addAll(beInvitedIds);
        return customerMapper.selectBatchIds(customerIds);
    }
}
