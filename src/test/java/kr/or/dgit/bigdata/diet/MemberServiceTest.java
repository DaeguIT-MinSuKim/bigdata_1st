package kr.or.dgit.bigdata.diet;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import kr.or.dgit.bigdata.diet.dto.Member;
import kr.or.dgit.bigdata.diet.service.CalorieService;
import kr.or.dgit.bigdata.diet.service.MemberService;

public class MemberServiceTest {
	
	private static MemberService memberService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		memberService = MemberService.getInstance();
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		memberService=null;
	}

	@Test
	public void testInsert() {
		
		Member mem = new Member();
		
		mem.setAddress("세종");
		mem.setAge(27);
		mem.setBudget(950000);
		mem.setGender("여");
		mem.setName("임선희");
		mem.setNo(1);
		mem.setPhone("010-9471-5821");
		mem.setWeight(55);
		
		int res= memberService.insertMember(mem);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void testSelectMemberByNo() {
		
		Member res= memberService.selectMemberByNo(2);
		Assert.assertNotNull(res);
		
	}

}
