-- create database bookstore;
-- use bookstore;

create table author(
URL varchar(50) unique,
author_name varchar(20),
address varchar(50) ,
primary key(author_name,address)
);

create table publisher(
publisher_name varchar(20) primary key,
address varchar(50),
phone integer,
URL varchar(50)
);

create table item(
item_id int primary key,
item_name varchar(500),
item_type varchar(50)
);

create table product(
product_id int primary key,
product_type varchar(20),
product_year int,
author_name varchar(20),
publisher_name varchar(20),
foreign key(publisher_name) references publisher(publisher_name) ,
foreign key(author_name) references author(author_name),
);

create table music_cassettes(
cassettes_id varchar(10) primary key,
item_id int,
title varchar(20),
cassettes_year int,
price float4,
author_name varchar(20),
address varchar(50) ,
publisher_name varchar(20),
foreign key(publisher_name) references publisher(publisher_name) ,
foreign key(author_name,address) references author(author_name,address),
foreign key(item_id) references item(item_id)
);

create table compact_disk(
disk_id varchar(10) primary key,
item_id int,
title varchar(20),
disk_year int,
price float4,
author_name varchar(20),
address varchar(50) ,
publisher_name varchar(20),
foreign key(publisher_name) references publisher(publisher_name) ,
foreign key(author_name,address) references author(author_name,address),
foreign key(item_id) references item(item_id)
);



create table warehouse(
code varchar(10) primary key,
address varchar(50),
phone integer,
isbn varchar(10),
foreign key(isbn) references book(isbn)
);

create table customer(
email varchar(50) primary key,
name varchar(20),
address varchar(50),
phone integer
);


create table shopping_basket(
basket_id varchar(10) primary key,
email varchar(50),
foreign key(email) references customer(email)
);

create table cart(
basket_id varchar(10),
item_id int,
foreign key(item_id) references item(item_id),
foreign key(basket_id) references shopping_basket(basket_id)
);