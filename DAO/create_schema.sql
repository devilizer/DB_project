
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
id   			int not null,
customer_id 	int not null,
city 			varchar(60) not null,
state 			varchar(60) not null,
pincode 		varchar(60) not null,
constraint pk_address primary key(id)
/*constraint fk_customer_id foreign key (customer_id) references customer(id)*/
);

create table cart(
id 			int auto_increment,
customer_id int not null,
empty 		int not null,
constraint pk_cart primary key(id)
/*constraint fk_customer_cart foreign key (customer_id) references customer(id)*/
);

/*alter table customer add constraint fk_cart foreign key (cart_id) references cart(id);*/

create table payment_detail(
payment_detail_id 	int AUTO_INCREMENT,
customer_detail 	int,
card_number 		varchar(255) NOT NULL,
card_expiry_date 	date NOT NULL,
bank_name 			varchar(255)NOT NULL,
constraint pk_payment_detail PRIMARY KEY (payment_detail_id)
/*#constraint FOREIGN KEY (customer_detail) REFERENCES customer(id)*/
);


create table customer_order(
order_id 			int AUTO_INCREMENT,
customer_detail 	int,
placed_date 		date NOT NULL,
status 				varchar(255),
total_amount 		int,
constraint pk_customer_order PRIMARY KEY (order_id)
/*#constraint FOREIGN KEY (customer_detail) REFERENCES customer(id)*/
);


create table product(

product_id          int not null auto_increment,
description varchar(255) not null,
price       int not null,
images      varchar(255),
constraint pk_product_id primary key(product_id)
);

create table order_item(
order_item_id 		int AUTO_INCREMENT,
order_detail 		int,
quantity 			int,
sub_amount 			int,
product_detail      int,
constraint pk_order_item PRIMARY KEY (order_item_id)
/*constraint foreign key (product_detail) references product(product_id),
#constraint FOREIGN KEY (order_detail) REFERENCES customer_order(order_id)
*/);



create table feedback(
feedback_id 		int AUTO_INCREMENT,
customer_detail 	int not null,
product_detail 		int,
des		varchar(60),
rating				int(5) NOT NULL,
constraint pk_feedback PRIMARY KEY (feedback_id)
/*constraint FOREIGN KEY (customer_detail) REFERENCES customer(id),
#constraint FOREIGN KEY (product_detail) REFERENCES product(product_id) ON DELETE CASCADE
*/);



create table vendor(
vendor_id 			int AUTO_INCREMENT,
name 				varchar(255) NOT NULL,
details 			varchar(255)NOT NULL,
rating 				int(5) NOT NULL,
constraint pk_vendor PRIMARY KEY (vendor_id)
);

create table vendor_product(
vendor_product_id 	int AUTO_INCREMENT,
vendor_detail 		int,
product_detail 		int,
constraint pk_vendor_product PRIMARY KEY (vendor_product_id)
/*constraint FOREIGN KEY (product_detail) REFERENCES product(product_id),
constraint FOREIGN KEY (vendor_detail) REFERENCES vendor(vendor_id)
*/);


create table cart_item(
cart_item_id 		int AUTO_INCREMENT,
cart_detail 		int,
quantity 			int,
sub_amount 			int,
product_detail      int not null,
constraint pk_cart_item PRIMARY KEY (cart_item_id)
/*constraint FOREIGN KEY (cart_detail) REFERENCES cart(id),
#constraint foreign key (product_detail) references product(product_id)
*/);




