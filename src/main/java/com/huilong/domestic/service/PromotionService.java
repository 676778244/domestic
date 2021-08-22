package com.huilong.domestic.service;

import com.huilong.domestic.enums.ServiceType;
import com.huilong.domestic.enums.WebPageType;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.PromotionVO;
import com.huilong.domestic.service.domain.PromotionEntry;
import com.huilong.domestic.service.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {
    private final PromotionRepository repository;

    public PromotionService(PromotionRepository repository) {
        this.repository = repository;
    }

    public XPage<List<PromotionVO>> promotionPageList(String name, ServiceType serviceType, WebPageType webPageType, LocalDateTime startDate, LocalDateTime endDate, long pageNumber, long pageSize) {
        return repository.promotionPageList(name, serviceType, webPageType, startDate, endDate, pageNumber, pageSize);
    }

    public Boolean add(PromotionEntry promotionEntry){
        return repository.save(promotionEntry);
    }

    public Boolean edit(PromotionEntry promotionEntry){
        return repository.edit(promotionEntry);
    }

    public Optional<PromotionEntry> promotion(Long aId){
        return repository.promotion(aId);
    }
}
