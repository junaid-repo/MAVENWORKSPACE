
  CREATE OR REPLACE PROCEDURE "OT"."CALCULATEBILLAMOUNT" (vOrderCode    in varchar2,
                                                vOrderDetails out CLOB,
                                                vGrossAmount  out number,
                                                vNetAmount    out number,
                                                vGST          out number,
                                                vRetcode      out number,
                                                vRetErr       out varchar2) as

  pItemPrice   number;
  pItemGst     number;
  pProductName varchar2(1000);
  pQuantity varchar2(20);

  pGrossAmount number := 0;
  pNetAmount   number := 0;
  pGst         number := 0;
  vNetItemPrice number := 0;
  vData        clob;

  cursor getOrderItemDetails is
  
    select oi.total_prize, (oi.total_prize * 0.18), p.product_name, (oi.total_prize*1.18), oi.quantity
      from ot.order_items oi, ot.orders o, ot.products p
     where oi.order_id = o.order_id
       and o.ordercode = vOrderCode
       and p.product_id = oi.product_id;

begin

  OPEN getOrderItemDetails;
  LOOP
    FETCH getOrderItemDetails
      INTO pItemPrice, pItemGst, pProductName, vNetItemPrice, pQuantity;
    exit when(getOrderItemDetails%notfound);
  
    vData := trim(pProductName) || '@@Product Name~~' || trim(pItemPrice) ||
             '@@Gross Price~~' ||pQuantity||'@@Quantity~~'|| pItemGst || '@@GST~~' || vNetItemPrice || '@@Net Price';
  
    vOrderDetails := vOrderDetails || vData || '##';
  
    pGrossAmount := pGrossAmount + pItemPrice;
    pGST         := pGST + pItemGst;
    pNetAmount   := pNetAmount + vNetItemPrice;
  
  end loop;
  close getOrderItemDetails;

  vGrossAmount := pGrossAmount;
  vGST         := pGST;
  vNetAmount   := pNetAmount;
  
  

exception
  when others then
    vRetcode := sqlcode;
    vRetErr :=sqlerrm;
  
end;
