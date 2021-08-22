package com.huilong.domestic.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.huilong.domestic.enums.Gender;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 客户表
 *
 * @TableName hg_customer
 */
@TableName(value = "hg_customer")
public class CustomerTable implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 微信unionId
     */
    private String unionId;

    /**
     * 微信openId
     */
    private String openId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 市
     */
    private String city;

    /**
     * 省
     */
    private String province;

    /**
     * 性别
     */
    private Gender gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 拉新时间
     */
    private LocalDateTime pullTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     *
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
     * 微信unionId
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 微信unionId
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 微信openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 微信openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
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
     * 头像
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 性别
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * 性别
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
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
     * 拉新时间
     */
    public LocalDateTime getPullTime() {
        return pullTime;
    }

    /**
     * 拉新时间
     */
    public void setPullTime(LocalDateTime pullTime) {
        this.pullTime = pullTime;
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
     *
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     *
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
        CustomerTable other = (CustomerTable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUnionId() == null ? other.getUnionId() == null : this.getUnionId().equals(other.getUnionId()))
                && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
                && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
                && (this.getHeadImg() == null ? other.getHeadImg() == null : this.getHeadImg().equals(other.getHeadImg()))
                && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
                && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
                && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
                && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
                && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                && (this.getPullTime() == null ? other.getPullTime() == null : this.getPullTime().equals(other.getPullTime()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUnionId() == null) ? 0 : getUnionId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getHeadImg() == null) ? 0 : getHeadImg().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getPullTime() == null) ? 0 : getPullTime().hashCode());
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
        sb.append(", unionId=").append(unionId);
        sb.append(", openId=").append(openId);
        sb.append(", nickName=").append(nickName);
        sb.append(", headImg=").append(headImg);
        sb.append(", city=").append(city);
        sb.append(", province=").append(province);
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append(", phone=").append(phone);
        sb.append(", pullTime=").append(pullTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}