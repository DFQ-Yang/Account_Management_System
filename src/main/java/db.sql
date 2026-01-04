create database IF NOT EXISTS ams;
use ams;

create table IF NOT EXISTS user(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT UNIQUE,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL
);
create table IF NOT EXISTS accounts(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT UNIQUE,
    user_id INTEGER NOT NULL,
    url varchar(70) NOT NULL ,
    comment varchar(20),
    account varchar(30) NOT NULL ,
    password varchar(30) NOT NULL
);

create index usernameIndex on ams.user(username);
create index userIdIndex on ams.accounts(user_id);