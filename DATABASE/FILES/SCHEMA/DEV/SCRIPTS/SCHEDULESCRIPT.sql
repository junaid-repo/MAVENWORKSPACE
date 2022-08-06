BEGIN
DBMS_SCHEDULER.create_job (
job_name => 'DBOJECTS_BACKUP',
job_type => 'STORED_PROCEDURE',
job_action => 'SYS.EXPORTDBOJECTS',
start_date => SYSTIMESTAMP,
repeat_interval => 'freq=HOURLY',
end_date => NULL,
enabled => TRUE,
comments => 'Job created for backing up db objects.');
End;


Begin
  Dbms_Scheduler.Drop_Job (Job_Name => 'DBOJECTS_BACKUP');

END;


select owner as schema_name,
       job_name,
       job_style,
       case when job_type is null 
                 then 'PROGRAM'
            else job_type end as job_type,  
       case when job_type is null
                 then program_name
                 else job_action end as job_action,
       start_date,
       case when repeat_interval is null
            then schedule_name
            else repeat_interval end as schedule,
       last_start_date,
       next_run_date,
       state
from sys.all_scheduler_jobs
