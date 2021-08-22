package com.huilong.domestic.model.input;

import com.huilong.domestic.enums.ServiceType;
import com.huilong.domestic.enums.WebPageType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ApiModel("活动分页列表查询条件")
public class PromotionQuery {
    /**
     * 活动名称
     */
    @ApiModelProperty("活动名称")
    private  String name;
    /**
     * 服务类型
     */
    @ApiModelProperty("服务类型")
    private final ServiceType serviceType;
    /**
     * 页面类型
     */
    @ApiModelProperty("页面类型")
    private final WebPageType webPageType;
    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private final Long startDate;
    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private final Long endDate;

    @ApiModelProperty("第几页")
    private long pageNumber;

    @ApiModelProperty("每页条数")
    private long pageSize;

}
