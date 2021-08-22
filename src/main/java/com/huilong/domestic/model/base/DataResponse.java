package com.huilong.domestic.model.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @param <T>
 * @author yanbw
 */
@ApiModel("输出应答信息")
public class DataResponse<T> {
    @ApiModelProperty("应答码")
    private String code;
    @ApiModelProperty("应答信息")
    private String msg;
    @ApiModelProperty("应答数据")
    private T data;

    public DataResponse() {
        this.code = DataRespCodeEnum.SUCCESS.getCode();
        this.msg = DataRespCodeEnum.SUCCESS.getMsg();
    }

    public DataResponse(T data) {
        this();
        this.data = data;
    }

    public DataResponse(DataRespCodeEnum orgApiRespCode, T data) {
        this.code = orgApiRespCode.getCode();
        this.msg = orgApiRespCode.getMsg();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

