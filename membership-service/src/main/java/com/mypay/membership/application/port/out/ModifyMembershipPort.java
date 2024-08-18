package com.mypay.membership.application.port.out;

import com.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membership.domain.Membership;
import com.mypay.membership.domain.Membership.MembershipId;

public interface ModifyMembershipPort {

    MembershipJpaEntity modifyMembership(
        Membership.MembershipId membershipId
        , Membership.MembershipName membershipName
        , Membership.MembershipEmail membershipEmail
        , Membership.MembershipAddress membershipAddress
        , Membership.MembershipIsValid membershipIsValid
        , Membership.MembershipIsCorp membershipIsCorp
    );
}
