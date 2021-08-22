package com.huilong.domestic.controller;

import com.huilong.domestic.model.base.DataRespCodeEnum;
import com.huilong.domestic.model.base.DataResponse;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.input.CustomerInput;
import com.huilong.domestic.model.input.CustomerQuery;
import com.huilong.domestic.model.output.CustomerVO;
import com.huilong.domestic.service.CustomerService;
import com.huilong.domestic.service.domain.CustomerEntry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customer")
@Api(value = "客户接口", tags = {"客户接口"})
public class CustomerController {
    public final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping(value = "/page/list")
    @ApiOperation("客户分页列表")
    public DataResponse<XPage<List<CustomerVO>>> customerList(@RequestBody CustomerQuery query) {
        return new DataResponse(DataRespCodeEnum.SUCCESS, service.pageList(query.getId(), query.getNickName(), query.getPhone(), query.getGender(), query.getPageNumber(), query.getPageSize()));
    }

    @PostMapping(value = "/add")
    @ApiOperation("新增客户")
    public DataResponse<Boolean> add(@RequestBody CustomerInput input) {
        CustomerEntry customerEntry = new CustomerEntry(null, input.getUnionId(), input.getOpenId(), input.getNickName(), input.getHeadImg(), input.getCity(), input.getProvince(), input.getGender(), input.getAge(), input.getPhone(), null, LocalDateTime.now(), LocalDateTime.now());
        return new DataResponse(DataRespCodeEnum.SUCCESS, service.register(customerEntry));
    }

    @PostMapping(value = "/edit/{id}")
    @ApiOperation("修改客户")
    public DataResponse<Boolean> edit(@PathVariable @ApiParam(value = "客户ID", example = "1") Long id, @RequestBody CustomerInput input) {
        CustomerEntry customerEntry = new CustomerEntry(id, input.getUnionId(), input.getOpenId(), input.getNickName(), input.getHeadImg(), input.getCity(), input.getProvince(), input.getGender(), input.getAge(), input.getPhone(), null, null, LocalDateTime.now());
        return new DataResponse(DataRespCodeEnum.SUCCESS, service.edit(customerEntry));
    }

    @GetMapping(value = "/detail/{id}")
    @ApiOperation("客户详情")
    public DataResponse<CustomerVO> detail(@PathVariable @ApiParam(value = "客户ID", example = "1") Long id) {
        CustomerVO customerVO = new CustomerVO();
        Optional<CustomerEntry> customer = service.customer(id);
        if (customer.isPresent()) {
            BeanUtils.copyProperties(customer.get(), customerVO);
        }
        return new DataResponse(DataRespCodeEnum.SUCCESS, customerVO);
    }
}
