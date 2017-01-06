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


LOAD DATA LOCAL INFILE 'D:/workspace/workspace_mybatis/dietfoodmanager/DataFiles/menu.txt' 
INTO TABLE menu character set 'UTF8' fields TERMINATED by ',';

LOAD DATA LOCAL INFILE 'D:/workspace/workspace_mybatis/dietfoodmanager/DataFiles/calorie.txt' 
INTO TABLE calorie character set 'UTF8' fields TERMINATED by ',';

select * from member;
select * from menu;
select * from calorie;

update menu set no=1 where no=0;
update calorie set minage=6 where minage=0;

insert into member values(1, '강보미', '여', 45, 22, '010-1234-5617', '대구', 320000);

select no, name, gender, weight, age, phone, address, budget from member;

-- 1일 평균 소비 금액
select name, round(budget/30,-1), age from member;

select name, age, case
					when gender = '여' then cal_woman
					when gender = '남' then cal_man
					end as '1일권장칼로리'
from calorie inner join member on age >= minage and age <= maxage
where name='강보미';

select grp, item, cal, fat, carbo, protein, cost from menu
order by rand();

select * from menu where grp = '고기';

select * from menu where grp = '생선&해산물';

select * from menu where grp = '음료';

select * from menu where grp <> '고기' and grp <> '생선&해산물' and grp <> '음료';