package com.huilong.domestic.table.virtual;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerInvitationExt {

    @ApiModelProperty("主键")
    private  Long id;

    /**
     * 邀请人ID
     */
    private  Long inviteId;

    /**
     * 邀请人昵称
     */
    private  String inviteNickName;

    /**
     * 邀请人电话
     */
    private  String invitePhone;

    /**
     * 邀请人ID
     */
    private  Long beInvitedId;

    /**
     * 被邀请人昵称
     */
    private  String beInvitedNickName;

    /**
     * 被邀请人电话
     */
    private  String beInvitedPhone;

    /**
     * 是否报名
     */
    private  boolean entered;

    /**
     * 活动ID
     */
    private  Long activityId;

    /**
     * 邀请时间
     */
    private  LocalDateTime inviteTime;

    /**
     * 报名时间
     */
    private  LocalDateTime enteredTime;
}
