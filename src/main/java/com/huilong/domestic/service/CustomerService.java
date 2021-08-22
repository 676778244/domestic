package com.huilong.domestic.service;

import com.huilong.domestic.enums.Gender;
import com.huilong.domestic.event.IDomainEventPublisher;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.CustomerVO;
import com.huilong.domestic.service.domain.CustomerEntry;
import com.huilong.domestic.service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    private final IDomainEventPublisher publisher;

    public CustomerService(CustomerRepository repository, IDomainEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public Boolean register(CustomerEntry customerEntry) {
        return customerEntry.register(repository, publisher);
    }

    public Boolean edit(CustomerEntry customerEntry) {
        return customerEntry.edit(repository);
    }

    public Optional<CustomerEntry> customer(Long id) {
        return CustomerEntry.customer(id, repository);
    }

    public XPage<List<CustomerVO>> pageList(Long id, String nickName, String phone, Gender gender, long pageNumber, long pageSize) {
        return repository.pageList(id, nickName, phone, gender, pageNumber, pageSize);
    }

}
