package com.huilong.domestic.model.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("客户输出信息")
public class CustomerInvitationVO {

    @ApiModelProperty("主键")
    private  Long id;

    /**
     * 邀请人ID
     */
    @ApiModelProperty("邀请人ID")
    private  Long inviteId;

    /**
     * 邀请人昵称
     */
    @ApiModelProperty("邀请人昵称")
    private  String inviteNickName;

    /**
     * 邀请人电话
     */
    @ApiModelProperty("邀请人电话")
    private  String invitePhone;

    /**
     * 邀请人ID
     */
    @ApiModelProperty("邀请人ID")
    private  Long beInvitedId;

    /**
     * 被邀请人昵称
     */
    @ApiModelProperty("被邀请人昵称")
    private  String beInvitedNickName;

    /**
     * 被邀请人电话
     */
    @ApiModelProperty("被邀请人电话")
    private  String beInvitedPhone;

    /**
     * 是否报名
     */
    @ApiModelProperty("是否报名")
    private  boolean entered;

    /**
     * 活动ID
     */
    @ApiModelProperty("活动ID")
    private  Long activityId;

    /**
     * 活动ID
     */
    @ApiModelProperty("活动名称")
    private  String activityName;

    /**
     * 邀请时间
     */
    @ApiModelProperty("邀请时间")
    private  LocalDateTime inviteTime;

    /**
     * 报名时间
     */
    @ApiModelProperty("报名时间")
    private  LocalDateTime enteredTime;
}
