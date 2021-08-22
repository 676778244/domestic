package com.huilong.domestic.service;

import com.huilong.domestic.service.domain.GroupEntry;
import com.huilong.domestic.service.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository repository;

    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    public boolean add(GroupEntry groupEntry) {
        return groupEntry.add(repository);
    }

    public List<GroupEntry> salesmenGroups(Long aSalesmenId) {
        return repository.salesmenGroups(aSalesmenId);
    }

    public boolean customerCountAdd(GroupEntry groupEntry) {
        return groupEntry.customerCountAdd(repository);
    }

    public boolean changeRQCode(GroupEntry groupEntry){
        return groupEntry.changeRQCode(repository);
    }
}
