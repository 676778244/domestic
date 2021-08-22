package com.huilong.domestic.service.repository;

import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.CustomerInvitationVO;
import com.huilong.domestic.service.domain.CustomerInvitationEntry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CustomerInvitationRepository {
    XPage<List<CustomerInvitationVO>> pageList(Long inviteId, String inviteNickName, String invitePhone,
                                               Long beInvitedId, String beInvitedNickName, String beInvitedPhone,
                                               LocalDateTime enteredTime, long pageNumber, long pageSize);

    Optional<CustomerInvitationEntry> customerInvitationEntry(Long beInvitedId);

    boolean updateInvitedActivity(CustomerInvitationEntry customerInvitationEntry);
}
