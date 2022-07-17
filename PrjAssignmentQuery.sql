--Xem danh sach hoc sinh của 1 lop--
Select s.[sid],s.MemberCode,s.FirstName,s.MiddleName,s.LastName,s.FullName,g.gid,g.GroupName,s.Email
from Student s INNER JOIN StGr sg ON s.sid= sg.sid INNER JOIN [Group] g ON g.gid=sg.gid
 WHERE g.gid= 1

--Timetable cho giao vien--
SELECT a.sessionID,a.gid,a.GroupName,a.sessionNumber,a.roomID,a.timeslot,a.Insid
 FROM 
(SELECT c.[Name],g.gid,g.Insid FROM [Group] g INNER JOIN Course c ON g.cid = c.id) c
INNER JOIN
(SELECT s.sessionID,g.gid,g.GroupName,s.sessionNumber,s.roomID,s.timeslot,g.Insid,s.[date]
FROM [Session] s INNER JOIN [Group] g ON s.groupID = g.gid 
				 INNER JOIN [Time] t ON s.timeslot = t.Slot
				 INNER JOIN [Room] r ON s.roomID = r.room) a 
				 ON c.gid = a.gid AND c.Insid = a.Insid
				 WHERE c.Insid = ? AND a.[date] BETWEEN ? AND ?
---------login---
Select username, [password], displayname,[isAdmin] From Account

---
Select [date] FROM [Date]

Select [date] FROM Calendar
 ORDER BY [date] ASC
OFFSET (4-1) *4  ROWS
FETCH NEXT 10 ROWS ONLY
					   SELECT COUNT(*) as total FROM Calendar

---get session by week---
Select ts.Slot,ts.[Time],se.SessionID,se.SessionNumber,se.[date],se.roomID,se.insID,g.gid,g.GroupName,g.Insid,c.id,c.[Name] from [Time] ts
join [Session] se On ts.Slot = se.timeslot 
join [Group] g On se.GroupID = g.gid
join Course c On g.cid = c.id
join Instructor i on se.insID = i.id
Where se.[date] Between '2022-06-01' And '2022-06-07' And se.insID = 'sonnt5'


---------get session---------
Select ts.Slot,ts.startTime,ts.endTime,se.SessionID,se.SessionNumber,se.[date],se.roomID,se.insID,g.gid,g.GroupName,g.Insid,c.id,c.[Name] 
from [Time] ts join [Session] se On ts.Slot = se.timeslot 
join [Group] g On se.GroupID = g.gid
join Course c On g.cid = c.id
join Instructor i on se.insID = i.id
Where se.[date] = '2022-06-01' And se.insID = 'sonnt5'

Select ts.Slot,ts.startTime,ts.endTime,se.sessionID,se.sessionNumber,se.[date],se.roomID,se.insID,g.gid,g.GroupName,g.Insid,c.id,c.[Name] 
                       from [Time] ts join [Session] se On ts.Slot = se.timeslot 
                       join [Group] g On se.GroupID = g.gid
                       join Course c On g.cid = c.id
                       join Instructor i on se.insID = i.id
                       Where se.insID = 'sonnt5'

---------view attendance-------
Select g.gid,g.GroupName,s.[sid],s.FullName,s.Email,a.[status]
,a.[description],se.[date],a.recordTime,se.insID as instructorForSession,g.gid as instructorForGroup,c.id, se.timeslot,se.roomID
From Attendance a 
                    join Student s on a.StudentID = s.sid
                    join [Session] se on a.SessionID = se.sessionID
                    join [Group] g on g.gid = se.groupID
                    join Course c on g.cid = c.id
                    where a.SessionID = 31
-------- Take Attendance------
Insert into Attendance (studentID,sessionID,[status],[description], recordTime)
VALUES (?,?,?,?,?)
Update Attendance SET [status] = ?, [description]= ?, recordTime = ? WHERE studentID = ? AND sessionID = ?
--------Test----------
Drop table [Time]
Select *From Attendance where sessionID =  31
Select * from Attendance where sessionID = 1
Delete from Attendance where sessionID = 1
