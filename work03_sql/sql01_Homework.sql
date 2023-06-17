--1) 30�� �μ� ������ ���(�Ҽ�2�ڸ� �Ʒ� �ø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT CEIL(AVG(sal)*100)/100, MAX(sal),MIN(sal), COUNT(-1)
FROM emp
WHERE deptno=30;
--2) �� �μ��� �޿��� ���(�Ҽ� ���� �ݿø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT deptno, ROUND(AVG(sal)), MAX(sal), MIN(sal), COUNT(-1)
FROM emp
GROUP BY deptno
ORDER BY 1;
--3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο�����
--����϶�.
SELECT deptno, job, count(-1)
FROM emp
GROUP BY deptno, job
ORDER BY 1;
--4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο����� ����϶�.
SELECT job, count(-1)
FROM emp
GROUP BY job
HAVING count(-1)>=2;
--5) �� �μ��� ��� ����(�Ҽ� ���� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ���
--������ ���� ������ ����϶�.
SELECT deptno, TRUNC(AVG(sal)), SUM(sal), MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
ORDER BY TRUNC(AVG(sal)) DESC;
--6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������ �� �޿���
--�Ұ�� ������ ����϶�. �μ��� �����Ѵ�.
SELECT deptno, job, sum(sal)
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY 1;
--7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
SELECT deptno
FROM emp
GROUP BY deptno
HAVING count(-1)>=5;
--8) �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
--��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���� ������
--��ȸ������� ���ܽ�Ų��.
SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal)!= MIN(sal)
ORDER BY 1;
--9) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴�
--�������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
--��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
--�μ� ���� ��µǵ��� �ؾ� �Ѵ�
SELECT deptno, AVG(sal)
FROM emp
WHERE deptno IN(10,20,30) AND sal BETWEEN 2500 AND 5000
GROUP BY deptno
HAVING AVG(sal)>=2000
ORDER BY 2 DESC;

