
  CREATE OR REPLACE PROCEDURE "DEV"."CLOB_TO_FILE" (/*p_clob      in  clob,*/
                                          p_dir       in  varchar2,
                                          p_filename  in  varchar2)
as
  l_file    SYS.utl_file.file_type;
  l_buffer  varchar2(32767);
  l_amount  binary_integer := 32767;
  l_pos     integer := 1;
begin
  l_file := utl_file.fopen(p_dir, p_filename, 'w', 32767);

  loop
    dbms_lob.read (p_clob, l_amount, l_pos, l_buffer);
    utl_file.put(l_file, l_buffer);
    utl_file.fflush(l_file);
    l_pos := l_pos + l_amount;
  end loop;
exception
  when no_data_found then
    -- expected end.
    if utl_file.is_open(l_file) then
      utl_file.fclose(l_file);
    end if;
  when others then
    if utl_file.is_open(l_file) then
      utl_file.fclose(l_file);
    end if;
    raise;
end clob_to_file;
