drop database if exists `spring-tutorial-employees`;
drop database if exists `spring-tutorial-products`;
drop user if exists `spring-tutorial`@'localhost';

create database `spring-tutorial-employees`;
create database `spring-tutorial-products`;

create user `spring-tutorial`@'localhost' identified by 'spring-tutorial';
grant all privileges on `spring-tutorial-employees`.* TO `spring-tutorial`@'localhost';
grant all privileges on `spring-tutorial-products`.* TO `spring-tutorial`@'localhost';

create table `spring-tutorial-employees`.`employee`(
    id int,
    firstname varchar(32),
    lastname varchar(32),
    email varchar(32),
    phonenumber varchar(32),
    hiredate date,
    salary int
);

create table `spring-tutorial-products`.`product`(
    id int,
    name varchar(32),
    quantity int,
    price float,
    available boolean
);
