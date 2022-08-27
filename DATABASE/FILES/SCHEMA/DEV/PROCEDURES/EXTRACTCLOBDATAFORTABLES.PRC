
  CREATE OR REPLACE PROCEDURE "DEV"."EXTRACTCLOBDATAFORTABLES" (vTableName in varchar2,
                                                     vClob      out clob,
                                                     vRetCode   out number,
                                                     vRetError  out varchar2) as
begin
  begin
  
  
    DEV.SQLQUERY_TABLESPECIFIC( vTableName, vRetCode, vRetError);
  exception
    when others then
      vRetCode  := sqlcode;
      vRetError := sqlerrm;
  end;

  /* select a.rawstructure
      into vClob
      from (
            
            select rownum rnum, t.rawstructure from TABLERAWSTRUCTURE t
            
            ) a
     where rnum = 3;
  */

  select t.rawstructure
    into vClob
    from TABLERAWSTRUCTURE t
   where upper(t.tablename) = upper(vTableName);

exception

  when others then
    vRetCode  := sqlcode;
    vRetError := sqlerrm;
end;
