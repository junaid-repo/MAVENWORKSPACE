
  CREATE OR REPLACE PROCEDURE "OT"."DOCOLLECTION" (pOrderCode       in varchar2,
                                         pCustomerCode    in varchar2,
                                         orderAmount      in number,
                                         paymentAmount    in number,
                                         paymentType      in varchar2,
                                         collectionNumber out varchar2,
                                         retCode          out number,
                                         retError         out varchar2) as
  orderId           number;
  customerId        number;
  OUTSTANDINGAMOUNT NUMBER;

begin

  begin
    select o.order_id
      into orderId
      from ot.orders o
     where o.ordercode = pOrderCode;
  
  exception
    when others then
      retCode  := 100;
      retError := pOrderCode || ' is invalid';
  end;

  begin
    select c.customer_id
      into customerId
      from ot.customers c
     where c.cutomer_code = pCustomerCode;
  
  exception
    when others then
      retCode  := 101;
      retError := pCustomerCode || ' is invalid';
  end;

  IF (paymentType = 'ONLINE') THEN
    OUTSTANDINGAMOUNT := OT.ONLINEPAYMENTOUTSTANDINGAMOUNT(orderId);
  END IF;

  IF OUTSTANDINGAMOUNT > 0 THEN
    retCode  := 102;
    retError := OUTSTANDINGAMOUNT ||
                ' amount is still pending  from Online';
    return;
  END IF;

  select ('22-' || LPAD(OT.CODE_SEQ.NEXTVAL, 10, '0') || '-00')
    into collectionNumber
    from dual;

  insert into ot.collection
  values
    (ot.customer_id_seq.nextval,
     orderId,
     sysdate,
     orderAmount,
     paymentAmount,
     paymentType,
     collectionNumber);

exception
  when others then
    null;
end;
