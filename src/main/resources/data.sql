
insert into course (id,name, created_date, last_updated_date)
values (1, 'Hibernate and jpa ', CURRENT_DATE(),CURRENT_DATE());

insert into course (id,name, created_date, last_updated_date)
values (3, 'java ', CURRENT_DATE(),CURRENT_DATE());

insert into passport(id, number)
values(100,'123');
insert into passport(id,number)
values(101,'456');
insert into passport(id, number)
values(102,'789');

insert into student(id, name,passport_id)
values(200,'esraa',100);
insert into student(id, name,passport_id)
values(201,'toto',101);
insert into student(id, name,passport_id)
values(202,'last',102);

insert into review(id,rating,description,course_id)
values(50001,'5', 'Great Course',1);
insert into review(id,rating,description,course_id)
values(50002,'4', 'Wonderful Course',1);
insert into review(id,rating,description,course_id)
values(50003,'5', 'Awesome Course',3);

insert into course_student(course_id,student_id)
values(1,200);
insert into course_student(course_id,student_id)
values(3,200);
insert into course_student(course_id,student_id)
values(1,201);



