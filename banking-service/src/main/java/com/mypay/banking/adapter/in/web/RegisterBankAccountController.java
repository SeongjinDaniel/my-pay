package com.mypay.banking.adapter.in.web;

import com.mypay.banking.application.port.in.RegisterBankAccountCommand;
import com.mypay.banking.application.port.in.RegisterBankAccountUseCase;
import com.mypay.banking.domain.RegisteredBankAccount;
import com.mypay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registeredBankAccountUseCase;

    @PostMapping(path = "/banking/account/register")
    RegisteredBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request) {
        // request~~> Command
        // request -> Command
        // UseCase ~~(request x, command)
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
            .membershipId(request.getMembershipId())
            .bankName(request.getBankName())
            .bankAccountNumber(request.getBankAccountNumber())
            .isValid(request.isValid())
            .build();

        RegisteredBankAccount registeredBankAccount = registeredBankAccountUseCase.registerBankAccount(command);
        if (registeredBankAccount == null) {
            // ToDo: Error Handling
            return null;
        }

        return registeredBankAccount;
    }
}
