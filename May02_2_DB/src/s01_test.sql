--DataBaseManagementSystem
--=> 보안성 높고, 네트워크, 다양한 기능의 파일을 지원해주는 프로그램
--
--OracleDB
--mySQL
--MariaDB
--
--
--OracleDB
--	1) 몇명이 한 조 -> 빈 컴 한대 서버로 만들어서 같이 쓰기
--	2) 그냥 빈 컴 한대 혼자쓰기
--OracleDB
--	1 2 ... 7i 8i 9i 10g 11g	12c 13c ...  21c
--		internet	gridcomputing	cloudcom
--
--Oracle 11g Release2 XE
--	express edition(lite)
--
--
--1. 설치(서버로 쓸자리)
-- 	-시작- cmd - ipconfig로 ipv4주소 확인
--
-- 	- 방화벽끄고
-- 	- DB파일 저장될 폴더 확보(경로 기억)
--		C:/noej/DB
-- 	- Oracle 11g r2 XE 다운받아서 설치
--
-- 	- 내PC - 관리 - 서비스 - Oracle어쩌고... 실행중인지 확인
--
--2. 원격접속되는 관리자 계정 만들기(서버로 쓸 자리에서)
--	-시작-  cmd
--		sqlplus / as sysdba
--		sqlplus : 프로그램명
--		/ : 지금 OS계정
--		as sysdba : 관리자 권한으로
--
--2.1. 관리자 계정만들기
--	create user 관리자ID identified by 관리자PW;
-----------------------------------------------------------------
--아이디 : noej
--비번 : j2527303
-----------------------------------------------------------------
--
--2.2. 원격접속해서 쓸 수 있도록 권한부여
--	grant connect, resource, dba to 관리자ID;
--
--3. 사용자 계정만들기(내 자리에서)
--3.1. OracleDB서버에 접속하려면 instantClient라는 프로그램이 필요
--	Basic Package
--	SQL*Plus Package
--	JDBC Supplement Package
--	=> 를 받아서 한군데 합쳐지게 압축해제
--
--3.2. 접속하기
--	instantClient폴더에서 cmd
--	sqlplus 아이디/비번@주소:포트/DB명
-- 포트 : 1521
-- DB명(SID) : xe
--
-- 3.3. 내계정 만들기
--	create user 아이디 identified by 비번;
--
--3.4. role(권한 세트) 설정
--	grant connect, resource to 아이디;
--
--3.5. 테이블스페이스 만들기
--	create tablespace 테이블스페이스명 datafile '경로/파일명.dbf' size 500m;
--
--3.6. 테이블스페이스를 계정에게 배정
--	alter user 아이디 default tablespace 테이블스페이스명;
-----------------------------------------------------------------------------------
--아이디 : noej1			|  sdedu
--비번 : j2527303			|  sdedu
--서버주소 : 195.168.9.61	|  sdgn-djvemfu.tplinkdns.com
--포트번호 : 1521			|  19195
--SID : xe					|  xe
-----------------------------------------------------------------------------------
--4. OracleDB에 접속
--	instantClient폴더에서 cmd
--	sqlplus	아이디/비번@주소:포트/SID

-- 주석
-- 1) 관리자 쪽 기능은 안됨
-- 2) SQL은 가능, SQLPlus라는 프로그램의 명령어는 불가능

-- 여러 줄 실행 : 블록지정 -> alt + x
create table student2(
	name char,
	age number
);

-- 한 줄 실행 : 커서 대충 갖다 놓고 -> alt + s
select * from student2;

desc student2