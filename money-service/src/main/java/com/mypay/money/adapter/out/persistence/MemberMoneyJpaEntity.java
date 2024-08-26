package com.mypay.money.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member_money")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberMoneyJpaEntity {

    @Id
    @GeneratedValue
    private Long memberMoneyId;

    private Long membershipId;

    private int balance; // 잔액

    public MemberMoneyJpaEntity(Long membershipId, int balance) {
        this.membershipId = membershipId;
        this.balance = balance;
    }
}
