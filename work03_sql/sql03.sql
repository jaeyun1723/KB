-- 단일행 서브쿼리
-- CLARK의 급여보다 더 많은 급여를 받는 사원을 검색
-- Step 1. -> SQL 파싱 2번
SELECT sal FROM emp WHERE ename = 'CLARK'; -- 2450
SELECT ename, sal FROM emp WHERE sal > 2450;
-- SQL parsing을 두 번 하는 쿼리이기 때문에 성능이 매우 안 좋다

-- Step 2. -> SQL 파싱 1번 하고 테이블을 두 번 호출하도록
SELECT sal FROM emp WHERE ename = 'CLARK'; -- 2450
SELECT ename, sal FROM emp WHERE sal > ?; -- 물음표 안에 윗줄이 들어가도록 바꾸면?

SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'CLARK');

-- 1. SELECT 절에 사용되는 서브쿼리
-- ename이 KING 인 사원과 같은 부서에서 일하는 사원을 검색...
-- SELECT 절에서 사용 / WHERE 절
SELECT ename, deptno
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'KING');

-- 2. HAVING 절에 사용되는 서브쿼리
-- job 별 평균급여들 중 가장 작은 평균급여를 검색
SELECT job, ROUND(AVG(sal))
FROM emp
GROUP BY job
HAVING AVG(sal) = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

-- 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색
SELECT deptno, MIN(sal)
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno = 20);

-- 3. FROM 절에 사용되는 서브쿼리
SELECT ename, sal FROM emp ORDER BY sal DESC;

SELECT ename, sal, rownum
FROM emp 
WHERE rownum <= 3
ORDER BY sal DESC;

-- Step2...ORDER BY절을 먼저 실행...(ORDER BY~~)
SELECT ename, sal, rownum
FROM (SELECT * FROM EMP ORDER BY sal DESC) -- 서브쿼리를 통해 전체 정렬 먼저 하고 비교
WHERE rownum <= 3;

SELECT empno, ename
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);
-- :: (=) : 단일행 연산자 --> 다중행 연산자로 바꿔야함 (IN,ANY,ALL)

SELECT ename, sal, job
FROM emp
WHERE job!='SALESMAN' AND sal > ANY(SELECT sal FROM emp WHERE job='SALESMAN') -- 최솟값 1200
ORDER BY 1;

SELECT ename, sal, job
FROM emp
WHERE job!='SALESMAN' AND sal > (SELECT MIN(sal) FROM emp WHERE job='SALESMAN')
ORDER BY 1;

SELECT ename ,sal ,job
FROM emp
WHERE job!='SALESMAN' AND sal > ALL(SELECT sal FROM emp WHERE job='SALESMAN')
ORDER BY 1;

SELECT ename, sal, job
FROM emp
WHERE job!='SALESMAN' AND sal > (SELECT MAX(sal) FROM emp WHERE job='SALESMAN')
ORDER BY 1;

-- SCOTT의 급여보다 더 많은 급여를 받는 사원을 검색
-- 1
SELECT ename, sal, job
FROM emp
WHERE sal>(SELECT sal FROM emp WHERE ename='SCOTT');

-- 2
SELECT *
FROM emp main,  (SELECT sal FROM emp WHERE ename='SCOTT') sub
WHERE main.sal>sub.sal; 

SELECT ename, sal, deptno, hiredate, job
FROM emp e
WHERE sal>(SELECT AVG(sal) FROM emp WHERE deptno=E.deptno);

-- 사원을 관리할 수 있는 사람의 평균급여보다 급여를 더 많이 받는 사원정보를 조회
SELECT empno, ename, sal
FROM emp e
WHERE sal > (SELECT AVG(sal) FROM emp WHERE e.empno=mgr);

SELECT deptno, dname
FROM DEPT d
WHERE EXISTS ( SELECT 'A' FROM EMP WHERE deptno=d.deptno);

SELECT deptno, dname
FROM DEPT d
WHERE EXISTS ( SELECT 1 FROM EMP WHERE deptno=d.deptno);
--실행순서
--1.WHERE
--2.EXISTS -> 만족하는 행이 1건이라도 존재하면 스캔 중단 후 TRUE 반환
--3.MAIN쿼리

--Step 2. DISTINCT
SELECT DISTINCT dname, d.deptno
FROM dept d, emp e
WHERE e.deptno=d.deptno;

--Step 3. IN
SELECT dname, deptno
FROM dept
WHERE deptno IN (SELECT deptno FROM emp WHERE job='MANAGER');
-- 1. 서브쿼리 실행 ==> emp테이블을 전부 다 스캔 후 메인쿼리의 deptno와 일일이 비교
-- 서브쿼리 데이터가 대용량일 때, IN -> EXIST

------WORKSHOP 정답------------
-- ### equi join ###

-- 1).  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.

select  dept.deptno, dname, ename, sal
from emp , dept 
where emp.deptno = dept.deptno 
order by dept.deptno;

-- =====================================
select d.deptno, d.dname, e.ename, e.sal 
from emp e  join dept d on e.deptno=d.deptno
order by d.deptno;
-- =====================================
select deptno, d.dname, e.ename, e.sal 
from emp e  join dept d using (deptno);

-- 2).  이름이 ‘SMITH’인 사원의 부서명을 출력하라.

select  dname
from emp, dept
where emp.deptno  = dept.deptno  and emp.ename='SMITH';

-- ========================================
select d.dname, e.ename
from emp e  join  dept d using (deptno)
where  e.ename='SMITH';

select d.dname, e.ename
from emp e  join  dept d on e.deptno=d.deptno
where  e.ename='SMITH';


 
-- ### outer join ###
-- 3).  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.



SELECT *
FROM emp e, dept d
WHERE e.deptno=d.deptno;

select *
from emp e  join  dept d using (deptno);

select *
from emp e  join  emp d;

select *
from emp e natural join dept d;


SELECT * FROM DEPT;
SELECT * FROM EMP ORDER BY deptno;
-- ========================================

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e RIGHT JOIN  dept d
ON e.deptno(+)=d.deptno;



-- ###self join###
-- 4.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’
-- 연결 연산자 사용  || 

SELECT  e.ename  ||' 의 매니저는 ' || m.ename || '이다.'
FROM emp e, emp m
WHERE e.mgr = m.empno;



-- ### SubQuery ###

-- 1).  전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서번호, 입사일,급여를 출력하라.
select empno, ename, DEPTNO, hiredate,  sal
from emp
where sal >=(select avg(sal) from emp);


-- 2). 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 급여를 검색..급여가 많은 순으로 출력하라.
select empno, ename, sal
from emp 
where job in ( select job from emp where deptno=10)
order by sal desc;

-- ===========================================
select e.empno, e.ename, d.dname, d.loc, sal
from emp e join dept d on e.deptno=d.deptno
where e.job  in (select job from emp where deptno=10)
Order by sal  desc;


-- 3).  10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서번호,업무, 입사일을 출력하라.
select empno, ename, hiredate, job
from emp 
where  (deptno=10 and job not in (select job from emp  where deptno=30));

-- ===========================================================

select e.empno, e.ename, d.dname, hiredate, d.loc
from emp e join dept d on e.deptno=d.deptno
where e.deptno=10
and e.job not in (select job from emp where deptno=30);

-- 4).  ‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 출력하라.
select empno, ename, sal
from emp
where sal in (select sal from emp where ename in ('KING','JAMES'));


-- 5).  급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 출력하라.
select empno, ename, sal
from emp
where sal >( select max(sal) from emp where deptno=30);


-- 6). SCOTT의 급여보다 더많은 급여를 받는 사원을 검색
-- 2가지 방법을 사용 1) 서브쿼리  2) 테이블 알리야스를 사용
-- 1) 
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');

-- 2) 
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal > b.sal;

-- 7). 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색
SELECT deptno, min(sal) FROM emp 
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=20);



-- 8). 부하직원을 거느린 사원을 검색 . 상사이름과 상사의 사원번호가 검색되도록(얄리야스 상사이름, 상사사원번호)
-- 1)
SELECT distinct mgr FROM emp;
SELECT * FROM emp WHERE empno IN (SELECT distinct mgr FROM emp);

-- 2)
SELECT e.ename 상사이름, e.empno 상사의사원번호 FROM emp e 
WHERE e.empno IN (SELECT m.mgr FROM emp m);

SELECT ename, sal, deptno,
    RANK() OVER(ORDER BY sal DESC) ALL_RANKING,
    RANK() OVER(PARTITION BY deptno ORDER BY sal DESC  ) DEPT_RANKING
FROM emp;

SELECT ename, sal, deptno
FROM emp
GROUP BY sal;

SELECT ename, sal, rownum FROM emp ORDER BY sal DESC;

SELECT ename, sal, rownum 
FROM (SELECT * FROM emp ORDER BY sal DESC);

SELECT ename, sal,
        ROW_NUMBER() OVER(ORDER BY sal DESC) ranking
FROM emp; 

SELECT empno, ename, deptno, sal,
        RANK() OVER (PARTITION BY deptno ORDER BY sal DESC) "RANK"
        FROM emp;
        
SELECT empno, ename, deptno, sal,
        DENSE_RANK() OVER (PARTITION BY deptno ORDER BY sal DESC) "RANK"
        FROM emp;

SELECT empno, ename, sal, hiredate,
    ROW_NUMBER() OVER( ORDER BY sal DESC, hiredate ASC) AS "순번"
    FROM emp;
    
SELECT ename, sal, NTILE(4) OVER(ORDER BY sal) FROM emp;

--1.테이블 생성
--2.DML
--INSERT INTO
--DELETE FROM
--UPDATE SET
--3. TRANSACTION
--4. CTAS 문법 --> 대용량 샘플데이타 로드와 동시에 테이블 생성
--5. 제약조건 추가 / 제약조건 이슈

-- 테이블 생성하기
-- 컬럼 레벨에서 PK추가
CREATE TABLE MYDEPT(
no number(3) CONSTRAINT PK_NO PRIMARY KEY,
dname varchar2(30) not null,
loc varchar2(30));

-- 테이블 생성하기2
-- 테이블 레벨에서 PK추가
CREATE TABLE CUSTOM(
SSN NUMBER(7),
CUST_NAME VARCHAR2(20),
ADDRESS VARCHAR2(50),
CONSTRAINT CUSTOM_PK PRIMARY KEY (SSN));

-- 데이터 일력하기
INSERT INTO custom(ssn, cust_name, address) VALUES(111,USER,'Brandon');
INSERT INTO custom(ssn, cust_name, address) VALUES(222,'JAMES','NY');
INSERT INTO custom(ssn, cust_name, address) VALUES(333,'JULITET','TEXAS');

SELECT * FROM CUSTOM;

-- 데이터 수정하기
UPDATE custom SET cust_name='이정재', address='신사동' WHERE ssn=111;

SELECT * FROM CUSTOM;

-- 데이터 삭제하기
--DELETE
--1) 조건에 해당하는 행만 삭제를 진행
--2) 완벽히 삭제된 건 아니다. rollback으로 원래대로 되돌릴 수 있다.
--TRUNCATE
--1) 모든 데이터를 다 삭제
--2) rollback 안된다.
--3) 테이블의 구조는 남긴다.
--DROP
--1) 모든 데이터가 없어지고, 테이블의 구조도 없앤다.
--2) rollback 불가.

DELETE custom WHERE ssn=222;
ROLLBACK;

TRUNCATE TABLE custom;
DESC custom;

DROP TABLE CUSTOM;

DROP TABLE employee;
DROP TABLE department;
CREATE TABLE employee
AS
SELECT * FROM emp;

CREATE TABLE department
AS
SELECT * FROM dept;

SELECT * FROM employee;
SELECT * FROM department;
DESC employee;
DESC department;

ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);
desc employee;
desc department;

delete employee where deptno=10; --삭제됨
SELECT ename, deptno FROM employee WHERE deptno=10;
delete department where deptno=20; -- 자식을 가진 부모는 죽을 수 없다.(FK 설정시)
SELECT ename, deptno FROM employee WHERE deptno=20;

-- 자식을 가지고 있는 부모 삭제 안됨
-- DEPARTMENT 테이블의 데이터 삭제 못함
-- 자식을 먼저 죽이고 부모 죽는 방법을 해결책으로 제시 = on delete cascade옵션
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno);

ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno) ON DELETE CASCADE;
delete employee where deptno=10;
delete department where deptno=20;
select * from employee;
select * from department;