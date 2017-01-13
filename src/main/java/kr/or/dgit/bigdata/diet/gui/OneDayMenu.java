package kr.or.dgit.bigdata.diet.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.service.MenuService;

public class OneDayMenu {
	int n;	         //메뉴개수
	int calSum;	     //1일칼로리합
	int costSum;     //1일총예산합
	int seafoodCnt;  //생선%해산물 횟수
	int meatCnt;     //고기 횟수
	int drinkCalSum; //음료칼로리합
	
	ArrayList<Menu> menuList = new ArrayList<Menu>(); //메뉴 리스트
	private ArrayList<Menu> tempmenuList;
	
	public OneDayMenu(int goodCal, int oneDayCost) { //(권장 칼로리, 1일예산, 시도횟수)
		
		
		tempmenuList = MenuService.getInstance().getMenuAll();
		while(true){
			 if(makeOneDay(goodCal, oneDayCost)) break;
			 //System.out.println("repeat");
		}
	}

	private boolean makeOneDay(int goodCal, int oneDayCost) { //(권장 칼로리, 1일예산, 시도횟수)
		int allCostSum = 0; //합산예산 = 0
		int allCalSum = 0; //합산칼로리 = 0
		int rndCost = 0; //랜덤예산 = 0
		
		n = 0;	//메뉴개수
		calSum = 0;	//1일칼로리합
		costSum = 0; //1일총예산합
		seafoodCnt = 0; //생선%해산물 횟수
		meatCnt = 0; //고기 횟수
		drinkCalSum = 0; //음료칼로리합
		menuList.clear();
		
		//신규예산 <= 조건( 1일예산-만원 < 랜덤예산 < min(1일예산+만원,3만원) )
		//int newCost = (int)( (Math.random() * (Math.min(oneDayCost+10000, 30000))) + (oneDayCost-10000));
		int newCost = (int)(    (  Math.random() * ( Math.min(oneDayCost+10000, 30000)-(oneDayCost-10000) )  )     +     (oneDayCost-10000)    );
		
		Random rnd = new Random();
		
		while (true) {			
						
			int x = rnd.nextInt(15)+1;  //1~15 <--- 1~24
			
			if (x == 1) { 					// 1 이면 고기
				int y = rnd.nextInt(4)+1;   //1~4
				x = y;
			}else if(x==2 || x==3){ 		//2도는 3 이면 생선 & 해산물
				int y = rnd.nextInt(4)+5;   //5~8  
				x = y;
			}else if(x==4){			//4,5이면 음료
				int y = rnd.nextInt(4)+9;   //9~12
				x = y;
			}else if(x==5 || x==6){         //5, 6 이면 빵씨리얼
				int y = rnd.nextInt(4)+21;   //16이면 21~24
				x = y;
			}else{ //나머지  채소
				x = x + 5; 
			}
		
					 
			//Menu newMenu = MenuService.getInstance().getMenu(x); //신menu = 랜덤menu
			Menu newMenu = tempmenuList.get(x-1);
			allCostSum += newMenu.getCost();//합산예산 += 신menu.예산
			allCalSum += newMenu.getCal();//합산칼로리 += 신menu.칼로리
			
			//System.out.println(newMenu);
			
			//합산예산 < 신규예산 and 합산칼로리 < 권장칼로리 + 100
			if (allCostSum < newCost && allCalSum < (goodCal + 100)) {
				menuList.add(newMenu); //메뉴 확정으로 저장
				calSum = allCalSum;    //메뉴 확정으로 아래 계산
				costSum = allCostSum;
				seafoodCnt += newMenu.getGrp().equals("생선&해산물") ? 1 : 0;
				meatCnt += newMenu.getGrp().equals("고기") ? 1 : 0;
				drinkCalSum += newMenu.getGrp().equals("음료") ? newMenu.getCal() : 0;
				n++;
			}else{
				//System.out.println(allCostSum + "  "  +   newCost + "  "  + allCalSum + "  "  + (goodCal + 100));
		/*		System.out.println("===================================");
				System.out.println(newCost);
				System.out.println("메뉴 개수 : "+ n);
				System.out.println("1일 칼로리 합 : " + calSum);
				System.out.println("1일 총예산 합 : " + costSum);
				System.out.println("생선&해산물 개수 : " + seafoodCnt);
				System.out.println("고기 횟수 : " + meatCnt);
				System.out.println("음료 칼로리 합 : " + drinkCalSum);*/
				break;
			}
		}
		
		/***  본 문제는 예산을 지나치게 많이 책정되어서 최저예산(1일예산-1만원)보다 적은 금액으로도 쉽게 권장칼로리를 넘게 설계되어 있음  **/ 
		
		
		//만약 1일 음료칼로리합이 500cal 넘거나 1일예산-만원 보다 적을 경우 다시 생성
		if ((drinkCalSum > 500) || ((oneDayCost-10000) > costSum)) {
			if(((oneDayCost-10000) > costSum)) System.out.println("=== 실격 : 최소예산 미달로 탈락");
			if((drinkCalSum > 500)) System.out.println("=== 실격 : 1일 음료수 칼로리 초과로 탈락");
			//System.out.println("음료칼로리합산 : " + drinkCalSum);
			//System.out.println("섭취칼로리 : " + calSum);
			//System.out.println("--> 메뉴합산예산 : " + costSum + "    1일예산-만원 : " + (oneDayCost-10000) +"<  신규예산 : " + newCost +  " <  1일예산최대  :"+Math.min(oneDayCost+10000, 30000));
			return false;
		}else return true;
	}
}