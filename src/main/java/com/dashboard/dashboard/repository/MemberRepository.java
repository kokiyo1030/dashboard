package com.dashboard.dashboard.repository;

import com.dashboard.dashboard.domain.Member;
import com.dashboard.dashboard.domain.MemberUpdateDto;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository implements MemberMapper {

    private final MemberMapper memberMapper;

    public MemberRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Member save(Member member) {
        memberMapper.save(member);
        return member;
    }

    @Override
    public void update(int memberNo, MemberUpdateDto updateDto) {
        memberMapper.update(memberNo, updateDto);
    }

    @Override
    public void delete(int memberNo) {
        memberMapper.delete(memberNo);
    }
}
