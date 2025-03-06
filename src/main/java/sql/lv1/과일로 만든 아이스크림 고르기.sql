select ii.FLAVOR as 'FLAVOR'
from ICECREAM_INFO ii join FIRST_HALF fh
    on ii.flavor = fh.flavor
where fh.total_order >= 3000
    and ii.INGREDIENT_TYPE = 'fruit_based'
order by fh.TOTAL_ORDER desc