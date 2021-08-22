package com.huilong.domestic.controller;

import com.huilong.domestic.model.base.DataRespCodeEnum;
import com.huilong.domestic.model.base.DataResponse;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.input.CustomerInvitationQuery;
import com.huilong.domestic.model.output.CustomerInvitationVO;
import com.huilong.domestic.service.CustomerInvitationService;
import com.huilong.domestic.service.domain.CustomerInvitationEntry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("customer/invitation")
@Api(value = "客户邀请关系", tags = {"客户邀请关系"})
public class CustomerInvitationController {
    private final CustomerInvitationService service;

    public CustomerInvitationController(CustomerInvitationService service) {
        this.service = service;
    }

    @PostMapping(value = "/page/list")
    @ApiOperation("客户邀请关系分页列表")
    public DataResponse<XPage<List<CustomerInvitationVO>>> customerInvitationList(@RequestBody CustomerInvitationQuery query) {
        return new DataResponse(DataRespCodeEnum.SUCCESS, service.pageList(query.getInviteId(), query.getInviteNickName(), query.getInvitePhone(), query.getBeInvitedId(), query.getBeInvitedNickName(), query.getBeInvitedPhone(), query.getEnteredTime(), query.getPageNumber(), query.getPageSize()));
    }

    @PostMapping(value = "/update/invited/activity/{aBeInvitedId}/{aActivityId}")
    @ApiOperation("客户邀请关系更新活动报名信息")
    public DataResponse<Boolean> updateInvitedActivity(@PathVariable Long aBeInvitedId, @PathVariable Long aActivityId) {
        CustomerInvitationEntry customerInvitationEntry = service.customerInvitationEntry(aBeInvitedId);
        return new DataResponse<>(service.updateInvitedActivity(new CustomerInvitationEntry(customerInvitationEntry.getActivityId(), customerInvitationEntry.getInviteId(), customerInvitationEntry.getBeInvitedId(), true, aActivityId, LocalDateTime.now(), null)));
    }
}
