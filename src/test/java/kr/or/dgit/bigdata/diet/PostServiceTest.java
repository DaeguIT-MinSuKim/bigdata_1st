package kr.or.dgit.bigdata.diet;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.diet.dto.Post;
import kr.or.dgit.bigdata.diet.service.PostService;


public class PostServiceTest {
	private static PostService postService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		postService = PostService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		postService = null;
	}
	
	@Test
	public void testSelectSido(){
		List<Post> list = postService.getInstance().selectSido();
		
		Assert.assertNotNull(list);
	}
	
	@Test
	public void testSearchDoro(){
		Post post = new Post("강원도", "임곡로");
		List<Post> list = postService.getInstance().searchDoro(post);
		
		Assert.assertNotNull(list);
	}
}
