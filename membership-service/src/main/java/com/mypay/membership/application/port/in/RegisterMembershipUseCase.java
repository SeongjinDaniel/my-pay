package com.mypay.membership.application.port.in;

import com.mypay.membership.domain.Membership;

public interface RegisterMembershipUseCase {
    Membership registerMembership(RegisterMembershipCommand command);
}
