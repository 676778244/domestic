package com.huilong.domestic.model.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huilong.domestic.enums.ServiceType;
import com.huilong.domestic.enums.WebPagePosition;
import com.huilong.domestic.enums.WebPageType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ApiModel("活动新增/编辑入参-v1")
public class PromotionInput {

    /**
     * 活动名称
     */
    @ApiModelProperty("活动名称")
    private String name;

    /**
     * 活动标题
     */
    @ApiModelProperty("活动标题")
    private String title;

    /**
     * 活动富文本内容
     */
    @ApiModelProperty("活动富文本内容")
    private String content;

    /**
     * 服务类型
     */
    @ApiModelProperty("活动新增/编辑入参-服务类型")
    private  ServiceType serviceType;
    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private  String picUrl;
    /**
     * 页面内图片地址
     */
    @ApiModelProperty("页面内图片地址")
    private  String webPicUrl;
    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private  BigDecimal amount;
    /**
     * 页面类型
     */
    @ApiModelProperty("活动新增/编辑入参-页面类型")
    private  WebPageType webPageType;
    /**
     * 页面位置
     */
    @ApiModelProperty("活动新增/编辑入参-页面位置")
    private WebPagePosition webPagePosition;
    /**
     * 开始时间
     */
    @ApiModelProperty("活动开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private  LocalDateTime startDate;
    /**
     * 结束时间
     */
    @ApiModelProperty("活动结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private  LocalDateTime endDate;

}
