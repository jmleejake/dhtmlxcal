drop table events;

drop sequence events_seq;

create table events(
  id number not null primary key, 
  start_date date, 
  end_date date,
  text varchar2(500)
  );
  
  CREATE SEQUENCE events_seq;
  
--���� ��ȸ�ϱ�(����)
  select * from events;
  select id, TO_CHAR(start_date, 'yyyy-mm-dd hh24:mi') start_date, TO_CHAR(end_date, 'yyyy-mm-dd hh24:mi') end_date, text from events where START_DATE like '__/03/__' or END_DATE like '__/03/__';
  
--���� �����ϱ�
  INSERT INTO EVENTS (ID, START_DATE, END_DATE, TEXT) VALUES ('4', TO_DATE('2017-03-24 00:34', 'YYYY-MM-DD HH24:MI'), TO_DATE('2017-03-24 00:34:18', 'YYYY-MM-DD HH24:MI:SS'), '����');


--���� �����ϱ�