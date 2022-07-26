
  CREATE TABLE "OT"."INVENTORIES" 
   (	"PRODUCT_ID" NUMBER(12,0), 
	"WAREHOUSE_ID" NUMBER(12,0), 
	"QUANTITY" NUMBER(8,0) NOT NULL ENABLE, 
	 CONSTRAINT "PK_INVENTORIES" PRIMARY KEY ("PRODUCT_ID", "WAREHOUSE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 CONSTRAINT "FK_INVENTORIES_PRODUCTS" FOREIGN KEY ("PRODUCT_ID")
	  REFERENCES "OT"."PRODUCTS" ("PRODUCT_ID") ON DELETE CASCADE ENABLE, 
	 CONSTRAINT "FK_INVENTORIES_WAREHOUSES" FOREIGN KEY ("WAREHOUSE_ID")
	  REFERENCES "OT"."WAREHOUSES" ("WAREHOUSE_ID") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
