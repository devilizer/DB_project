use eshopping;

insert into customer(username,password,email,address,cart_id) values ("swapnil","123","abc@gmail.com","bhopal","1");
insert into customer(username,password,email,address,cart_id) values ("karan","456","karan@gmail.com","bhopal","2");
insert into customer(username,password,email,address,cart_id) values ("divyanshu","678","div@gmail.com","alwar","3");

insert into cart(customer_id,empty) values (1,1);
insert into cart(customer_id,empty) values (2,1);
insert into cart(customer_id,empty) values (3,1);


insert into product(description,price,images) values("Denim","500","http://amazon/denim");
insert into product(description,price,images) values("Shirt","400","http://amazon/shirt");
insert into product(description,price,images) values("Shoes","1000","http://amazon/shoes");
insert into product(description,price,images) values("TrackPants","700","http://amazon/track");	

insert into cart_item(cart_detail,quantity,sub_amount,product_detail) values(1,0,0,1);
insert into cart_item(cart_detail,quantity,sub_amount,product_detail) values(2,1,400,2);
insert into cart_item(cart_detail,quantity,sub_amount,product_detail) values(3,2,600,3);	



alter table cart add constraint fk_cart foreign key(customer_id) references customer(id);
alter table customer add constraint fk_customer foreign key(cart_id) references cart(id);
alter table cart_item add constraint fk_cart_2 foreign key (cart_detail) references cart(id);
alter table cart_item add constraint fk_cart_item foreign key(product_detail) references product(product_id);