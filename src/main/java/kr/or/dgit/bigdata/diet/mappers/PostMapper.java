package kr.or.dgit.bigdata.diet.mappers;

import java.util.List;

import kr.or.dgit.bigdata.diet.dto.Post;

public interface PostMapper {
	List<Post> selectSido();
	List<Post> searchDoro(Post post);
}
