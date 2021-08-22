package com.huilong.domestic.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum WebPageType implements IEnum {
    /**
     * 页面类型
     */
    HOME_PAGE("home_page", 10, "首页"),
    LOOKING_SERVICE("home_page", 20, "找服务"),
    HOUSEKEEPING_COLLEGE("home_page", 30, "家政大学"),

    NULL("", 9999999, "空"),
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
