package com.mypay.money.application.port.out;

import com.mypay.common.RechargingMoneyTask;

public interface SendRechargingMoneyTaskPort {

    void sendRechargingMoneyTaskPort (
        RechargingMoneyTask task
    );
}
