drop table events;

drop sequence events_seq;

create table events(
  id number not null primary key, 
  start_date date, 
  end_date date,
  text varchar2(500)
  );
  
  CREATE SEQUENCE events_seq;
  
--일정 조회하기(월별)
  select * from events;
  select id, TO_CHAR(start_date, 'yyyy-mm-dd hh24:mi') start_date, TO_CHAR(end_date, 'yyyy-mm-dd hh24:mi') end_date, text from events where START_DATE like '__/03/__' or END_DATE like '__/03/__';
  
  select 
  		id
  		, text
  		, to_char(start_date, 'yyyy-mm-dd hh24:mi') start_date
  		, to_char(end_date, 'yyyy-mm-dd hh24:mi') end_date
  from events
  
--일정 저장하기
  INSERT INTO EVENTS (ID, START_DATE, END_DATE, TEXT) 
  VALUES ('4', TO_DATE('2017-03-24 00:34', 'YYYY-MM-DD HH24:MI'), TO_DATE('2017-03-24 00:34:18', 'YYYY-MM-DD HH24:MI:SS'), '월세');
	
  insert into events values (events_seq.nextval, sysdate-3, sysdate-1, '테스트 데이터!!');

--일정 삭제하기