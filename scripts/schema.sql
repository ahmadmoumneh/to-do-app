drop database if exists todoapp;
create database todoapp;
use todoapp;

drop table if exists category;
create table category (
	categoryId int primary key auto_increment,
	categoryName varchar(30) not null,
	categoryImageName varchar(30) not null
);

drop table if exists user;
create table user (
	userId int primary key auto_increment,
	userName varchar(50) not null,
	userEmail varchar(50) not null,
    userPassword varchar(10) not null,
	userAvatar varchar(30)
);

drop table if exists todo;
create table todo (
	todoId int primary key auto_increment,
	todoTitle varchar(50) not null,
	description varchar(300) not null,
	isDone bool not null,
    userId int not null,
    categoryId int not null,
    foreign key (userId) references user(userId),
    foreign key (categoryId) references category(categoryId)
);