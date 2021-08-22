package com.huilong.domestic.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huilong.domestic.dao.CustomerMapper;
import com.huilong.domestic.enums.Gender;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.CustomerVO;
import com.huilong.domestic.service.domain.CustomerEntry;
import com.huilong.domestic.service.repository.CustomerRepository;
import com.huilong.domestic.table.CustomerTable;
import com.huilong.domestic.utils.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerMapper customerMapper;

    public CustomerRepositoryImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public boolean save(CustomerEntry customerEntry) {
        CustomerTable customerTable = new CustomerTable();
        BeanUtils.copyProperties(customerEntry, customerTable);
        if (customerMapper.insert(customerTable) == 1) {
            customerEntry.setId(customerTable.getId());
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(CustomerEntry customerEntry) {
        CustomerTable customerTable = new CustomerTable();
        BeanUtils.copyProperties(customerEntry, customerTable);
        return customerMapper.updateById(customerTable) == 1;
    }

    @Override
    public Optional<CustomerEntry> customer(Long id) {
        CustomerTable customerTable = customerMapper.selectById(id);
        if (Objects.nonNull(customerTable)) {
            return Optional.of(new CustomerEntry(customerTable.getId(), customerTable.getUnionId(), customerTable.getOpenId(), customerTable.getNickName(), customerTable.getHeadImg(), customerTable.getCity(), customerTable.getProvince(), customerTable.getGender(), customerTable.getAge(), customerTable.getPhone(), customerTable.getPullTime(), customerTable.getCreateTime(), customerTable.getUpdateTime()));

        }
        return Optional.empty();
    }

    @Override
    public XPage<List<CustomerVO>> pageList(Long id, String nickName, String phone, Gender gender, long pageNumber, long pageSize) {
        LambdaQueryWrapper<CustomerTable> lambdaQuery = Wrappers.lambdaQuery(CustomerTable.class);
        assembleCustomerQuery(lambdaQuery, id, nickName, phone, gender);
        Page<CustomerTable> customerTablePage = customerMapper.selectPage(new Page<>(pageNumber, pageSize), lambdaQuery);
        if (Objects.nonNull(customerTablePage) && CollectionUtils.isNotEmpty(customerTablePage.getRecords())) {
            List<CustomerVO> customerVOS = ListUtils.copyPropertiesToList(customerTablePage.getRecords(), CustomerVO.class);
            return new XPage(customerVOS, customerTablePage.getCurrent(), customerTablePage.getSize(), customerTablePage.getTotal());
        }
        return new XPage(null, pageNumber, pageSize, 0);
    }

    private void assembleCustomerQuery(LambdaQueryWrapper<CustomerTable> lambdaQuery, Long id, String nickName, String phone, Gender gender) {
        if (Objects.nonNull(id)) {
            lambdaQuery.eq(CustomerTable::getId, id);
        }
        if (StringUtils.isNotBlank(nickName)) {
            lambdaQuery.like(CustomerTable::getNickName, nickName);
        }
        if (StringUtils.isNotBlank(phone)) {
            lambdaQuery.like(CustomerTable::getPhone, phone);
        }
        if (Objects.nonNull(gender) && gender != Gender.NULL) {
            lambdaQuery.eq(CustomerTable::getGender, gender);
        }
        lambdaQuery.orderByDesc(CustomerTable::getUpdateTime, CustomerTable::getUpdateTime);
    }
}
