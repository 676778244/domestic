package com.huilong.domestic.model.input;

import com.huilong.domestic.enums.ServiceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("新增/修改销售人员入参")
public class SalesmenInput {
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
    private  Boolean cover;
    /**
     * 服务类型
     */
    @ApiModelProperty("服务类型")
    private  ServiceType serviceType;

}
