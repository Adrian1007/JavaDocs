DROP TABLE LOCATIONS;
CREATE TABLE LOCATIONS (
  LOCATION_ID    INT PRIMARY KEY,
  STREET_ADDRESS VARCHAR(40),
  POSTAL_CODE    VARCHAR(12),
  CITY           VARCHAR(30) NOT NULL,
  STATE_PROVENCE VARCHAR(25)
);

DROP TABLE DEPARTMENTS;
CREATE TABLE DEPARTMENTS (
  DEPARTMENT_ID   INT PRIMARY KEY,
  DEPARTMENT_NAME VARCHAR(30),
  LOCATION_ID     INT
);

DROP TABLE JOBS;
CREATE TABLE JOBS (
  JOB_ID     VARCHAR(30) PRIMARY KEY,
  JOB_TITLE  VARCHAR(35),
  MIN_SALARY INT,
  MAX_SALARY INT
);

DROP TABLE EMPLOYEES;
CREATE TABLE EMPLOYEES (
  EMPLOYEE_ID   INT PRIMARY KEY,
  FIRST_NAME    VARCHAR(20),
  LAST_NAME     VARCHAR(25) NOT NULL,
  EMAIL         VARCHAR(25) NOT NULL,
  PHONE_NUMBER  VARCHAR(20),
  HIRE_DATE     DATE        NOT NULL,
  JOB_ID        VARCHAR(30) NOT NULL,
  SALARY        DECIMAL(8, 2),
  COMMISION_PCT DECIMAL(2, 2),
  MANAGER_ID    INT,
  DEPARTMENT_ID INT
);

ALTER TABLE LOCATIONS CHANGE LOCATION_ID LOCATION_ID INT AUTO_INCREMENT;
ALTER TABLE JOBS  CHANGE JOB_ID JOB_ID INT AUTO_INCREMENT;
ALTER TABLE DEPARTMENTS CHANGE DEPARTMENT_ID DEPARTMENT_ID INT AUTO_INCREMENT;
ALTER TABLE EMPLOYEES CHANGE EMPLOYEE_ID EMPLOYEE_ID INT AUTO_INCREMENT;

ALTER TABLE EMPLOYEES ADD FOREIGN KEY (MANAGER_ID) REFERENCES EMPLOYEES (EMPLOYEE_ID);
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (JOB_ID) REFERENCES JOBS (JOB_ID);
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENTS (DEPARTMENT_ID);
ALTER TABLE DEPARTMENTS ADD FOREIGN KEY (LOCATION_ID) REFERENCES LOCATIONS (LOCATION_ID);

INSERT INTO LOCATIONS VALUES (1, 'Splai', '999', 'Bucuresti', 'Romania');
INSERT INTO DEPARTMENTS VALUES (1, 'ADMINISTRATION', 1);
INSERT INTO JOBS VALUES (1, 'ADMINISTRATION', 999, 9999);
INSERT INTO EMPLOYEES VALUES (1, 'Adi', 'Gheorghe', 'mail', '056.342', now(), 1, 2000, NULL, NULL, 1);

ROLLBACK;

COMMIT;

SELECT *
FROM EMPLOYEES;
SELECT *
FROM DEPARTMENTS;
SELECT *
FROM JOBS;


SELECT
  FIRST_NAME,
  LAST_NAME
FROM EMPLOYEES;

SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 50;

UPDATE EMPLOYEES
SET SALARY = 1.3 * SALARY
WHERE DEPARTMENT_ID = 50;
|

!!! DELETE *FROM EMPLOYEES
WHERE EMPLOYEE_ID = 101;

SELECT *
FROM EMPLOYEES
WHERE JOB_ID = 15;

SELECT a.DEPARTMENT_NAME
FROM DEPARTMENTS a, EMPLOYEES b
WHERE a.DEPARTMENT_ID = b.DEPARTMENT_ID AND a.DEPARTMENT_ID = 50;


SELECT EMPLOYEE_ID AS COUNT
FROM EMPLOYEES
WHERE JOB_ID = 15;

SELECT *
FROM EMPLOYEES a, LOCATIONS b
WHERE b.CITY = 'SEATTLE';

CREATE VIEW Angajati AS
SELECT a.EMPLOYEE_ID, a.FIRST_NAME, b.DEPARTMENT_NAME
FROM EMPLOYEES a, DEPARTMENTS b

SELECT sysdate() from dual;
SELECT date_format(sysdate(), '%y-%m-%d');







