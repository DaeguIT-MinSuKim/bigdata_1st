package kr.or.dgit.bigdata.diet.mappers;

import java.util.List;

import kr.or.dgit.bigdata.diet.dto.Member;

public interface MemberMapper {
	int insertMember(Member member);
	List<Member> selectAllMembers();
}
