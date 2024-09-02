package com.mypay.money.application.port.out;


public interface GetMembershipPort {

    MembershipStatus getMembership(String membershipId);
}
