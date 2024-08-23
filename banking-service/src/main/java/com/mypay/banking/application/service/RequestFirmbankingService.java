package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.mypay.banking.adapter.out.external.bank.FirmbankingResult;
import com.mypay.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import com.mypay.banking.adapter.out.persistence.FirmbankingRequestMapper;
import com.mypay.banking.application.port.in.RequestFirmBankingUseCase;
import com.mypay.banking.application.port.in.RequestFirmbankingCommand;
import com.mypay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.mypay.banking.application.port.out.RequestFirmbankingPort;
import com.mypay.banking.domain.FirmbankingRequest;
import com.mypay.common.UseCase;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmbankingService implements RequestFirmBankingUseCase {

    private final FirmbankingRequestMapper mapper;
    private final RequestFirmbankingPort requestFirmbankingPort;
    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

    @Override
    public FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command) {
        // Business Logic
        // a -> b 계좌

        // 1. 요청에 대해 정보를 먼저 write . "요청" 상태로
        FirmbankingRequestJpaEntity requestedEntity = requestFirmbankingPort.createFirmbankingRequest(
            new FirmbankingRequest.FromBankName(command.getFromBankName()),
            new FirmbankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
            new FirmbankingRequest.ToBankName(command.getToBankName()),
            new FirmbankingRequest.ToBankAccountNumber(command.getFromBankAccountNumber()),
            new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
            new FirmbankingRequest.FirmbankingStatus(0)
        );

        // 2. 외부 은행에 펌뱅킹 요청
        FirmbankingResult result = requestExternalFirmbankingPort.requestExternalFirmbanking(
            new ExternalFirmbankingRequest(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber()
            ));

        UUID randomUUID = UUID.randomUUID();
        requestedEntity.setUuid(randomUUID.toString());

        // 3. 결과에 따라서 1번에서 작성했던 FirmbankingRequest 정보를 Update
        if (result.getResultCode() == 0) {
            // 성공
            requestedEntity.setFirmbankingStatus(1);
        } else {
            // 실패
            requestedEntity.setFirmbankingStatus(2);
        }

        // 4. 결과를 리턴하기 전에 바뀐 상태 값을 기준으로 다시 save
        return mapper.mapToDomainEntity(requestFirmbankingPort.modifyFirmbankingRequest(requestedEntity), randomUUID);
    }
}
