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
