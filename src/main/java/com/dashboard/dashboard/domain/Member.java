package com.dashboard.dashboard.domain;

import lombok.Data;

@Data
public class Member {

    private int memberNo;
    private String memberName;
    private String memberId;
    private String memberPw;
    private int memberAge;

    public Member(String memberName, String memberId, String memberPw, int memberAge) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberAge = memberAge;
    }
}
