package com.huilong.domestic.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ApiModel("服务类型")
public enum ServiceType implements IEnum {
    /**
     * 服务类型
     * 家政服务,养老，护幼，保洁，保姆，家政大学
     */
    HOUSEKEEPING("housekeeping", 100, "家政服务"),
    ELDERLY_CARE("elderly_care",200,"养老"),
    CARE_OF_YOUNG("care_of_young",300,"护幼"),
    CLEAN("clean",400,"保洁"),
    NURSE("nurse",500,"保姆"),
    HOUSEKEEPING_COLLEGE("housekeeping_college",600,"家政大学"),
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
