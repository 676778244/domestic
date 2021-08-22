package com.huilong.domestic.table;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 销售客户班级表
 * @TableName hg_rf_salesmen_customer_group
 */
@TableName(value ="hg_rf_salesmen_customer_group")
public class SalesmenCustomerGroupTable implements Serializable {
    /**
     * 
     */
    private Long salesmenId;

    /**
     * 
     */
    private Long customerId;

    /**
     * 
     */
    private Long groupId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getSalesmenId() {
        return salesmenId;
    }

    /**
     * 
     */
    public void setSalesmenId(Long salesmenId) {
        this.salesmenId = salesmenId;
    }

    /**
     * 
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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
        SalesmenCustomerGroupTable other = (SalesmenCustomerGroupTable) that;
        return (this.getSalesmenId() == null ? other.getSalesmenId() == null : this.getSalesmenId().equals(other.getSalesmenId()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSalesmenId() == null) ? 0 : getSalesmenId().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", salesmenId=").append(salesmenId);
        sb.append(", customerId=").append(customerId);
        sb.append(", groupId=").append(groupId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}