
  CREATE OR REPLACE PROCEDURE "DEV"."CREATENEWEMPLOYEE" (firstName   in varchar2,
                                              lastName    in varchar2,
                                              email       in varchar2,
                                              phoneNumber in varchar2,
                                              hireDate    in varchar2,
                                              jobId       in varchar2,
                                              salary      in varchar2,
                                              
                                              managerId in varchar2,
                                              deptId    in varchar2,
                                              empdId    out varchar2,
                                              retCode   out number,
                                              retError  out varchar2) as

  empId number;

begin
  retCode  := 0;
  retError := 'Success';

  select employeeIdSeq.Nextval into empId from dual;

  begin
  
    insert into dev.employees
    values
      (empId,
       firstName,
       lastName,
       email,
       phoneNumber,
       hireDate,
       jobid,
       salary,
       '',
       managerId,
       deptId);
  
  exception
    when others then
    
      retCode  := sqlcode;
      retError := sqlerrm;
    
  end;
  
  empdId:=empId;

exception
  when others then
  
    retCode  := sqlcode;
    retError := sqlerrm;
  
end;
