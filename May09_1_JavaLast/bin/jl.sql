-- 여태했던 작업 DB서버에 실제 반영
COMMIT
-- 여태했던 작업 취소
rollback

create table noej_may09_restaurant (
	r_name varchar2(20 char) primary key,
	r_since date not null,
	r_addr varchar2(20 char) not null
);

insert into noej_may09_restaurant values('한솥종로관철동점', to_date('20000101','YYYYMMDD'), '종로12길 10');

create table noej_may09_menu (
	m_no number(3) primary key,
	m_name varchar2(10 char) not null,
	m_price number(5) not null,
	m_r_name varchar2(20 char) not null,
	constraint noej_may09_restaurant_menu
		foreign key(m_r_name)
		references noej_may09_restaurant(r_name)
		on delete cascade
);
insert into noej_may09_menu values(noej_may09_menu_seq.nextval,'빅치킨마요', 4300, '한솥종로관철동점');

create sequence noej_may09_menu_seq;

select * from noej_may09_restaurant;
select * from noej_may09_menu;

select count(*) from noej_may09_menu

select *
from noej_may09_menu

select *
from(
	select rownum as rn, m_no, m_name, m_price, m_r_name
	from (
		select *
		from noej_may09_menu
		order by m_r_name, m_name
	)
)
where rn >= 6 and rn <= 10
