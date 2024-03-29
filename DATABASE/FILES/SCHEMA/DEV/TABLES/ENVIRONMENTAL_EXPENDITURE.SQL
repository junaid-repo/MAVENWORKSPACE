
  CREATE TABLE "DEV"."ENVIRONMENTAL_EXPENDITURE" 
   (	"ENVIRONMENTAL_EXPENDITURE_ID" NUMBER, 
	"CREATED_DATE" DATE, 
	"YEAR" NUMBER, 
	"SECTOR" VARCHAR2(200), 
	"CLASS" VARCHAR2(200), 
	"CFN_TLE1" VARCHAR2(200), 
	"CFN_TLE2" VARCHAR2(200), 
	"UNITS" VARCHAR2(200), 
	"MAGNITUDE" VARCHAR2(200), 
	"SOURCE" VARCHAR2(200), 
	"DATA_VALUE" NUMBER, 
	"FLAG" VARCHAR2(200)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
