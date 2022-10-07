
  CREATE OR REPLACE PROCEDURE "OT"."UPDATECHAT" (vsender     in varchar2,
                                       vreceiver   in varchar2,
                                       vchattext   in varchar2,
                                       chatHistory out clob,
                                       retcode     out number,
                                       reterr      out varchar2) as

  vChatHistory varchar2(3000);

begin
  retcode := 0;
  reterr  := 'success';
  insert into ot.chattexts
  values
    (vsender, vreceiver, vchattext, sysdate, '',ot.order_id_seq.nextval);
  commit;

  ot.getChatHistory(vsender,
                    vreceiver,
                    null,
                    vChatHistory,
                    retcode,
                    reterr);

  chatHistory := vChatHistory;

end;
