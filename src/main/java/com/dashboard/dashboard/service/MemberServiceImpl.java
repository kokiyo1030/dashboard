package com.dashboard.dashboard.service;

import com.dashboard.dashboard.domain.Member;
import com.dashboard.dashboard.domain.MemberUpdateDto;

public interface MemberServiceImpl {

    Member register(Member member);

    void login(String id, String password);

    void update(int memberNo, MemberUpdateDto memberUpdateDto);

    void delete(int id);

}
