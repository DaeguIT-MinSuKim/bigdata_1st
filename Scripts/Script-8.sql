-- 우편번호
CREATE TABLE post_program.post (
	zipcode   CHAR(5)     NULL COMMENT '우편번호', -- 우편번호
	sido      VARCHAR(20) NULL COMMENT '시도', -- 시도
	sigungu   VARCHAR(20) NULL COMMENT '시군구', -- 시군구
	doro      VARCHAR(80) NULL COMMENT '도로', -- 도로
	building1 INT(5)      NULL COMMENT '건물번호1', -- 건물번호1
	building2 INT(5)      NULL COMMENT '건물번호2' -- 건물번호2
)
COMMENT '우편번호';

select * from post;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/강원도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

-- C:\workspace_java\post_program\DataFiles => 집

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/경기도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/경상남도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/경상북도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/광주광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/대구광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/대전광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/부산광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/서울특별시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/세종특별자치시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/울산광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/인천광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/전라남도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/전라북도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/제주특별자치도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/충청남도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;

load data local infile 'D:/workspace/workspace_mybatis/post_program_gradle/DataFiles/충청북도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d)
set zipcode = @zipcode, sido = @sido, sigungu = @sigungu, doro = @doro, building1 = @building1, building2 = @building2;


delete from post;

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
select distinct sigungu from post where doro = '신상대향길';

-- 시도 불러오기 쿼리
select distinct sido from post;

-- 시도와 도로명을 선택하고 검색하면 걔네만 보이게
select zipcode, sido, sigungu, doro, building1, building2 from post where sido='강원도' and doro='임곡로' order by building1, building2;
