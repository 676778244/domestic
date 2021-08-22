package com.huilong.domestic.service.repository;

import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.SalesmenVO;
import com.huilong.domestic.service.domain.SalesmenEntry;

import java.util.List;
import java.util.Optional;

public interface SalesmenRepository {
    Optional<SalesmenEntry> salesmenEntry(Long id);

    boolean save(SalesmenEntry salesmenEntry);

    boolean edit(SalesmenEntry salesmenEntry);

    boolean updateRQCode(SalesmenEntry salesmenEntry);

    XPage<List<SalesmenVO>> salesmenPageList(Long id, String nickName, String phone, Boolean cover,long pageNumber,long pageSize);

    List<SalesmenEntry> salesmenList();
}
