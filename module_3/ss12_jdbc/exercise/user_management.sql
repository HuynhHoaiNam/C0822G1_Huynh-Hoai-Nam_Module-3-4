create database user_management;
create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

select * from users;
insert into users(name,email,country)values("black","black@gmail.com","USA");