package com.huilong.domestic.service;

import com.huilong.domestic.event.SalesmenAddDomainEvent;
import com.huilong.domestic.service.domain.GroupEntry;
import com.huilong.domestic.service.domain.SalesmenEntry;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

import static com.huilong.domestic.service.domain.GroupEntry.GROUP_LIMIT;
import static com.huilong.domestic.service.domain.GroupEntry.GROUP_NOT_LIMIT;

public class SalesmenAddEventTrigger {
    private final GroupService groupService;


    public SalesmenAddEventTrigger(GroupService groupService) {
        this.groupService = groupService;
    }

    @EventListener(SalesmenAddDomainEvent.class)
    public void handleAdmissionApplyEventDealAttachment(SalesmenAddDomainEvent salesmenAddDomainEvent) {
        SalesmenEntry salesmenEntry = salesmenAddDomainEvent.getSalesmenEntry();
        groupService.add(new GroupEntry(null, salesmenEntry.getId(), salesmenEntry.getRqCode1(), 0, 1, salesmenEntry.getCover() ? GROUP_NOT_LIMIT : GROUP_LIMIT, LocalDateTime.now()));
        groupService.add(new GroupEntry(null, salesmenEntry.getId(), salesmenEntry.getRqCode2(), 0, 1, salesmenEntry.getCover() ? GROUP_NOT_LIMIT : GROUP_LIMIT, LocalDateTime.now()));
        groupService.add(new GroupEntry(null, salesmenEntry.getId(), salesmenEntry.getRqCode3(), 0, 1, salesmenEntry.getCover() ? GROUP_NOT_LIMIT : GROUP_LIMIT, LocalDateTime.now()));

    }
}
