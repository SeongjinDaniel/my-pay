package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {
    public RegisteredBankAccount mapToDomainEntity(RegisteredBankAccountJpaEntity RegisteredBankAccountJpaEntity) {
        return RegisteredBankAccount.generateMember(
            new RegisteredBankAccount.RegisteredBankAccountId(RegisteredBankAccountJpaEntity.getRegisteredBankAccountId()+""),
            new RegisteredBankAccount.MembershipId(RegisteredBankAccountJpaEntity.getMembershipId()),
            new RegisteredBankAccount.BankName(RegisteredBankAccountJpaEntity.getBankName()),
            new RegisteredBankAccount.BankAccountNumber(RegisteredBankAccountJpaEntity.getBankAccountNumber()),
            new RegisteredBankAccount.LinkedStatusIsValid(RegisteredBankAccountJpaEntity.isLinkedStatusIsValid()));
    }
}
