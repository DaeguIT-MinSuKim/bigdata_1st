package kr.or.dgit.bigdata.diet.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import kr.or.dgit.bigdata.diet.dto.Menu;
import kr.or.dgit.bigdata.diet.service.MenuService;

public class OneDayMenu {
   int n;            //메뉴개수
   int calSum;        //1일칼로리합
   int costSum;     //1일총예산합
   int seafoodCnt;  //생선%해산물 횟수
   int meatCnt;     //고기 횟수
   int drinkCalSum; //음료칼로리합
   
   int gogiNumSum =0;   //전체 메뉴 중에서 고기 항목 갯수 저장(170116 추가)
   int fishNumSum =0;   //                     170116 추가
   int drinkNumSum =0;   //                    170116 추가
   int fluitNumSum =0;//                    170116 추가
   int vegiNumSum =0;//                    170116 추가
   int breadNumSum =0;//                    170116 추가
   
   int menulistSum=0;    //전체 메뉴 갯수 0116 추가
   ArrayList<Integer> menuNumArray;    //메뉴 검색을 위한 항목 배열
   boolean meatFlag = false;   //local에서 field로 변경(170116)
   
   
   public ArrayList<Menu> menuList = new ArrayList<Menu>(); //메뉴 리스트
   private ArrayList<Menu> DBmenuList;   //db에서 받아 오는 메뉴 리스트
   public int gogi[]= new int[1000];//                    170116 추가
   public int fish[]= new int[1000];//                    170116 추가
   public int drink[]= new int[1000];//                    170116 추가
   public int fluit[]= new int[1000];//                    170116 추가
   public int vegi[]= new int[1000];//                    170116 추가
   public int bread[]= new int[1000];//                    170116 추가
   
   private void gogi_fish_drink_set(ArrayList<Menu> tempmenuList2) {
      for (Menu menu : tempmenuList2) {
         if(menu.getGrp().equals("고기")){
            gogi[gogiNumSum]=menu.getNo();                    // gogi[3,4,6,9] 고기 array와  고기 갯수 gogiNumSum=4 저장 
            gogiNumSum++;            
            
         }else if(menu.getGrp().equals("생선&해산물")){
            fish[fishNumSum]=menu.getNo();
            fishNumSum++;
         }else if(menu.getGrp().equals("음료")){
            drink[drinkNumSum]=menu.getNo();
            drinkNumSum++;
         }else if(menu.getGrp().equals("과일")){
            fluit[fluitNumSum]=menu.getNo();
            fluitNumSum++;
         }else if(menu.getGrp().equals("야채")){
            vegi[vegiNumSum]=menu.getNo();
            vegiNumSum++;
         }else if(menu.getGrp().equals("빵&씨리얼")){
            bread[breadNumSum]=menu.getNo();
            breadNumSum++;
         }
      }
      //System.out.println("합계들");
      //System.out.println(gogiNumSum);
      //System.out.println(fishNumSum);
      //System.out.println(drinkNumSum);
      
      menulistSum = tempmenuList2.size();
   }
   
   public OneDayMenu(int goodCal, int oneDayCost) { //(권장 칼로리, 1일예산, 시도횟수)
      
      
      DBmenuList = (ArrayList<Menu>) MenuService.getInstance().selectAllMenu();
      
      gogi_fish_drink_set(DBmenuList);
      
      while(true){
          if(makeOneDay(goodCal, oneDayCost)) break;
          //System.out.println("repeat");
      }
   }
   

   private boolean makeOneDay(int goodCal, int oneDayCost) { //(권장 칼로리, 1일예산, 시도횟수)
      int allCostSum = 0; //합산예산 = 0
      int allCalSum = 0; //합산칼로리 = 0
      int rndCost = 0; //랜덤예산 = 0
      
      n = 0;   //메뉴개수
      calSum = 0;   //1일칼로리합
      costSum = 0; //1일총예산합
      seafoodCnt = 0; //생선%해산물 횟수
      meatCnt = 0; //고기 횟수
      drinkCalSum = 0; //음료칼로리합
      menuList.clear();
      
      
      
      //신규예산 <= 조건( 1일예산-만원 < 랜덤예산 < min(1일예산+만원,3만원) )
      //int newCost = (int)( (Math.random() * (Math.min(oneDayCost+10000, 30000))) + (oneDayCost-10000));
      int newCost = (int)(    (  Math.random() * ( Math.min(oneDayCost+10000, 30000)-(oneDayCost-10000) )  )     +     (oneDayCost-10000)    );
      
      
      
      while (true) {         
         
         //고기 확률은 다른 메뉴보다 1/4로 맞춤..
         //생선확률 다른 메뉴보다 1/2로 맞춤..
         //빵시리얼 다른 메뉴보다 1/2로 맞춤..
         //음료 다른 메뉴보다 1/2로 맞춤..
         Random rnd = new Random(); 
         
         int r = gogiNumSum/4 + fishNumSum/2 + drinkNumSum/2 + fluitNumSum + vegiNumSum + breadNumSum/2;
         //System.out.println(" r 값   ::::::::::::::"+ r );
         int z = rnd.nextInt(r)+1;
         if ( z <= gogiNumSum/4 ) {                      //고기
            int y = rnd.nextInt(gogiNumSum);            //0~3
            if(!meatFlag) meatFlag = true;
            else meatFlag = false;
            if(meatFlag) continue ;  //   
            else z = gogi[y];
         }else if( z <= gogiNumSum/4 + fishNumSum/2 ){       //생선
            int y = rnd.nextInt(fishNumSum);                  //0~3  
            z = fish[y];
         }else if(z <= gogiNumSum/4 + fishNumSum/2 + drinkNumSum/2){         // 음료
            int y = rnd.nextInt(drinkNumSum);                                    //9~12
            z = drink[y];;
         }else if(z <= gogiNumSum/4 + fishNumSum/2 + drinkNumSum/2 + fluitNumSum){         // 과일
            int y = rnd.nextInt(fluitNumSum);                                       //16이면 21~24
            z = fluit[y];
         }else if(z <= gogiNumSum/4 + fishNumSum/2 + drinkNumSum/2 + fluitNumSum + vegiNumSum ){         // 야채
            int y = rnd.nextInt(vegiNumSum);                                       //16이면 21~24
            z = vegi[y];
         }else if(z <= gogiNumSum/4 + fishNumSum/2 + drinkNumSum/2 + fluitNumSum + vegiNumSum + breadNumSum/2){         // 야채
            int y = rnd.nextInt(breadNumSum);                                       //16이면 21~24
            z = bread[y];
         }         
         
         /*int x = rnd.nextInt(15)+1;  //1~15 <--- 1~24(6%<--16%)
         
         if (x == 1) {                // 1 이면 고기
            int y = rnd.nextInt(4)+1;   //1~4
            if(!meatFlag) meatFlag = true;
            else meatFlag = false;
            if(meatFlag) x = y+10;
            else x = y;
         }else if(x==2 || x==3){       //2도는 3 이면 생선 & 해산물
            int y = rnd.nextInt(4)+5;   //5~8  
            x = y;
         }else if(x==4){         //4,5이면 음료
            int y = rnd.nextInt(4)+9;   //9~12
            x = y;
         }else if(x==5 || x==6){         //5, 6 이면 빵씨리얼
            int y = rnd.nextInt(4)+21;   //16이면 21~24
            x = y;
         }else{ //나머지  채소
            x = x + 5; 
         }*/
      
         //System.out.println("z값 :::::::: " + z);
                
         //Menu newMenu = MenuService.getInstance().getMenu(x); //신menu = 랜덤menu
         //Menu newMenu = DBmenuList.get(x-1);
         
         Menu newMenu = DBmenuList.get(z-1);
         
         allCostSum += newMenu.getCost();//합산예산 += 신menu.예산
         allCalSum += newMenu.getCal();//합산칼로리 += 신menu.칼로리
         
         
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
      /*      System.out.println("===================================");
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
