package com.huilong.domestic.model.input;

import com.huilong.domestic.enums.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("新增客户入参")
public class CustomerInput {

    /**
     * 微信unionId
     */
    @ApiModelProperty("微信unionId")
    private  String unionId;
    /**
     * 微信openId
     */
    @ApiModelProperty("微信openId")
    private  String openId;
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private  String nickName;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String headImg;
    /**
     * 市
     */
    @ApiModelProperty("市")
    private String city;
    /**
     * 省
     */
    @ApiModelProperty("省")
    private String province;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private  Gender gender;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private  Integer age;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private  String phone;
    /**
     * 拉新时间
     */
    @ApiModelProperty("拉新时间")
    private  LocalDateTime pullTime;

}
