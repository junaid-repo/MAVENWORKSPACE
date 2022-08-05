
  CREATE OR REPLACE PROCEDURE "DEV"."COPYUSERDATA" (fromUser in varchar2,
                                         toUser   in varchar2,
                                         retCode out number,
                                         retError out varchar2) as

  query     varchar2(100);
  tableName varchar2(100);

  CURSOR allTables is
  
    select t.TABLE_NAME
      from all_tables t
     where t.OWNER = fromUser
    MINUS
    select t.TABLE_NAME
      from all_tables t
     where t.OWNER = touser;
begin
retCode:=0;
retError:='Success';

begin
  open allTables;

  loop
    fetch allTables
      into tableName;
    exit when allTables%notfound;
  
    begin
      query := 'create table ' || toUser || '.' || tableName ||
               ' as (select * from ' || fromUser || '.' || tableName || ')';
    
      execute immediate query;
    
    exception
      when others then
        retCode:=sqlcode;
  retError:=sqlerrm;
   
      
    end;
  
  end loop;
  
  exception when others then
    
  retCode:=sqlcode;
  retError:=sqlerrm;
    
  end;

exception
  when others then
   retCode:=sqlcode;
  retError:=sqlerrm;
   
  
end;
