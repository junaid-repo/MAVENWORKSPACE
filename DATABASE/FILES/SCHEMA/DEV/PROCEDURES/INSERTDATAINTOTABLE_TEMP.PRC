
  CREATE OR REPLACE PROCEDURE "DEV"."INSERTDATAINTOTABLE_TEMP" (tableName    in varchar2,
                                                     tableColumns in varchar2,
                                                     retCode      out number,
                                                     retErr       out varchar2)

 as

  tableC     varchar2(20000);
  vQuery     varchar2(20000);
  cName      varchar2(20000);
  vCount     number;
  columnval  varchar2(200);
  columnType varchar2(200);
  vSubQuery  varchar2(20000);

  CURSOR GETCOLTYPE IS
    SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH, DATA_PRECISION, DATA_SCALE
      FROM ALL_TAB_COLS
     WHERE OWNER = 'DEV'
       AND TABLE_NAME = tableName;

  CURSOR GETCOLUMNS IS
    SELECT
    
     REGEXP_SUBSTR(tableColumns, '[^##]+', 1, level)
      FROM dual
    CONNECT BY REGEXP_SUBSTR(tableColumns, '[^##]+', 1, level) IS NOT NULL;

  CURSOR GETVALUES IS
    SELECT
    
     REGEXP_SUBSTR(tableColumns, '[^,]+', 1, level)
      FROM dual
    CONNECT BY REGEXP_SUBSTR(tableColumns, '[^,]+', 1, level) IS NOT NULL;

begin
  vCount := 0;

  RETCODE := 0;
  retErr  := 'SuccsspbDDs';
--tableColumns  := replace(tableColumns, ''', ''''');
  vSubQuery := 'insert into ' || tableName || ' values ' || '( ' ||
               ' tablesSeq.Nextval,    sysdate,';

  --vCount:=GETCOLUMNS%rowcount;
  BEGIN
    OPEN GETCOLUMNS;
    LOOP
      FETCH GETCOLUMNS
        INTO cName;
         exit when(GETCOLUMNS%notfound);
      --cName  := replace(cName, '~~', ''',''');
      SELECT SUBSTR(cName, 0, INSTR(cName, '~~') - 1),
             SUBSTR(cName, INSTR(cName, '~~') + 2)
        into columnval, columnType
      
        FROM dual;
      if (columnType  <> 'DATE') THEN
      
        vSubQuery := vSubQuery||'''' || columnval||''',';
      end if;
    
      if (columnType = 'DATE') THEN
    --  columnval:=  replace(columnval, ''''', ''''');
        vSubQuery :=vSubQuery|| ' ' || columnval||',';
      end if;
    
      /*tableC := 'insert into ' || tableName || ' values ' || '( ' ||
                      ' tablesSeq.Nextval,    sysdate,';
      */
     
    
       
    
    end loop;
    close GETCOLUMNS;
      tableC := tableC || ' ' || vSubQuery;
   tableC := SUBSTR(tableC, 1, LENGTH(tableC) - 1);
    
      tableC := tableC || ')';
      vQuery := tableC;
      testjoyProc( vQuery);
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
