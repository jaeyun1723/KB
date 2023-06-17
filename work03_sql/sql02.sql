-- Extract (년, 월, 일, 시간, 초 추출할 때 사용)
-- emp 테이블에서 사원의 이름과 사원이입사한 년, 월, 일을 추출... 부서번호가 20번인 사원
-- Year, Month, Day
SELECT ename 이름, hiredate,
EXTRACT (YEAR FROM hiredate) "Year",
EXTRACT (MONTH FROM hiredate) "Month",
EXTRACT (DAY FROM hiredate) "Day"
FROM emp
WHERE deptno = 20;

-- 다른 방법
SELECT ename 이름, hiredate,
SUBSTR(hiredate, 1, 2) "Year",
EXTRACT (MONTH FROM hiredate) "Month",
EXTRACT (DAY FROM hiredate) "Day"
FROM emp
WHERE deptno = 20;

-- p.70 예제3
SELECT ename, hiredate, NEXT_DAY(hiredate, 6) n_6, NEXT_DAY(hiredate, 7) n_7
FROM emp
WHERE deptno = 10
ORDER BY hiredate DESC;

-- p.70 예제4
SELECT empno, ename, hiredate, LAST_DAY(hiredate) l_last, LAST_DAY(hiredate) - hiredate l_day
FROM emp
ORDER BY LAST_DAY(hiredate) - hiredate DESC;

-- p.76 예제7 함수의 중첩 가능

-- p.73 예제1 급여에 3자리마다 , 를 출력하여 구분 (무조건 3자리마다 찍히는건 아님, 아래에서 추가 설명)
-- TO_CHAR( )를 통해 문자열로 바꿔줘야 함
-- 문제 발생 예시 : 2,000,400 은 안됨. 구분하려면 9로 자릿수 지정을 늘려준 후 ,로 처리 -> 999,999,999
SELECT empno, ename, job, sal, TO_CHAR(sal, '999,999')
FROM emp
WHERE deptno = 20
ORDER BY sal DESC;

-- p.75 예제3
SELECT ename, hiredate, TO_CHAR(hiredate, 'YYYY"년" MM"월" DD"일"') t_kor
FROM emp
WHERE deptno = 20
ORDER BY hiredate DESC;

-- p.83 DECODE -> ORACLE에만 존재하는 문법
-- 업무가 PRESIDENT면 사장
--       MANAGER면 관리자
--       ANALYST면 분석가
--       해당하는 것이 없다면 직원
--       직원분류 Alias
SELECT ename, job,
      DECODE(job, 'PRESIDENT', '사장',
                  'MANAGER', '관리자',
                  'ANALYST', '분석가',
                  '직원') 직원분류
FROM emp;

-- p.84 CASE -> 다른 DB에서도 사용 가능
-- 조건이 다양하거나 복잡하면 CASE를 주로 사용
SELECT ename, deptno,
      CASE WHEN deptno = '10' THEN 'NewYork'
           WHEN deptno = '20' THEN 'Dallas'
           ELSE 'city'
      END 도시명
FROM emp;      

-- 모든 사원의 보너스 평균.. AVG()
-- step1
-- null값이 있는 경우,.. 그룹 함수 사용시 주의 4로만 나눈다
SELECT ROUNG(AVG(comm)) "보너스 평균1" FROM emp;

-- step2
SELECT ROUND(AVG(NVL(comm, 0))) "보너스 평균2" FROM emp;

-- emp 테이블에서 부서 갯수
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno;

-- step2
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
ORDER BY DNumber;

-- step3
-- 알리야스 적용이 안되는 구절...1) where 2)group by
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp
GROUP BY DNumber
ORDER BY DNumber; -- 에러! 

-- Step 4.
SELECT deptno DNumber, ROUND(AVG(sal))
FROM emp
WHERE deptno != 10
GROUP BY deptno
ORDER BY DNumber;

-- 입사년도별 사원의 인원수 조회..count()
SELECT EXTRACT(YEAR FROM hiredate) AS Year FROM emp;
SELECT EXTRACT(YEAR FROM hiredate) AS Year, COUNT(empno)
FROM emp
--GROUP BY Year -- 이거 안됨
GROUP BY EXTRACT(YEAR FROM hiredate) -- 이거 됨
ORDER BY Year;

-- 2
SELECT TO_CHAR(hiredate, 'YY') 년도, COUNT(*)
FROM emp
GROUP BY TO_CHAR(hiredate, 'YY')
ORDER BY 1;

-- 부서별 평균 급여가 2000달러 이상인 부서의 부서번호와 평균급여를 조회
-- STEP1
-- where 절은 그룹함수와 함께 사용 못함
-- 그룹함수는 WHERE절에 아닌 HAVING 절에 넣어야함
SELECT deptno, ROUND(AVG(sal)) AvgSalary
FROM emp
WHERE ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

-- STEP2
-- 의미론적으로 그룹핑을 하고 > 그리고 나서 그중에서 조건에 맞는 것만 추출해서 출력
SELECT deptno, ROUND(AVG(sal)) AvgSalary
FROM emp
GROUP BY deptno
HAVING 2000 <= ROUND(AVG(sal));

-- 최대 급여가 2900달러가 넘는 부서들의 최대 급여를 출력
SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno
HAVING 2900 <= MAX(sal);

-- 부서별 평균급여가 최대 급여인 부서의 급여를 검색
-- 그룹함수의 중첩
SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal) > AVG(sal);

-- rollup: 그룹함수의 총합이나 각 그룹별 중간합계가 필요한 경우에 사용
-- 많이사용
SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY ROLLUP(deptno);

SELECT deptno, count(*), sum(sal) FROM emp GROUP BY ROLLUP(deptno);

SELECT deptno, job, sum(sal) FROM emp GROUP BY ROLLUP (deptno, job);

SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job);

--조인
--하나 이상(Self Join)의 테이블에서 질의를 던지는 경우
--일반적인 경우 FK에 의해서 조인 조건이 성립된다.
--Equi Join, Self Join, Outer Join을 주요하게 살펴보자
SELECT empno, ename, sal, job FROM emp; -- 해당 사원의 정보를 알고 싶을 때
SELECT deptno, dname, loc FROM dept; -- 해당 부서의 정보를 알고 싶을 때
SELECT * FROM emp, dept;

-- Cartesian Product
-- ::
-- emp, dept 테이블이 수평적으로 결합
-- 14 * 4= 56
-- 1) 조인 조건을 생략했을 떄
-- 2) 조인 조건을 잘못줬을 때

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
-- 하나의 테이블을 자체적으로 조인함
-- 특정 사원의 상사의 이름을 조회

-- 1. emp테이블에서 먼저 특정한 사원의 ename을 조회
-- 2. ename에 해당하는 mgr번호를 찾는다
-- 3. 다시 emp테이블에서 empno가 mgr인 사원을 찾아서 ename을 찾는다.

-- STEP 1.
SELECT ename, mgr FROM emp; -- BLAKE 사원의 상사번호를 찾고
SELECT empno, ename FROM emp; -- 상사번호와 일치하는 사원번호를 찾고 그에 해당하는 사원 이름을 찾는다.

-- STEP 2.
SELECT * FROM (SELECT ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m;

-- Step 3.
SELECT *
FROM(SELECT ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

-- STEP 4.
SELECT e.empno, e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr = m.empno;

-- STEP 5.
SELECT e.empno, e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename='BLAKE';

SELECT * FROM dept;

-- OUTER JOIN
-- p. 123 예제1
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