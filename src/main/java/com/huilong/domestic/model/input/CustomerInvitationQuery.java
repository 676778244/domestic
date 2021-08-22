package com.huilong.domestic.model.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("客户邀请关系分页列表入参")
public class CustomerInvitationQuery {

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
     * 被邀请人ID
     */
    @ApiModelProperty("被邀请人ID")
    private  Long beInvitedId;

    /**
     * 被邀请人昵称
     */
    @ApiModelProperty("被邀请人昵称")
    private  String beInvitedNickName;
    /**
     * 邀请人电话
     */
    @ApiModelProperty("邀请人电话")
    private  String beInvitedPhone;

    /**
     * 报名时间
     */
    @ApiModelProperty("报名时间")
    private  Long enteredTime;

    @ApiModelProperty("第几页")
    private long pageNumber;

    @ApiModelProperty("每页条数")
    private long pageSize;
}
