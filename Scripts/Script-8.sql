LOAD DATA LOCAL INFILE 'D:/workspace/workspace_mybatis/dietfoodmanger_test/DataFiles/menu.txt' 
INTO TABLE menu character set 'UTF8' fields TERMINATED by ',';

LOAD DATA LOCAL INFILE 'D:/workspace/workspace_mybatis/dietfoodmanger_test/DataFiles/calorie.txt' 
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

select no, grp, item, cal, sum(cal)  from menu
order by rand();

select item, cal 
from menu
order by rand();

select no, grp, item
from menu
where grp = '고기'
order by rand() limit 1;

select no, grp, item
from menu
where grp = '생선&해산물';

select * from calorie
where minage <= 33 and maxage >= 33;

select minage,maxage,cal_man,h_man,w_man,cal_woman,h_woman,w_woman
from calorie
where 22 >= minage and 22 <= maxage; 