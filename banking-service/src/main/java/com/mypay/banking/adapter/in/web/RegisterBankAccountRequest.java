package com.mypay.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {

    private String membershipId;
    private String bankName; // enum
    private String bankAccountNumber;
    private boolean isValid;
}
