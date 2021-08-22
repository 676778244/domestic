package com.huilong.domestic.service;

import com.huilong.domestic.model.base.DataResponse;
import com.huilong.domestic.model.base.XPage;
import com.huilong.domestic.model.output.CustomerInvitationVO;
import com.huilong.domestic.service.domain.CustomerInvitationEntry;
import com.huilong.domestic.service.repository.CustomerInvitationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

import static com.huilong.domestic.constant.ZoneConstant.ASIA_SHANGHAI;

@Service
public class CustomerInvitationService {
    public final CustomerInvitationRepository repository;

    public CustomerInvitationService(CustomerInvitationRepository repository) {
        this.repository = repository;
    }

    public XPage<List<CustomerInvitationVO>> pageList(Long inviteId, String inviteNickName, String invitePhone, Long beInvitedId, String beInvitedNickName, String beInvitedPhone, Long enteredTime, long pageNumber, long pageSize) {
        if (Objects.nonNull(enteredTime)) {
            return repository.pageList(inviteId, inviteNickName, invitePhone, beInvitedId, beInvitedNickName,
                    beInvitedPhone, Objects.nonNull(enteredTime) ? LocalDateTime.ofInstant(Instant.ofEpochMilli(enteredTime), ZoneId.of(ASIA_SHANGHAI)) : null,
                    pageNumber, pageSize);
        }
        return repository.pageList(inviteId, inviteNickName, invitePhone, beInvitedId, beInvitedNickName, beInvitedPhone,
                null, pageNumber, pageSize);
    }

    public CustomerInvitationEntry customerInvitationEntry(Long aBeInvitedId){
        return CustomerInvitationEntry.customerInvitationEntry(aBeInvitedId,repository);
    }

    public Boolean updateInvitedActivity(CustomerInvitationEntry customerInvitationEntry) {
        return customerInvitationEntry.updateInvitedActivity(repository);
    }
}
