create or replace procedure exportDBOJECTS as

  CURSOR OBJECTNAME IS
    select T.OBJECT_NAME, t.object_type, t.object_id, t.owner
      from TEMPOBJECTS t, all_objects ATO
     WHERE T.OBJECT_NAME = ATO.object_name
       AND ATO.owner = T.OWNER
       AND ATO.last_ddl_time <> T.LAST_DDL_TIME;

  CURSOR OBJECTNAME2 IS
  
    select ato.object_name, ATO.object_type, ATO.object_id, ATO.owner
      from all_objects ATO
     where ato.object_name NOT IN (SELECT T.OBJECT_NAME FROM TEMPOBJECTS T)
       and ato.owner IN ('DEV', 'OT');

  PROCNAME  VARCHAR2(200);
  CLOBFILE  CLOB;
  vobjname  varchar2(200);
  vobjtype  varchar2(200);
  vobjectid number;
  vschema   varchar2(20);

  dropquery   varchar2(200);
  createquery varchar2(400);

begin

  --IF (OBJTYPE = 'PROCEDURE') THEN
  begin
    OPEN OBJECTNAME;
    LOOP
      FETCH OBJECTNAME
        INTO vobjname, vobjtype, vobjectid, vschema;
      begin
        select dbms_metadata.get_ddl(vobjtype, vobjname, vschema)
          INTO CLOBFILE
          from dual;
      
        IF (vobjtype = 'TABLE') THEN
        
          clob_to_file(CLOBFILE, 'TABLES_DIR', vobjname || '.SQL');
        
        ELSIF (vobjtypE = 'PACKAGE') THEN
          clob_to_file(CLOBFILE, 'PACKAGES_DIR', vobjname || '.PKG');
        ELSIF (vobjtype = 'PROCEDURE') THEN
          clob_to_file(CLOBFILE, 'PROCEDURE_DIR', vobjname || '.PRC');
        
        ELSIF (vobjtype = 'SEQUENCE') THEN
          clob_to_file(CLOBFILE, 'SCRIPT_DIR', vobjname || '.SQL');
        
        END IF;
      EXCEPTION
        WHEN OTHERS THEN
          dbms_output.put_line(SUBSTR(DBMS_UTILITY.format_error_stack ||
                                      DBMS_UTILITY.format_error_backtrace,
                                      1,
                                      4000));
      END;
    
      EXIT WHEN(OBJECTNAME%NOTFOUND);
    
    END LOOP;
    CLOSE OBJECTNAME;
  
    vobjname  := '';
    vobjtype  := '';
    vobjectid := '';
    vschema   := '';
  
  exception
    when others then
    
      dbms_output.put_line(SUBSTR(DBMS_UTILITY.format_error_stack ||
                                  DBMS_UTILITY.format_error_backtrace,
                                  1,
                                  4000));
    
  end;

  begin
    OPEN OBJECTNAME2;
    LOOP
      FETCH OBJECTNAME2
        INTO vobjname, vobjtype, vobjectid, vschema;
    
      BEGIN
        if (vobjname is not null) then
        
          select dbms_metadata.get_ddl(vobjtype, vobjname, vschema)
            INTO CLOBFILE
            from dual;
        
          IF (vobjtype = 'TABLE') THEN
          
            clob_to_file(CLOBFILE, 'TABLES_DIR', vobjname || '.SQL');
          
          ELSIF (vobjtypE = 'PACKAGE') THEN
            clob_to_file(CLOBFILE, 'PACKAGES_DIR', vobjname || '.PKG');
          ELSIF (vobjtype = 'PROCEDURE') THEN
            clob_to_file(CLOBFILE, 'PROCEDURE_DIR', vobjname || '.PRC');
          
          ELSIF (vobjtype = 'SEQUENCE') THEN
            clob_to_file(CLOBFILE, 'SCRIPT_DIR', vobjname || '.SQL');
          
          END IF;
        end if;
      
      EXCEPTION
        WHEN OTHERS THEN
          dbms_output.put_line(SUBSTR(DBMS_UTILITY.format_error_stack ||
                                      DBMS_UTILITY.format_error_backtrace,
                                      1,
                                      4000));
      END;
    
      EXIT WHEN(OBJECTNAME2%NOTFOUND);
    
    END LOOP;
    CLOSE OBJECTNAME2;
  
  exception
    when others then
    
      dbms_output.put_line(SUBSTR(DBMS_UTILITY.format_error_stack ||
                                  DBMS_UTILITY.format_error_backtrace,
                                  1,
                                  4000));
    
  end;
  if (vobjname is not null) then
    begin
      dropquery := 'drop table TEMPOBJECTS';
      execute immediate dropquery;
    
    exception
      when others then
      
        dbms_output.put_line(SUBSTR(DBMS_UTILITY.format_error_stack ||
                                    DBMS_UTILITY.format_error_backtrace,
                                    1,
                                    4000));
    end;
    begin
      createQuery := 'CREATE TABLE TEMPOBJECTS AS(
      SELECT T.object_name,
             T.owner,
             T.object_id,
             T.object_type,
             T.last_ddl_time
        FROM all_objects T
       WHERE T.owner in (''DEV'',''OT''))';
    
      execute immediate createQuery;
    
    exception
      when others then
      
        dbms_output.put_line(SUBSTR(DBMS_UTILITY.format_error_stack ||
                                    DBMS_UTILITY.format_error_backtrace,
                                    1,
                                    4000));
    end;
  end if;
exception
  when others then
  
    dbms_output.put_line(SUBSTR(DBMS_UTILITY.format_error_stack ||
                                DBMS_UTILITY.format_error_backtrace,
                                1,
                                4000));
end;
/
