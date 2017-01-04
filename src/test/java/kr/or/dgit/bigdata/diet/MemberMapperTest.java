package kr.or.dgit.bigdata.diet;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class MemberMapperTest {
	private static MemberService memberService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		memberService = MemberService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		memberService = null;
	}

//	@Test
//	public void testInsertMember() {
//		Member member = new Member();
//		member.setNo(2);
//		member.setName("박경아");
//		member.setGender("여");
//		member.setWeight(45);
//		member.setAge(26);
//		member.setPhone("010-1234-5678");
//		member.setAddress("모름");
//		member.setBudget(500000);
//		
//		int res = memberService.insertMember(member);
//		
//		Assert.assertEquals(1, res);
//	}
	
	@Test
	public void testSelectAllMembers(){
		List<Member> list = memberService.selectAllMembers();
		
		Assert.assertNotNull(list);
		
		for (Member member : list) {
			System.out.println(member);
		}
	}

}
