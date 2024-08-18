package com.mypay.membership.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypay.membership.domain.Membership;
import com.mypay.membership.domain.Membership.MembershipAddress;
import com.mypay.membership.domain.Membership.MembershipEmail;
import com.mypay.membership.domain.Membership.MembershipId;
import com.mypay.membership.domain.Membership.MembershipIsCorp;
import com.mypay.membership.domain.Membership.MembershipIsValid;
import com.mypay.membership.domain.Membership.MembershipName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("멤버쉽을 등록해서 요청과 응답이 같은지 확인한다.")
    @Test
    void testRegisterMembership() throws Exception {
        RegisterMembershipRequest request = new RegisterMembershipRequest("name",
            "address", "email", false);
        Membership expect = Membership.generateMember(
            new MembershipId("1"),
            new MembershipName("name"),
            new MembershipEmail("email"),
            new MembershipAddress("address"),
            new MembershipIsValid(true),
            new MembershipIsCorp(false)
        );

        mockMvc.perform(
            MockMvcRequestBuilders.post("/membership/register/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(expect)));
    }

}