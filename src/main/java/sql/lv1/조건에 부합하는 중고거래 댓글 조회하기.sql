select
    usb.TITLE as TITLE,
    usb.BOARD_ID as BOARD_ID,
    ugr.REPLY_ID as REPLY_ID,
    ugr.WRITER_ID as WRITER_ID,
    ugr.CONTENTS as CONTENTS,
    date_format(ugr.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD as usb
         join USED_GOODS_REPLY as ugr
              on usb.BOARD_ID = ugr.BOARD_ID
where usb.CREATED_DATE between'2022-10-01' AND '2022-10-31'
order by ugr.CREATED_DATE asc, usb.TITLE;
