select * from student;

create table student(
       id number(6) primary key,
       student_no varchar2(50) not null unique,
       student_name varchar2(50) not null,
       student_class varchar2(50) not null
)
create sequence stu_seq
start with 1
maxvalue 999999
increment by 1
nocache
insert into student values(stu_seq.nextval,'001','���','����һ��');
insert into student values(stu_seq.nextval,'002','����','���϶���');
insert into student values(stu_seq.nextval,'003','������','����һ��');
insert into student values(stu_seq.nextval,'004','�����','���϶���');
