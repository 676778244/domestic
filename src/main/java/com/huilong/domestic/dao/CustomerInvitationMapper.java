package com.huilong.domestic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huilong.domestic.table.CustomerInvitationTable;
import com.huilong.domestic.table.virtual.CustomerInvitationExt;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * @Entity dao.domain.CustomerInvitation
 */
@Repository
public interface CustomerInvitationMapper extends BaseMapper<CustomerInvitationTable> {
    IPage<CustomerInvitationExt> customerInvitationPageList(Page page, @Param("inviteId") Long inviteId,
                                                            @Param("inviteNickName") String inviteNickName,
                                                            @Param("invitePhone") String invitePhone,
                                                            @Param("beInvitedId") Long beInvitedId,
                                                            @Param("beInvitedNickName") String beInvitedNickName,
                                                            @Param("beInvitedPhone") String beInvitedPhone,
                                                            @Param("startEnteredTime") LocalDateTime startEnteredTime,
                                                            @Param("endEnteredTime") LocalDateTime endEnteredTime);


}
