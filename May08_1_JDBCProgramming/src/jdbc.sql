create table may08_product (
	p_name varchar2(10 char) primary key,
	p_price number(6) not null
);

insert into may08_product values('테스트', 1000);

select * from may08_product;

update may08_product
set p_price = p_price-500
where p_name = '펜';

delete from may08_product
where p_name = ''

select avg(p_price)
from may08_product
where p_name like ' ';