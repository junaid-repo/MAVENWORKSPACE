
  CREATE OR REPLACE PROCEDURE "OT"."UPDATEORDERDETAILS" (orderNumber in varchar2,
                                               grossAmount in number,
                                               gstAmount   in number,
                                               netAmount   in number) as

  orderId number;
begin

  begin
    select o.order_id
      into orderId
      from ot.orders o
     where o.ordercode = orderNumber;
  exception
    when others then
      null;
    
  end;

  begin
  
    insert into ot.order_amount
    values
      (orderId, sysdate, round(grossAmount,2), round(gstAmount,2), round(netAmount,2));
  
  exception
    when others then
      null;
    
  end;

exception
  when others then
    null;
  
end;
