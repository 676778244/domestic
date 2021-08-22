package com.huilong.domestic.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum ServiceType implements IEnum {
    /**
     * 服务类型
     */
    HOUSEKEEPING("housekeeping", 100, "家政服务"),
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
