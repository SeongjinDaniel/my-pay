package com.mypay.banking.application.port.out;

import com.mypay.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import com.mypay.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingPort {

    FirmbankingRequestJpaEntity createFirmbankingRequest (
        FirmbankingRequest.FromBankName fromBankName,
        FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber,
        FirmbankingRequest.ToBankName toBankName,
        FirmbankingRequest.ToBankAccountNumber toBankAccountNumber,
        FirmbankingRequest.MoneyAmount moneyAmount,
        FirmbankingRequest.FirmbankingStatus firmbankingStatus
    );

    FirmbankingRequestJpaEntity modifyFirmbankingRequest (
        FirmbankingRequestJpaEntity entity
    );
}
