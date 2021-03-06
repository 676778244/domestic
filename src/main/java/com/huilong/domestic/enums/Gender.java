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
@ApiModel("性别")
public enum Gender implements IEnum {
    /**
     * 性别
     */
    @ApiModelProperty("男")
    MALE("male", 10, "男"),
    @ApiModelProperty("女")
    FEMALE("female", 20, "女"),
    @ApiModelProperty("未知")
    NONE("none", 30, "未知"),
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
