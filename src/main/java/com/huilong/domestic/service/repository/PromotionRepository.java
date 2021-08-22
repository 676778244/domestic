package com.huilong.domestic.service.repository;

import com.huilong.domestic.enums.ServiceType;
import com.huilong.domestic.enums.WebPageType;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.PromotionVO;
import com.huilong.domestic.service.domain.PromotionEntry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository {
    XPage<List<PromotionVO>> promotionPageList(String name, ServiceType serviceType, WebPageType webPageType, LocalDateTime startDate, LocalDateTime endDate, long pageNumber, long pageSize);

    boolean save(PromotionEntry promotionEntry);

    boolean edit(PromotionEntry promotionEntry);


    Optional<PromotionEntry> promotion(Long aId);
}
