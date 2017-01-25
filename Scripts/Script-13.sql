select * from menu;

delete from menu;

LOAD DATA LOCAL INFILE 'D:/menu.txt' 
INTO TABLE menu character set 'UTF8' fields TERMINATED by ',';

select * from menu;

select * from member;

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
	ADD CONSTRAINT PK_Member -- Member 기본키
		PRIMARY KEY (
			no -- 회원번호

		);