
  CREATE OR REPLACE PROCEDURE "DEV"."CREATETABLE_TEMP" (retCode out number,
                                             retErr  out varchar2)

 as

  tableC       varchar2(20000);
  tableColumns varchar2(20000);
  tableName    varchar2(200);
  vQuery       varchar2(20000);
  cName        varchar2(200);
  columnName   varchar2(200);
  columnType   varchar2(200);
  vCount       number;

  CURSOR GETCOLUMNS IS
    SELECT
    
     REGEXP_SUBSTR(tableColumns, '[^##]+', 1, level)
      FROM dual
    CONNECT BY REGEXP_SUBSTR(tableColumns, '[^##]+', 1, level) IS NOT NULL;

begin
  tableColumns := 'aaa~~varchar##bbb~~varchar##createdDate~~date##revenue~~number';
  tableName    := 'Testing';

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
    
      SELECT SUBSTR(cName, 0, INSTR(cName, '~~') - 1),
             SUBSTR(cName, INSTR(cName, '~~') + 2)
        into columnName, columnType
      
        FROM dual;
    
    -------------------------------------------------------
    
    if(lower(columnType)='varchar') then
       columnName:=columnName||' varchar2(200),';
       
    elsif   (lower(columnType)='number') then
       columnName:=columnName||' number,';
    elsif  (lower(columnType)='date') then
          columnName:=columnName||' DATE,';
    end if;
    
    -------------------------------------------------------
      vCount := vCount + 1;
      exit when(GETCOLUMNS%notfound);
      tableC := tableC || ' ' || columnName;
    
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
