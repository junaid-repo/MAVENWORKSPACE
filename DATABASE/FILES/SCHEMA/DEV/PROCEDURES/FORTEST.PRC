
  CREATE OR REPLACE PROCEDURE "DEV"."FORTEST" as

begin
  for J in (select e.first_name, e.last_name, e.salary
                from dev.employees e
               where e.employee_id > 100) loop
      dbms_output.put_line(j.first_name || '   ' || j.last_name || '--->' ||
                           j.salary);
    end loop;
exception
  when others then
  
   null;
  
end;
