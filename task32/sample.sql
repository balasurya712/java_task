create database sample;

use sample;

create table primary_table1(
id varchar(5) primary key
);

create table forign_table1(
id varchar(10),
foreign key (id) references primary_table1(id)
);

create table forign_table2(
id int,
foreign key (id) references primary_table1(id)
);

create table primary_table2(
id int primary key
);

create table forign_table3(
id varchar(10),
foreign key (id) references primary_table2(id)
);
