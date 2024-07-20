# Write your MySQL query statement below
select s.id,s.visit_date,s.people
from Stadium s,Stadium s1, Stadium s2
where (     (s.id+1=s1.id and s.id+2=s2.id)
            or(s.id-1=s1.id and s.id-2=s2.id)
            or(s.id-1=s1.id and s.id+1=s2.id))
            and s.people>=100 and s1.people>=100 and s2.people>=100
            group by s.id
            order by id