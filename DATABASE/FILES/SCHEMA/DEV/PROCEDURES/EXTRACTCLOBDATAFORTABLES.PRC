
  CREATE OR REPLACE PROCEDURE "DEV"."EXTRACTCLOBDATAFORTABLES" (vClob     out clob,
                                                     vRetCode  out number,
                                                     vRetError out varchar2) as
begin
  begin
  
    DEV.MAKETABLESQLQUERY(vRetCode, vRetError);
  exception
    when others then
      vRetCode  := sqlcode;
      vRetError := sqlerrm;
  end;

 

  select a.rawstructure into vClob
    from (
          
          select rownum rnum, t.rawstructure from TABLERAWSTRUCTURE t
          
          ) a
   where rnum = 3;

exception

  when others then
    vRetCode  := sqlcode;
    vRetError := sqlerrm;
end;
