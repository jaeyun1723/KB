--1) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�. ��, �̸��� �տ��� 3���ھ��� ����϶�.
SELECT empno, SUBSTR(ename,1,3), sal
FROM emp;
--2) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸�����
--����϶�.
SELECT SUBSTR(ename,1,3)
FROM emp
WHERE LENGTH(ename)>=6;
--3) ���������� �Է��ϴ� �� �Ʒ��� ���� �Է� �Ǿ���.(�̸��� ������ �Էµ�)
--insert into emp values(8001, �� PARK �� , 'IT' , 7521 , '21/11/10', 20000,1000,10);
--select * from emp;
--�̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
--select * from emp where ename='PARK';
--�̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����϶�.
SELECT * FROM emp WHERE TRIM(ename)='PARK';

--4) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. 
--�̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.
SELECT ename, sal, ROUND(0.15*sal,1) "ȸ��" 
FROM emp
WHERE sal BETWEEN 1500 AND 3000;
--5) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ���� �� �Ͽ���. 
--�̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�
SELECT ename, sal, FLOOR(sal*0.05)
FROM emp
WHERE sal>=2000;
--6) �Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿���
--����϶�.
SELECT ename, hiredate, hiredate+100, sal
FROM emp;
--7) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�. 
--�Ի���, 6���� ���� ��¥, �޿��� ����϶�
SELECT hiredate, ADD_MONTHS(hiredate,6), sal
FROM emp;
--8) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �ٹ��ϼ��� ����϶�.
SELECT deptno, ename, last_day(hiredate)-hiredate FROM emp;
--9) ��� ����� �Ի��� �������� 100���� ���� ���� �������� ��¥�� ���ؼ� ��� �̸�, 
--�Ի��� , ��MONDAY���� ����϶�.
SELECT ename, hiredate, next_day(hiredate+100,2) "MONDAY" FROM emp;
--10) ������ �̸�, ����, �ټӳ���� ���Ͽ� ����϶�.
SELECT ename, job, TRUNC((sysdate-hiredate)/365) FROM emp;
--11) ��� ������ �̸��� �Ի����� ��1996-05-14���� ���·� ��� �϶�.
SELECT ename, TO_CHAR(hiredate,'YYYY-MM-DD') FROM emp;
--12) ��� ������ ��ȣ, �̸�, �޿��� ����϶�. ��, �޿� �տ� ȭ��ǥ��($), �׸���
--����(,)ǥ��, �Ҽ��� ���� 2�ڸ��� ǥ�õǵ��� �϶�.
SELECT empno, ename, TO_CHAR(sal,'$999,999.99') FROM emp;
--13) ��� ������ �̸��� �Ի��� ������ ����϶�.
SELECT ename, TO_CHAR(hiredate,'DAY') FROM emp;
--�ۼ��Ͻ� �ڵ�� sql02_Workshop.sql ���Ϸ� MM�� ���ε��� �ֽñ� �ٶ��ϴ�