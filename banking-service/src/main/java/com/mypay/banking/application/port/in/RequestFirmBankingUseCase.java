package com.mypay.banking.application.port.in;

import com.mypay.banking.domain.FirmbankingRequest;

public interface RequestFirmBankingUseCase {
    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}
