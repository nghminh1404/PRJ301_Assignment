--Xem danh sach hoc sinh của 1 lop--
Select s.sid,s.MemberCode,s.FullName
from Student s INNER JOIN StGr sg ON s.sid= sg.sid INNER JOIN [Group] g ON g.gid=sg.gid
 WHERE g.gid= ?

--Timetable cho giao vien--
SELECT a.sessionID,a.gid,a.GroupName,a.sessionNumber,a.roomID,a.timeslot,a.Insid
 FROM 
(SELECT c.[Name],g.gid,g.Insid FROM [Group] g INNER JOIN Course c ON g.cid = c.id) c
INNER JOIN
(SELECT s.sessionID,g.gid,g.GroupName,s.sessionNumber,s.roomID,s.timeslot,g.Insid
FROM [Session] s INNER JOIN [Group] g ON s.groupID = g.gid 
				 INNER JOIN [Time] t ON s.timeslot = t.Slot
				 INNER JOIN [Room] r ON s.roomID = r.room) a 
				 ON c.gid = a.gid AND c.Insid = a.Insid
				 WHERE c.Insid = ?
-- Take Attendance--
Insert into Attendance (studentID,sessionID,[status],[description], recordTime)
VALUES (?,?,?,?, GETDATE())
Update Attendance SET [status] = ? WHERE studentID = ? AND sessionID = ?
