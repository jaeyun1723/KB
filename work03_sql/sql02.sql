-- Extract (��, ��, ��, �ð�, �� ������ �� ���)
-- emp ���̺��� ����� �̸��� ������Ի��� ��, ��, ���� ����... �μ���ȣ�� 20���� ���
-- Year, Month, Day
SELECT ename �̸�, hiredate,
EXTRACT (YEAR FROM hiredate) "Year",
EXTRACT (MONTH FROM hiredate) "Month",
EXTRACT (DAY FROM hiredate) "Day"
FROM emp
WHERE deptno = 20;

-- �ٸ� ���
SELECT ename �̸�, hiredate,
SUBSTR(hiredate, 1, 2) "Year",
EXTRACT (MONTH FROM hiredate) "Month",
EXTRACT (DAY FROM hiredate) "Day"
FROM emp
WHERE deptno = 20;

-- p.70 ����3
SELECT ename, hiredate, NEXT_DAY(hiredate, 6) n_6, NEXT_DAY(hiredate, 7) n_7
FROM emp
WHERE deptno = 10
ORDER BY hiredate DESC;

-- p.70 ����4
SELECT empno, ename, hiredate, LAST_DAY(hiredate) l_last, LAST_DAY(hiredate) - hiredate l_day
FROM emp
ORDER BY LAST_DAY(hiredate) - hiredate DESC;

-- p.76 ����7 �Լ��� ��ø ����

-- p.73 ����1 �޿��� 3�ڸ����� , �� ����Ͽ� ���� (������ 3�ڸ����� �����°� �ƴ�, �Ʒ����� �߰� ����)
-- TO_CHAR( )�� ���� ���ڿ��� �ٲ���� ��
-- ���� �߻� ���� : 2,000,400 �� �ȵ�. �����Ϸ��� 9�� �ڸ��� ������ �÷��� �� ,�� ó�� -> 999,999,999
SELECT empno, ename, job, sal, TO_CHAR(sal, '999,999')
FROM emp
WHERE deptno = 20
ORDER BY sal DESC;

-- p.75 ����3
SELECT ename, hiredate, TO_CHAR(hiredate, 'YYYY"��" MM"��" DD"��"') t_kor
FROM emp
WHERE deptno = 20
ORDER BY hiredate DESC;

-- p.83 DECODE -> ORACLE���� �����ϴ� ����
-- ������ PRESIDENT�� ����
--       MANAGER�� ������
--       ANALYST�� �м���
--       �ش��ϴ� ���� ���ٸ� ����
--       �����з� Alias
SELECT ename, job,
      DECODE(job, 'PRESIDENT', '����',
                  'MANAGER', '������',
                  'ANALYST', '�м���',
                  '����') �����з�
FROM emp;

-- p.84 CASE -> �ٸ� DB������ ��� ����
-- ������ �پ��ϰų� �����ϸ� CASE�� �ַ� ���
SELECT ename, deptno,
      CASE WHEN deptno = '10' THEN 'NewYork'
           WHEN deptno = '20' THEN 'Dallas'
           ELSE 'city'
      END ���ø�
FROM emp;      

-- ��� ����� ���ʽ� ���.. AVG()
-- step1
-- null���� �ִ� ���,.. �׷� �Լ� ���� ���� 4�θ� ������
SELECT ROUNG(AVG(comm)) "���ʽ� ���1" FROM emp;

-- step2
SELECT ROUND(AVG(NVL(comm, 0))) "���ʽ� ���2" FROM emp;

-- emp ���̺��� �μ� ����
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno;

-- step2
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
ORDER BY DNumber;

-- step3
-- �˸��߽� ������ �ȵǴ� ����...1) where 2)group by
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp
GROUP BY DNumber
ORDER BY DNumber; -- ����! 

-- Step 4.
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp
WHERE deptno != 10
GROUP BY deptno
ORDER BY DNumber;

-- �Ի�⵵�� ����� �ο��� ��ȸ..count()
SELECT EXTRACT(YEAR FROM hiredate) AS Year FROM emp;
SELECT EXTRACT(YEAR FROM hiredate) AS Year, COUNT(empno)
FROM emp
--GROUP BY Year -- �̰� �ȵ�
GROUP BY EXTRACT(YEAR FROM hiredate) -- �̰� ��
ORDER BY Year;

-- 2
SELECT TO_CHAR(hiredate, 'YY') �⵵, COUNT(*)
FROM emp
GROUP BY TO_CHAR(hiredate, 'YY')
ORDER BY 1;

-- �μ��� ��� �޿��� 2000�޷� �̻��� �μ��� �μ���ȣ�� ��ձ޿��� ��ȸ
-- STEP1
-- where ���� �׷��Լ��� �Բ� ��� ����
-- �׷��Լ��� WHERE���� �ƴ� HAVING ���� �־����
SELECT deptno, ROUND(AVG(sal)) AvgSalary
FROM emp
WHERE ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

-- STEP2
-- �ǹ̷������� �׷����� �ϰ� > �׸��� ���� ���߿��� ���ǿ� �´� �͸� �����ؼ� ���
SELECT deptno, ROUND(AVG(sal)) AvgSalary
FROM emp
GROUP BY deptno
HAVING 2000 <= ROUND(AVG(sal));

-- �ִ� �޿��� 2900�޷��� �Ѵ� �μ����� �ִ� �޿��� ���
SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno
HAVING 2900 <= MAX(sal);

-- �μ��� ��ձ޿��� �ִ� �޿��� �μ��� �޿��� �˻�
-- �׷��Լ��� ��ø
SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal) > AVG(sal);

-- rollup: �׷��Լ��� �����̳� �� �׷캰 �߰��հ谡 �ʿ��� ��쿡 ���
-- ���̻��
SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY ROLLUP(deptno);

SELECT deptno, count(*), sum(sal) FROM emp GROUP BY ROLLUP(deptno);

SELECT deptno, job, sum(sal) FROM emp GROUP BY ROLLUP (deptno, job);

SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job);

--����
--�ϳ� �̻�(Self Join)�� ���̺��� ���Ǹ� ������ ���
--�Ϲ����� ��� FK�� ���ؼ� ���� ������ �����ȴ�.
--Equi Join, Self Join, Outer Join�� �ֿ��ϰ� ���캸��
SELECT empno, ename, sal, job FROM emp; -- �ش� ����� ������ �˰� ���� ��
SELECT deptno, dname, loc FROM dept; -- �ش� �μ��� ������ �˰� ���� ��
SELECT * FROM emp, dept;

-- Cartesian Product
-- ::
-- emp, dept ���̺��� ���������� ����
-- 14 * 4= 56
-- 1) ���� ������ �������� ��
-- 2) ���� ������ �߸����� ��

-- STEP 1
SELECT * 
FROM emp, dept
WHERE emp.deptno=dept.deptno;

-- STEP 2. Alias
SELECT * FROM emp e, dept d
WHERE e.deptno=d.deptno;

-- STEP 3. Projection
SELECT empno, ename, sal, dname, loc FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP 4. Projection
SELECT e.empno, e.ename, e.sal, d.dname, d.loc FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- STEP 5.
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno AND d.deptno=10;

-- SELF JOIN
-- ::
-- �ϳ��� ���̺��� ��ü������ ������
-- Ư�� ����� ����� �̸��� ��ȸ

-- 1. emp���̺��� ���� Ư���� ����� ename�� ��ȸ
-- 2. ename�� �ش��ϴ� mgr��ȣ�� ã�´�
-- 3. �ٽ� emp���̺��� empno�� mgr�� ����� ã�Ƽ� ename�� ã�´�.

-- STEP 1.
SELECT ename, mgr FROM emp; -- BLAKE ����� ����ȣ�� ã��
SELECT empno, ename FROM emp; -- ����ȣ�� ��ġ�ϴ� �����ȣ�� ã�� �׿� �ش��ϴ� ��� �̸��� ã�´�.

-- STEP 2.
SELECT * FROM (SELECT ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m;

-- Step 3.
SELECT *
FROM(SELECT ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

-- STEP 4.
SELECT e.empno, e.ename ����̸�, m.ename ����̸�
FROM emp e, emp m
WHERE e.mgr = m.empno;

-- STEP 5.
SELECT e.empno, e.ename ����̸�, m.ename ����̸�
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename='BLAKE';

SELECT * FROM dept;

-- OUTER JOIN
-- p. 123 ����1
SELECT e.empno, e.ename, e.job, e.deptno e_deptno, d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+); -- Right Outer Join

SELECT e.empno, e.ename, e.job, e.deptno e_deptno, d.deptno d_deptno, d.dname
FROM emp e RIGHT JOIN dept d
ON d.deptno = e.deptno;

SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno  -- LEFT Outer Join
AND e.sal(+) > 2000;