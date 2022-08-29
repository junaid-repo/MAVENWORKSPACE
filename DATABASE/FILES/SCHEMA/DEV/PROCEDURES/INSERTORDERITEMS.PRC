
  CREATE OR REPLACE PROCEDURE "OT"."INSERTORDERITEMS" (orderNumber in varchar2,
                                             productId   in number,
                                             quantity    in number,
                                             itemId      in number,
                                             retcode     out number,
                                             reterr      out varchar2) as

  vOrderId      number;
  vUnitPrize    number;
  vProductPrize number;

begin
  begin
    select o.order_id
      into vOrderId
      from ot.orders o
     where o.ordercode = orderNumber;
  
    select p.list_price
      into vUnitPrize
      from ot.products p
     where p.product_id = productId;
  
    vProductPrize := quantity * vUnitPrize;
  
  exception
    when others then
    
      retcode := sqlcode;
      retErr  := sqlerrm;
  end;
  begin
  
    update ot.products p
       set p.product_count = p.product_count - quantity
     where p.product_id = productId;
  exception
    when others then
    
      retcode := sqlcode;
      retErr  := sqlerrm;
  end;
  begin
    insert into ot.order_items
    values
      (vOrderId, itemId, productId, quantity, vUnitPrize, vProductPrize);
  
  exception
    when others then
    
      retcode := sqlcode;
      retErr  := sqlerrm;
  end;

exception
  when others then
    retcode := sqlcode;
    retErr  := sqlerrm;
  
end;
