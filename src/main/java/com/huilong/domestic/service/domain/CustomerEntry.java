package com.huilong.domestic.service.domain;

import com.huilong.domestic.enums.Gender;
import com.huilong.domestic.event.CustomerDomainEvent;
import com.huilong.domestic.event.IDomainEventPublisher;
import com.huilong.domestic.service.repository.CustomerRepository;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@ToString
public class CustomerEntry {
    /**
     * @param id
     * @param unionId
     * @param openId
     * @param nickName
     * @param headImg
     * @param city
     * @param province
     * @param gender
     * @param age
     * @param phone
     * @param pullTime
     * @param createTime
     * @param updateTime
     */
    public CustomerEntry(Long id, String unionId, String openId, String nickName, String headImg, String city, String province, Gender gender, Integer age, String phone, LocalDateTime pullTime, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.unionId = unionId;
        this.openId = openId;
        this.nickName = nickName;
        this.headImg = headImg;
        this.city = city;
        this.province = province;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.pullTime = pullTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    private Long id;
    /**
     * 微信unionId
     */
    private final String unionId;
    /**
     * 微信openId
     */
    private final String openId;
    /**
     * 昵称
     */
    private final String nickName;
    /**
     * 头像
     */
    private final String headImg;
    /**
     * 市
     */
    private final String city;

    /**
     * 省
     */
    private final String province;
    /**
     * 性别
     */
    private final Gender gender;
    /**
     * 年龄
     */
    private final Integer age;
    /**
     * 手机号
     */
    private final String phone;
    /**
     * 拉新时间
     */
    private final LocalDateTime pullTime;
    /**
     * 创建时间
     */
    private final LocalDateTime createTime;
    /**
     * 更新时间
     */
    private final LocalDateTime updateTime;

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param repository
     * @return
     */
    public boolean register(CustomerRepository repository, IDomainEventPublisher publisher) {
        if (repository.save(this)) {
            //发送添加客户事件，分配老师
            publisher.publish(new CustomerDomainEvent(CustomerEntry.class, this));
            return true;
        }
        return false;
    }

    public boolean edit(CustomerRepository repository) {
        return repository.edit(this);
    }

    /**
     * @param id
     * @param repository
     * @return
     */
    public static Optional<CustomerEntry> customer(Long id, CustomerRepository repository) {
        return repository.customer(id);
    }

}
