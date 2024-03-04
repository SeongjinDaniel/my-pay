package com.mypay.membership.application.service;

import com.mypay.membership.application.port.in.RegisterMembershipCommand;
import com.mypay.membership.application.port.in.RegisterMembershipUseCase;
import com.mypay.membership.domain.Membership;
import org.springframework.stereotype.Service;

@Service
public class RegisterMembershipService implements RegisterMembershipUseCase {

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // ??
        // command -> DB


        // biz logic -> DB

        // external system
        // port, adapter


        return null;
    }
}
