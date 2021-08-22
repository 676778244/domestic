package com.huilong.domestic.event;


import org.springframework.context.ApplicationContext;

/**
 * @author yixiaodong
 */
public class DefaultDomainEventPublisher implements IDomainEventPublisher {
    private final ApplicationContext applicationContext;

    public DefaultDomainEventPublisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public void publish(AbstractDomainEvent event) {
        this.applicationContext.publishEvent(event);
    }

}
