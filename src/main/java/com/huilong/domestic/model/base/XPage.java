package com.huilong.domestic.model.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yixiaodong
 */
@Data
@ApiModel("Page分页信息")
public class XPage<T> {
    @ApiModelProperty("分页数据")
    private final T data;
    @ApiModelProperty("第几页")
    private long pageNumber;
    @ApiModelProperty("每页条数")
    private long pageSize;
    @ApiModelProperty("总条数")
    private long total;

    public XPage(T data, long pageNumber, long pageSize, long total) {
        this.data = data;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
    }
}
