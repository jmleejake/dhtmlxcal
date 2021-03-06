drop table events;

drop sequence events_seq;

create table events(
  id number not null primary key, 
  start_date date, 
  end_date date,
  text varchar2(500),
  content varchar2(2000),
  repeat_type varchar2(50),
  repeat_end_date date,
  is_dbdata char(1),
  alarm_yn char(1) DEFAULT 'F' NOT NULL,
  alarm_val number,
  category varchar2(30)
);
  
CREATE SEQUENCE events_seq;
  
--기본 데이터 
INSERT INTO EVENTS (ID, START_DATE, END_DATE, TEXT) VALUES (events_seq.nextval, TO_DATE('2017-03-14 09:34', 'YYYY-MM-DD HH24:MI'), TO_DATE('2017-03-14 11:34', 'YYYY-MM-DD HH24:MI'), '모임');
INSERT INTO EVENTS (ID, START_DATE, END_DATE, TEXT) VALUES (events_seq.nextval, TO_DATE('2017-03-04 10:34', 'YYYY-MM-DD HH24:MI'), TO_DATE('2017-03-04 20:34', 'YYYY-MM-DD HH24:MI'), '입주자 면접');
INSERT INTO EVENTS (ID, START_DATE, END_DATE, TEXT) VALUES (events_seq.nextval, TO_DATE('2017-03-09 00:34', 'YYYY-MM-DD HH24:MI'), TO_DATE('2017-03-12 00:34', 'YYYY-MM-DD HH24:MI'), '대청소');
INSERT INTO EVENTS (ID, START_DATE, END_DATE, TEXT) VALUES (events_seq.nextval, TO_DATE('2017-03-24 00:34', 'YYYY-MM-DD HH24:MI'), TO_DATE('2017-03-24 00:34', 'YYYY-MM-DD HH24:MI'), '월세');
  
commit
  
--일정 조회하기(월별)
  select * from events;
  select id, TO_CHAR(start_date, 'yyyy-mm-dd hh24:mi') start_date, TO_CHAR(end_date, 'yyyy-mm-dd hh24:mi') end_date, text from events where START_DATE like '__/03/__' or END_DATE like '__/03/__';
  
  -- 재민
  select 
  		id
  		, text
  		, to_char(start_date, 'yyyy-mm-dd hh24:mi') start_date
  		, to_char(end_date, 'yyyy-mm-dd hh24:mi') end_date
  from events
  
--일정 저장하기
  INSERT INTO EVENTS (ID, START_DATE, END_DATE, TEXT) VALUES ('4', TO_DATE('2017-03-24 00:34', 'YYYY-MM-DD HH24:MI'), TO_DATE('2017-03-24 00:34:18', 'YYYY-MM-DD HH24:MI:SS'), '월세');


--일정 삭제하기

  
  
  
  
  select to_date('2017-04-30' || ' 00:00:00','YYYY-MM-DD hh24:mi:ss') + 1 from dual
  
  
  
  select to_char (start_date - alarm_val/(24*60), 'ss mi hh24 dd mm ? yyyy') alarm_time 
  from msm_calendar where alarm_yn = 'T' and id ='2'
  
  
  
  update events 
  set text = '새 이벤트101'
  , content = '23456'
  , start_date = to_date(substr('Sat Apr 15 2017 17:29:00 GMT+0900 (대한민국 표준시)',1,24), 'DY MON DD YYYY HH24:MI:SS','NLS_DATE_LANGUAGE = American') 
  , end_date = to_date(substr('Sat Apr 15 2017 17:34:00 GMT+0900 (대한민국 표준시)',1,24), 'DY MON DD YYYY HH24:MI:SS','NLS_DATE_LANGUAGE = American') 
  , repeat_type = 'daily'
  , repeat_end_date = to_date('2017-04-16' || ' 00:00:00', 'YYYY-MM-DD hh24:mi:ss') + 1 
  , alarm_yn = 'F' , alarm_val = 'none' 
  where id = '19' 
  
  
  
 select 
	  id 
	  , text 
	  , to_char(start_date, 'yyyy-mm-dd hh24:mi') start_date 
	  , to_char(end_date, 'yyyy-mm-dd hh24:mi') end_date
	  , content
	  , repeat_type
	  , to_char(repeat_end_date, 'yyyy-mm-dd') repeat_end_date
	  , is_dbdata
	  , alarm_yn
	  , alarm_val
	  , category
 from events
 where repeat_type != 'none'
union
 select 
	  id 
	  , text 
	  , to_char(start_date, 'yyyy-mm-dd hh24:mi') start_date 
	  , to_char(end_date, 'yyyy-mm-dd hh24:mi') end_date
	  , content
	  , repeat_type
	  , to_char(repeat_end_date, 'yyyy-mm-dd') repeat_end_date
	  , is_dbdata
	  , alarm_yn
	  , alarm_val
	  , category
 from events
 where start_date >= add_months(to_date('2017-04-01', 'yyyy-mm-dd'), -1)
 and end_date <= add_months(last_day(to_date('2017-04-01', 'yyyy-mm-dd')) +1, 1)
 and repeat_type = 'none'
  