-- SQL로 CRUD
테이블 만들기
테이블삭제
시퀀스만들기
시퀀스삭제
C - insert
-- 테이블 만들기
create table 테이블명 (
	필드형 자료형[옵션]
	필드형 자료형[옵션]
	...
);

create table noej_snack(
	noej_name varchar2(5 char),
	noej_price number(5)
);

select * from noej_snack;
---------------------------------------------------
-- 옵션
--		not null : 데이터를 안넣지 못하게
--		primary key : not null + 중복데이터 못넣게
--			어떤 데이터의 대표값
--			나중에 검색할때 정확한 데이터를 찾을 수 있음
--			-> 어떤 테이블에는 PK(primary key)가 꼭 있도록
---------------------------------------------------
-- 데이터 만들기 : C
insert into 테이블명(필드명, 필드명, ...)
values(값, 값, ...);

insert into 테이블명 values(값,값,...);	-- 주로 사용

---- 위치바뀌어도
-- 별로
insert into noej_snack(noej_price, noej_name)
values(500, '새콤달콤');

-- 값이 0이면 계산이 되는데
-- 값이 없으면 계산 불가능
-- 별로
insert into noej_snack(noej_name)
values('빼빼로');

insert into noej_snack values('새우깡', 4000);
---------------------------------------------------------
create table noej_may03_coffee (
	c_name varchar2(10 char) primary key,
	c_price number(5) not null
);

select * from NOEJ_MAY03_COFFEE;

insert into NOEJ_MAY03_COFFEE(c_name) values('아메리카노');

insert into NOEJ_MAY03_COFFEE values('아멤리카노', 4000);
insert into NOEJ_MAY03_COFFEE values('아메리카노', 5000);
insert into NOEJ_MAY03_COFFEE values('라떼', 6000);
insert into NOEJ_MAY03_COFFEE values('녹차라떼', 6000);
---------------------------------------------------------
-- 테이블 수정 - 실전에는 없는 작업
--		SQL이 알고싶으면 찾아보면 있기는 함
---------------------------------------------------------
-- 테이블 삭제
drop table 테이블명 cascade constraint purge;

drop table noej_may03_student cascade constraint purge;
---------------------------------------------------------
-- 이름/나이/국/영/수 중에 PK로 쓸만한게 없어서
-- 번호 필드 추가해서 PK로
-- -> 번호는 자동으로 올라갔으면...(Java때 팩토리 패턴)
-- MySQL/MariaDB에는 autoincrement옵션이 있는데
---------------------------------------------------------
-- 시퀀스 만들기
create sequence 시퀀스명;
create sequence noej_may03_student_seq;
-- 시퀀스 사용(insert때)
시퀀스명.nextval
-- 시퀀스 삭제
drop sequence 시퀀스명
-- insert 실패해도 올라감
-- 여러 테이블이 같이 사용할 수 있음
-- 3번인데, 2번학생 전학가면 2번이 되나?
-- -> 12345아님(행번호가 아님)
---------------------------------------------------------
create table noej_may03_student (
	s_no number(2) primary key ,
	s_name varchar2(10 char) not null,
	s_age number(3) not null,
	s_kor number(3) not null,
	s_eng number(3) not null,
	s_mat number(3) not null
);

insert into noej_may03_student values(noej_may03_student_seq.nextval, '홍길동', 20, 100, 90, 90);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '홍길동', 23, 80, 70, 20);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '김길동', 22, 50, 50, 100);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '김길동', 22, 0, 20, 70);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '최길동', 12, 30, 5, 10);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '강길동', 52, 96, 55, 100);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '정길동', 66, 48, 25, 97);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '이길동', 72, 18, 36, 86);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '박길동', 5, 25, 97, 48);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '서길동', 30, 44, 100, 36);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '지길동', 86, 26, 76, 75);
insert into noej_may03_student values(noej_may03_student_seq.nextval, '오길동', 94, 0, 48, 80);

select * from noej_may03_student;
----------------------------------------------------------
create table noej_may03_snack (
	s_no number(3) primary key,
	s_name varchar2(20 char) not null,
	s_price number(5) not null,
	s_weight number(4, 1) not null,
	s_exp date not null
);

drop table NOEJ_MAY03_SNACK cascade constraint purge;
drop sequence noej_may03_snack_seq;


create sequence noej_may03_snack_seq;
-- 날짜/시간
-- sysdate : 현재시간날짜
-- 특정시간날짜
--		1) Java/Python에서 Date객체
--		2) to_date('날짜', '패턴') : 글자 -> 날짜

-- SQL은 대소문자구별x, 대문자로 인식
-- YYYY
-- MM : 월
-- DD : 일
-- AM/PM
-- HH : 12시간제
-- HH24 : 24시간제
-- MI : 분
-- SS

insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '초코파이', 6000, 500.1, sysdate);

insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '초코파이', 5500, 550.1, to_date('20230601','YYYYMMDD'));

insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '새우깡', 1500, 120.7, to_date('20230607','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '감자깡', 1200, 110.7, to_date('20240207','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '고구마깡', 1300, 130.7, to_date('20230807','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '버터링', 4500, 170.7, to_date('20230415','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '허니버터칩', 1500, 120.7, to_date('20240117','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '이구동성', 2300, 150.6, to_date('20230807','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '인디언밥', 1500, 120.7, to_date('20240107','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '뿌셔뿌셔', 1500, 90.7, to_date('20231007','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '쫄병스낵', 1200, 88.4, to_date('20230907','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '썬칩', 2500, 220.7, to_date('20230707','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '포테토칩', 3500, 111.7, to_date('20240207','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '스윙칩', 3500, 102.5, to_date('20241007','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '포카칩', 3500, 100.1, to_date('20230817','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '새우깡', 1500, 122.5, to_date('20231017','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '에낙', 500, 60.1, to_date('20230527','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '뽀빠이', 1000, 80.8, to_date('20250107','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '눈을 뜬 감자', 2500, 90.3, to_date('20240327','YYYYMMDD'));
insert into noej_may03_snack values(noej_may03_snack_seq.nextval, '칙촉', 3000, 200.5, to_date('20231105','YYYYMMDD'));

SELECT *from noej_may03_snack;

