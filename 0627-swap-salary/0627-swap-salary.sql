# Write your MySQL query statement below


update Salary SET sex =(CASE when sex='m' then 'f' ELSE 'm' END);
