package kr.or.dgit.bigdata.diet.mappers;

import kr.or.dgit.bigdata.diet.dto.Member;

public interface MemberMapper {
	public int insertMember(Member member);
	public Member selectMemberByNo(int no);
}
