package com.mypay.banking.application.port.out;

import com.mypay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.mypay.banking.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {
    FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}
