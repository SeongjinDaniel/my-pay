package com.mypay.membership.application.port.in;

import com.mypay.membership.domain.Membership;
import common.UseCase;

@UseCase
public interface RegisterMembershipUseCase {
    Membership registerMembership(RegisterMembershipCommand command);
}
