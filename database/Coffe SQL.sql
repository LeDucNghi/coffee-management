DROP database IF EXISTS Coffee_Website;
create database Coffee_Website
use Coffee_Website

-- table product
create table Category (
	category_id int not null primary key,
	category_name nvarchar(30)
)

create table products(
	product_id int not null primary key,
    product_name nvarchar(40),
    product_price varchar(10),
    product_quantity tinyint

)	

create table Customers(
	product 

)
 