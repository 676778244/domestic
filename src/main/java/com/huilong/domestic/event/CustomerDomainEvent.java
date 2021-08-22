package com.huilong.domestic.event;

import com.huilong.domestic.service.domain.CustomerEntry;
import lombok.Getter;

/**
 * @author yixiaodong
 */
@Getter
public class CustomerDomainEvent extends AbstractDomainEvent {
    public CustomerDomainEvent(Object source, CustomerEntry customerEntry) {
        super(source);
        this.customerEntry = customerEntry;
    }

    private final CustomerEntry customerEntry;

}
