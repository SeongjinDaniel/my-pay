package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.external.bank.BankAccount;
import com.mypay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mypay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.mypay.banking.application.port.in.RegisterBankAccountCommand;
import com.mypay.banking.application.port.in.RegisterBankAccountUseCase;
import com.mypay.banking.application.port.out.GetMembershipPort;
import com.mypay.banking.application.port.out.MembershipStatus;
import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import com.mypay.banking.domain.RegisteredBankAccount;
import com.mypay.banking.domain.RegisteredBankAccount.BankAccountNumber;
import com.mypay.banking.domain.RegisteredBankAccount.BankName;
import com.mypay.banking.domain.RegisteredBankAccount.LinkedStatusIsValid;
import com.mypay.banking.domain.RegisteredBankAccount.MembershipId;
import com.mypay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final GetMembershipPort getMembershipPort;
    private final RegisterBankAccountPort registerBankAccountPort;
    private final RegisteredBankAccountMapper mapper;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야하는 서비스 (비즈니스 로직)
//        command.getMembershipId();

        // (멤버 서비스도 확인?) 여기서는 skip

        // call membership sv, 정상인지 확인
        // call external bank svc, 정상인지 확인
        MembershipStatus membershipStaus = getMembershipPort.getMembership(command.getMembershipId());
        if (!membershipStaus.isValid()) {
            return null;
        }

        // 1. 외부 실제 은행에 등록이 가능한 계좌인지(정상인지) 확인한다.
        // 외부의 은행에 이 계좌 정상인지? 확인을 해야해요.
        // Biz Logic -> External System
        // Port -> Adapter -> External System
        // Port
        // 실제 외부의 은행계좌 정보를 Get
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid = accountInfo.isValid();

        // 2. 등록가능한 계좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
        // 2-1. 등록가능하지 않은 계좌라면, 에러를 리턴
        if (accountIsValid) {
            // 등록 정보 저장
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
                new MembershipId(command.getMembershipId()),
                new BankName(command.getBankName()),
                new BankAccountNumber(command.getBankAccountNumber()),
                new LinkedStatusIsValid(command.isValid())
            );
            return mapper.mapToDomainEntity(savedAccountInfo);
        }
        return null;
    }
}
