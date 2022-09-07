
  CREATE OR REPLACE PROCEDURE "DEV"."TESTPREPARE" is

  var1  varchar2(20);
  var2  varchar2(20);
  fName varchar2(200);
  lName varchar2(200);
  pct varchar2(22);

  cursor cur1 is
  
    select e.first_name, e.last_name, e.salary, e.phone_number, e.commission_pct
      from dev.employees e
     where e.employee_id < 200;
begin

  var1 := null;

  var2 := nvl(var1, 'test');

  open cur1;
  loop
    fetch cur1
      into fName, lName, var1, var2, pct;
    --dbms_output.put_line(nvl(pct, 'the data was null'));
    dbms_output.put_line(nullif(length(fName), length(lName)));

    --dbms_output.put_line(concat(fName||'  ', lName));
  
    exit when cur1%notfound;
  end loop;
  close cur1;

exception
  when others then
    null;
  
end;
