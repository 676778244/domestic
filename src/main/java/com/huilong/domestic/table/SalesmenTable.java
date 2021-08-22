package com.huilong.domestic.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.huilong.domestic.enums.ServiceType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 销售人员表
 * @TableName hg_salesmen
 */
@TableName(value ="hg_salesmen")
public class SalesmenTable implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 二维码1
     */
    private String rqCode1;

    /**
     * 二维码2
     */
    private String rqCode2;

    /**
     * 二维码3
     */
    private String rqCode3;

    /**
     * 服务类型
     */
    private ServiceType serviceType;

    /**
     * 是否兜底老师
     */
    private boolean cover;

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
     * 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
     * 二维码1
     */
    public String getRqCode1() {
        return rqCode1;
    }

    /**
     * 二维码1
     */
    public void setRqCode1(String rqCode1) {
        this.rqCode1 = rqCode1;
    }

    /**
     * 二维码2
     */
    public String getRqCode2() {
        return rqCode2;
    }

    /**
     * 二维码2
     */
    public void setRqCode2(String rqCode2) {
        this.rqCode2 = rqCode2;
    }

    /**
     * 二维码3
     */
    public String getRqCode3() {
        return rqCode3;
    }

    /**
     * 二维码3
     */
    public void setRqCode3(String rqCode3) {
        this.rqCode3 = rqCode3;
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

    public Boolean getCover() {
        return cover;
    }

    public void setCover(Boolean cover) {
        this.cover = cover;
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
        SalesmenTable other = (SalesmenTable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getRqCode1() == null ? other.getRqCode1() == null : this.getRqCode1().equals(other.getRqCode1()))
            && (this.getRqCode2() == null ? other.getRqCode2() == null : this.getRqCode2().equals(other.getRqCode2()))
            && (this.getRqCode3() == null ? other.getRqCode3() == null : this.getRqCode3().equals(other.getRqCode3()))
            && (this.getServiceType() == null ? other.getServiceType() == null : this.getServiceType().equals(other.getServiceType()))
            && (this.getCover()? other.getCover() : this.getCover()&&other.getCover())
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getRqCode1() == null) ? 0 : getRqCode1().hashCode());
        result = prime * result + ((getRqCode2() == null) ? 0 : getRqCode2().hashCode());
        result = prime * result + ((getRqCode3() == null) ? 0 : getRqCode3().hashCode());
        result = prime * result + ((getServiceType() == null) ? 0 : getServiceType().hashCode());
        result = prime * result + ((getCover()) ? 0 : getCover().hashCode());
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
        sb.append(", nickName=").append(nickName);
        sb.append(", phone=").append(phone);
        sb.append(", rqCode1=").append(rqCode1);
        sb.append(", rqCode2=").append(rqCode2);
        sb.append(", rqCode3=").append(rqCode3);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", cover=").append(cover);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}