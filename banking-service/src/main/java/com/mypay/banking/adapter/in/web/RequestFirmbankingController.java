package com.mypay.banking.adapter.in.web;

import com.mypay.banking.application.port.in.RequestFirmbankingCommand;
import com.mypay.banking.application.port.in.RequestFirmBankingUseCase;
import com.mypay.banking.domain.FirmbankingRequest;
import com.mypay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmbankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping(path = "/banking/firmbanking/request")
    FirmbankingRequest registerMembership(@RequestBody RequestFirmbankingRequest request) {

        RequestFirmbankingCommand command = RequestFirmbankingCommand.builder()
            .fromBankName(request.getFromBankName())
            .fromBankAccountNumber(request.getFromBankAccountNumber())
            .toBankName(request.getToBankName())
            .toBankAccountNumber(request.getToBankAccountNumber())
            .moneyAmount(request.getMoneyAmount())
            .build();

        return requestFirmBankingUseCase.requestFirmbanking(command);
    }
}
