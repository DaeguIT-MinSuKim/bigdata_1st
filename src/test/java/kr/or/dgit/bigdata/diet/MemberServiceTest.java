package kr.or.dgit.bigdata.diet;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class MemberServiceTest {
	private static MemberService memberService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		memberService = MemberService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		memberService = null;
	}

	@Test
	public void testSelectMemberByNo() {
		Member member = memberService.getInstance().selectMemberByNo(2);
		
		Assert.assertNotNull(member);
	}

	@Test
	public void testSelectAllMember(){
		ArrayList<Member> list = memberService.selectAllMember();
		
		Assert.assertNotNull(list);
	}
	
	@Test
	public void testInsertMember(){
		Member member = new Member();
		member.setAddress("대구");
		member.setAge(25);
		member.setBudget(990000);
		member.setGender("여");
		member.setName("강보영");
		member.setPhone("010-2678-4160");
		member.setWeight(48);
		
		int res = memberService.insertMember(member);
		
		Assert.assertEquals(res, 1);
	}
}
