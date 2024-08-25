package com.mypay.money.adapter.out.persistence;

import com.mypay.money.domain.MoneyChangingRequest;
import com.mypay.money.domain.MoneyChangingRequest.ChangingMoneyAmount;
import com.mypay.money.domain.MoneyChangingRequest.MoneyChangingRequestId;
import com.mypay.money.domain.MoneyChangingRequest.MoneyChangingStatus;
import com.mypay.money.domain.MoneyChangingRequest.MoneyChangingType;
import com.mypay.money.domain.MoneyChangingRequest.TargetMembershipId;
import com.mypay.money.domain.MoneyChangingRequest.Uuid;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {
    public MoneyChangingRequest mapToDomainEntity(MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity) {
        return MoneyChangingRequest.generateMoneyChangingRequest(
            new MoneyChangingRequestId(moneyChangingRequestJpaEntity.getMoneyChangingRequestId()+""),
            new TargetMembershipId(moneyChangingRequestJpaEntity.getTargetMembershipId()),
            new MoneyChangingType(moneyChangingRequestJpaEntity.getMoneyChangingType()),
            new ChangingMoneyAmount(moneyChangingRequestJpaEntity.getMoneyAmount()),
            new MoneyChangingStatus(moneyChangingRequestJpaEntity.getChangingMoneyStatus()),
            new Uuid(moneyChangingRequestJpaEntity.getUuid())
        );
    }
}
