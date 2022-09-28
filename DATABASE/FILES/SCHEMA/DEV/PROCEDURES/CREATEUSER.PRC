
  CREATE OR REPLACE PROCEDURE "OT"."CREATEUSER" (firstName in varchar2,
                                          lastName  in varchar2,
                                          gender    in varchar2,
                                          dob       in varchar2,
                                          roleCode  in varchar2,
                                          PSD       IN VARCHAR2,
                                          userCode  out varchar2,
                                          retCode   out number,
                                          retError  out varchar2) as

  pusercode varchar2(20);

begin
  retCode  := 0;
  retError := 'Success';

  pusercode := 'ME00' || ot.code_seq.nextval;

  BEGIN
    insert into ot.users
    values
      (ot.order_id_seq.nextval,
       sysdate,
       Firstname,
       lastname,
       gender,
       dob,
       pusercode,
       ROLECODE);
  EXCEPTION
    WHEN OTHERS THEN
      userCode := NULL;
      RETCODE  := SQLCODE;
      RETERROR := SQLERRM;
  END;
  userCode := pusercode;

  if (userCode is not null and psd is not null) then
    ot.encd(userCode, psd, RETCODE, RETERROR);
  end if;

EXCEPTION
  WHEN OTHERS THEN
    userCode := NULL;
    RETCODE  := SQLCODE;
    RETERROR := SQLERRM;
  
end;
