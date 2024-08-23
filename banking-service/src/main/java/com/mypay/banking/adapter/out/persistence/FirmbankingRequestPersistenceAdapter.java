package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.application.port.out.RequestFirmbankingPort;
import com.mypay.banking.domain.FirmbankingRequest.FirmbankingStatus;
import com.mypay.banking.domain.FirmbankingRequest.FromBankAccountNumber;
import com.mypay.banking.domain.FirmbankingRequest.FromBankName;
import com.mypay.banking.domain.FirmbankingRequest.MoneyAmount;
import com.mypay.banking.domain.FirmbankingRequest.ToBankAccountNumber;
import com.mypay.banking.domain.FirmbankingRequest.ToBankName;
import com.mypay.common.PersistenceAdapter;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataFirmbankingRequestRepository firmbankingRequestRepository;

    @Override
    public FirmbankingRequestJpaEntity createFirmbankingRequest(FromBankName fromBankName, FromBankAccountNumber fromBankAccountNumber, ToBankName toBankName, ToBankAccountNumber toBankAccountNumber, MoneyAmount moneyAmount, FirmbankingStatus firmbankingStatus) {
        FirmbankingRequestJpaEntity entity = firmbankingRequestRepository.save(
            new FirmbankingRequestJpaEntity(
                fromBankName.getFromBankName(),
                fromBankAccountNumber.getFromBankAccountNumber(),
                toBankName.getToBankName(),
                toBankAccountNumber.getToBankAccountNumber(),
                moneyAmount.getMoneyAmount(),
                firmbankingStatus.getFirmbankingStatus(),
                UUID.randomUUID()
            ));
        return entity;
    }

    @Override
    public FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity entity) {
        return firmbankingRequestRepository.save(entity);
    }


}
