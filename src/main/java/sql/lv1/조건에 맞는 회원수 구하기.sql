select count(user_id) as USERS
from user_info
where age >= 20 and age <= 29
and joined >= 20210101 and joined <= 20211231