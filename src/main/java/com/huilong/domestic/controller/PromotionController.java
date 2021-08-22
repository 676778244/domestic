package com.huilong.domestic.controller;

import com.huilong.domestic.model.base.DataRespCodeEnum;
import com.huilong.domestic.model.base.DataResponse;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.input.PromotionInput;
import com.huilong.domestic.model.input.PromotionQuery;
import com.huilong.domestic.model.output.PromotionVO;
import com.huilong.domestic.service.PromotionService;
import com.huilong.domestic.service.domain.PromotionEntry;
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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.huilong.domestic.constant.ZoneConstant.ASIA_SHANGHAI;

@RestController
@RequestMapping("promotion")
@Api(value = "活动接口", tags = {"活动接口"})
public class PromotionController {

    private final PromotionService service;

    public PromotionController(PromotionService service) {
        this.service = service;
    }

    @PostMapping(value = "/page/list")
    @ApiOperation("活动分页列表")
    public DataResponse<XPage<List<PromotionVO>>> promotionList(@RequestBody PromotionQuery query) {

        return new DataResponse(DataRespCodeEnum.SUCCESS, service.promotionPageList(query.getName(),
                query.getServiceType(), query.getWebPageType(),
                Objects.nonNull(query.getStartDate()) ? LocalDateTime.ofInstant(Instant.ofEpochMilli(query.getStartDate()), ZoneId.of(ASIA_SHANGHAI)) : null,
                Objects.nonNull(query.getEndDate()) ? LocalDateTime.ofInstant(Instant.ofEpochMilli(query.getEndDate()), ZoneId.of(ASIA_SHANGHAI)) : null,
                query.getPageNumber(), query.getPageSize()));
    }

    @PostMapping(value = "/add")
    @ApiOperation("活动新增")
    public DataResponse<Boolean> add(@RequestBody PromotionInput input) {
        PromotionEntry promotionEntry = new PromotionEntry(null, input.getName(), input.getTitle(), input.getContent(), input.getServiceType(), input.getPicUrl(), input.getWebPicUrl(), input.getAmount(), input.getWebPageType(), input.getWebPagePosition(), input.getStartDate(), input.getEndDate(), LocalDateTime.now(), LocalDateTime.now());
        return new DataResponse(DataRespCodeEnum.SUCCESS, service.add(promotionEntry));
    }

    @GetMapping(value = "/detail/{id}")
    @ApiOperation("活动详情")
    public DataResponse<PromotionVO> detail(@PathVariable @ApiParam(value = "活动ID", example = "1") Long id) {
        PromotionVO promotionVO = new PromotionVO();
        Optional<PromotionEntry> promotion = service.promotion(id);
        if (promotion.isPresent()) {
            BeanUtils.copyProperties(promotion.get(), promotionVO);
        }
        return new DataResponse(DataRespCodeEnum.SUCCESS, promotionVO);
    }

    @GetMapping(value = "/update/{id}")
    @ApiOperation("更新活动")
    public DataResponse<Boolean> update(@PathVariable @ApiParam(value = "活动ID", example = "1") Long id, @RequestBody PromotionInput input) {
        PromotionEntry promotionEntry = new PromotionEntry(id, input.getName(), input.getTitle(), input.getContent(), input.getServiceType(), input.getPicUrl(), input.getWebPicUrl(), input.getAmount(), input.getWebPageType(), input.getWebPagePosition(), input.getStartDate(), input.getEndDate(), null, LocalDateTime.now());
        return new DataResponse(DataRespCodeEnum.SUCCESS, service.edit(promotionEntry));

    }

}
