-- 데이터 읽기 : R
select 필드명, 필드명 as 별칭, 연산자, 통계함수, ...
from 테이블명, 테이블명, ...
where 조건식
group by 필드명, 필드명, ...
having 조건식
order by 필드명(desc(내림차순)), 필드명, ...;(기본 오름차순)
--------------------------------------
-- 과자
-- 수원에 있는 오리온, 직원 100명
-- 초코파이 5000원, 500.5g

drop table noej_may04_company cascade constraint purge;
drop table noej_may04_snack cascade constraint purge;

create table noej_may04_company (
	c_name varchar2(10 char) primary key,
	c_addr varchar2(10 char) not null,
	c_emp number(3) not null
);

insert into noej_may04_company values('삼양', '부산', 240);

create table noej_may04_snack (
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_price number(5) not null,
	s_weight number(4,1) not null,
	s_c_name varchar2(10 char) not null
);

create sequence noej_may04_snack_seq;

insert into noej_may04_snack values(noej_may04_snack_seq.nextval, '새콤달콤', 400, 23.2, '크라운');

select * from noej_may04_company;
select * from noej_may04_snack;
------------------------------------------------------
-- 전체 과자 이름, 가격, g당 가격
-- 을 과자 가격순
select s_name, s_price, s_price/s_weight as s_ggp
from noej_may04_snack
order by s_price, s_name;

-- 평균가보다 싼과자를 파는 회사이름, 위치, 직원 수
-- 을 직원 많은 순
select *
from noej_may04_company
where c_name in (
	select s_c_name
	from noej_may04_snack
	where s_price < (
		select avg(s_price)
		from noej_may04_snack
	)
)
order by c_emp desc;

-- 직원수 가장 많은 회사의 회사 이름, 직원 수, 과자이름, 가격
-- 을 회사이름 -> 과자이름 순
select c_name, c_emp, s_name, s_price
from noej_may04_company, noej_may04_snack
where c_name = s_c_name and c_emp = (
	select max(c_emp)
	from noej_may04_company
)
order by c_name, s_name;

-- 사장이름, 생일
-- 생일 날짜별로 정렬
select c_ceo, c_birth
from noej_may03_ceo
order by c_birth;

-- 실전에서 
--		전체조회는 있을수가 없고(10TB를 언제 다 받아오나)
--		필요x -> 페이지 나눠서 10개만 필요하지

-- sequence
--		insert실패해도 올라감
--		여러 테이블이 같이 쓰기도 함
--		1234 - x
--		=> 중복안되는 번호 들어가는거

-- 과자이름, 가격
-- 이름순
-- 4 ~ 6번만
select s_name, s_price
from noej_may04_snack
where s_no >= 4 and s_no <=6
order by s_name;

-- rownum
--		select할때마다 부여되는 가상필드
--		*랑은 같이 못씀
--		order by보다 먼저
--		1번부터 조회해야만해서
--			from()을 더 씌워주고 rownum이 아니게 바꿔줘야
select *
from(
	select rownum as rn, s_no, s_name, s_price, s_weight, s_c_name
	from (
		select *
		from noej_may04_snack
		order by s_name
	)
)
where rn >= 4 and rn <= 6
-----------------------------------------------
-- 평균가보다 비싼 과자
-- 회사이름, 위치, 과자이름, 가격
-- 회사이름순 -> 과자이름순
-- 2 ~ 4번까지
select *
from(
	select rownum as rn, c_name, c_addr, s_name, s_price
	from (
		select c_name, c_addr, s_name, s_price
		from noej_may04_company, noej_may04_snack
		where c_name = s_c_name and s_price > (
			select avg(s_price)
			from noej_may04_snack
			)
		order by c_name, s_name
	)
)
where rn >= 2 and rn <= 4;

-- 회사별평균가
select s_c_name, avg(s_price)
from noej_may04_snack
group by s_c_name;

-- 지역별 최고가
select c_addr, max(s_price)
from noej_may04_snack , noej_may04_company
where s_c_name = c_name
group by c_addr;

-- 사장님별 -> 매장별 메뉴 평균가
-- 4개 다 붙여서
select c_ceo, r_name , avg(m_price)
from NOEJ_MAY03_menu, noej_may03_run , noej_may03_ceo, noej_may03_restaurant
where c_no = r_c_no and r_r_no = m_r_no and r_r_no = noej_may03_restaurant.r_no
group by c_ceo, r_name
order by c_ceo, r_name;

-- 회사별 과자 평균가
-- 평균가 구할때 2000원 안되는 과자는 빼고 구하는걸로
-- 통계 낼 때 데이터를 필터링
select s_c_name, avg(s_price)
from noej_may04_snack
where s_price >= 2000
group by s_c_name

-- 회사별 과자 평균가
-- 그렇게 구해서 평균가 2000원 안되는 과자는 안 볼래
-- 통계를 내고 그 결과를 필터링
select s_c_name, avg(s_price)
from noej_may04_snack
group by s_c_name
having avg(s_price) >= 2000;

-- 사장이름별 -> 식당별 메뉴 갯수
-- 평균가보다 싼거 빼고 갯수 세는걸로
-- 세어서, 갯수가 2개 안되는거는 안나오게
-- 사장이름별 -> 식당별 정렬
select c_ceo, r_name, count(*)
from noej_may03_menu , noej_may03_restaurant, noej_may03_ceo, noej_may03_run
where c_no = r_c_no and r_r_no = m_r_no and r_r_no = noej_may03_restaurant.r_no 
	and m_price <= (
		select avg(m_price)
		from noej_may03_menu
	)
group by c_ceo, r_name
having count(*) >= 2
order by c_ceo, r_name;
