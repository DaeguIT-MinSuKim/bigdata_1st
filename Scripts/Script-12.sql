use diet;

select * from member;

select * from menu;

drop table menu;

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
	ADD CONSTRAINT PK_Menu
		PRIMARY KEY (no);

drop table member;

-- Member
CREATE TABLE diet.Member (
	no      INT(4)      NOT NULL COMMENT '회원번호', -- 회원번호
	name    VARCHAR(10) NOT NULL COMMENT '이름', -- 이름
	gender  VARCHAR(4)  NOT NULL COMMENT '성별', -- 성별
	weight  INT(3)      NOT NULL COMMENT '몸무게', -- 몸무게
	age     INT(3)      NOT NULL COMMENT '나이', -- 나이
	phone   VARCHAR(20) NOT NULL COMMENT '휴대전화', -- 휴대전화
	address VARCHAR(100) NOT NULL COMMENT '거주지', -- 거주지
	budget  INT(10)     NOT NULL COMMENT '월예산' -- 월예산
)
COMMENT 'Member';

-- Member
ALTER TABLE diet.Member
	ADD CONSTRAINT PK_Member
		PRIMARY KEY (no);

ALTER TABLE diet.`member` MODIFY COLUMN `no` int(4) NOT NULL AUTO_INCREMENT COMMENT '회원번호';

select * from menu;