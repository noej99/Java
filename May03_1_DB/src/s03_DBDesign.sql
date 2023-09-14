-- RDBMS(Relational DBMS)계열
-- 		OracleDB, MySQL, MariaDB, ...
--		테이블을 나눠서 디자인해놓고
--		테이블간의 관계를 중심으로 풀어나가는

-- NoSQL계열
--		MongoDB, Elasticsearch, ...
---------------------------------------------
-- DB디자인
-- 1) 한 데이터에는 하나의 정보만
-- 2) 주제별로 테이블을 나누기
-- 3) 테이블 옵션(PK, NN)
-- 4) 테이블간의 관계 파악
-- 사장 1 : 매장 n
-- 매장 1 : 사장 n
-- => 사장 : 매장 = m : n
-- => 매장 : 메뉴 = 1 : n

-- 식당프렌차이즈
-- 홍길동, 1999-01-01생, 수원
-- 김밥천국, 종로점, 종각역, 10테이블
-- 야채김밥, 4000원
-- ...

-- sd서버

drop table menu cascade constraint purge;

create table noej_may03_ceo (
	c_no number(3) primary key,
	c_ceo varchar2(5 char) not null, 
	c_birth date not null,
	C_home varchar2(10 char) not null
);
insert into noej_may03_ceo values(noej_may03_restaurant_seq.nextval, '최길동', to_date('19821227', 'YYYYMMDD'), '대전');

select * from noej_may03_ceo;
-----------------------------------------------
create table noej_may03_restaurant (
	r_no number(3) primary key,
	r_name varchar2(15 char) not null,
	r_spot varchar2(10 char) not null,
	r_locate varchar2(10 char) not null,
	r_table number(2) not null
);

insert into noej_may03_restaurant values(noej_may03_restaurant_seq.nextval, '노브랜드버거', '인천', '인천', 22);

select * from noej_may03_restaurant;
-----------------------------------------------
create table noej_may03_menu (
	m_no number(3) primary key,
	m_name varchar2(10 char) not null,
	m_price number(5) not null,
	m_r_no number(3) not null
);

insert into noej_may03_menu values(noej_may03_restaurant_seq.nextval, '노브랜드버거', 5400, 12);
-----------------------------------------------
create table noej_may03_run (
	r_no number(3) primary key,
	r_c_no number(3) not null,
	r_r_no number(3) not null
);
insert into noej_may03_run values(noej_may03_restaurant_seq.nextval, 6, 12);

select * from noej_may03_run;

-----------------------------------------------
create sequence noej_may03_restaurant_seq;