--person.sql
drop table person;
create table person
(
	no number constraint person_pk primary key,
	name varchar2(15) not null,
	age number,
	job varchar2(15)
);

--시퀀스
drop sequence person_seq;
create sequence person_seq
	start with 1
	increment by 1
	nocycle --유일무의한 값
	nocache;