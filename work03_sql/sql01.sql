-- ���̺��� ������ Ȯ�� DESC
-- pk�� ������ column�� not null + unique
desc emp;
desc dept;

-- Projection : ���÷����ϰ��� �ϴ� �÷��� �����ؼ� ������
-- * ������� �ʴ� �� ����
    -- ���� : ��� column ���� ���� �ʾƾ� �� ����
    -- ���� �� ������ projection ���
select * from emp;

-- emp table���� ����� �̸�, �ݿ�, ����, �μ���ȣ �˻�
select ename, sal, job, deptno from emp;
-- selection : ����(where)�� �ο��ؼ� ���� ����
-- 10�� �μ����� �ٹ��ϴ� ����� �̸�, �޿�, �Ի�⵵, �μ���ȣ �˻�
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10;

-- 10�� �μ����� �ٹ��ϴ� ����� �̸�, �޿�, �Ի�⵵, �μ���ȣ �˻�
-- �޿��� ���� ���� ��� �� ���� order by
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal ASC; -- asc�� default

SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal DESC; -- desc ��������

-- SALESMAN �μ����� ����� �����ȣ, �̸�, ����, �μ���ȣ�� �˻�
-- ������ �μ���ȣ ��
SELECT empno, ename, job, deptno �μ���ȣ
FROM EMP
WHERE job = 'SALESMAN'
ORDER BY deptno;

SELECT empno, ename, job, deptno �μ���ȣ
FROM EMP
WHERE job = 'SALESMAN'
ORDER BY �μ���ȣ;

SELECT empno, ename, job, deptno �μ���ȣ
FROM EMP
WHERE job = 'SALESMAN'
ORDER BY 4;
/*
SELECT empno, ename, job, deptno �μ���ȣ
FROM EMP
WHERE �μ���ȣ = 20
ORDER BY 4;
*/

-- ��� �߿��� �Ի����� ���� ���� ��
SELECT empno, ename, hiredate
FROM EMP
ORDER BY hiredate;

-- ��� �� ���� ���� �޿� �޴� ��� 3�� (rownum)
SELECT ename, job, sal
FROM EMP
ORDER BY sal DESC;

-- where�� ���� order by ���� ���� ����ǵ��� �ؾ��Ѵ�
-- rownum�� order by ������ ���� ������ �Ǽ� ����� �߸�����
SELECT ename, job, sal
FROM EMP
WHERE rownum <= 3
ORDER BY sal DESC;
-- ���å
SELECT ename, job, sal
FROM (SELECT * FROM emp ORDER BY sal DESC) 
WHERE rownum <= 3;


-- ��� ����� �޿��� ���� �޿��� 2�迡 20�޷� �߰��� �޿��� �λ�
SELECT ename, sal, sal*2 + 20 "�λ� �޿�"
FROM emp;

SELECT ename, sal, sal*2 + 20 "�λ� �޿�"
FROM emp
ORDER BY "�λ� �޿�";

SELECT ename, sal, sal*2 + 20 "IncrementSalary"
FROM emp;

-- �޿����� ���� ���� �˻�(10����)
SELECT ename, sal, sal-(sal*0.1) "���� ���� �޿�"
FROM emp;

SELECT ename, sal, sal*0.9 "���� ���� �޿�"
FROM emp;

-- ��� ����� ����
SELECT ename, job, sal, sal*12+comm "AnnualSalary"
FROM emp;
-- null���� �������� ����� �� �ݵ�� �ٸ� ������ ġȯ�ؼ� ���
-- NVL(comm, 0) : comm�� null�̸� 0����, null�� �ƴϸ� comm�� �״�� ���
Select ename, job, sal, sal*12+ NVL(comm,0) AnnualSalary
FROM emp;

-- step3 
-- comm�� null�� �ƴ� ����� ������ ���Ѵٶ�� ����
Select ename, job, sal, sal*12+ comm AnnualSalary
FROM emp
WHERE comm is not null;

SELECT comm
FROM emp
ORDER BY comm desc;

-- emp table �μ� �˻�
SELECT deptno FROM emp;

-- distinct : ���� ���Ͽ� ���� ���� ����
SELECT DISTINCT deptno FROM emp;

-- 10G ���� ���ʹ� �ڵ����� �ȵ�
SELECT DISTINCT deptno FROM emp ORDER BY 1;

-- DISTINCT�� ����ؼ� �μ� ��ȣ�� �ߺ� ���� �����;� �ϴ� ��� -> EXISTS ���
SELECT deptno from dept d
WHERE EXISTS(SELECT * FROM emp e WHERE d.deptno = e.deptno);

-- Ư���� �������� �˻�
-- LIKE ������ + ���ϵ�ī��()
-- ��� �߿��� �̸��� S�� �����ϴ� ����� �˻� 
SELECT ename
FROM emp
WHERE ename LIKE 'S%';

-- ��� �߿��� ��� �̸��� A�� ���Ե� ��� �˻�
SELECT ename
FROM emp
WHERE ename LIKE '%A%';

-- 80�⿡ �Ի��� ���
SELECT ename, job, hiredate
FROM emp
WHERE hiredate LIKE '80%';

--IN ������
--���� ���� �� �߿� ��� �ϳ��� ��ġ�ϴ����� ��
SELECT empno, ename, job FROM emp WHERE empno=7369;
SELECT empno, ename, job FROM emp WHERE empno=7521;
SELECT empno, ename, job FROM emp WHERE empno=7782;

SELECT empno, ename, job
FROM emp
WHERE empno IN(7369, 7521, 7782);

SELECT empno, ename, job
FROM emp
WHERE empno NOT IN(7369, 7521, 7782); -- !=7369 and !=7521 and !=7782

--SUBSTR(������ ���ڿ�, ������ġ)
--SUBSTR(������ ���ڿ�, ������ġ, ���ⰹ��)
--���ڿ��� �����ϴ� ���... �Լ����� ���ڰ��� ��Ȯ�� ����
SELECT SUBSTR('HelloWorld',6) FROM DUAL;   -- H �ε��� : 1
SELECT SUBSTR('HelloWorld',6,3) FROM DUAL;
SELECT SUBSTR('HelloWorld',-5) FROM DUAL;

-- ����̸��� N���� ������ ����� �˻�
SELECT ename, job FROM emp WHERE SUBSTR(ename,-1)='N';
SELECT ename, job FROM emp WHERE ename LIKE '%N';

-- EMP���̺��� �⵵�� ����... 10�� �μ����� �˻��ǵ���
SELECT ename, hiredate, SUBSTR(hiredate,1,2)
FROM emp
WHERE deptno=10;

--PAD :: LPAD, RPAD
SELECT LPAD('abc',6,'*') FROM dual; -- ***abc
SELECT RPAD('abc',6,'*') FROM dual; -- abc***

SELECT RPAD(deptno,10) FROM emp;

-- TRIM :: RTRIM, LTRIM
SELECT RTRIM('      James Gosling               ') FROM dual;
SELECT LTRIM('      James Gosling               ') FROM dual;
SELECT TRIM('      James          Gosling   ') FROM dual;
SELECT REPLACE('      James    Gosling           ',' ','') FROM dual; -- ��� ���� ����

--�����Լ�
SELECT ROUND(45.923,2) FROM dual; -- �Ҽ��� 2��° �ڸ����� ǥ��-> �Ҽ��� ���� 3��°���� �ݿø�
SELECT ROUND(45.923,0) FROM dual; -- 46
SELECT ROUND(45.923) FROM dual;

-- FLOOR :: �Ҽ��� �Ʒ��� ����(�����θ� ǥ��, �ڸ��� ����x)
SELECT FLOOR(45.923) FROM DUAL;

-- TRUNC :: ������ �ڸ��� ���ϸ� ����
SELECT TRUNC(45.923,2) FROM DUAL; -- 45.92

-- CEIL :: �ø�. �����θ� ǥ��
SELECT CEIL(45.923) FROM DUAL;
--SELECT CEIL(45.923,2) FROM DUAL; ����

-- ��¥ �Լ�
-- ��¥+����=��¥
-- ��¥-����=��¥
-- ��¥-��¥=�Ⱓ(����)

SELECT SYSDATE FROM DUAL;
SELECT SYSDATE + 1 FROM DUAL;
SELECT SYSDATE + 100 FROM DUAL;

SELECT ROUND(SYSDATE - TO_DATE('1997/4/5')) FROM DUAL;

-- 4���� ���� ��¥�� �˻�
SELECT ADD_MONTHS(SYSDATE,4) FROM DUAL;
-- ���濬���� ��ƿ� ������ �˻�
SELECT FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE('2000/12/8'))) FROM DUAL;
-- EMP���̺��� ������� ������� �ٹ��� ��(WEEKS) ���� �˻�
SELECT FLOOR((SYSDATE-HIREDATE)/7) FROM EMP;