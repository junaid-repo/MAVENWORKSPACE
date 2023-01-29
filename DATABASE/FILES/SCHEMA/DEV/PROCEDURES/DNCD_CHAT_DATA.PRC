
  CREATE OR REPLACE PROCEDURE "OT"."DNCD_CHAT_DATA" (uid      in varchar2, cid in varchar2,
                                 pd      out varchar2,
                                 retcode out number,
                                 reterr  out varchar2) as
  l_user_id  enc_data.user_id%TYPE := 'SCOTT';
  l_msg_chat RAW(2000);

  l_key VARCHAR2(2000) := '1234567890999999';
  l_mod NUMBER := DBMS_CRYPTO.ENCRYPT_AES128 + DBMS_CRYPTO.CHAIN_CBC +
                  DBMS_CRYPTO.PAD_PKCS5;
  l_dec RAW(2000);
BEGIN

  l_user_id := uid;
  begin
    SELECT ecd.chat_enc_text INTO l_msg_chat FROM enc_chat_data ecd WHERE ecd.userid = l_user_id and ecd.chatid = cid;
  exception
    when others then
      retCode := 300;
      retErr  := 'User is invalid';
  end;

  l_dec := DBMS_CRYPTO.decrypt(l_msg_chat,
                               l_mod,
                               UTL_I18N.STRING_TO_RAW(l_key, 'AL32UTF8'));
 -- DBMS_OUTPUT.put_line('Decrypted=' || UTL_I18N.raw_to_char(l_dec));
  pd := UTL_I18N.raw_to_char(l_dec);

END;
