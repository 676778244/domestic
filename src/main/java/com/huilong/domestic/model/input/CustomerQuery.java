package com.huilong.domestic.model.input;

import com.huilong.domestic.enums.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("客户分页查询条件")
public class CustomerQuery {
    @ApiModelProperty("用户编号")
    private Long id;
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Gender gender;

    @ApiModelProperty("第几页")
    private long pageNumber;

    @ApiModelProperty("每页条数")
    private long pageSize;

}
