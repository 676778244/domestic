package com.huilong.domestic.service.domain;

import com.huilong.domestic.service.repository.CustomerInvitationRepository;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CustomerInvitationEntry {
    public CustomerInvitationEntry(Long id, Long inviteId, Long beInvitedId, boolean entered, Long activityId, LocalDateTime inviteTime, LocalDateTime enteredTime) {
        this.id = id;
        this.inviteId = inviteId;
        this.beInvitedId = beInvitedId;
        this.entered = entered;
        this.activityId = activityId;
        this.inviteTime = inviteTime;
        this.enteredTime = enteredTime;
    }

    private final Long id;

    /**
     * 邀请人ID
     */
    private final Long inviteId;

    /**
     * 被邀请人ID
     */
    private final Long beInvitedId;

    /**
     * 是否报名
     */
    private final boolean entered;

    /**
     * 活动ID
     */
    private final Long activityId;

    /**
     * 邀请时间
     */
    private final LocalDateTime inviteTime;

    /**
     * 报名时间
     */
    private final LocalDateTime enteredTime;

    public static CustomerInvitationEntry customerInvitationEntry(Long aBeInvitedId, CustomerInvitationRepository repository) {
        return repository.customerInvitationEntry(aBeInvitedId).get();
    }

    public boolean updateInvitedActivity(CustomerInvitationRepository repository){
        return repository.updateInvitedActivity(this);
    }
}
