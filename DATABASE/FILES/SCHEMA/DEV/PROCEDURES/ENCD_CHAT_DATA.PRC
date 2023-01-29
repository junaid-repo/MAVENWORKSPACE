
  CREATE OR REPLACE PROCEDURE "OT"."ENCD_CHAT_DATA" (uid     in varchar2,
                                      cid     in varchar2,
                                      text    in varchar2,
                                      retcode out number,
                                      reterr  out varchar2) as
  l_user_id ot.enc_data.USER_ID%TYPE := 'SCOTT';
  l_msg_txt VARCHAR2(4000) := 'sample msg';

  l_key VARCHAR2(2000) := '1234567890999999';
  l_mod NUMBER := DBMS_CRYPTO.ENCRYPT_AES128 + DBMS_CRYPTO.CHAIN_CBC +
                  DBMS_CRYPTO.PAD_PKCS5;
  l_enc RAW(2000);
BEGIN
  l_user_id := uid;
  l_msg_txt := text;
  l_msg_txt := DBMS_CRYPTO.encrypt(UTL_I18N.string_to_raw(l_msg_txt,
                                                          'AL32UTF8'),
                                   l_mod,
                                   UTL_I18N.string_to_raw(l_key, 'AL32UTF8'));

  DBMS_OUTPUT.put_line('Encrypted=' || l_msg_txt);

  INSERT INTO ot.enc_chat_data
    (userid, chatid, chat_enc_text)
  VALUES
    (l_user_id, cid, l_msg_txt);


  COMMIT;
END;
