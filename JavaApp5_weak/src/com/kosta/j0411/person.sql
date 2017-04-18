--person.sql
drop table person;
create table person
(
	no number constraint person_pk primary key,
	name varchar2(15) not null,
	age number,
	job varchar2(15)
);

--������
drop sequence person_seq;
create sequence person_seq
	start with 3
	increment by 1
	nocycle --���Ϲ����� ��
	nocache;
	
drop sequence age_seq;	
create sequence age_seq
	start with 1
	increment by 1
	nocycle --���Ϲ����� ��
	nocache;