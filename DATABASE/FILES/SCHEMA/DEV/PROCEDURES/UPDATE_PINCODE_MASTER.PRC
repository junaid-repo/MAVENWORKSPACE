
  CREATE OR REPLACE PROCEDURE "DEV"."UPDATE_PINCODE_MASTER" (pinCode                in number,
                                                  voffice             in VARCHAR2,
                                                  office_type        in VARCHAR2,
                                                  delivery           in VARCHAR2,
                                                  division           in VARCHAR2,
                                                  region             in VARCHAR2,
                                                  circle             in VARCHAR2,
                                                  taluk              in VARCHAR2,
                                                  district           in VARCHAR2,
                                                  state_id           in NUMBER,
                                                  phoneNumber              in VARCHAR2,
                                                  related_suboffice  in VARCHAR2,
                                                  related_headoffice VARCHAR2,
                                                  longitude          in VARCHAR2,
                                                  latitude           VARCHAR2) as

  flag number:=0;

begin
begin
  select count(*) into flag from dev.pincode_master pm where pm.office = voffice;
exception when others then
  flag:=0;
end;
  if (flag = 0) then
   insert into dev.pincode_master
    values
      (pinCode,
       voffice,
       office_type,
       delivery,
       division,
       region,
       circle,
       taluk,
       district,
       state_id,
       phoneNumber,
       related_suboffice,
       related_headoffice,
       longitude,
       latitude);
   
  
  else
    
  delete dev.pincode_master pm   where pm.office = voffice;
   insert into dev.pincode_master
    values
      (pinCode,
       voffice,
       office_type,
       delivery,
       division,
       region,
       circle,
       taluk,
       district,
       state_id,
       phoneNumber,
       related_suboffice,
       related_headoffice,
       longitude,
       latitude);
  end if;

end;
