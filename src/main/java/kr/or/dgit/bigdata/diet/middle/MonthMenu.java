package kr.or.dgit.bigdata.diet.middle;

import java.util.ArrayList;

public class MonthMenu {
	int dayCal; //1일 권장 칼로리
	int dayCost; //1일 예산
	int monthCost; //30일 예산	
	int dayCount; //마지막 넣은 하루 메뉴의 index(0~29)
	public int count = 0;
	
	public ArrayList<OneDayMenu> monthMenuList = new ArrayList<>();

	
	
	
	
	public MonthMenu(int dayCal, int monthCost) {
		this.dayCal = dayCal;
		this.monthCost = monthCost;
		this.dayCost = monthCost/30;
		
		dayCount = -1; //날짜 카운트 (하루 메뉴의 index가 0(1일)부터 시작하기 때문에 -1로 초기값 설정)
		
		//30일분 메뉴
		int monthM = 30;
		
		for (int i = 0; i < monthM; i++) {
			dayCount++; //0~29
			System.out.println((dayCount+1) + "일째 시도");
			OneDayMenu dayMenutemp = new OneDayMenu(this.dayCal, dayCost);
			monthMenuList.add(dayMenutemp); //하루 메뉴 받아오기
			
			count += dayMenutemp.n;
			//System.out.println("행수 : " + count);
			
			//System.out.println(monthMenuList.size());
			//System.out.println(monthMenuList.get(i).menuList.get(i).toArray());
			//고기 체크와 생선&해산물 체크 중 하나라도 false라면
			
			if (!gogiCheck(monthMenuList)||!seafoodCheck(monthMenuList)) {
			
				monthMenuList.remove(dayCount); //monthMenuList에 이미 add된 하루 메뉴 삭제
				dayCount--; //dayCount원래대로 
				monthM++; //30일을 채우기 위해
				count -= dayMenutemp.n;
				//continue;
			}else{
				System.out.println("======" + (dayCount+1) + "====성공===================");
				/*System.out.println("메뉴 개수 : "+ monthMenuList.get(dayCount).n);
				System.out.println("1일 칼로리 합 : " + monthMenuList.get(dayCount).calSum);
				System.out.println("1일 총예산 합 : " + monthMenuList.get(dayCount).costSum);
				System.out.println("생선&해산물 개수 : " + monthMenuList.get(dayCount).seafoodCnt);
				System.out.println("고기 횟수 : " + monthMenuList.get(dayCount).meatCnt);
				System.out.println("음료 칼로리 합 : " + monthMenuList.get(dayCount).drinkCalSum);*/
			}
			
		}
	}

	private boolean gogiCheck(ArrayList<OneDayMenu> getMonthMenuList) {
		
		int gogiCnt = 0; //고기 횟수
		int dc = dayCount; //고기는 일주일에 0~2회(갯수 3개)만 추가 가능
		boolean tag = false; //고기의 연속성 검사(불연속일 때가 true)
		
		if (dc != 0) {
			if (getMonthMenuList.get(dc).meatCnt > 0 && getMonthMenuList.get(dc-1).meatCnt > 0) {
				System.out.println("=== 실격 : 고기가 연속이라 탈락");
				return false;
			}
		}
		//System.out.println(((dc+1) +  "일 검사결과  고기는 " + getMonthMenuList.get(dc).meatCnt));
		for (int i = 0; i < 7; i++) { //최근부터 일주일을 거꾸로 점검
			dc = dayCount-i; 					//dayCount-1
			
			if (dc >= 0) { //이전 날짜로 줄어들면서 반복
				//고기를 한 번 이라도 먹었다면
				
				gogiCnt += getMonthMenuList.get(dc).meatCnt; //고기 카운트 저장
			}
		}
		//고기 횟수가 3이 되면
		if (gogiCnt > 2) {
			//System.out.println("고기카운트  " + gogiCnt);
			System.out.println("=== 실격 : 1주일에 고기가 많아서 탈락");
			return false;
			
		}else return true;
	}
	
	
	private boolean seafoodCheck(ArrayList<OneDayMenu> getMonthMenuList) {
		int seafoodCnt = 0; //생선&해산물 횟수
		int dc = dayCount;
		
		//최근부터 3일을 거꾸로 점검
		for (int i = 0; i < 3; i++) {
			dc = dayCount - i;
			
			if (dc >= 0) { //이전 날짜로 줄어들면서 반복
				seafoodCnt += getMonthMenuList.get(dc).seafoodCnt; //생선 카운트 저장
				
			}
		}
			
		
		//생선을 먹은 횟수가 1~5가 아니면 false
		if(seafoodCnt < 1 || seafoodCnt > 5) {
			System.out.println("=== 실격 : 3일에 해산물이 5회 이상이라 탈락");
			return false;
			
		}else return true;
	}

}
