package com.huilong.domestic.model.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("销售人员分页列表查询条件")
public class SalesmenQuery {
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
     * 是否兜底老师
     */
    @ApiModelProperty("是否兜底老师")
    private  Boolean cover;

    @ApiModelProperty("第几页")
    private long pageNumber;

    @ApiModelProperty("每页条数")
    private long pageSize;

}
