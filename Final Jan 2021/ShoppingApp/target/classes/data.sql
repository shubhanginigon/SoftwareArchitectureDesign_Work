insert into Category (name) values ('Cat1')
insert into Category (name) values ('Cat2')
insert into Category (name) values ('Cat3')

insert into Company (name) values ('Comp1')
insert into Company (name) values ('Comp2')

insert into Product (name, company_id, price, stock) values ('Product1', 1, '100.00',100)
insert into Product (name, company_id, price, stock) values ('Product2', 1, '200.00',100)
insert into Product (name, company_id, price, stock) values ('Product3', 2, '300.00',100)

update Category SET product_product_id =1 where id = 1
update Category SET product_product_id=1 where id = 2
update Category SET product_product_id=2 where id = 3
