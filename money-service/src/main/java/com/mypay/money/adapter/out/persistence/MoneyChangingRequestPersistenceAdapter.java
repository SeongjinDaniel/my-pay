package com.mypay.money.adapter.out.persistence;

import com.mypay.common.PersistenceAdapter;
import com.mypay.money.application.port.out.IncreaseMoneyPort;
import com.mypay.money.domain.MemberMoney.MembershipId;
import com.mypay.money.domain.MemberMoney.MoneyBalance;
import com.mypay.money.domain.MoneyChangingRequest.ChangingMoneyAmount;
import com.mypay.money.domain.MoneyChangingRequest.MoneyChangingStatus;
import com.mypay.money.domain.MoneyChangingRequest.MoneyChangingType;
import com.mypay.money.domain.MoneyChangingRequest.TargetMembershipId;
import com.mypay.money.domain.MoneyChangingRequest.Uuid;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

    private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;
    private final SpringDataMemberMoneyRepository memberMoneyRepository;

    @Override
    public MoneyChangingRequestJpaEntity createMoneyChangingRequest(TargetMembershipId targetMembershipId,
        MoneyChangingType moneyChangingType, ChangingMoneyAmount changingMoneyAmount,
        MoneyChangingStatus moneyChangingStatus, Uuid uuid) {
        return moneyChangingRequestRepository.save(
            new MoneyChangingRequestJpaEntity(
                targetMembershipId.getTargetMembershipId(),
                moneyChangingType.getMoneyChangingType(),
                changingMoneyAmount.getChangingMoneyAmount(),
                new Timestamp(System.currentTimeMillis()), // TODO: 2021-08-17 11:00:00
                moneyChangingStatus.getMoneyChangingStatus(),
                UUID.randomUUID()
            )
        );
    }

    @Override
    public MemberMoneyJpaEntity increaseMoney(MembershipId memberId, int increaseMoneyAmount) {
        MemberMoneyJpaEntity entity;
        try {
            List<MemberMoneyJpaEntity> entities = memberMoneyRepository.findByMembershipId(Long.parseLong(memberId.getMembershipId()));
            entity = entities.get(0); // 첫번째것만 받는 다고 가정

            entity.setBalance(entity.getBalance() + increaseMoneyAmount);
            return memberMoneyRepository.save(entity);
        } catch (Exception e) {
            entity = new MemberMoneyJpaEntity(
                Long.parseLong(memberId.getMembershipId()),
                increaseMoneyAmount
            );
            return memberMoneyRepository.save(entity);
        }
    }
}
