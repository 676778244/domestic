package com.huilong.domestic.service.domain;

import com.huilong.domestic.service.repository.GroupRepository;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GroupEntry {
    public static final int GROUP_LIMIT = 200;
    public static final int GROUP_NOT_LIMIT = 999999;


    public GroupEntry(Long id, Long salesmenId, String rqCode, int count, int version, int limit,LocalDateTime createTime) {
        this.id = id;
        this.salesmenId = salesmenId;
        this.RQCode = rqCode;
        this.customerCount = count;
        this.createTime = createTime;
        this.version = version;
        this.limit = limit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    private final Long salesmenId;
    /**
     * 销售人员二维码
     */
    private final String RQCode;

    private final int customerCount;

    private final int limit;


    private final int version;

    /**
     * 创建时间
     */
    private final LocalDateTime createTime;

    public boolean add(GroupRepository repository) {
        return repository.add(this);
    }

    public boolean customerCountAdd(GroupRepository repository) {
        return repository.customerCountAdd(this);
    }

    public boolean changeRQCode(GroupRepository repository) {
        return repository.changeRQCode(this);
    }
}
