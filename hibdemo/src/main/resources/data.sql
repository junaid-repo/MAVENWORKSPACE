
insert into Course (id, name, created_date, last_updated_date) 
values(1001, 'JDBC', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into Course (id, name, created_date, last_updated_date)
values(1002, 'Springboot', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into Course (id, name, created_date, last_updated_date) 
values(1003, 'Hibernate', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into Course (id, name, created_date, last_updated_date) 
values(1004, 'Rest API', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


insert into Passport(id, passportnumber) values(3001, 'ERJ7789RH');
insert into Passport(id, passportnumber) values(3002, 'FV33459GX');
insert into Passport(id, passportnumber) values(3003, 'JH98323NB');
insert into Passport(id, passportnumber) values(3004, 'VB478290SN');



insert into Student(id, name, passport_id) values(2001, 'Junaid',3001);

insert into Student(id, name, passport_id) values(2002, 'King',3002);

insert into Student(id, name, passport_id) values(2003, 'Raja',3003);

insert into Student(id, name, passport_id) values(2004, 'Khan',3004);



insert into Review(id, ratings, descriptions, COURSE_ID) values(4001, 'OK', 'Greate',1002);
insert into Review(id, ratings, descriptions, COURSE_ID) values(4002, '5', 'Nice content',1002);
insert into Review(id, ratings, descriptions, COURSE_ID) values(4003, '4 star', 'Could be better',1001);
insert into Review(id, ratings, descriptions, COURSE_ID) values(4004, '2 stars', 'No upto the marks',1004);