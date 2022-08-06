
  CREATE OR REPLACE PROCEDURE "DEV"."INSERTDATAINTOTABLE" (tableName    in varchar2,
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
  retErr  := 'SuccesSsss';

  --vCount:=GETCOLUMNS%rowcount;
  BEGIN
    OPEN GETCOLUMNS;
    LOOP
      FETCH GETCOLUMNS
        INTO cName;
      cName  := replace(cName, '~~', ''',''');
      cName  := '''' || cName;
      tableC := 'insert into ' || tableName || ' values ' || '( ' ||
                ' tablesSeq.Nextval, sysdate,';

      exit when(GETCOLUMNS%notfound);
      tableC := tableC || ' ' || cName;
      --  tableC := SUBSTR(tableC, 1, LENGTH(tableC) - 1);

      tableC := tableC || ''')';
      vQuery := tableC;
      execute immediate vQuery;

    end loop;
    close GETCOLUMNS;

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
