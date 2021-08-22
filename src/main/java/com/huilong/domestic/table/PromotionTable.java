package com.huilong.domestic.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.huilong.domestic.enums.ServiceType;
import com.huilong.domestic.enums.WebPagePosition;
import com.huilong.domestic.enums.WebPageType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 活动表
 *
 * @TableName hg_promotion
 */
@TableName(value = "hg_promotion")
public class PromotionTable implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动富文本内容
     */
    private String content;

    /**
     * 服务类型
     */
    private ServiceType serviceType;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 页面内图片地址
     */
    private String webPicUrl;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 页面类型
     */
    private WebPageType webPageType;

    /**
     * 页面位置
     */
    private WebPagePosition webPagePosition;

    /**
     * 活动开始时间
     */
    private LocalDateTime startTime;

    /**
     * 活动结束时间
     */
    private LocalDateTime endTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public Long getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 服务类型
     */
    public ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * 服务类型
     */
    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * 图片地址
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 图片地址
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 页面内图片地址
     */
    public String getWebPicUrl() {
        return webPicUrl;
    }

    /**
     * 页面内图片地址
     */
    public void setWebPicUrl(String webPicUrl) {
        this.webPicUrl = webPicUrl;
    }

    /**
     * 金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 页面类型
     */
    public WebPageType getWebPageType() {
        return webPageType;
    }

    /**
     * 页面类型
     */
    public void setWebPageType(WebPageType webPageType) {
        this.webPageType = webPageType;
    }

    /**
     * 页面位置
     */
    public WebPagePosition getWebPagePosition() {
        return webPagePosition;
    }

    /**
     * 页面位置
     */
    public void setWebPagePosition(WebPagePosition webPagePosition) {
        this.webPagePosition = webPagePosition;
    }

    /**
     * 活动开始时间
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * 活动开始时间
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * 活动结束时间
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * 活动结束时间
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PromotionTable other = (PromotionTable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
                && (this.getServiceType() == null ? other.getServiceType() == null : this.getServiceType().equals(other.getServiceType()))
                && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
                && (this.getWebPicUrl() == null ? other.getWebPicUrl() == null : this.getWebPicUrl().equals(other.getWebPicUrl()))
                && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
                && (this.getWebPageType() == null ? other.getWebPageType() == null : this.getWebPageType().equals(other.getWebPageType()))
                && (this.getWebPagePosition() == null ? other.getWebPagePosition() == null : this.getWebPagePosition().equals(other.getWebPagePosition()))
                && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
                && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getServiceType() == null) ? 0 : getServiceType().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getWebPicUrl() == null) ? 0 : getWebPicUrl().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getWebPageType() == null) ? 0 : getWebPageType().hashCode());
        result = prime * result + ((getWebPagePosition() == null) ? 0 : getWebPagePosition().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", webPicUrl=").append(webPicUrl);
        sb.append(", amount=").append(amount);
        sb.append(", webPageType=").append(webPageType);
        sb.append(", webPagePosition=").append(webPagePosition);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}