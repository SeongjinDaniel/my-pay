package com.mypay.membership.adapter.out.persistence;

import com.mypay.membership.application.port.out.RegisterMembershipPort;
import com.mypay.membership.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public void createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        membershipRepository.save(
            new MembershipJpaEntity(
                membershipName.getNameValue(),
                membershipEmail.getEmailValue(),
                membershipAddress.getAddressValue(),
                membershipIsValid.isValidValue(),
                membershipIsCorp.isCorpValue()
            )
        );
    }
}
