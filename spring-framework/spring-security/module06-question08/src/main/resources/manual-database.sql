drop database if exists `spring-tutorial`;
drop user if exists `spring-tutorial`@'localhost';

create database `spring-tutorial`;

create user `spring-tutorial`@'localhost' identified by 'spring-tutorial';
grant all privileges on `spring-tutorial`.* TO `spring-tutorial`@'localhost';
