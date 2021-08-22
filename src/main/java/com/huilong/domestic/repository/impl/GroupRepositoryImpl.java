package com.huilong.domestic.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.huilong.domestic.dao.GroupMapper;
import com.huilong.domestic.service.domain.GroupEntry;
import com.huilong.domestic.service.repository.GroupRepository;
import com.huilong.domestic.table.GroupTable;
import com.huilong.domestic.utils.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupRepositoryImpl implements GroupRepository {
    private final GroupMapper groupMapper;

    public GroupRepositoryImpl(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @Override
    public boolean add(GroupEntry groupEntry) {
        GroupTable groupTable = new GroupTable();
        BeanUtils.copyProperties(groupEntry, groupTable);
        if (groupMapper.insert(groupTable) == 1) {
            groupEntry.setId(groupTable.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<GroupEntry> salesmenGroups(Long aSalesmenId) {
        List<GroupEntry> groupEntries = new ArrayList();
        LambdaQueryWrapper<GroupTable> lambdaQuery = Wrappers.lambdaQuery(GroupTable.class);
        lambdaQuery.eq(GroupTable::getSalesmenId, aSalesmenId);
        groupMapper.selectList(lambdaQuery).forEach(x -> groupEntries.add(new GroupEntry(x.getId(), x.getSalesmenId(), x.getRQCode(), x.getCustomerCount(), x.getVersion(), x.getGroupLimit(), x.getCreateTime())));
        return groupEntries;
    }

    @Override
    public boolean customerCountAdd(GroupEntry groupEntry) {
        GroupTable groupTable = groupMapper.selectById(groupEntry.getId());
        LambdaUpdateWrapper<GroupTable> lambdaQuery = Wrappers.lambdaUpdate(GroupTable.class);
        lambdaQuery.eq(GroupTable::getId, groupEntry.getId());
        lambdaQuery.eq(GroupTable::getVersion, groupTable.getVersion());
        lambdaQuery.le(GroupTable::getCustomerCount, groupEntry.getLimit());
        groupTable.setCustomerCount(groupTable.getCustomerCount() + 1);
        groupTable.setVersion(groupTable.getVersion() + 1);
        return groupMapper.update(groupTable, lambdaQuery) == 1;
    }

    @Override
    public boolean changeRQCode(GroupEntry groupEntry) {
        GroupTable groupTable = groupMapper.selectById(groupEntry.getId());
        groupTable.setRQCode(groupEntry.getRQCode());
        return groupMapper.updateById(groupTable) == 1;
    }
}
