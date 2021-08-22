package com.huilong.domestic.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.huilong.domestic.dao.SalesmenCustomerGroupMapper;
import com.huilong.domestic.event.CustomerDomainEvent;
import com.huilong.domestic.service.domain.CustomerEntry;
import com.huilong.domestic.service.domain.GroupEntry;
import com.huilong.domestic.service.domain.SalesmenEntry;
import com.huilong.domestic.table.SalesmenCustomerGroupTable;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerAddEventTrigger {
    private final SalesmenService salesmenService;

    private final GroupService groupService;

    private final SalesmenCustomerGroupMapper salesmenCustomerGroupMapper;

    public CustomerAddEventTrigger(SalesmenService salesmenService, GroupService groupService, SalesmenCustomerGroupMapper salesmenCustomerGroupMapper) {
        this.salesmenService = salesmenService;
        this.groupService = groupService;
        this.salesmenCustomerGroupMapper = salesmenCustomerGroupMapper;
    }

    @EventListener(CustomerDomainEvent.class)
    public void handleAdmissionApplyEventDealAttachment(CustomerDomainEvent customerDomainEvent) {
        CustomerEntry customerEntry = customerDomainEvent.getCustomerEntry();
        List<SalesmenEntry> salesmenEntries = salesmenService.salesmenList();
        if (CollectionUtils.isNotEmpty(salesmenEntries)) {
            List<SalesmenEntry> notCoverSalesmenEntries = new ArrayList<>();
            List<SalesmenEntry> coverSalesmenEntries = new ArrayList<>();

            for (SalesmenEntry x : salesmenEntries) {
                if (x.getCover()) {
                    coverSalesmenEntries.add(x);
                } else {
                    notCoverSalesmenEntries.add(x);
                }
            }
            notCoverSalesmenEntries.sort(Comparator.comparing(SalesmenEntry::getCreateTime));

            boolean customerCountAddResult = false;
            for (SalesmenEntry notCoverSalesmen : notCoverSalesmenEntries) {
                List<GroupEntry> groupEntries = groupService.salesmenGroups(notCoverSalesmen.getId());
                groupEntries.sort(Comparator.comparing(GroupEntry::getCreateTime));
                for (GroupEntry groupEntry : groupEntries) {
                    if (groupEntry.getCustomerCount() < GroupEntry.GROUP_LIMIT) {
                        customerCountAddResult = distributionGroup(customerEntry, notCoverSalesmen, groupEntry);
                    }
                }
                if (customerCountAddResult) {
                    return;
                }
            }
            //随便找一个兜底老师
            SalesmenEntry salesmenEntryRandom = coverSalesmenEntries.stream().findAny().get();
            List<GroupEntry> groupEntries = groupService.salesmenGroups(salesmenEntryRandom.getId());
            //随便找一个兜底老师的班级
            GroupEntry groupEntryAny = groupEntries.stream().findAny().get();
            distributionGroup(customerEntry, salesmenEntryRandom, groupEntryAny);

        }
    }

    private boolean distributionGroup(CustomerEntry customerEntry, SalesmenEntry notCoverSalesmen, GroupEntry groupEntry) {
        boolean customerCountAddResult = groupService.customerCountAdd(groupEntry);
        int tryTime = 0;
        while (tryTime < 10 && !customerCountAddResult) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customerCountAddResult = groupService.customerCountAdd(groupEntry);
            tryTime++;
        }
        SalesmenCustomerGroupTable salesmenCustomerGroupTable = new SalesmenCustomerGroupTable();
        salesmenCustomerGroupTable.setCustomerId(customerEntry.getId());
        salesmenCustomerGroupTable.setGroupId(groupEntry.getId());
        salesmenCustomerGroupTable.setSalesmenId(notCoverSalesmen.getId());
        salesmenCustomerGroupMapper.insert(salesmenCustomerGroupTable);
        return customerCountAddResult;
    }
}
