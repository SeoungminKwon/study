select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPER_INFOS
where skill_3 = 'Python' or skill_1 = 'Python' or skill_2 = 'Python'
order by id asc;