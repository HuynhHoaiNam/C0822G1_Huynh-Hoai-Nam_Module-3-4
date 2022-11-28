DROP database `furama_resort_web_C08`;
CREATE DATABASE `furama_resort_web_C08`;

USE `furama_resort_web_C08`;



CREATE TABLE `position` -- `vi_tri`
(
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE  education_degree-- `trinh_do` 
(
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE devision -- `bo_phan` 
(
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);

-- CREATE TABLE `role` (
--     role_id INT PRIMARY KEY,
--     role_name VARCHAR(255)
-- );
-- CREATE TABLE user_role (
--     role_id INT,
--     foreign key (role_id) references `role`(role_id),
--     user_name VARCHAR(255),
--     primary key(role_id,user_name)
-- );

-- CREATE TABLE `user` (
--     user_name VARCHAR(255) PRIMARY KEY,
--     `password` VARCHAR(255)
-- );
CREATE TABLE employee (
    id INT PRIMARY KEY,
    `name` VARCHAR(45),
    date_of_birth DATE,
    id_card VARCHAR(45),
    salary DOUBLE,
    phone_number VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    position_id INT,
    FOREIGN KEY (position_id)
        REFERENCES `position` (id)
        on delete cascade,
    education_degree_id INT,
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (id) on delete cascade,
    devision_id INT,
    FOREIGN KEY (devision_id)
        REFERENCES devision (id)
        on delete cascade
  --   user_name VARCHAR(255),
--     foreign key (user_name) references `user`(user_name)
);
 
 CREATE TABLE customer_type -- `loai_khach` 
 (
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE customer -- `khach_hang` 
(
    id INT PRIMARY KEY,
    `name` VARCHAR(45),
    date_of_birth DATE,
    gender BIT(1),
    id_card VARCHAR(45),
    phone_number VARCHAR(45),
    address VARCHAR(45),
    email VARCHAR(45),
    customer_type_id INT,
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (id)
        on delete cascade
);

CREATE TABLE facility_type -- `loai_dich_vu` 
(
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE rent_type -- `kieu_thue` 
(
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE facility (
    id INT PRIMARY KEY,
    `name` VARCHAR(45),
    `area` INT,
    cost DOUBLE,
    max_peolpe INT,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    facility_free TEXT,
    rent_type_id INT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (id) on delete cascade,
        facility_type_id INT,
    FOREIGN KEY (facility_type_id)
        REFERENCES facility_type (id) on delete cascade
);
CREATE TABLE attach_facility -- `dich_vu_di_kem` 
(
    id INT PRIMARY KEY,
    `name` VARCHAR(45),
    cost DOUBLE,
    unit VARCHAR(10),
    `status` VARCHAR(45)
);
CREATE TABLE contract -- `hop_dong` 
(
    id INT PRIMARY KEY,
    start_date DATETIME,
    end_date DATETIME,
    deposit DOUBLE,
    employee_id INT,
    FOREIGN KEY (employee_id)
        REFERENCES employee (id) on delete cascade,
    customer_id INT,
    FOREIGN KEY (customer_id)
        REFERENCES customer (id) on delete cascade,
    facility_id INT,
    FOREIGN KEY (facility_id)
        REFERENCES facility (id) on delete cascade
);

CREATE TABLE contract_detail -- `hop_dong_chi_tiet` 
(
    id INT PRIMARY KEY,
    contract_id INT,
    FOREIGN KEY (contract_id)
        REFERENCES contract (id) on delete cascade,
    attach_facility_id INT,
    FOREIGN KEY (attach_facility_id)
        REFERENCES attach_facility (id) on delete cascade,
    quantity INT
);


select * from customer;
-- select * from customer where `name` like '% Hào';
-- update customer set name="Nguyen Van Vu", date_of_birth="1992-08-08", gender=1, id_card="021353568", phone_number="0964523458", address="23 Nguyễn Hoàng, Đà Nẵng", email="vu@gmail.com",customer_type_id="2" where id="3";

--  delete from customer where id = 8;
-- select * from customer where  `name` like '% Hào';

-- ALTER DATABASE furama_resort CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- select c.*, ct.`name` as customer_type_name from customer c join customer_type ct on c.customer_type_id = ct.id where c.name like '% Hào' and email like lk and address like adda;