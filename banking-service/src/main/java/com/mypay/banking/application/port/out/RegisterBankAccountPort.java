package com.mypay.banking.application.port.out;

import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mypay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
        RegisteredBankAccount.MembershipId membershipId
        , RegisteredBankAccount.BankName bankName
        , RegisteredBankAccount.BankAccountNumber bankAccountNumber
        , RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
