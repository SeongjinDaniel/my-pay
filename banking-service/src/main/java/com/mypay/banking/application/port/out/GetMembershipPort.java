package com.mypay.banking.application.port.out;

public interface GetMembershipPort {

    MembershipStatus getMembership(String membershipId);
}
