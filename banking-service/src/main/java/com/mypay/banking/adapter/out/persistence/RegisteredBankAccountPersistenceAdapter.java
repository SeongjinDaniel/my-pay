package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.domain.RegisteredBankAccount;
import com.mypay.banking.domain.RegisteredBankAccount.LinkedStatusIsValid;
import com.mypay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredAccountRepository bankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(RegisteredBankAccount.MembershipId membershipId, RegisteredBankAccount.BankName bankName, RegisteredBankAccount.BankAccountNumber bankAccountNumber, LinkedStatusIsValid linkedStatusIsValid) {
        return bankAccountRepository.save(
            new RegisteredBankAccountJpaEntity(
                membershipId.getMembershipId(),
                bankName.getBankName(),
                bankAccountNumber.getBankAccountNumber(),
                linkedStatusIsValid.isLinkedStatusIsValid()
            )
        );
    }
}
