drop table events;

drop sequence events_seq;

create table events(
  id number not null primary key, 
  start_date date, 
  end_date date,
  text varchar2(500),
  content varchar2(2000)
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