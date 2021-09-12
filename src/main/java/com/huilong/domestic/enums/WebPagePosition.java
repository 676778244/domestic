package com.huilong.domestic.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ApiModel("枚举-页面位置")
public enum WebPagePosition implements IEnum {
    /**
     * 页面位置
     */
    ONE("one", 10, "位置一"),
    TWO("two", 20, "位置二"),
    THREE("three", 30, "位置三"),
    FOUR("four", 40, "位置四"),
    FIVE("five", 50, "位置五"),
    SIX("six", 60, "位置六"),
    SEVEN("seven", 70, "位置七"),
    EIGHT("eight", 80, "位置八"),
    NINE("nine", 90, "位置九"),
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
