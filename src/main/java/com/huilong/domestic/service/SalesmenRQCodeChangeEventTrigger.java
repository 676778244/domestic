package com.huilong.domestic.service;

import com.huilong.domestic.event.SalesmenRQCodeChangeDomainEvent;
import com.huilong.domestic.service.domain.GroupEntry;
import com.huilong.domestic.service.domain.SalesmenEntry;
import org.springframework.context.event.EventListener;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SalesmenRQCodeChangeEventTrigger {
    private final GroupService groupService;
    private final SalesmenService salesmenService;


    public SalesmenRQCodeChangeEventTrigger(GroupService groupService, SalesmenService salesmenService) {
        this.groupService = groupService;
        this.salesmenService = salesmenService;
    }

    @EventListener(SalesmenRQCodeChangeDomainEvent.class)
    public void handleAdmissionApplyEventDealAttachment(SalesmenRQCodeChangeDomainEvent salesmenRQCodeChangeDomainEvent) {
        Long aSalesmenId = salesmenRQCodeChangeDomainEvent.getSalesmenEntry().getId();
        Optional<SalesmenEntry> salesmenEntryOptional = salesmenService.salesmenEntry(aSalesmenId);
        String rqCode1 = salesmenEntryOptional.get().getRqCode1();
        String rqCode2 = salesmenEntryOptional.get().getRqCode2();
        String rqCode3 = salesmenEntryOptional.get().getRqCode3();
        List<GroupEntry> groupEntries = groupService.salesmenGroups(aSalesmenId);
        groupEntries.sort(Comparator.comparing(GroupEntry::getCreateTime));
        GroupEntry groupEntry1 = groupEntries.get(0);
        GroupEntry groupEntry2 = groupEntries.get(1);
        GroupEntry groupEntry3 = groupEntries.get(2);

        groupService.changeRQCode(new GroupEntry(groupEntry1.getId(), groupEntry1.getSalesmenId(), rqCode1,
                groupEntry1.getCustomerCount(), groupEntry1.getVersion(), groupEntry1.getLimit(), groupEntry1.getCreateTime()));
        groupService.changeRQCode(new GroupEntry(groupEntry2.getId(), groupEntry2.getSalesmenId(), rqCode2,
                groupEntry2.getCustomerCount(), groupEntry2.getVersion(), groupEntry2.getLimit(), groupEntry2.getCreateTime()));
        groupService.changeRQCode(new GroupEntry(groupEntry3.getId(), groupEntry3.getSalesmenId(), rqCode3,
                groupEntry3.getCustomerCount(), groupEntry3.getVersion(), groupEntry3.getLimit(), groupEntry3.getCreateTime()));


    }
}
