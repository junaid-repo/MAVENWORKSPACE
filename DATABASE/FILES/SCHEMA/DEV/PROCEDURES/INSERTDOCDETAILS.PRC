
  CREATE OR REPLACE PROCEDURE "DEV"."INSERTDOCDETAILS" (fileName     in varchar2,
                                             fileLocation in varchar2,
                                             docId        out varchar2,
                                             retCode      out number,
                                             retErr       out varchar2) is

begin
  retCode := 0;
  retErr  := 'Success';

  select DOC_SQUENCE.Nextval into docId from dual;

  begin
    insert into dev.document_details
    values
      (docId, sysdate, fileName, fileLocation, null);
  
  Exception
    when others then
      retCode := sqlcode;
      retErr  := sqlerrm;
    
  end;
Exception
  when others then
    retCode := sqlcode;
    retErr  := sqlerrm;
end;
