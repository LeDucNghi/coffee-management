DROP database IF EXISTS Coffee_Website;
create database Coffee_Website
use Coffee_Website

-- table
create table Category (
	category_id int not null primary key  AUTO_INCREMENT,
	category_name nvarchar(30)
);

create table products(
	product_id int not null primary key AUTO_INCREMENT,
    product_name nvarchar(40),
    discount_event tinyint,
    product_price varchar(10),
    product_quantity tinyint,
    category_id int,
    CONSTRAINT category_product FOREIGN KEY (category_id) REFERENCES  Category(category_id)

);

create table Customers(
	customer_id int not null AUTO_INCREMENT primary key,
    cus_username char(30) not null,
    cus_name nvarchar(30) not null,
    cus_password nvarchar(20) not null,
    cus_point int(50),
    cus_latestDate date
);

create table Employees(
	Employee_id int not null AUTO_INCREMENT primary key,
    Employee_name varchar(25),
    Employee_password nvarchar(50)
);
create table Book_history(
	history_id int not null auto_increment primary key,
    book_date date,
    TimeBook time not null,
    status_book char,
	room_id int ,
    customer_id int,
	constraint customer_book foreign key (customer_id) references customers(customer_id),
    constraint room_book foreign key (room_id) references rooms(room_id)
);


create table rooms (
	room_id int not null auto_increment primary key,
    room_type char(10),
    status boolean
);

create table Orders(
	order_id int not null auto_increment primary key,
    product_id int not null,
	customer_id int not null,
    order_time time ,
    room_id int null,
    order_date date,
    discount int null,
    total varchar(50),
    
    constraint customer_order foreign key (customer_id) references customers(customer_id),
    constraint room_order foreign key (room_id) references rooms(room_id),
    constraint order_product foreign key (product_id) references products(product_id)
);

create table total_revenue(
	id int primary key auto_increment,
    order_id int,
	monthTotal tinyint(2),
    yearTotal tinyint(4),
    total_revenue varchar(100)
);


 