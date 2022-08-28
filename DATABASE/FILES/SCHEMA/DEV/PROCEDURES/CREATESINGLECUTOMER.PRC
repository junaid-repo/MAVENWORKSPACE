
  CREATE OR REPLACE PROCEDURE "OT"."CREATESINGLECUTOMER" (vName        in varchar2,
                                                 vType       in varchar2,            
                                                vAddress     in varchar2,
                                                vWebSite     in varchar2,
                                                vCreditLimit in number,
                                                firstName    in varchar2,
                                                lastName     in varchar2,
                                                email        in varchar2,
                                                phoneNumber  in varchar2,
                                                vCustNumber out varchar2,
                                                retCode      out number,
                                                retError     out varchar2) as

  vCustId number;
 -- vCustNumber varchar2(40);

begin

  select ot.customer_id_seq.nextVal into vCustId from dual;
  
  select 'CR'||OT.CUSTOMER_ID_SEQ.NEXTVAL into vCustNumber from dual;

  insert into ot.customers
  values
    (vCustId,vCustNumber,vType, vName, vAddress, vWebsite, vCreditLimit);

  insert into ot.contacts
  values
    (ot.contact_id_seq.nextVal,
     firstName,
     lastName,
     email,
     phoneNumber,
     vCustId);

exception
  when others then
    retCode  := sqlcode;
    retError := sqlerrm;
end;
