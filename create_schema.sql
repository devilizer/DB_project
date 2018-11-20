
drop database eshopping;
create database eshopping;
use  eshopping;


create table customer(
id        int NOT NULL AUTO_INCREMENT,
username  varchar(60) not null,
password  varchar(60) not null,
email     varchar(60) not null,
address   varchar(60) not null,
cart_id   int null,
constraint pk_customer primary key(id)
);

create table address(
id   int not null,
customer_id int not null,
city varchar(60) not null,
state varchar(60) not null,
pincode varchar(60) not null,
constraint pk_address primary key(id),
constraint fk_customer_id foreign key (customer_id) references customer(id)
);

create table cart(
id int ,
customer_id int not null,
empty bit not null,
constraint pk_cart primary key(id),
constraint fk_customer_cart foreign key (customer_id) references customer(id)
);

alter table customer add constraint fk_cart foreign key (cart_id) references cart(id);