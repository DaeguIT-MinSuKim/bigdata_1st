package kr.or.dgit.bigdata.diet.service;

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
	
	private MemberService(){}
	
	public int insertMember(Member member){
		if (logger.isDebugEnabled()) {
			logger.debug("insertMember(Member) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			int res = memberMapper.insertMember(member);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Member> selectAllMembers(){
		if (logger.isDebugEnabled()) {
			logger.debug("selectAllMembers() - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			return memberMapper.selectAllMembers();
		} finally {
			sqlSession.close();
		}
	}
}
