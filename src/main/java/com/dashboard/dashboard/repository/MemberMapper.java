package com.dashboard.dashboard.repository;

import com.dashboard.dashboard.domain.Member;
import com.dashboard.dashboard.domain.MemberUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    Member save(Member member);

    void update(@Param("memberNo") int memberNo,@Param("updateDto") MemberUpdateDto updateDto);

    void delete(int memberNo);

}
