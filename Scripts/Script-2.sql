-- diet
DROP SCHEMA IF EXISTS diet;

-- diet
CREATE SCHEMA diet;

-- Member
CREATE TABLE diet.Member (
	no      INT(4)      NOT NULL COMMENT '회원번호', -- 회원번호
	name    VARCHAR(10) NOT NULL COMMENT '이름', -- 이름
	gender  VARCHAR(4)  NOT NULL COMMENT '성별', -- 성별
	weight  INT(3)      NOT NULL COMMENT '몸무게', -- 몸무게
	age     INT(3)      NOT NULL COMMENT '나이', -- 나이
	phone   VARCHAR(20) NOT NULL COMMENT '휴대전화', -- 휴대전화
	address VARCHAR(30) NOT NULL COMMENT '거주지', -- 거주지
	budget  INT(10)     NOT NULL COMMENT '월예산' -- 월예산
)
COMMENT 'Member';

-- Calorie
CREATE TABLE diet.Calorie (
	minage    INT(3) NOT NULL COMMENT '최소나이', -- 최소나이
	maxage    INT(3) NOT NULL COMMENT '최대나이', -- 최대나이
	cal_man   INT    NOT NULL COMMENT '권장칼로리(남성)', -- 권장칼로리(남성)
	h_man     int(3) NOT NULL COMMENT '기준키(남성)', -- 기준키(남성)
	w_man     FLOAT  NOT NULL COMMENT '기준몸무게(남성)', -- 기준몸무게(남성)
	cal_woman INT    NOT NULL COMMENT '권장칼로리(여성)', -- 권장칼로리(여성)
	h_woman   int(3) NOT NULL COMMENT '기준키(여성)', -- 기준키(여성)
	w_woman   FLOAT  NOT NULL COMMENT '기준몸무게(여성)' -- 기준몸무게(여성)
)
COMMENT 'Calorie';

-- Menu
CREATE TABLE diet.Menu (
	no      INT         NULL COMMENT '번호', -- 번호
	grp     VARCHAR(20) NULL COMMENT '항목', -- 항목
	item    VARCHAR(20) NULL COMMENT '메뉴', -- 메뉴
	cal     INT         NULL COMMENT '칼로리', -- 칼로리
	fat     FLOAT       NULL COMMENT '지방', -- 지방
	carbo   FLOAT       NULL COMMENT '탄수화물', -- 탄수화물
	protein FLOAT       NULL COMMENT '단백질', -- 단백질
	cost    INT         NULL COMMENT '비용', -- 비용
	con     VARCHAR(20) NULL COMMENT '조건' -- 조건
)
COMMENT 'Menu';



-- Menu
ALTER TABLE diet.Menu
	ADD CONSTRAINT PK_Menu -- Menu 기본키
		PRIMARY KEY (
			no -- 번호
		);


-- Member
ALTER TABLE diet.Member
	ADD CONSTRAINT PK_Member -- Member 기본키
		PRIMARY KEY (
			no -- 회원번호
		);
-- 자동 증가 설정  
ALTER TABLE diet.`member` MODIFY COLUMN `no` int(4) NOT NULL AUTO_INCREMENT COMMENT '회원번호';		
ALTER TABLE diet.menu MODIFY COLUMN `no` int(11) NOT NULL AUTO_INCREMENT COMMENT '번호';		


-- 사용자 권한 주기
grant select,update,insert,delete on diet.* to user_diet@'%' identified by 'rootroot';


select * from member;
ALTER TABLE menu AUTO_INCREMENT=1;	

insert into member(name,gender,weight,age,phone,address,budget) 
		 			 values('임선희','여',55,27,'010-9471-5821','세종',950000);
		 			 
delete from member where no = 1;		

select count(*) from member;
select no,name,gender,weight,age,phone,address,budget from member ;

delete from menu ;
select * from menu;
ALTER TABLE menu AUTO_INCREMENT=1;

insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('고기','돼지갈비'	,395,30.17,0,28.94,1500,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('고기','소고기 갈비살',469,41.8 ,0,21.48,4700,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('고기','닭고기'	,237,13.49,0,27.07,5500,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('고기','오리고기'	,132,5.95,0,18.28,8000,'100g당');

insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('생선&해산물','고등어',167,9.36,0,19.32,9900,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('생선&해산물','멸치'	,131 ,4.84,0,20.35,8900,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('생선&해산물','문어'	,82  ,1.04,2.2,14.91,4650,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('생선&해산물','굴'	,68  ,2.46,3.91,7.05,2500,'100g당');

insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('음료','두유',127,4.7,12.08,10.98,700,'1컵');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('음료','사과주스',117,0.27,28.97,0.15,800,'1컵');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('음료','우유',122,4.88,11.49,8.03,500,'1컵');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('음료','오렌지주스',112,0.5,25.79,1.74,700,'1컵');

insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('과일','딸기',32,0.3,7.68,0.67,1280,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('과일','바나나',89,0.33,22.84,1.09,400,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('과일','사과',52,0.17,13.81,0.26,700,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('과일','오렌지',47,0.12,11.75,0.94,1000,'100g당');

insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('야채','감자',87,0.1,20.13,1.87,390,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('야채','고구마',86,0.05,20.12,1.57,650,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('야채','당근',41,0.24,9.58,0.93,750,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('야채','상추',14,0.14,2.97,0.9,1150,'100g당');

insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('빵&씨리얼','식빵',266,2.29,50.61,7.64,980,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('빵&씨리얼','시리얼',376,3.36,83.02,7.24,700,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('빵&씨리얼','마늘빵',330,12.78,45.62,7.75,1200,'100g당');
insert into menu(grp,item,cal,fat,carbo,protein,cost,con) values('빵&씨리얼','베이글',257,1.62,50.5,10.02,820,'100g당');

select * from menu;
		 			 

insert into calorie values(6,8  ,1500,121,24.6 ,1600,120,25);
insert into calorie values(9,11 ,1700,141,34.8 ,1900,140,36);
insert into calorie values(12,14,2000,156,47.5 ,2400,159,51);
insert into calorie values(15,18,2000,160,53.4 ,2700,171,61);
insert into calorie values(19,29,2100,160,56.3 ,2600,173,66);
insert into calorie values(30,49,1900,157,54.2 ,2400,170,64);
insert into calorie values(50,64,1800,154,52.2 ,2200,166,61);

select * from calorie;

select cal_man,cal_woman,h_man,h_woman,maxage,minage,w_man,w_woman  
		 from calorie where (minage <= 7) and (maxage >= 7);
		 			 
select minage,maxage,cal_man,h_man,w_man,cal_woman,h_woman,w_woman
		from calorie where (minage <= 7)and( maxage >= 7);
		 			 