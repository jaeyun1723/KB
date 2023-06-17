-- ������ ��������
-- CLARK�� �޿����� �� ���� �޿��� �޴� ����� �˻�
-- Step 1. -> SQL �Ľ� 2��
SELECT sal FROM emp WHERE ename = 'CLARK'; -- 2450
SELECT ename, sal FROM emp WHERE sal > 2450;
-- SQL parsing�� �� �� �ϴ� �����̱� ������ ������ �ſ� �� ����

-- Step 2. -> SQL �Ľ� 1�� �ϰ� ���̺��� �� �� ȣ���ϵ���
SELECT sal FROM emp WHERE ename = 'CLARK'; -- 2450
SELECT ename, sal FROM emp WHERE sal > ?; -- ����ǥ �ȿ� ������ ������ �ٲٸ�?

SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'CLARK');

-- 1. SELECT ���� ���Ǵ� ��������
-- ename�� KING �� ����� ���� �μ����� ���ϴ� ����� �˻�...
-- SELECT ������ ��� / WHERE ��
SELECT ename, deptno
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'KING');

-- 2. HAVING ���� ���Ǵ� ��������
-- job �� ��ձ޿��� �� ���� ���� ��ձ޿��� �˻�
SELECT job, ROUND(AVG(sal))
FROM emp
GROUP BY job
HAVING AVG(sal) = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

-- �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻�
SELECT deptno, MIN(sal)
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno = 20);

-- 3. FROM ���� ���Ǵ� ��������
SELECT ename, sal FROM emp ORDER BY sal DESC;

SELECT ename, sal, rownum
FROM emp 
WHERE rownum <= 3
ORDER BY sal DESC;

-- Step2...ORDER BY���� ���� ����...(ORDER BY~~)
SELECT ename, sal, rownum
FROM (SELECT * FROM EMP ORDER BY sal DESC) -- ���������� ���� ��ü ���� ���� �ϰ� ��
WHERE rownum <= 3;

SELECT empno, ename
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);
-- :: (=) : ������ ������ --> ������ �����ڷ� �ٲ���� (IN,ANY,ALL)

SELECT ename, sal, job
FROM emp
WHERE job!='SALESMAN' AND sal > ANY(SELECT sal FROM emp WHERE job='SALESMAN') -- �ּڰ� 1200
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

-- SCOTT�� �޿����� �� ���� �޿��� �޴� ����� �˻�
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

-- ����� ������ �� �ִ� ����� ��ձ޿����� �޿��� �� ���� �޴� ��������� ��ȸ
SELECT empno, ename, sal
FROM emp e
WHERE sal > (SELECT AVG(sal) FROM emp WHERE e.empno=mgr);

SELECT deptno, dname
FROM DEPT d
WHERE EXISTS ( SELECT 'A' FROM EMP WHERE deptno=d.deptno);

SELECT deptno, dname
FROM DEPT d
WHERE EXISTS ( SELECT 1 FROM EMP WHERE deptno=d.deptno);
--�������
--1.WHERE
--2.EXISTS -> �����ϴ� ���� 1���̶� �����ϸ� ��ĵ �ߴ� �� TRUE ��ȯ
--3.MAIN����

--Step 2. DISTINCT
SELECT DISTINCT dname, d.deptno
FROM dept d, emp e
WHERE e.deptno=d.deptno;

--Step 3. IN
SELECT dname, deptno
FROM dept
WHERE deptno IN (SELECT deptno FROM emp WHERE job='MANAGER');
-- 1. �������� ���� ==> emp���̺��� ���� �� ��ĵ �� ���������� deptno�� ������ ��
-- �������� �����Ͱ� ��뷮�� ��, IN -> EXIST

------WORKSHOP ����------------
-- ### equi join ###

-- 1).  emp�� dept Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿���  ����϶�.

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

-- 2).  �̸��� ��SMITH���� ����� �μ����� ����϶�.

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
-- 3).  dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ� 
-- ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.



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
-- 4.  emp Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�. ��SMTH�� �Ŵ����� FORD�̴١�
-- ���� ������ ���  || 

SELECT  e.ename  ||' �� �Ŵ����� ' || m.ename || '�̴�.'
FROM emp e, emp m
WHERE e.mgr = m.empno;



-- ### SubQuery ###

-- 1).  ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���ȣ, �Ի���,�޿��� ����϶�.
select empno, ename, DEPTNO, hiredate,  sal
from emp
where sal >=(select avg(sal) from emp);


-- 2). 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �޿��� �˻�..�޿��� ���� ������ ����϶�.
select empno, ename, sal
from emp 
where job in ( select job from emp where deptno=10)
order by sal desc;

-- ===========================================
select e.empno, e.ename, d.dname, d.loc, sal
from emp e join dept d on e.deptno=d.deptno
where e.job  in (select job from emp where deptno=10)
Order by sal  desc;


-- 3).  10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���ȣ,����, �Ի����� ����϶�.
select empno, ename, hiredate, job
from emp 
where  (deptno=10 and job not in (select job from emp  where deptno=30));

-- ===========================================================

select e.empno, e.ename, d.dname, hiredate, d.loc
from emp e join dept d on e.deptno=d.deptno
where e.deptno=10
and e.job not in (select job from emp where deptno=30);

-- 4).  ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.
select empno, ename, sal
from emp
where sal in (select sal from emp where ename in ('KING','JAMES'));


-- 5).  �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
select empno, ename, sal
from emp
where sal >( select max(sal) from emp where deptno=30);


-- 6). SCOTT�� �޿����� ������ �޿��� �޴� ����� �˻�
-- 2���� ����� ��� 1) ��������  2) ���̺� �˸��߽��� ���
-- 1) 
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');

-- 2) 
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal > b.sal;

-- 7). �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻�
SELECT deptno, min(sal) FROM emp 
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=20);



-- 8). ���������� �Ŵ��� ����� �˻� . ����̸��� ����� �����ȣ�� �˻��ǵ���(�⸮�߽� ����̸�, �������ȣ)
-- 1)
SELECT distinct mgr FROM emp;
SELECT * FROM emp WHERE empno IN (SELECT distinct mgr FROM emp);

-- 2)
SELECT e.ename ����̸�, e.empno ����ǻ����ȣ FROM emp e 
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
    ROW_NUMBER() OVER( ORDER BY sal DESC, hiredate ASC) AS "����"
    FROM emp;
    
SELECT ename, sal, NTILE(4) OVER(ORDER BY sal) FROM emp;

--1.���̺� ����
--2.DML
--INSERT INTO
--DELETE FROM
--UPDATE SET
--3. TRANSACTION
--4. CTAS ���� --> ��뷮 ���õ���Ÿ �ε�� ���ÿ� ���̺� ����
--5. �������� �߰� / �������� �̽�

-- ���̺� �����ϱ�
-- �÷� �������� PK�߰�
CREATE TABLE MYDEPT(
no number(3) CONSTRAINT PK_NO PRIMARY KEY,
dname varchar2(30) not null,
loc varchar2(30));

-- ���̺� �����ϱ�2
-- ���̺� �������� PK�߰�
CREATE TABLE CUSTOM(
SSN NUMBER(7),
CUST_NAME VARCHAR2(20),
ADDRESS VARCHAR2(50),
CONSTRAINT CUSTOM_PK PRIMARY KEY (SSN));

-- ������ �Ϸ��ϱ�
INSERT INTO custom(ssn, cust_name, address) VALUES(111,USER,'Brandon');
INSERT INTO custom(ssn, cust_name, address) VALUES(222,'JAMES','NY');
INSERT INTO custom(ssn, cust_name, address) VALUES(333,'JULITET','TEXAS');

SELECT * FROM CUSTOM;

-- ������ �����ϱ�
UPDATE custom SET cust_name='������', address='�Ż絿' WHERE ssn=111;

SELECT * FROM CUSTOM;

-- ������ �����ϱ�
--DELETE
--1) ���ǿ� �ش��ϴ� �ุ ������ ����
--2) �Ϻ��� ������ �� �ƴϴ�. rollback���� ������� �ǵ��� �� �ִ�.
--TRUNCATE
--1) ��� �����͸� �� ����
--2) rollback �ȵȴ�.
--3) ���̺��� ������ �����.
--DROP
--1) ��� �����Ͱ� ��������, ���̺��� ������ ���ش�.
--2) rollback �Ұ�.

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

delete employee where deptno=10; --������
SELECT ename, deptno FROM employee WHERE deptno=10;
delete department where deptno=20; -- �ڽ��� ���� �θ�� ���� �� ����.(FK ������)
SELECT ename, deptno FROM employee WHERE deptno=20;

-- �ڽ��� ������ �ִ� �θ� ���� �ȵ�
-- DEPARTMENT ���̺��� ������ ���� ����
-- �ڽ��� ���� ���̰� �θ� �״� ����� �ذ�å���� ���� = on delete cascade�ɼ�
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno);

ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno) ON DELETE CASCADE;
delete employee where deptno=10;
delete department where deptno=20;
select * from employee;
select * from department;