drop table events;

drop sequence events_seq;

create table events(
  id number not null primary key, 
  start_date date, 
  end_date date,
  text varchar2(500)
  );
  
  CREATE SEQUENCE events_seq;
  
--기본 데이터 
	Insert into EVENTS (ID,START_DATE,END_DATE,TEXT) values (1,to_date('17/03/11','RR/MM/DD'),to_date('17/03/11','RR/MM/DD'),'모임
');
Insert into EVENTS (ID,START_DATE,END_DATE,TEXT) values (2,to_date('17/03/15','RR/MM/DD'),to_date('17/03/18','RR/MM/DD'),'청소기간
');
Insert into EVENTS (ID,START_DATE,END_DATE,TEXT) values (3,to_date('17/03/24','RR/MM/DD'),to_date('17/03/24','RR/MM/DD'),'면접
');
Insert into EVENTS (ID,START_DATE,END_DATE,TEXT) values (4,to_date('17/03/24','RR/MM/DD'),to_date('17/03/24','RR/MM/DD'),'월세');

  
  
  
--일정 조회하기(월별)
  select * from events;
  select id, TO_CHAR(start_date, 'yyyy-mm-dd hh24:mi') start_date, TO_CHAR(end_date, 'yyyy-mm-dd hh24:mi') end_date, text from events where START_DATE like '__/03/__' or END_DATE like '__/03/__';
  
--일정 저장하기
  INSERT INTO EVENTS (ID, START_DATE, END_DATE, TEXT) VALUES ('4', TO_DATE('2017-03-24 00:34', 'YYYY-MM-DD HH24:MI'), TO_DATE('2017-03-24 00:34:18', 'YYYY-MM-DD HH24:MI:SS'), '월세');


--일정 삭제하기