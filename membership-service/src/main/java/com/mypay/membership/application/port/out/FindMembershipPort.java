package com.mypay.membership.application.port.out;

import com.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membership.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public interface FindMembershipPort {

    MembershipJpaEntity findMembership(
        Membership.MembershipId membershipId
    );
}
