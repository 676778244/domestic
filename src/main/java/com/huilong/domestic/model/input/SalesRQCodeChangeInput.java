package com.huilong.domestic.model.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改销售人员二维码入参")
public class SalesRQCodeChangeInput {
    /**
     * 二维码1
     */
    @ApiModelProperty("新增/修改销售人员入参-二维码1")
    private  String rqCode1;
    /**
     * 二维码2
     */
    @ApiModelProperty("新增/修改销售人员入参-二维码2")
    private  String rqCode2;
    /**
     * 二维码3
     */
    @ApiModelProperty("新增/修改销售人员入参-二维码3")
    private  String rqCode3;
}
