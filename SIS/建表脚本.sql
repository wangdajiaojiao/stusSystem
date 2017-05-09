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
insert into student values(stu_seq.nextval,'001','王睿','智障一班');
insert into student values(stu_seq.nextval,'002','王珏','智障二班');
insert into student values(stu_seq.nextval,'003','二狗子','智障一班');
insert into student values(stu_seq.nextval,'004','二愣子','智障二班');
