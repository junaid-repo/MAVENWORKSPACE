
  CREATE OR REPLACE PROCEDURE "OT"."CREATEORDER" (customerCode in varchar2,
                                        employeeCode in varchar2,
                                        orderCode    out varchar2,
                                        retCode      out number,
                                        retError     out varchar2) as

  customerId number;
  empId      number;

begin
  retCode:=0;
  retError:='Success';
  
  begin
    select 'ODR' || OT.CODE_SEQ.NEXTVAL into orderCode from dual;
  
    select e.employee_id
      into empId
      from ot.employees e
     where e.employee_code = employeeCode;
  
    select c.customer_id
      into customerId
      from ot.customers c
     where c.cutomer_code = customerCode;
  
  exception
    when others then
      retCode  := sqlcode;
      retError := sqlerrm;
  end;

  begin
  
    insert into ot.orders
    values
      (ot.order_id_seq.nextval,
       orderCode,
       customerId,
       'Pending',
       empId,
       sysdate);
  
  exception
    when others then
      retCode  := sqlcode;
      retError := sqlerrm;
  end;
exception
  when others then
    retCode  := sqlcode;
    retError := sqlerrm;
end;
