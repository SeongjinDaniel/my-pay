package com.mypay.banking.application.port.out;

import com.mypay.banking.adapter.out.external.bank.BankAccount;
import com.mypay.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
