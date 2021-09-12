package com.huilong.domestic.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ApiModel("枚举-页面类型")
public enum WebPageType implements IEnum {
    /**
     * 页面类型
     */
    @ApiModelProperty("首页")
    HOME_PAGE("home_page", 10, "首页"),
    @ApiModelProperty("找服务")
    LOOKING_SERVICE("looking_service", 20, "找服务"),
    @ApiModelProperty("家政大学")
    HOUSEKEEPING_COLLEGE("housekeeping_college", 30, "家政大学"),

    NULL("", -99, "空"),
    ;

    public String name;
    public int value;
    public String desc;


    @Override
    public Serializable getValue() {
        return this.value;
    }

    @JsonValue
    public String getName() {
        return this.name;
    }
}
