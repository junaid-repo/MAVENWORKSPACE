
  CREATE OR REPLACE PROCEDURE "DEV"."TESTJOYPROC" (datas in clob) as

begin

insert into dev.testjoy values(sysdate, datas);
commit;

exception when others then
 null;
end;
