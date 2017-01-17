package kr.or.dgit.bigdata.diet.mappers;

import kr.or.dgit.bigdata.diet.dto.Calorie;
import kr.or.dgit.bigdata.diet.dto.Member;

public interface CalorieMapper {

	Calorie selectCalorieByAge(int age);
	Calorie selectCalorieByAgeNo(Member member);
}
