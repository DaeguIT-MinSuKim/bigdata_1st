package kr.or.dgit.bigdata.diet.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.mappers.MemberMapper;
import kr.or.dgit.bigdata.diet.util.MyBatisSqlSessionFactory;


public class MemberService {

	private static final Logger logger = Logger.getLogger(MemberService.class);

	private static final MemberService instance = new MemberService();

	public static MemberService getInstance() {
		return instance;
	}
	
	public int insertMember(Member member){
		if (logger.isDebugEnabled()) {
			logger.debug("insertMember(Member) - start"); 
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			int res = memberMapper.insertMember(member);
			sqlSession.commit();
			return res;
		}finally{
			sqlSession.close();
		}
	}	
	
	
	public Member selectMemberByNo(int no){
		if (logger.isDebugEnabled()) {
			logger.debug("selectMemberByNo(no) - start"); 
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			Member res = memberMapper.selectMemberByNo(no);
			return res;
		}finally{
			sqlSession.close();
		}
	}

	public int selectMemberSum() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectMemberSum() - start"); 
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			int res = memberMapper.selectMemberSum();
			return res;
		}finally{
			sqlSession.close();
		}		
	}

	public List<Member> selectAllMember() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAllMember() - start"); 
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			ArrayList<Member> memberList = memberMapper.selectAllMember();
			return memberList;
		}finally{
			sqlSession.close();
		}
	}

	
}
