package com.huilong.domestic.event;

/**
 * @author yixiaodong
 */
public interface IDomainEventPublisher {
    /**
     * 发布事件
     * @param event
     */
     void publish(AbstractDomainEvent event);
}
