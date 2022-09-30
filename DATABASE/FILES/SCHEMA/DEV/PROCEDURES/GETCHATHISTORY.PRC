
  CREATE OR REPLACE PROCEDURE "OT"."GETCHATHISTORY" (vsender     in varchar2,
                                           vreceiver   in varchar2,
                                           tillDate    in varchar2,
                                           chatHistory out varchar2,
                                           retcode     out number,
                                           reterr      out varchar2) as

  cursor getChatHis is
    select th.send, th.rec, th.text
      from (select t.sender      send,
                   t.receiver    rec,
                   t.chattext    text,
                   t.createddate cd
              from CHATTEXTS t
             where t.sender = vsender
               and t.receiver = vreceiver
            union
            select t.sender      send,
                   t.receiver    rec,
                   t.chattext    text,
                   t.createddate cd
              from CHATTEXTS t
             where t.sender = vreceiver
               and t.receiver = vsender) th
     order by th.cd;

  pSender  varchar2(20);
  pReciver varchar2(20);
  vText    varchar2(3000);

  vtextHistory varchar2(3000);

begin
  vtextHistory := '';
  open getChatHis;
  loop
    fetch getChatHis
      into pSender, pReciver, vText;
  
    exit when getChatHis%notfound;
   
  if(pSender=vsender) then 
    pSender  := 'me';
    pReciver:='her';
  else
    pSender  := 'her';
     pReciver:='me';
  end if;  
    
  
    vtextHistory :=vtextHistory||pSender||'##'||vText||'&&';
    
  
  end loop;
vtextHistory:= SUBSTR(vtextHistory, 0, LENGTH(vtextHistory) - 2);
  close getChatHis;

chatHistory:=vtextHistory;
end;
