package kr.or.dgit.bigdata.diet.service;

import org.apache.log4j.Logger;

public class MemberService {

	private static final Logger logger = Logger.getLogger(MemberService.class);

	private static final MemberService instance = new MemberService();

	public static MemberService getInstance() {
		return instance;
	}
	
}
