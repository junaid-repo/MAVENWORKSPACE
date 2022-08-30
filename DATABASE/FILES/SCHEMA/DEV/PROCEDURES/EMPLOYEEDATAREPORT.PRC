
  CREATE OR REPLACE PROCEDURE "OT"."EMPLOYEEDATAREPORT" (EMPLOYEECODE  in varchar2,
                                               vOrderDetails out CLOB,
                                               vGrossAmount  out number,
                                               vNetAmount    out number,
                                               vGST          out number,
                                               vRetcode      out number,
                                               vRetErr       out varchar2) as

  pItemPrice   number;
  pItemGst     number;
  pProductName varchar2(1000);
  pQuantity    varchar2(20);

  ordercode    varchar2(20);
  cutomer_code varchar2(20);
  order_date   varchar2(20);
  status       varchar2(20);
  gross_amount number;
  gst          number;
  net_amount   number;

  pGrossAmount number;

  pGST       number;
  pNetAmount number;

  vData clob;

  cursor getOrderItemDetails is
  
    select o.ordercode,
           c.cutomer_code,
           o.order_date,
           o.status,
           oa.gross_amount,
           oa.gst,
           oa.net_amount
      from ot.order_amount oa, ot.orders o, ot.customers c, OT.EMPLOYEES e
     where oa.order_id = o.order_id
       and c.customer_id = o.customer_id
       AND e.employee_id = o.salesman_id
       and e.employee_code = EMPLOYEECODE;

begin
  

  pGrossAmount := 0;
  pGST         := 0;
  pNetAmount   := 0;

  OPEN getOrderItemDetails;
  LOOP
    FETCH getOrderItemDetails
      INTO ordercode,
           cutomer_code,
           order_date,
           status,
           gross_amount,
           gst,
           net_amount;
    exit when(getOrderItemDetails%notfound);
  
    vData := trim(ordercode) || '@@Order Number~~' ||
             trim(cutomer_code) || '@@Customer Code~~' ||
             order_date || '@@Order Date~~' ||
             status || '@@Status~~' ||
             gross_amount || '@@Gross Amount~~' || 
             gst || '@@gst~~' || 
             net_amount || '@@Net Amount';
  
    vOrderDetails := vOrderDetails || vData || '##';
  
    pGrossAmount := pGrossAmount + gross_amount;
    pGST         := pGST + gst;
    pNetAmount   := pNetAmount + net_amount;
  
  end loop;
  close getOrderItemDetails;

  vGrossAmount := pGrossAmount;
  vGST         := pGST;
  vNetAmount   := pNetAmount;

exception
  when others then
    vRetcode := sqlcode;
    vRetErr  := sqlerrm;
  
end;
