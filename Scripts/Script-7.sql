select * from calorie;
select * from member;

select m.no, m.name, m.age, m.gender, minage, maxage, case 
												when m.gender = '여' then cal_woman 
												when m.gender = '남' then cal_man
												end cal
from calorie inner join member m on m.no = 1
where m.age >= minage and m.age <= maxage;