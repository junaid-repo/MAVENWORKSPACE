
  CREATE OR REPLACE PROCEDURE "DEV"."INSERT_API_DATA" (serviceName  in varchar2,
                                            requestJson  in varchar2,
                                            responseJson in varchar2,
                                            retCode      out number,
                                            retError     out varchar2) as

begin
  retCode  := 0;
  retError := 'Success';

  begin
    insert into dev.external_api_logs
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
