
  CREATE OR REPLACE PROCEDURE "DEV"."MAKETABLESQLQUERY" (RETCODE  OUT NUMBER,
                                              RETERROR OUT VARCHAR2) AS

  vTableName    varchar2(200);
  vQuery1       varchar2(2000);
  vQuery2       varchar2(2000);
   vQuery3       varchar2(20000);
  vMasterQuery  varchar2(2000);
  vTableColumns varchar2(200);
  vColumnType   varchar2(200);

  TYPE REFCURSOR IS REF CURSOR;
  crResult       refcursor;
  vTableColumns2 varchar2(200);
  vColumnType2   varchar2(200);
    vColumnTypeRows   varchar2(20000);
    vSuperMasterQuery varchar2(20000);
  vDateFormat     varchar2(200);
  
  vClob           clob;

  cursor getTables is
  
    SELECT T.object_name
      FROM all_objects T
     WHERE object_type IN ('TABLE')
       AND T.owner = 'DEV' and t.OBJECT_NAME<>'TABLERAWSTRUCTURE';

  cursor getTableColumns is
  
    SELECT column_name, data_type
      FROM USER_TAB_COLUMNS
     WHERE table_name = vTableName;

BEGIN
  vDateFormat:='to_date(';
  execute immediate 'truncate table TABLERAWSTRUCTURE';
  open getTables;
  loop
    fetch getTables
      into vTableName;
  
    vQuery1 := '' || vTableName || '####';
  
    open getTableColumns;
    loop
      fetch getTableColumns
        into vTableColumns, vColumnType;
      exit when(getTableColumns%notfound);
      vQuery1 := vQuery1 || vTableColumns || ',';
    
    end loop;
    close getTableColumns;
    vQuery1 := SUBSTR(vQuery1, 1, LENGTH(vQuery1) - 1);
  
    vQuery1 := vQuery1 || ' ####  ';
  
    VQUERY2 := 'SELECT ';
   vColumnTypeRows:='';
    open getTableColumns;
    loop
      fetch getTableColumns
        into vTableColumns2, vColumnType2;
    
 --    IF vColumnType2 <> 'DATE' THEN
    
      vTableColumns2 := 'E.' || vTableColumns2;
      exit when(getTableColumns%notfound);
     
     vColumnTypeRows:=vColumnTypeRows||vColumnType2||',';
     
     -- VQUERY2 := VQUERY2 ||   vTableColumns2 || '||'','' ||';
     
     VQUERY2 := VQUERY2 ||   vTableColumns2 || '||'','' ||';
      
      
      
      
      
     --   END IF;
    
    /*  IF vColumnType2 = 'DATE' THEN
      vTableColumns2:='E.'||vTableColumns2;
        VQUERY2 := VQUERY2 ||   vTableColumns2 || '||'' ,   '' ||';
        
      
      END IF;
    */
    end loop;
    close getTableColumns;
   vColumnTypeRows := SUBSTR(vColumnTypeRows, 1, LENGTH(vColumnTypeRows) - 1);
    vQuery2 := SUBSTR(vQuery2, 1, LENGTH(vQuery2) - 8);
    vQuery2 := vQuery2 || ' FROM ' || vTableName || ' E ';
    
    OPEN crResult FOR vQuery2;
     LOOP 
       FETCH CrResult into  vQuery3;
       
  --     vQuery3:=replace(vQuery3, ',','`');
   -- vQuery3:=''''||   vQuery3;
     --  vQuery3 := SUBSTR(vQuery3, 1, LENGTH(vQuery3) - 1);
      -- EXECUTE IMmediate vQuery3;
       
       
       
       
       
    vMasterQuery:= vQuery1||  vQuery3||'';
    
    vMasterQuery:=vMasterQuery||'####'||vColumnTypeRows;
    
    vClob:=vClob||vMasterQuery||'~~~';
       
       exit when (crREsult%notfound);
       end loop;
       close crResult;
        
     --vClob := SUBSTR(vQuery3, 1, LENGTH(vClob) - 3);

       INSERT INTO TABLERAWSTRUCTURE VALUEs(TABLERAWSTRUCTURE_SEQ.Nextval  ,vTableName,vClob);
       vClob:='';
  
    --vMasterQuery := 'SELECT ''' || vQuery1 || vQuery2 || ' FROM DUAL';
  
    exit when(getTables%notfound);
  end loop;
  close getTables;
commit;
EXCEPTION
  WHEN OTHERS THEN
   RETCODE:=SQLCODE;
   RETERROR:=SQLERRM;
END;
