package com.huilong.domestic.service;

import com.huilong.domestic.event.IDomainEventPublisher;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.SalesmenVO;
import com.huilong.domestic.service.domain.SalesmenEntry;
import com.huilong.domestic.service.repository.SalesmenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesmenService {
    private final SalesmenRepository repository;
    private final IDomainEventPublisher publisher;

    public SalesmenService(SalesmenRepository repository, IDomainEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public XPage<List<SalesmenVO>> salesmenPageList(Long id, String nickName, String phone, Boolean cover, long pageNumber, long pageSize) {
        return repository.salesmenPageList(id, nickName, phone, cover, pageNumber, pageSize);
    }

    public List<SalesmenEntry> salesmenList(){
        return repository.salesmenList();
    }
    public boolean add(SalesmenEntry salesmenEntry) {
        return salesmenEntry.add(repository,publisher);
    }

    public boolean edit(SalesmenEntry salesmenEntry) {
        return repository.edit(salesmenEntry);
    }


    public Optional<SalesmenEntry> salesmenEntry(Long aId) {
        return SalesmenEntry.SalesmenEntry(aId,repository);
    }

    public boolean changeRQCode(Long aId,String RQCode1,String RQCode2,String RQCode3) {
        Optional<SalesmenEntry> salesmenEntry = SalesmenEntry.SalesmenEntry(aId, repository);
        if(salesmenEntry.isPresent()){
            return salesmenEntry.get().changeRQCode(RQCode1,RQCode2,RQCode3,repository);
        }
        return false;
    }
}
