package kr.or.dgit.bigdata.diet.mappers;

import kr.or.dgit.bigdata.diet.dto.Calorie;

public interface CalorieMapper {

	Calorie selectCalorieByAge(int age);

}
