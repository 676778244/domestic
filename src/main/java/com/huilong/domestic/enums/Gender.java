package com.huilong.domestic.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum Gender implements IEnum {
    /**
     * 性别
     */
    MALE("male", 10, "男"),
    FEMALE("female", 20, "女"),
    NONE("none", 30, "未知"),
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
