
  CREATE OR REPLACE PROCEDURE "OT"."ENCD" (un      in varchar2,
                               pd       in varchar2,
                               retcode out number,
                               reterr  out varchar2) as
  l_user_id  ot.enc_data.USER_ID%TYPE := 'SCOTT';
  l_user_psw VARCHAR2(2000) := 'mypassword123';

  l_key VARCHAR2(2000) := '1234567890999999';
  l_mod NUMBER := DBMS_CRYPTO.ENCRYPT_AES128 + DBMS_CRYPTO.CHAIN_CBC +
                  DBMS_CRYPTO.PAD_PKCS5;
  l_enc RAW(2000);
BEGIN
  l_user_id:=un;
  l_user_psw:=pd;
  l_user_psw := DBMS_CRYPTO.encrypt(UTL_I18N.string_to_raw(l_user_psw,
                                                           'AL32UTF8'),
                                    l_mod,
                                    UTL_I18N.string_to_raw(l_key, 'AL32UTF8'));

  DBMS_OUTPUT.put_line('Encrypted=' || l_user_psw);

  INSERT INTO ot.enc_data
    (user_id, enc_psw)
  VALUES
    (l_user_id, l_user_psw);

  COMMIT;
  COMMIT;
END;
