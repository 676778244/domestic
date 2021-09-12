package com.huilong.domestic.controller;

import com.huilong.domestic.model.base.DataRespCodeEnum;
import com.huilong.domestic.model.base.DataResponse;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.input.SalesmenInput;
import com.huilong.domestic.model.input.SalesmenQuery;
import com.huilong.domestic.model.output.SalesmenVO;
import com.huilong.domestic.service.SalesmenService;
import com.huilong.domestic.service.domain.SalesmenEntry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("salesmen")
@Api(value = "销售人员接口", tags = {"销售人员接口"})
public class SalesmenController {
    public final SalesmenService service;

    public SalesmenController(SalesmenService service) {
        this.service = service;
    }

    @PostMapping(value = "/page/list")
    @ApiOperation("销售人员分页列表")
    public DataResponse<XPage<List<SalesmenVO>>> salesmenList(@RequestBody SalesmenQuery query) {
        return new DataResponse(DataRespCodeEnum.SUCCESS, service.salesmenPageList(query.getId(), query.getNickName(), query.getPhone(), query.getCover(), query.getPageNumber(), query.getPageSize()));
    }

    @PostMapping(value = "/add")
    @ApiOperation("销售人员新增")
    public DataResponse<Boolean> add(@RequestBody SalesmenInput input) {
        SalesmenEntry salesmenEntry = new SalesmenEntry(null, input.getNickName(), input.getPhone(), input.getRqCode1(), input.getRqCode2(), input.getRqCode3(), input.getCover(), input.getServiceType(), LocalDateTime.now(), LocalDateTime.now());
        return new DataResponse(DataRespCodeEnum.SUCCESS, service.add(salesmenEntry));
    }

    @GetMapping(value = "/detail/{id}")
    @ApiOperation("销售人员详情")
    public DataResponse<SalesmenVO> detail(@PathVariable @ApiParam(value = "销售人员ID", example = "1") Long id) {
        SalesmenVO salesmenVO = new SalesmenVO();
        Optional<SalesmenEntry> salesmenEntry = service.salesmenEntry(id);
        if (salesmenEntry.isPresent()) {
            BeanUtils.copyProperties(salesmenEntry.get(), salesmenVO);
            return new DataResponse(DataRespCodeEnum.SUCCESS, salesmenVO);

        }
        return new DataResponse(DataRespCodeEnum.SUCCESS, salesmenVO);
    }

    @PostMapping(value = "/update/{id}")
    @ApiOperation("更新销售人员二维码")
    public DataResponse<Boolean> update(@PathVariable @ApiParam(value = "销售人员ID", example = "1") Long id,
                                        @RequestParam(value = "RQCode1", required = false) @ApiParam(value = "销售人员二维码1") String RQCode1,
                                        @RequestParam(value = "RQCode2", required = false) @ApiParam(value = "销售人员二维码2") String RQCode2,
                                        @RequestParam(value = "RQCode3", required = false) @ApiParam(value = "销售人员二维码3") String RQCode3) {

        return new DataResponse(DataRespCodeEnum.SUCCESS, service.changeRQCode(id, RQCode1, RQCode2, RQCode3));

    }

}
