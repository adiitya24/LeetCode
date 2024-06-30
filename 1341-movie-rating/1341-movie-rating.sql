# Write your MySQL query statement below
(select u.name as results
from MovieRating as m
left join Users as u
on m.user_id=u.user_id
group by m.user_id order by count(rating) desc,name limit 1)

union all

(select m.title as results 
from MovieRating as mr
join Movies as m
on  mr.movie_id=m.movie_id
where year(created_at)=2020 and month(created_at)=02
group by mr.movie_id order by avg(mr.rating) desc , m.title limit 1)