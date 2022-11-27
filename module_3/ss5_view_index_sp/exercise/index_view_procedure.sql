drop database demo;
create database demo;

-- Bước 1

-- 1.1 Tạo Table
create table product(
id int primary key,
product_code int,
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(45),
product_status varchar(45)
);


-- 1.2 Insert data
insert into product value
(1,01,'a',100,3,'hu','ki'),
(2,02,'b',50,2,'ha','hi'),
(3,03,'c',150,1,'hi','fi');


-- 1.3 tạo index
create index i_product_code on product(product_name, product_price);
explain 
select 
  * 
from 
  product;
  
  
-- 1.4 tạo view
create view w_product as 
select 
  product_code, 
  product_name, 
  product_price, 
  product_status 
from 
  product;
select 
  * 
from 
  w_product;
drop 
  view w_product;
  
  
  
-- Bước 2
delimiter // create procedure get_all_product() begin 
select 
  * 
from 
  product;
end // delimiter;
call get_all_product();



-- Bước 3
delimiter // create procedure add_new_product(
  in p_id int, 
  p_code int, 
  p_name varchar(45), 
  p_price double, 
  p_amount int, 
  p_description varchar(45), 
  p_status varchar(45)
) begin insert into products value(
  p_id, p_code, p_name, p_price, p_amount, 
  p_description, p_status
);
end // delimiter;
call add_new_product(4, 04, 'd', 250, 5, 'ji', 'ri');



-- Bước 4
delimiter // create procedure update_product(
  in p_name varchar(45), 
  p_id int
) begin 
update 
  products 
set 
  product_name = p_name 
where 
  id = p_id;
end // delimiter;
call update_product('lo', 2);




-- Bước 5
delimiter // create procedure delete_product(in p_code int) begin 
delete from 
  products 
where 
  product_code = p_code;
end // delimiter;
SET 
  SQL_SAFE_UPDATES = 0;
call delete_product(02);