package com.huilong.domestic.model.output;

import com.huilong.domestic.enums.ServiceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("销售人员输出信息")
public class SalesmenVO {
    @ApiModelProperty("销售人员编号")
    private  Long id;
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private  String nickName;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private  String phone;
    /**
     * 二维码1
     */
    @ApiModelProperty("二维码1")
    private  String RQCode1;
    /**
     * 二维码2
     */
    @ApiModelProperty("二维码2")
    private  String RQCode2;
    /**
     * 二维码3
     */
    @ApiModelProperty("二维码3")
    private  String RQCode3;
    /**
     * 是否兜底老师
     */
    @ApiModelProperty("是否兜底老师")
    private  boolean cover;
    /**
     * 服务类型
     */
    @ApiModelProperty("服务类型")
    private  ServiceType serviceType;
}
