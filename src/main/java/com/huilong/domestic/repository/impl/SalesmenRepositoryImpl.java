package com.huilong.domestic.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huilong.domestic.dao.SalesmenMapper;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.CustomerVO;
import com.huilong.domestic.model.output.SalesmenVO;
import com.huilong.domestic.service.domain.SalesmenEntry;
import com.huilong.domestic.service.repository.SalesmenRepository;
import com.huilong.domestic.table.CustomerTable;
import com.huilong.domestic.table.SalesmenTable;
import com.huilong.domestic.utils.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class SalesmenRepositoryImpl implements SalesmenRepository {
    private final SalesmenMapper mapper;

    public SalesmenRepositoryImpl(SalesmenMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean save(SalesmenEntry salesmenEntry) {
        SalesmenTable salesmenTable = new SalesmenTable();
        BeanUtils.copyProperties(salesmenEntry, salesmenTable);
        if (mapper.insert(salesmenTable) == 1) {
            salesmenEntry.setId(salesmenTable.getId());
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(SalesmenEntry salesmenEntry) {
        SalesmenTable salesmenTable = new SalesmenTable();
        BeanUtils.copyProperties(salesmenEntry, salesmenTable);
        if (mapper.updateById(salesmenTable) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRQCode(SalesmenEntry salesmenEntry) {
        return edit(salesmenEntry);
    }

    @Override
    public Optional<SalesmenEntry> salesmenEntry(Long id) {
        SalesmenTable salesmenTable = mapper.selectById(id);
        if (Objects.nonNull(salesmenTable)) {
            return Optional.of(new SalesmenEntry(salesmenTable.getId(), salesmenTable.getNickName(), salesmenTable.getPhone(), salesmenTable.getRqCode1(), salesmenTable.getRqCode2(), salesmenTable.getRqCode3(), salesmenTable.getCover(), salesmenTable.getServiceType(), salesmenTable.getCreateTime(), salesmenTable.getUpdateTime()));
        }
        return Optional.empty();
    }

    @Override
    public XPage<List<SalesmenVO>> salesmenPageList(Long id, String nickName, String phone, Boolean cover, long pageNumber, long pageSize) {
        LambdaQueryWrapper<SalesmenTable> lambdaQuery = Wrappers.lambdaQuery(SalesmenTable.class);
        assembleSalesmenQuery(id, nickName, phone, cover, lambdaQuery);
        Page<SalesmenTable> salesmenTablePage = mapper.selectPage(new Page<SalesmenTable>(pageNumber, pageSize), lambdaQuery);
        if (Objects.nonNull(salesmenTablePage) && CollectionUtils.isNotEmpty(salesmenTablePage.getRecords())) {
            List<SalesmenVO> salesmenVOS = ListUtils.copyPropertiesToList(salesmenTablePage.getRecords(), SalesmenVO.class);
            return new XPage(salesmenVOS, salesmenTablePage.getCurrent(), salesmenTablePage.getSize(), salesmenTablePage.getTotal());

        }
        return new XPage(null, pageNumber, pageSize, 0);
    }

    @Override
    public List<SalesmenEntry> salesmenList() {
        LambdaQueryWrapper<SalesmenTable> lambdaQuery = Wrappers.lambdaQuery(SalesmenTable.class);
        List<SalesmenTable> salesmenTables = mapper.selectList(lambdaQuery);
        if (CollectionUtils.isNotEmpty(salesmenTables)) {
            return ListUtils.copyPropertiesToList(salesmenTables, SalesmenEntry.class);
        }
        return Collections.EMPTY_LIST;
    }

    private void assembleSalesmenQuery(Long id, String nickName, String phone, Boolean cover, LambdaQueryWrapper<SalesmenTable> lambdaQuery) {
        if (Objects.nonNull(id)) {
            lambdaQuery.eq(SalesmenTable::getId, id);
        }
        if (StringUtils.isNotBlank(nickName)) {
            lambdaQuery.like(SalesmenTable::getNickName, nickName);
        }
        if (StringUtils.isNotBlank(phone)) {
            lambdaQuery.like(SalesmenTable::getPhone, phone);
        }
        if (Objects.nonNull(cover)) {
            lambdaQuery.eq(SalesmenTable::getCover, cover);
        }
    }
}
