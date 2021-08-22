package com.huilong.domestic.event;

import com.huilong.domestic.service.domain.SalesmenEntry;
import lombok.Getter;

/**
 * @author yixiaodong
 */
@Getter
public class SalesmenRQCodeChangeDomainEvent extends AbstractDomainEvent {
    public SalesmenRQCodeChangeDomainEvent(Object source, SalesmenEntry salesmenEntry) {
        super(source);
        this.salesmenEntry = salesmenEntry;
    }

    private final SalesmenEntry salesmenEntry;

}
