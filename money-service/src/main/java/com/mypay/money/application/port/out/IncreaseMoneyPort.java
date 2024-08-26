package com.mypay.money.application.port.out;

import com.mypay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.mypay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.mypay.money.domain.MemberMoney;
import com.mypay.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

    MoneyChangingRequestJpaEntity createMoneyChangingRequest(
        MoneyChangingRequest.TargetMembershipId targetMembershipId,
        MoneyChangingRequest.MoneyChangingType moneyChangingType,
        MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
        MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus,
        MoneyChangingRequest.Uuid uuid
    );

    MemberMoneyJpaEntity increaseMoney (
        MemberMoney.MembershipId membershipId,
        int increaseMoneyAmount
    );
}
