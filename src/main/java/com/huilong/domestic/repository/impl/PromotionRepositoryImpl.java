package com.huilong.domestic.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huilong.domestic.dao.PromotionMapper;
import com.huilong.domestic.enums.ServiceType;
import com.huilong.domestic.enums.WebPageType;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.PromotionVO;
import com.huilong.domestic.service.domain.PromotionEntry;
import com.huilong.domestic.service.repository.PromotionRepository;
import com.huilong.domestic.table.PromotionTable;
import com.huilong.domestic.utils.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class PromotionRepositoryImpl implements PromotionRepository {
    private final PromotionMapper mapper;

    public PromotionRepositoryImpl(PromotionMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public XPage<List<PromotionVO>> promotionPageList(String name, ServiceType serviceType, WebPageType webPageType, LocalDateTime startDate, LocalDateTime endDate, long pageNumber, long pageSize) {
        LambdaQueryWrapper<PromotionTable> lambdaQuery = Wrappers.lambdaQuery(PromotionTable.class);
        assemblePromotionQuery(name, serviceType, webPageType, startDate, endDate, lambdaQuery);
        Page<PromotionTable> promotionTablePage = mapper.selectPage(new Page<>(pageNumber, pageSize), lambdaQuery);
        if (Objects.nonNull(promotionTablePage) && CollectionUtils.isNotEmpty(promotionTablePage.getRecords())) {
            List<PromotionVO> promotions = ListUtils.copyPropertiesToList(promotionTablePage.getRecords(), PromotionVO.class);
            return new XPage(promotions, promotionTablePage.getCurrent(), promotionTablePage.getSize(), promotionTablePage.getTotal());

        }
        return new XPage(null, pageNumber, pageSize, 0);
    }

    @Override
    public boolean save(PromotionEntry promotionEntry) {
        PromotionTable promotionTable = new PromotionTable();
        BeanUtils.copyProperties(promotionEntry, promotionTable);
        if (mapper.insert(promotionTable) == 1) {
            promotionEntry.setId(promotionTable.getId());
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(PromotionEntry promotionEntry) {
        PromotionTable promotionTable = new PromotionTable();
        BeanUtils.copyProperties(promotionEntry, promotionTable);
        if (mapper.updateById(promotionTable) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Optional<PromotionEntry> promotion(Long aId) {
        PromotionTable promotionTable = mapper.selectById(aId);
        if (Objects.nonNull(promotionTable)) {
            return Optional.of(new PromotionEntry(promotionTable.getId(), promotionTable.getName(), promotionTable.getTitle(), promotionTable.getContent(), promotionTable.getServiceType(), promotionTable.getPicUrl(), promotionTable.getWebPicUrl(), promotionTable.getAmount(), promotionTable.getWebPageType(), promotionTable.getWebPagePosition(), promotionTable.getStartTime(), promotionTable.getEndTime(), promotionTable.getCreateTime(), promotionTable.getUpdateTime()));
        }
        return Optional.empty();
    }

    private void assemblePromotionQuery(String name, ServiceType serviceType, WebPageType webPageType, LocalDateTime startDate, LocalDateTime endDate, LambdaQueryWrapper<PromotionTable> lambdaQuery) {
        if (StringUtils.isNotBlank(name)) {
            lambdaQuery.like(PromotionTable::getName, name);
        }
        if (Objects.nonNull(serviceType) && serviceType != ServiceType.NULL) {
            lambdaQuery.eq(PromotionTable::getServiceType, serviceType);
        }
        if (Objects.nonNull(webPageType) && webPageType != WebPageType.NULL) {
            lambdaQuery.eq(PromotionTable::getWebPageType, webPageType);
        }
        if (Objects.nonNull(startDate)) {
            lambdaQuery.ge(PromotionTable::getStartTime, startDate);
        }
        if (Objects.nonNull(endDate)) {
            lambdaQuery.le(PromotionTable::getStartTime, endDate);
        }
        lambdaQuery.orderByDesc(PromotionTable::getUpdateTime, PromotionTable::getUpdateTime);
    }
}
