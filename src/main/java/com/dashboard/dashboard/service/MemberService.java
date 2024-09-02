package com.dashboard.dashboard.service;

import com.dashboard.dashboard.domain.Member;
import com.dashboard.dashboard.domain.MemberUpdateDto;
import com.dashboard.dashboard.repository.MemberMapper;
import com.dashboard.dashboard.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements MemberServiceImpl {

    private final MemberMapper memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member register(Member member) {
        memberRepository.save(member);
        return member;
    }

    @Override
    public void login(String id, String password) {

    }

    @Override
    public void update(int memberNo, MemberUpdateDto memberUpdateDto) {
        memberRepository.update(memberNo, memberUpdateDto);
    }

    @Override
    public void delete(int id) {
        memberRepository.delete(id);
    }
}
