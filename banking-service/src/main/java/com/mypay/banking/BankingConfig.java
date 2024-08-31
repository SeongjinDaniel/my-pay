package com.mypay.banking;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mypay.common") // common 패키지의 모든것을 빈으로 등록하고 시작
public class BankingConfig {

}
