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

-- Member
ALTER TABLE diet.Member
	ADD CONSTRAINT PK_Member -- Member 기본키
		PRIMARY KEY (
			no -- 회원번호

		);
		
ALTER TABLE diet.`member` MODIFY COLUMN `no` int(4) NOT NULL AUTO_INCREMENT COMMENT '회원번호';

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

use diet;
		
LOAD DATA LOCAL INFILE 'E:/workspace/workspace_mybatis/DietFoodManager/DataFiles/menu.txt' 
INTO TABLE menu character set 'UTF8' fields TERMINATED by ',';

LOAD DATA LOCAL INFILE 'E:/workspace/workspace_mybatis/DietFoodManager/DataFiles/calorie.txt' 
INTO TABLE calorie character set 'UTF8' fields TERMINATED by ',';

-- 우편번호
CREATE TABLE diet.post (
	zipcode   CHAR(5)     NULL COMMENT '우편번호', -- 우편번호
	sido      VARCHAR(20) NULL COMMENT '시도', -- 시도
	sigungu   VARCHAR(20) NULL COMMENT '시군구', -- 시군구
	doro      VARCHAR(80) NULL COMMENT '도로', -- 도로
	building1 INT(5)      NULL COMMENT '건물번호1', -- 건물번호1
	building2 INT(5)      NULL COMMENT '건물번호2' -- 건물번호2
)
COMMENT '우편번호';

select * from post;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/강원도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

-- C:\workspace_java\post_program\DataFiles => 집

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/경기도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/경상남도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/경상북도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/광주광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/대구광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/대전광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/부산광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/서울특별시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/세종특별자치시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/울산광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/인천광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/전라남도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/전라북도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/제주특별자치도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/충청남도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'E:/workspace/workspace_mybatis/post_program/DataFiles/충청북도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

select * from post where sido = '강원도';

create index idx_post_sido on post(sido);
create index idx_post_doro on post(doro);
create index idx_post_sigungu on post(sigungu);

show index from post;

-- type이 ALL이 아니면 인덱스를 타고 있다는 뜻.
explain select * from post where sido = '강원도';
explain select * from post where doro = '임곡로';

select * from post where sido = '경기도';
select * from post where doro like '임곡%';
select distinct sido, sigungu from post where doro = '신상대향길';

-- 시도 불러오기 쿼리
select distinct sido from post;

-- 시도와 도로명을 선택하고 검색하면 걔네만 보이게
select zipcode, sido, sigungu, doro, building1, building2 from post where sido='강원도' and doro='임곡로' order by building1, building2;