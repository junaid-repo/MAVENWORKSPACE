
  CREATE OR REPLACE PROCEDURE "DEV"."CREATETABLE" (tableName    in varchar2,
                                        tableColumns in varchar2,
                                        retCode      out number,
                                        retErr       out varchar2)

 as

  tableC varchar2(20000);
  vQuery varchar2(20000);
  cName  varchar2(200);
  vCount number;

  CURSOR GETCOLUMNS IS
    SELECT
    
     REGEXP_SUBSTR(tableColumns, '[^##]+', 1, level) || ' varchar2(200),'
      FROM dual
    CONNECT BY REGEXP_SUBSTR(tableColumns, '[^##]+', 1, level) IS NOT NULL;

begin
  vCount := 0;
  tableC := 'create table ' || tableName || ' ( ' || tableName ||
            '_id number, created_date date, ';

  RETCODE := 0;
  retErr  := 'SuccessS';

  --vCount:=GETCOLUMNS%rowcount; 
  BEGIN
    OPEN GETCOLUMNS;
    LOOP
      FETCH GETCOLUMNS
        INTO cName;
      vCount := vCount + 1;
      exit when(GETCOLUMNS%notfound);
      tableC := tableC || ' ' || cName;
    
    end loop;
    close GETCOLUMNS;
    tableC := SUBSTR(tableC, 1, LENGTH(tableC) - 1);
  
    tableC := tableC || ')';
    vQuery := tableC;
    execute immediate vQuery;
  exception
    when others then
      RETCODE := SQLCODE;
      retErr  := SQLERRM;
    
  end;

exception
  when others then
    RETCODE := SQLCODE;
    retErr  := SQLERRM;
  
end;
