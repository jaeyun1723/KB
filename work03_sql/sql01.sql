-- 테이블의 구조를 확인 DESC
-- pk로 지정된 column은 not null + unique
desc emp;
desc dept;

-- Projection : 디스플레이하고자 하는 컬럼을 지정해서 가져옴
-- * 사용하지 않는 것 권장
    -- 보안 : 모든 column 공개 하지 않아야 할 수도
    -- 성능 상 무조건 projection 사용
select * from emp;

-- emp table에서 사원의 이름, 금여, 업무, 부서번호 검색
select ename, sal, job, deptno from emp;
-- selection : 조건(where)을 부여해서 행을 제한
-- 10번 부서에서 근무하는 사원의 이름, 급여, 입사년도, 부서번호 검색
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10;

-- 10번 부서에서 근무하는 사원의 이름, 급여, 입사년도, 부서번호 검색
-- 급여를 많이 받은 사원 순 정렬 order by
SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal ASC; -- asc가 default

SELECT ename, sal, hiredate, deptno
FROM emp
WHERE deptno=10
ORDER BY sal DESC; -- desc 내림차순

-- SALESMAN 부서에서 사원의 사원번호, 이름, 업무, 부서번호를 검색
-- 정렬을 부서번호 순
SELECT empno, ename, job, deptno 부서번호
FROM EMP
WHERE job = 'SALESMAN'
ORDER BY deptno;

SELECT empno, ename, job, deptno 부서번호
FROM EMP
WHERE job = 'SALESMAN'
ORDER BY 부서번호;

SELECT empno, ename, job, deptno 부서번호
FROM EMP
WHERE job = 'SALESMAN'
ORDER BY 4;
/*
SELECT empno, ename, job, deptno 부서번호
FROM EMP
WHERE 부서번호 = 20
ORDER BY 4;
*/

-- 사원 중에서 입사일이 가장 빠른 순
SELECT empno, ename, hiredate
FROM EMP
ORDER BY hiredate;

-- 사원 중 가장 많은 급여 받는 사원 3명 (rownum)
SELECT ename, job, sal
FROM EMP
ORDER BY sal DESC;

-- where절 보다 order by 절이 먼저 실행되도록 해야한다
-- rownum이 order by 절보다 먼저 실행이 되서 결과가 잘못나옴
SELECT ename, job, sal
FROM EMP
WHERE rownum <= 3
ORDER BY sal DESC;
-- 대안책
SELECT ename, job, sal
FROM (SELECT * FROM emp ORDER BY sal DESC) 
WHERE rownum <= 3;


-- 모든 사원의 급여를 기존 급여에 2배에 20달러 추가한 급여로 인상
SELECT ename, sal, sal*2 + 20 "인상 급여"
FROM emp;

SELECT ename, sal, sal*2 + 20 "인상 급여"
FROM emp
ORDER BY "인상 급여";

SELECT ename, sal, sal*2 + 20 "IncrementSalary"
FROM emp;

-- 급여에서 세금 제외 검색(10프로)
SELECT ename, sal, sal-(sal*0.1) "실제 수령 급여"
FROM emp;

SELECT ename, sal, sal*0.9 "실제 수령 급여"
FROM emp;

-- 모든 사원의 연봉
SELECT ename, job, sal, sal*12+comm "AnnualSalary"
FROM emp;
-- null값이 연산으로 진행될 때 반드시 다른 값으로 치환해서 사용
-- NVL(comm, 0) : comm이 null이면 0으로, null이 아니면 comm을 그대로 사용
Select ename, job, sal, sal*12+ NVL(comm,0) AnnualSalary
FROM emp;

-- step3 
-- comm이 null이 아닌 사원의 연봉을 구한다라는 조건
Select ename, job, sal, sal*12+ comm AnnualSalary
FROM emp
WHERE comm is not null;

SELECT comm
FROM emp
ORDER BY comm desc;

-- emp table 부서 검색
SELECT deptno FROM emp;

-- distinct : 성능 저하에 가장 많은 영향
SELECT DISTINCT deptno FROM emp;

-- 10G 이후 부터는 자동정렬 안됨
SELECT DISTINCT deptno FROM emp ORDER BY 1;

-- DISTINCT를 사용해서 부서 번호를 중복 없이 가져와야 하는 경우 -> EXISTS 사용
SELECT deptno from dept d
WHERE EXISTS(SELECT * FROM emp e WHERE d.deptno = e.deptno);

-- 특정한 패턴으로 검색
-- LIKE 연산자 + 와일드카드()
-- 사원 중에서 이름이 S로 시작하는 사원을 검색 
SELECT ename
FROM emp
WHERE ename LIKE 'S%';

-- 사원 중에서 사원 이름에 A가 포함된 사원 검색
SELECT ename
FROM emp
WHERE ename LIKE '%A%';

-- 80년에 입사한 사원
SELECT ename, job, hiredate
FROM emp
WHERE hiredate LIKE '80%';

--IN 연산자
--여러 개의 값 중에 어느 하나와 일치하는지를 비교
SELECT empno, ename, job FROM emp WHERE empno=7369;
SELECT empno, ename, job FROM emp WHERE empno=7521;
SELECT empno, ename, job FROM emp WHERE empno=7782;

SELECT empno, ename, job
FROM emp
WHERE empno IN(7369, 7521, 7782);

SELECT empno, ename, job
FROM emp
WHERE empno NOT IN(7369, 7521, 7782); -- !=7369 and !=7521 and !=7782

--SUBSTR(추출할 문자열, 시작위치)
--SUBSTR(추출할 문자열, 시작위치, 추출갯수)
--문자열을 추출하는 기능... 함수안의 인자값을 정확히 이해
SELECT SUBSTR('HelloWorld',6) FROM DUAL;   -- H 인덱스 : 1
SELECT SUBSTR('HelloWorld',6,3) FROM DUAL;
SELECT SUBSTR('HelloWorld',-5) FROM DUAL;

-- 사원이름이 N으로 끝나는 사원을 검색
SELECT ename, job FROM emp WHERE SUBSTR(ename,-1)='N';
SELECT ename, job FROM emp WHERE ename LIKE '%N';

-- EMP테이블에서 년도만 추출... 10번 부서에서 검색되도록
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
SELECT REPLACE('      James    Gosling           ',' ','') FROM dual; -- 모든 공백 제거

--숫자함수
SELECT ROUND(45.923,2) FROM dual; -- 소수점 2번째 자리까지 표시-> 소수점 이하 3번째에서 반올림
SELECT ROUND(45.923,0) FROM dual; -- 46
SELECT ROUND(45.923) FROM dual;

-- FLOOR :: 소수점 아래를 버림(정수로만 표시, 자릿수 지정x)
SELECT FLOOR(45.923) FROM DUAL;

-- TRUNC :: 지정된 자릿수 이하를 버림
SELECT TRUNC(45.923,2) FROM DUAL; -- 45.92

-- CEIL :: 올림. 정수로만 표시
SELECT CEIL(45.923) FROM DUAL;
--SELECT CEIL(45.923,2) FROM DUAL; 에러

-- 날짜 함수
-- 날짜+숫자=날짜
-- 날짜-숫자=날짜
-- 날짜-날짜=기간(숫자)

SELECT SYSDATE FROM DUAL;
SELECT SYSDATE + 1 FROM DUAL;
SELECT SYSDATE + 100 FROM DUAL;

SELECT ROUND(SYSDATE - TO_DATE('1997/4/5')) FROM DUAL;

-- 4개월 후의 날짜를 검색
SELECT ADD_MONTHS(SYSDATE,4) FROM DUAL;
-- 정길연님의 살아온 월수를 검색
SELECT FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE('2000/12/8'))) FROM DUAL;
-- EMP테이블에서 사원들이 현재까지 근무한 주(WEEKS) 수를 검색
SELECT FLOOR((SYSDATE-HIREDATE)/7) FROM EMP;