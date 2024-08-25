package com.mypay.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {
    private String moneyChangingRequestId;

    // 증액, 감액
    private int moneyChangingType;
    private int moneyChangingResultStatus;
    private int amount;
}

//enum MoneyChangingType {
//    INCREASING, // 증액
//    DECREASING // 감액
//}
//
//enum MoneyChangingResultStatus {
//    SUCCEEDED, // 성공
//    FAILED, // 실패
//    FAILED_NOT_ENOUGH_MONEY, // 실패 - 잔액 부족
//    FAILED_NOT_EXIST_MEMBERSHIP, // 실패 - 멤버십 없음
//}
