-- 데이터 읽기 : R
select 필드명, 필드명 as 별칭, 연산자, 통계함수, ...
from 테이블명, 테이블명, ...
where 조건식; 
--------------------------------------
-- DB : hdd에 저장(13개 - 130mb)
-- subquery 쓰면 5개(감소) - 변수에 5mb
-- join 쓰면 1300개(폭증) - 변수에 13000mb???

-- subquery : HDD에 130MB -> RAM에 5MB
-- join : HDD에 130MB -> RAM에 1.3TB

-- 전체 메뉴명, 가격
select m_name, m_price
from noej_may03_menu;

-- 전체 식당이름, 위치
select r_name, r_locate
from noej_may03_restaurant;

-- 프랜차이즈 전체의 메뉴 평균가
select avg(m_price)
from noej_may03_menu;

-- 식당 수
select count(*)
from noej_may03_restaurant;

-- 최연장자 사장님 이름, 생일, 집
-- 정보저장할때 birth를 -넣어서 저장해서 안됨
select c_ceo, c_birth, c_home
from noej_may03_ceo
where c_birth = (
	select min(c_birth)
	from noej_may03_ceo
);
-- 테이블 수 제일 적은 매장은 어디에
select r_locate
from noej_may03_restaurant
where r_table = (
	select min(r_table)
	from noej_may03_restaurant
);

-- '버거'시리즈 평균가
select avg(m_price)
from noej_may03_menu
where m_name like '%버거%';

-- subquery
--		where절에 통계함수 못쓰니
-- 		테이블 여러개 엮을때
--		subquery의 결과는 하나만 나와야 : 근데...
--			in쓰면 m_r_no = 5 or m_r_no = 8
-- 종각에 가면 먹을수 있는 메뉴명, 가격
select m_name, m_price
from noej_may03_menu
where m_r_no in (
	select r_no
	from noej_may03_restaurant
	where r_locate = '종각'
);

-- 와퍼가 먹고 싶으면 어디로 가야
select r_locate
from noej_may03_restaurant
where r_no = (
	select m_r_no
	from may03_menu
	where m_name like '%와퍼%'
);

-- 제일 싼 메뉴 파는 매장명, 위치
select r_name, r_locate
from noej_may03_restaurant
where r_no = (
	select m_r_no
	from noej_may03_menu
	where m_price = (
		select min(m_price)
		from noej_may03_menu
	)
);

-- 최연장자 사장님이 운영하는 매장명, 지점명, 위치
select r_name,r_spot , r_locate
from noej_may03_restaurant
where r_no in (
	select r_r_no
	from noej_may03_run
	where r_c_no = (
		select c_no
		from NOEJ_MAY03_CEO
		where c_birth = (
			select min(c_birth)
			from noej_may03_ceo
		)
	)
);

-- 와퍼시리즈 파는 사장님 이름
select c_ceo
from NOEJ_MAY03_CEO
where c_no in (
	select r_c_no
	from NOEJ_MAY03_RUN
	where r_r_no in (
		select m_r_no
		from NOEJ_MAY03_MENU
		where m_name like '%와퍼%'
	)
);
-- 최연장자 사장님네 메뉴 평균가
select avg(m_price)
from NOEJ_MAY03_MENU
where m_r_no in (
	select r_r_no
	from NOEJ_MAY03_RUN
	where r_c_no in (
		select c_no
		from NOEJ_MAY03_RUN
		where c_birth = (
			select min(c_birth)
			from NOEJ_MAY03_CEO
		)
	)
);

-- join
-- 테이블 붙이기
-- 안쓸 수 있으면 안쓰는게
-- 모든 경우의 수를 붙여서 폭발적으로 결과값이 늘어남(조건을 넣어야함)
-- 전체 매장명, 위치, 메뉴명, 가격
select r_name, r_locate, m_name, m_price
from NOEJ_MAY03_RESTAURANT, NOEJ_MAY03_MENU
where r_no = m_r_no;

-- 전체 사장이름, 매장명, 위치
select c_ceo, r_name, r_locate
from NOEJ_MAY03_CEO, NOEJ_MAY03_RUN, NOEJ_MAY03_RESTAURANT
where c_no = r_c_no and r_r_no = NOEJ_MAY03_RESTAURANT.r_no

-- 최연장자 사장님이 운영하는 매장명, 지점명, 위치
select r_name, r_spot, r_locate
from NOEJ_MAY03_CEO, NOEJ_MAY03_RUN, NOEJ_MAY03_RESTAURANT
where c_no = r_c_no and r_r_no = NOEJ_MAY03_RESTAURANT.R_NO
	and c_birth = (
		select min(c_birth)
		from NOEJ_MAY03_CEO
	);
-- join은 자제..

-- 테이블 수 가장 많은 식당에서 파는 메뉴명, 가격
select m_name, m_price
from NOEJ_MAY03_MENU
where m_r_no in (
	select r_no
	from NOEJ_MAY03_RESTAURANT
	where r_table = (
		select max(r_table)
		from NOEJ_MAY03_RESTAURANT
	)
);
--평균가보다 비싼 메뉴명, 가격, 식당명
select m_name, m_price, r_name
from NOEJ_MAY03_MENU, NOEJ_MAY03_RESTAURANT
where r_no = m_r_no and m_price > (
	select avg(m_price)
	from NOEJ_MAY03_MENU
);

	


