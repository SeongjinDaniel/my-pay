package com.mypay.membership.application.port.out;

import com.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membership.domain.Membership;

public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(
        Membership.MembershipName membershipName
        , Membership.MembershipAddress membershipAddress
        , Membership.MembershipEmail membershipEmail
        , Membership.MembershipIsValid membershipIsValid
        , Membership.MembershipIsCorp membershipIsCorp
    );
}
