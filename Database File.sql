use hotelms;
show databases;


create table login(username varchar(25),password varchar(25));
insert into login value('rahul','rahul');
select *from login;

create table login2(username varchar(25),password varchar(25));
insert into login2 value('rahul','rahul');
select *from login2;

create table room(roomno varchar(20),availability varchar(20),cleaning_status varchar(20),price varchar(20),bed_type varchar(20))
select *from room;

create table employee(name varchar(20),age varchar(20),gender varchar(20),job varchar(20),salary varchar(20),phone varchar(20),email varchar(20),addhar varchar(20))
select *from employee;

create table driver(name varchar(20),age varchar(20),carcom varchar(20),carname varchar(20),location varchar(20),available varchar(20),gender varchar(20));
select *from driver;

create table department(department varchar(80),functions varchar(200),budget varchar(80))
insert into department value('Reeception','Handle Guest,check-in/out,reservations','5 LPA');
insert into department value('Housekeeping','Clean and maintaine Guest Room,laundry and public area(lobbies)','12 LPA');
insert into department value('Food & Beverage(F&B)','Manege the hotels restaurant,bars and room service','18-20 LPA');
insert into department value('Maintenance','Ensure that all hotel facilities,including electrical,plumbing and all activities','8-15 LPA');
insert into department value('Security','Ensure the safety and security of Guests,Staff and hotel property','8-11 LPA');
insert into department value('Human Resources (HR)','Manage recruitment,employee relationships and training','4-6 LPA');
insert into department value('Finance and Accounting','Manage the Hotels finance including Budget','6-10 LPA');
insert into department value('IT','Manage the hotels it Infrastructure including CCTVS and Wifi and other facility','3-5 LPA');
insert into department value('Purchase','Responsible for purchasing all necessary supplies,equipment, and inventory','2-4 LPA');
select *from department;

select * from customer;