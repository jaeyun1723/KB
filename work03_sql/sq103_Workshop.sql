--### Equi join ###
--1) EMP�� DEPT Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿��� ����϶�.
SELECT emp.deptno, dname, ename, sal
FROM EMP, DEPT
where emp.deptno=dept.deptno;
--2) �̸��� ��SMITH���� ����� �μ����� ����϶�.
SELECT dname
FROM EMP, DEPT
WHERE emp.deptno=dept.deptno AND ename='SMITH';
--### Outer join ###
--3) dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ�
--��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.
SELECT ename, emp.deptno, dname, sal
FROM EMP, DEPT
WHERE dept.deptno=emp.deptno(+);

--### Self join###
--4) EMP Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�.
--��SMTH�� �Ŵ����� FORD�̴١�
SELECT e.ename || '�� �Ŵ����� ' || m.ename ||'�̴�.'
FROM emp e, emp m
WHERE e.ename='SMITH' AND e.mgr=m.empno ;

--### Sub Query ###
--1) ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���ȣ, �Ի���,
--�޿��� ����϶�.
SELECT empno, ename, deptno, hiredate, sal
FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp);
--2) 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �޿��� �˻�..�޿��� ���� ������
--����϶�.
SELECT empno, ename, sal
FROM EMP
WHERE job IN (SELECT job FROM emp WHERE deptno=10)
ORDER BY sal DESC;
--3) 10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���ȣ,
--����, �Ի����� ����϶�.
SELECT empno, ename, deptno, job, hiredate
FROM emp
WHERE deptno=10 AND job NOT IN(SELECT job FROM emp WHERE deptno=30);
--4) ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE sal IN(SELECT sal FROM emp WHERE ename IN('KING','JAMES'));
--5) �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno=30);
--6) SCOTT�� �޿����� �� ���� �޿��� �޴� ����� �˻��϶�.
--2���� ����� ��� 1) �������� 2) ���̺� �˸��߽� ���
--6-1) 
SELECT ename
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');
--6-2) 
SELECT ename
FROM emp main, (SELECT sal FROM emp WHERE ename='SCOTT') sub
WHERE main.sal>sub.sal;
--7) �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻��϶�.
SELECT deptno, MIN(sal)
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno=20);

--8) ���������� �Ŵ��� ����� �˻��϶� .
SELECT ename "����̸�", empno "�������ȣ" 
FROM emp 
WHERE empno IN (SELECT distinct mgr FROM emp);
--�̶� ����̸��� ����� �����ȣ�� �˻��ǵ��� �Ѵ�.
--(�⸮�߽��� ����̸�, �������ȣ)
--�ۼ��Ͻ� ������ sql03_Workshop.sql �� �����ϰ� MM�� �÷��ֽñ� �ٶ��ϴ�