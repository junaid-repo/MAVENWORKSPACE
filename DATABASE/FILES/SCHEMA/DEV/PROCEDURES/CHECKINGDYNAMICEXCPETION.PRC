
  CREATE OR REPLACE PROCEDURE "DEV"."CHECKINGDYNAMICEXCPETION" as

  dyanmicException exception;

begin

  for i in 1 .. 20 loop
    begin
      if (mod(i, 3) = 0) then
        raise dyanmicException;
      
      end if;
      dbms_output.put_line(i);
    exception
      when dyanmicException then
        dbms_output.put_line(i || ' is divisible by 3');
        when others then
           dbms_output.put_line(sqlerrm);
    end;
  end loop;
end;
