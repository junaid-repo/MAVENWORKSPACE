
  CREATE OR REPLACE PROCEDURE "DEV"."INSERT_INTERAL_API_DATA" (serviceName  in varchar2,
                                            requestJson  in CLOB,
                                            responseJson in CLOB,
                                            retCode      out number,
                                            retError     out varchar2) as

begin
  retCode  := 0;
  retError := 'Success';

  begin
    insert into dev.WebService_logs
    values
      (apilogseq.nextval, sysdate, serviceName, requestJson, responseJson);
  
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
