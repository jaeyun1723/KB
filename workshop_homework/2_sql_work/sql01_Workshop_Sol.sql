--  1) EMP 테이블 정보의 구조를 확인하는 SQL을 작성 하세요.
DESC emp;

-- 2) 이름이 K로 시작하는 사원의 사원번호, 이름, 입사일, 급여를 검색하세요.
SELECT empno, ename, hiredate, sal
FROM emp
WHERE ename LIKE 'K%';

-- 3)입사일이 80년도인 사람의 모든 정보를 검색하세요.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE hiredate LIKE '80%';

-- 4)커미션이 NULL이 아닌 사람의 모든 정보를 검색하세요.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE comm IS NOT NULL;

-- 5)부서가 30번 부서이고 급여가 $1,500 이상인 사람의 이름, 부서 ,월급을 검색하세요.
SELECT ename, deptno, sal
FROM emp
WHERE deptno = 30 and sal >= 1500;

-- 6)부서번호가 30인 사람 중 사원번호 SORT하여 출력되도록 검색하세요.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE deptno = 30
ORDER BY empno;

-- 7)급여가 많은 순으로 SORT하여 출력되도록 검색하세요
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY sal DESC;

-- 8)부서번호로 ASCENDING SORT한 후 급여가 많은 사람 순으로  검색하세요
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY deptno, sal DESC;

-- 9)부서번호가 DESCENDING SORT하고, 이름 순으로 ASCENDING SORT,
-- 급여 순으로 DESCENDING SORT 하여 출력되도록 검색하세요.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY deptno DESC, ename, sal DESC;

-- 10)  EMP Table에서 이름, 급여, 커미션 금액, 총액(급여+커미션금액)을 
-- 구하여 총액이 많은 순서로 검색하세요. 단, 커미션이 NULL인
-- 사람은 제외한다.(커미션금액: sal*comm/100) 
-- 총액의 별칭은 Total로 한다.
SELECT ename, sal, sal*comm/100 comm, sal+sal*comm/100 Total
FROM emp
WHERE comm IS NOT NULL
ORDER BY Total DESC;

-- 11)10번 부서의 모든 사람들에게 급여의 13%를 보너스로 지불하기로 하였다. 이름, 급여, 보너스 금액, 부서번호를 검색하세요.
SELECT ename, sal, sal*0.13 Bonus, deptno
FROM emp
WHERE deptno = 10;

SELECT ename, sal, sal*.13 Bonus, deptno
FROM emp
WHERE deptno = 10;

-- 12)부서번호가 20인 사원의 시간당 임금을 계산하여 검색하세요.
-- 단, 1달의 근무일수는 12일이고, 1일 근무시간은 5시간이다. 
-- 출력양식은 이름, 급여, 시간당 임금(소수점 이하 첫 번째 자리에서 반올림)을 검색하세요
SELECT ename, sal, round(sal/12/5) HourSal
FROM emp
WHERE deptno = 20;

-- 13)급여가 $1,500부터 $3,000 사이의 사람은 급여의 15%를 회비로 지불하기로 하였다. 이를 이름, 급여, 회비(소수점 두자리 아래에서 반올림)를 검색하세요.
SELECT ename, sal, round(sal*.15, 2) 회비
FROM emp
WHERE sal between 1500 and 3000;

SELECT ename, sal, round(sal*.15, 2) 회비
FROM emp
WHERE sal <=3000 AND sa>=1500;

-- 14) 모든 사원의 실 수령액을 계산하여 검색하세요.. 단, 급여가 많은  순으로 이름, 급여, 실 수령액을 검색하세요..(실 수령액은 급여에  대해 10%의 세금을 뺀 금액)
SELECT ename, sal, sal*.9 as 실수령액
FROM emp
ORDER BY sal DESC;
