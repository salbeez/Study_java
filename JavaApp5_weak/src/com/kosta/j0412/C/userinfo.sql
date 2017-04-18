drop table userinfo;

create table userinfo
(
	id varchar2(15) constraint userinfo_pk primary key,
	pass varchar2(15) not null,
	name varchar2(15) not null,
	ssn1 char(6) not null,
	ssn2 char(7) not null,
	tel varchar2(14), --010-123-4566
	addr varchar2(50),
	job varchar2(30)
);