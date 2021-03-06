ALTER TABLE LOCATIONS CHANGE LOCATION_ID LOCATION_ID INT AUTO_INCREMENT;
ALTER TABLE JOBS  CHANGE JOB_ID JOB_ID INT AUTO_INCREMENT;
ALTER TABLE DEPARTMENTS CHANGE DEPARTMENT_ID DEPARTMENT_ID INT AUTO_INCREMENT;
ALTER TABLE EMPLOYEES CHANGE EMPLOYEE_ID EMPLOYEE_ID INT AUTO_INCREMENT;

ALTER TABLE EMPLOYEES ADD FOREIGN KEY (MANAGER_ID) REFERENCES EMPLOYEES (EMPLOYEE_ID);
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (JOB_ID) REFERENCES JOBS(JOB_ID);
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENTS(DEPARTMENT_ID);
ALTER TABLE DEPARTMENTS ADD FOREIGN KEY (LOCATION_ID) REFERENCES LOCATIONS(LOCATION_ID);