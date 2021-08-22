package com.huilong.domestic.service.repository;

import com.huilong.domestic.enums.Gender;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.CustomerVO;
import com.huilong.domestic.service.domain.CustomerEntry;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    boolean save(CustomerEntry customerEntry);

    boolean edit(CustomerEntry customerEntry);

    Optional<CustomerEntry> customer(Long id);

    XPage<List<CustomerVO>> pageList(Long id, String nickName, String phone, Gender gender, long pageNumber, long pageSize);
}
