package com.mypay.money.application.service;

import com.mypay.common.UseCase;
import com.mypay.money.adapter.out.persistence.MoneyChangingRequestMapper;
import com.mypay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.mypay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.mypay.money.application.port.out.IncreaseMoneyPort;
import com.mypay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

    private final IncreaseMoneyPort increaseMoneyPort;
    private final MoneyChangingRequestMapper mapper;


    @Override
    public MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command) {

        // 머니의 충전, 증액이라는 과정
        // 1. 고객 정보가 정상인지 확인 (멤버)

        // 2. 고객의 연동된 계좌가 있는지, 고객의 연동된 계좌의 잔액이 충분한지도 확인 (뱅킹)

        // 3. 법인 계좌 상태도 정상인지 확인 (뱅킹)

        // 4. 증액을 위한 "기록", 요청 상태로 MoneyChangingRequest 를 생성한다. (MoneyChangingRequest)

        // 5. 펌뱅킹을 수행하고 (고객의 연된된 계좌 -> 마이페이 법인 계좌) (뱅킹)

        // 6-1. 결과가 정상적이라면. 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴

        // 6-2. 결과가 실패라면, 실패라고 MoneyChangingRequest 상태값을 변동 후에 리턴

        return null;
    }
}
