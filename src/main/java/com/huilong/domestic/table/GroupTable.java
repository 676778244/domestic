package com.huilong.domestic.table;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.api.R;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 班级表
 * @TableName hg_group
 */
@TableName(value ="hg_group")
public class GroupTable implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 销售人员ID
     */
    private Long salesmenId;

    /**
     * 销售人员二维码
     */
    private String RQCode;

    /**
     * 客户数量
     */
    private Integer customerCount;

    /**
     * 分组上限
     */
    private Integer groupLimit;

    /**
     * 更新版本
     */
    private Integer version;

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
     * 销售人员ID
     */
    public Long getSalesmenId() {
        return salesmenId;
    }

    /**
     * 销售人员ID
     */
    public void setSalesmenId(Long salesmenId) {
        this.salesmenId = salesmenId;
    }

    public String getRQCode() {
        return RQCode;
    }

    public void setRQCode(String RQCode) {
        this.RQCode = RQCode;
    }

    /**
     * 客户数量
     */
    public Integer getCustomerCount() {
        return customerCount;
    }

    /**
     * 客户数量
     */
    public void setCustomerCount(Integer customerCount) {
        this.customerCount = customerCount;
    }

    /**
     * 分组上限
     */
    public Integer getGroupLimit() {
        return groupLimit;
    }

    /**
     * 分组上限
     */
    public void setGroupLimit(Integer groupLimit) {
        this.groupLimit = groupLimit;
    }

    /**
     * 更新版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 更新版本
     */
    public void setVersion(Integer version) {
        this.version = version;
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
        GroupTable other = (GroupTable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSalesmenId() == null ? other.getSalesmenId() == null : this.getSalesmenId().equals(other.getSalesmenId()))
            && (this.getRQCode() == null ? other.getRQCode() == null : this.getRQCode().equals(other.getRQCode()))
            && (this.getCustomerCount() == null ? other.getCustomerCount() == null : this.getCustomerCount().equals(other.getCustomerCount()))
            && (this.getGroupLimit() == null ? other.getGroupLimit() == null : this.getGroupLimit().equals(other.getGroupLimit()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSalesmenId() == null) ? 0 : getSalesmenId().hashCode());
        result = prime * result + ((getRQCode() == null) ? 0 : getRQCode().hashCode());
        result = prime * result + ((getCustomerCount() == null) ? 0 : getCustomerCount().hashCode());
        result = prime * result + ((getGroupLimit() == null) ? 0 : getGroupLimit().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
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
        sb.append(", salesmenId=").append(salesmenId);
        sb.append(", RQCode=").append(RQCode);
        sb.append(", customerCount=").append(customerCount);
        sb.append(", groupLimit=").append(groupLimit);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}