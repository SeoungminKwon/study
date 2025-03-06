select animal_id, name
from animal_ins
where INTAKE_CONDITION != 'Aged'
order by animal_id