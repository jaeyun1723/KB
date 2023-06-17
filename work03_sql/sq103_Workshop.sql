--### Equi join ###
--1) EMP와 DEPT Table을 JOIN하여 부서번호, 부서명, 이름, 급여를 출력하라.
SELECT emp.deptno, dname, ename, sal
FROM EMP, DEPT
where emp.deptno=dept.deptno;
--2) 이름이 ‘SMITH’인 사원의 부서명을 출력하라.
SELECT dname
FROM EMP, DEPT
WHERE emp.deptno=dept.deptno AND ename='SMITH';
--### Outer join ###
--3) dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여
--모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
SELECT ename, emp.deptno, dname, sal
FROM EMP, DEPT
WHERE dept.deptno=emp.deptno(+);

--### Self join###
--4) EMP Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라.
--‘SMTH의 매니저는 FORD이다’
SELECT e.ename || '의 매니저는 ' || m.ename ||'이다.'
FROM emp e, emp m
WHERE e.ename='SMITH' AND e.mgr=m.empno ;

--### Sub Query ###
--1) 전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서번호, 입사일,
--급여를 출력하라.
SELECT empno, ename, deptno, hiredate, sal
FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp);
--2) 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 급여를 검색..급여가 많은 순으로
--출력하라.
SELECT empno, ename, sal
FROM EMP
WHERE job IN (SELECT job FROM emp WHERE deptno=10)
ORDER BY sal DESC;
--3) 10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서번호,
--업무, 입사일을 출력하라.
SELECT empno, ename, deptno, job, hiredate
FROM emp
WHERE deptno=10 AND job NOT IN(SELECT job FROM emp WHERE deptno=30);
--4) ‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 출력하라.
SELECT empno, ename, sal
FROM emp
WHERE sal IN(SELECT sal FROM emp WHERE ename IN('KING','JAMES'));
--5) 급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 출력하라.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno=30);
--6) SCOTT의 급여보다 더 많은 급여를 받는 사원을 검색하라.
--2가지 방법을 사용 1) 서브쿼리 2) 테이블 알리야스 사용
--6-1) 
SELECT ename
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');
--6-2) 
SELECT ename
FROM emp main, (SELECT sal FROM emp WHERE ename='SCOTT') sub
WHERE main.sal>sub.sal;
--7) 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색하라.
SELECT deptno, MIN(sal)
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno=20);

--8) 부하직원을 거느린 사원을 검색하라 .
SELECT ename "상사이름", empno "상사사원번호" 
FROM emp 
WHERE empno IN (SELECT distinct mgr FROM emp);
--이때 상사이름과 상사의 사원번호가 검색되도록 한다.
--(얄리야스는 상사이름, 상사사원번호)
--작성하신 파일은 sql03_Workshop.sql 로 저장하고 MM에 올려주시기 바랍니다