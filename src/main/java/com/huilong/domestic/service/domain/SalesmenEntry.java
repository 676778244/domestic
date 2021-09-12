package com.huilong.domestic.service.domain;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.huilong.domestic.enums.ServiceType;
import com.huilong.domestic.event.IDomainEventPublisher;
import com.huilong.domestic.event.SalesmenAddDomainEvent;
import com.huilong.domestic.service.repository.CustomerRepository;
import com.huilong.domestic.service.repository.SalesmenRepository;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
public class SalesmenEntry {
    public SalesmenEntry(Long id, String nickName, String phone, String rqCode1, String rqCode2, String rqCode3, Boolean cover, ServiceType serviceType, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.nickName = nickName;
        this.phone = phone;
        this.rqCode1 = rqCode1;
        this.rqCode2 = rqCode2;
        this.rqCode3 = rqCode3;
        this.cover = cover;
        this.serviceType = serviceType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    /**
     * 昵称
     */
    private final String nickName;
    /**
     * 手机号
     */
    private final String phone;

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
     * 是否兜底老师
     */
    private final Boolean cover;
    /**
     * 服务类型
     */
    private final ServiceType serviceType;
    /**
     * 创建时间
     */
    private final LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    private void setRQCode1(String rqCode1) {
        this.rqCode1 = rqCode1;
    }

    private void setRQCode2(String rqCode2) {
        this.rqCode2 = rqCode2;
    }

    private void setRQCode3(String rqCode3) {
        this.rqCode3 = rqCode3;
    }

    /**
     * @param repository
     * @return
     */
    public boolean add(SalesmenRepository repository, IDomainEventPublisher publisher) {
        if (repository.save(this)) {
            publisher.publish(new SalesmenAddDomainEvent(SalesmenEntry.class, this));
            return true;
        }
        return false;
    }

    /**
     * @param repository
     * @return
     */
    public boolean edit(SalesmenRepository repository) {
        if (repository.edit(this)) {
            return true;
        }
        return false;
    }

    public static Optional<SalesmenEntry> SalesmenEntry(Long aId, SalesmenRepository repository) {
        return repository.salesmenEntry(aId);
    }

    public boolean changeRQCode(String RQCode1, String RQCode2, String RQCode3, SalesmenRepository repository) {
        LocalDateTime beforeUpdateTime = this.getUpdateTime();
        if (StringUtils.isNotBlank(RQCode1)) {
            this.setRQCode1(RQCode1);
            this.setUpdateTime(LocalDateTime.now());
        }
        if (StringUtils.isNotBlank(RQCode2)) {
            this.setRQCode2(RQCode2);
            this.setUpdateTime(LocalDateTime.now());

        }
        if (StringUtils.isNotBlank(RQCode3)) {
            this.setRQCode3(RQCode3);
            this.setUpdateTime(LocalDateTime.now());

        }
        if (beforeUpdateTime.isEqual(this.getUpdateTime())) {
            return false;
        }
        return repository.updateRQCode(this);
    }

}
