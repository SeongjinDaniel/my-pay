package com.mypay.membership.adapter.in.web;

import com.mypay.membership.application.port.in.RegisterMembershipCommand;
import com.mypay.membership.application.port.in.RegisterMembershipUseCase;
import com.mypay.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import common.WebAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;
    @PostMapping(path = "/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        // request~~> Command
        // request -> Command
        // UseCase ~~(request x, command)
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
            .name(request.getName())
            .address(request.getAddress())
            .email(request.getEmail())
            .isValid(true)
            .isCorp(request.isCorp())
            .build();

        return registerMembershipUseCase.registerMembership(command);
    }
}
