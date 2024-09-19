package com.mypay.money.adapter.in.web;

import com.mypay.common.WebAdapter;
import com.mypay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.mypay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.mypay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestMoneyChangingController {

    private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;

    // private final DecreaseMoneyRequestUseCase decreaseMoneyRequestUseCase;

    @PostMapping(path = "/money/increase")
    MoneyChangingResultDetail increaseMoneyChangingRequest(@RequestBody IncreaseMoneyChangingRequest request) {
        IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
            .targetMembershipId((request.getTargetMembershipId()))
            .amount(request.getAmount())
            .build();

        MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command);

        // -> MoneyChangingRequest -> MoneyChangingResultDetail
        return new MoneyChangingResultDetail(
            moneyChangingRequest.getMoneyChangingRequestId(),
            0,
            0,
            moneyChangingRequest.getChangingMoneyAmount()
        );
    }

    @PostMapping(path = "/money/increase-async")
    MoneyChangingResultDetail increaseMoneyChangingRequestAsync(@RequestBody IncreaseMoneyChangingRequest request) {
        IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
            .targetMembershipId((request.getTargetMembershipId()))
            .amount(request.getAmount())
            .build();

        MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequestAsync(command);

        // -> MoneyChangingRequest -> MoneyChangingResultDetail
        return new MoneyChangingResultDetail(
            moneyChangingRequest.getMoneyChangingRequestId(),
            0,
            0,
            moneyChangingRequest.getChangingMoneyAmount()
        );
    }

    @PostMapping(path = "/money/decrease")
    MoneyChangingResultDetail decreaseMoneyChangingRequest(@RequestBody DecreaseMoneyChangingRequest request) {
        // -> MoneyChangingResultDetail
        // return decreaseMoneyRequestUseCase.decreaseMoneyChangingRequest(command);
        return null;
    }
}
