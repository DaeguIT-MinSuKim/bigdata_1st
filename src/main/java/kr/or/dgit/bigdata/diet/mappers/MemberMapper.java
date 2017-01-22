package kr.or.dgit.bigdata.diet.mappers;

import java.util.ArrayList;

import kr.or.dgit.bigdata.diet.dto.Member;

public interface MemberMapper {
	int insertMember(Member member);		//멤버 삽입
	Member selectMemberByNo(int no);		//특정 넘버의 멤버 가져오기
	int selectMemberSum();				//모든 멤버 명수 가져오기
	ArrayList<Member> selectAllMember(); //모든 멤버 가져오기
	int deleteMember(int no); //멤버 삭제
	int updateMember(Member member); //멤버 수정
}