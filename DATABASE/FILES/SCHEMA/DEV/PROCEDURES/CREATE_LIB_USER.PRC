
  CREATE OR REPLACE PROCEDURE "OT"."CREATE_LIB_USER" (userName       in varchar2,
                                               gender         in varchar2,
                                               membershipType in varchar2,
                                               validity       in number,
                                               userCode       out varchar2,
                                               retCode        OUT varchar2,
                                               retError       OUT varchar2) as

begin
  USERCODE := NULL;
  retCode:=0;
  retError:='Success';
  begin
    select 'LIBUSR' || OT.CODE_SEQ.NEXTVAL INTO USERCODE FROM DUAL;
  
  exception
    when others then
      retCode  := sqlcode;
      retError := sqlerrm;
  end;

  IF (USERCODE IS NOT NULL) THEN
  
    BEGIN
      INSERT INTO OT.LIB_USERS
      VALUES
        (OT.CONTACT_ID_SEQ.NEXTVAL,
         USERCODE,
         SYSDATE,
         userName,
         gender,
         membershipType,
         sysdate + validity);
    exception
      when others then
        retCode  := sqlcode;
        retError := sqlerrm;
    end;
  END IF;
exception
  when others then
  
    retcode  := sqlcode;
    reterror := sqlerrm;
end;
