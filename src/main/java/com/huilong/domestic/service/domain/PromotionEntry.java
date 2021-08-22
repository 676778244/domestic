package com.huilong.domestic.service.domain;

import com.huilong.domestic.enums.ServiceType;
import com.huilong.domestic.enums.WebPagePosition;
import com.huilong.domestic.enums.WebPageType;
import com.huilong.domestic.service.repository.PromotionRepository;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
public class PromotionEntry {
    public PromotionEntry(Long id, String name, String title, String content, ServiceType serviceType, String picUrl, String webPicUrl, BigDecimal amount, WebPageType webPageType, WebPagePosition webPagePosition, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.serviceType = serviceType;
        this.picUrl = picUrl;
        this.webPicUrl = webPicUrl;
        this.amount = amount;
        this.webPageType = webPageType;
        this.webPagePosition = webPagePosition;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    /**
     * 活动名称
     */
    private final String name;

    /**
     * 活动标题
     */
    private final String title;

    /**
     * 活动富文本内容
     */
    private final String content;

    /**
     * 服务类型
     */
    private final ServiceType serviceType;
    /**
     * 图片地址
     */
    private final String picUrl;
    /**
     * 页面内图片地址
     */
    private final String webPicUrl;
    /**
     * 金额
     */
    private final BigDecimal amount;
    /**
     * 页面类型
     */
    private final WebPageType webPageType;
    /**
     * 页面位置
     */
    private final WebPagePosition webPagePosition;
    /**
     * 开始时间
     */
    private final LocalDateTime startDate;
    /**
     * 结束时间
     */
    private final LocalDateTime endDate;
    /**
     * 创建时间
     */
    private final LocalDateTime createTime;
    /**
     * 更新时间
     */
    private final LocalDateTime updateTime;

    public boolean add(PromotionRepository repository){
        return repository.save(this);
    }

    public boolean edit(PromotionRepository repository){
        return repository.edit(this);
    }

    public static Optional<PromotionEntry> PromotionEntry(Long aId, PromotionRepository repository){
        return repository.promotion(aId);
    }
}
