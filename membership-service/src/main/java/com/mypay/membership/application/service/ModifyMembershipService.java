package com.mypay.membership.application.service;

import com.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membership.adapter.out.persistence.MembershipMapper;
import com.mypay.membership.application.port.in.ModifyMembershipCommand;
import com.mypay.membership.application.port.in.ModifyMembershipUseCase;
import com.mypay.membership.application.port.out.ModifyMembershipPort;
import com.mypay.membership.domain.Membership;
import com.mypay.membership.domain.Membership.MembershipAddress;
import com.mypay.membership.domain.Membership.MembershipEmail;
import com.mypay.membership.domain.Membership.MembershipId;
import com.mypay.membership.domain.Membership.MembershipIsCorp;
import com.mypay.membership.domain.Membership.MembershipIsValid;
import com.mypay.membership.domain.Membership.MembershipName;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
            new MembershipId(command.getMembershipId()),
            new MembershipName(command.getName()),
            new MembershipEmail(command.getEmail()),
            new MembershipAddress(command.getAddress()),
            new MembershipIsValid(command.isValid()),
            new MembershipIsCorp(command.isCorp())
        );
        // entity -> Membership
        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
