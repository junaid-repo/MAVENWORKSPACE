
  CREATE OR REPLACE PROCEDURE "OT"."SEARCHUSER" (firstName in varchar2,
                                       lastName  in varchar2,
                                       gender    in varchar2,
                                       dob       in varchar2,
                                       userList  out varchar2,
                                       retCode   out number,
                                       retError  out varchar2) as
  TYPE REFCURSOR IS REF CURSOR;

  vFirstName varchar2(200);
  vLastName  varchar2(200);
  sqlquery   varchar2(2000);

  pName     varchar2(200);
  pUserCode varchar2(200);

  CURSR REFCURSOR;

begin
  vFirstName := '%' || firstName || '%';
  vLastName  := '%' || lastName || '%';
  sqlQuery   := 'select uu.usercode , uu.firstname||'' ''||uu.lastname from ot.users uu where 1=1 ';

  if (firstName is not null) then
    sqlQuery := sqlQuery || 'and upper(uu.firstname) LIKE upper(''' ||
                vFirstName || ''')';
  end if;

  if (lastName is not null) then
    sqlQuery := sqlQuery || 'and upper(uu.lastName) LIKE upper(''' ||
                vLastName || ''')';
  end if;

  if (gender is not null) then
    sqlQuery := sqlQuery || 'and upper(uu.gender)=upper(''' || gender ||
                ''')';
  end if;

  OPEN CURSR FOR sqlQuery;
  loop
    fetch CURSR
      into pUserCode, pName;
      
      
  
    exit when CURSR%notfound;
    
    userList:=userList||'$$'||'userCode'||'##'||pUserCode||'@@'||'userName '||'##'||pName;
  
  end loop;
  close CURSR;

end;
