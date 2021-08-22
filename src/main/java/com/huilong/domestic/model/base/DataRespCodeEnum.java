package com.huilong.domestic.model.base;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;

/**
 * @author yanbw
 * @Date: 2020/5/14 14:48
 * E + 服务序号 + 错误类型码 + 错误码序号。
 * 形如： E02030005
 */
@Getter
public enum DataRespCodeEnum {
    SUCCESS("0", "success", "200"),
    FAIL("3000401", "操作失败", "401"),
    NOT_FOUND("3000402", "数据不存在", "402"),
    PARAMETER_ERROR("3000403", "参数有误", "403"),
    VALUE_CHANGE("3000405", "原值已改变,操作失败", "405"),
    ILLEGAL_OPERATION("3000406", "非法操作，请联系管理员", "406"),
    SAVE_FAIL("3000407", "保存到数据库失败", "407"),

    CAMERA_RESET_FAIL("3000408", "没有设置预置位，或接口调用失败", "408"),
    BATCH_REMOVE_ALARM_PARAM_ERROR("3000409", "参数中不能存在已经被解除或处置的报警", "409");


    private String code;
    private String msg;
    private String outRelated;

    DataRespCodeEnum(String code, String msg, String outRelated) {
        this.code = code;
        this.msg = msg;
        this.outRelated = outRelated;
    }

    private static final ImmutableMap<String, DataRespCodeEnum> INIT_MAP;

    static {
        final ImmutableMap.Builder<String, DataRespCodeEnum> builder = new ImmutableMap.Builder<>();
        for (DataRespCodeEnum status : DataRespCodeEnum.values()) {
            builder.put(status.outRelated, status);
        }
        INIT_MAP = builder.build();
    }

    public static DataRespCodeEnum of(String outRelated) {
        if (INIT_MAP.containsKey(outRelated)) {
            return INIT_MAP.get(outRelated);
        }
        return FAIL;
    }

}
