package com.huilong.domestic.event;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yixiaodong
 */
@Configuration
public class DomainEventPublisherConfiguration {
    private final ApplicationContext applicationContext;

    public DomainEventPublisherConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    @ConditionalOnMissingBean(IDomainEventPublisher.class)
    public IDomainEventPublisher defaultStorageDomainEventPublisher(){
        return new DefaultDomainEventPublisher(applicationContext);
    }
}
