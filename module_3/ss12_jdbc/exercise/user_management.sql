create database user_management;
create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

select * from users order by country;
insert into users(name,email,country)values("black","black@gmail.com","USA");
select*from users where country like "%vietnam";

delimiter //
create procedure p_select()
begin
select * from users;
end //
delimiter ;

call p_select;

delimiter //
create procedure p_update(in name_u varchar(120), email_u varchar(220),country_u varchar(120), id_u int)
begin
update users set name=name_u , email=email_u, country=country_u where id = id_u;
end //
delimiter ;
drop procedure p_update;
call p_update("hahah","email@gmail.com","VietNam",13);

delimiter //
create procedure p_delete(in id_delete int)
begin
delete from users where id=id_delete;
end //
delimiter ;
call p_delete(6);