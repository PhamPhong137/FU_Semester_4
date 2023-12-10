
create database TestFinal
go
use TestFinal
go
create table Student
(
RollNo nvarchar(7) not null primary key,
Major nvarchar(20) not null,
FullName nvarchar(100) not null,
City nvarchar(100),
Male bit not null, 
)

insert into Student values('A001','teacher','binhNV','Hanoi',1)
insert into Student values('S001','student','TungNA','Hanoi',1)
select * from Student