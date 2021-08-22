package com.huilong.domestic.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 客户邀请关系表
 * @TableName hg_customer_invitation
 */
@TableName(value ="hg_customer_invitation")
public class CustomerInvitationTable implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 邀请人ID
     */
    private Long inviteId;

    /**
     * 被邀请人ID
     */
    private Long beInvitedId;

    /**
     * 是否报名
     */
    private Boolean entered;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 报名时间
     */
    private LocalDateTime enteredTime;

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

    /**
     * 邀请人ID
     */
    public Long getInviteId() {
        return inviteId;
    }

    /**
     * 邀请人ID
     */
    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    /**
     * 被邀请人ID
     */
    public Long getBeInvitedId() {
        return beInvitedId;
    }

    /**
     * 被邀请人ID
     */
    public void setBeInvitedId(Long beInvitedId) {
        this.beInvitedId = beInvitedId;
    }

    /**
     * 是否报名
     */
    public Boolean getEntered() {
        return entered;
    }

    /**
     * 是否报名
     */
    public void setEntered(Boolean entered) {
        this.entered = entered;
    }

    /**
     * 活动ID
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 活动ID
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 报名时间
     */
    public LocalDateTime getEnteredTime() {
        return enteredTime;
    }

    /**
     * 报名时间
     */
    public void setEnteredTime(LocalDateTime enteredTime) {
        this.enteredTime = enteredTime;
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
        CustomerInvitationTable other = (CustomerInvitationTable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInviteId() == null ? other.getInviteId() == null : this.getInviteId().equals(other.getInviteId()))
            && (this.getBeInvitedId() == null ? other.getBeInvitedId() == null : this.getBeInvitedId().equals(other.getBeInvitedId()))
            && (this.getEntered() == null ? other.getEntered() == null : this.getEntered().equals(other.getEntered()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEnteredTime() == null ? other.getEntered() == null : this.getEnteredTime().equals(other.getEnteredTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInviteId() == null) ? 0 : getInviteId().hashCode());
        result = prime * result + ((getBeInvitedId() == null) ? 0 : getBeInvitedId().hashCode());
        result = prime * result + ((getEntered() == null) ? 0 : getEntered().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEnteredTime() == null) ? 0 : getEnteredTime().hashCode());
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
        sb.append(", inviteId=").append(inviteId);
        sb.append(", beInvitedId=").append(beInvitedId);
        sb.append(", entered=").append(entered);
        sb.append(", activityId=").append(activityId);
        sb.append(", phone=").append(phone);
        sb.append(", enteredTime=").append(enteredTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}