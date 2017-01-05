package kr.or.dgit.bigdata.diet.mappers;

import java.util.ArrayList;

import kr.or.dgit.bigdata.diet.dto.Member;

public interface MemberMapper {
	public int insertMember(Member member);		//멤버 삽입
	public Member selectMemberByNo(int no);		//특정 넘버의 멤버 가져오기
	public int selectMemberSum();				//모든 멤버 명수 가져오기
	public ArrayList<Member> selectAllMember(); //모든 멤버 가져오기
}
