package com.huilong.domestic.event;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author yixiaodong
 */
public abstract class AbstractDomainEvent extends ApplicationEvent {
    protected AbstractDomainEvent(Object source) {
        super(source);
    }

    public long getTimeSec(){
        return this.getTimestamp()/1000;
    }
}
