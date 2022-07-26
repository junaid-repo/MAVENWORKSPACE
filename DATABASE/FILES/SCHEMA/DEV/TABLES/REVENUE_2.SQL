
  CREATE TABLE "DEV"."REVENUE_2" 
   (	"REVENUE_2_ID" NUMBER, 
	"CREATED_DATE" DATE, 
	"SHIPTO_ADDR_KEY" VARCHAR2(200), 
	"OFFICE_KEY" VARCHAR2(200), 
	"EMPL_KEY" VARCHAR2(200), 
	"PROD_KEY" VARCHAR2(200), 
	"ORDER_KEY" VARCHAR2(200), 
	"UNITS" NUMBER, 
	"DISCNT_VALUE" NUMBER, 
	"BILL_MTH_KEY" NUMBER, 
	"BILL_QTR_KEY" NUMBER, 
	"BILL_DAY_DT" DATE, 
	"ORDER_DAY_DT" DATE, 
	"PAID_DAY_DT" DATE, 
	"DISCNT_RATE" NUMBER, 
	"ORDER_STATUS" VARCHAR2(200), 
	"CURRENCY" VARCHAR2(200), 
	"ORDER_TYPE" VARCHAR2(200), 
	"CUST_KEY" VARCHAR2(200), 
	"SHIP_DAY_DT" DATE, 
	"COST_FIXED" NUMBER, 
	"COST_VARIABLE" NUMBER, 
	"SRC_ORDER_NUMBER" NUMBER, 
	"ORDER_NUMBER" NUMBER, 
	"REVENUE" NUMBER, 
	"ORDER_DTIME2_TIMEZONE" VARCHAR2(200)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
