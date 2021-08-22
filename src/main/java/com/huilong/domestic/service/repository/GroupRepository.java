package com.huilong.domestic.service.repository;

import com.huilong.domestic.service.domain.GroupEntry;

import java.util.List;

public interface GroupRepository {
    boolean add(GroupEntry groupEntry);

    List<GroupEntry> salesmenGroups(Long aSalesmenId);

    boolean customerCountAdd(GroupEntry groupEntry);

    boolean changeRQCode(GroupEntry groupEntry);
}
