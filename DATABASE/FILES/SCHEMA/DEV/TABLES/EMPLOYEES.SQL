
  CREATE TABLE "OT"."EMPLOYEES" 
   (	"EMPLOYEE_ID" NUMBER, 
	"FIRST_NAME" VARCHAR2(255) NOT NULL ENABLE, 
	"LAST_NAME" VARCHAR2(255) NOT NULL ENABLE, 
	"EMAIL" VARCHAR2(255) NOT NULL ENABLE, 
	"PHONE" VARCHAR2(50) NOT NULL ENABLE, 
	"HIRE_DATE" DATE NOT NULL ENABLE, 
	"MANAGER_ID" NUMBER(12,0), 
	"JOB_TITLE" VARCHAR2(255) NOT NULL ENABLE, 
	"EMPLOYEE_CODE" VARCHAR2(20), 
	 PRIMARY KEY ("EMPLOYEE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 CONSTRAINT "FK_EMPLOYEES_MANAGER" FOREIGN KEY ("MANAGER_ID")
	  REFERENCES "OT"."EMPLOYEES" ("EMPLOYEE_ID") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
