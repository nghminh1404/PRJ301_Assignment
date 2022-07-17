/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Course;
import model.Group;
import model.Instructor;
import model.Room;
import model.Session;
import model.Student;
import model.TimeSlot;

/**
 *
 * @author PC
 */
public class AttendanceDBContext extends DBContext<Attendance> {

     public void insertAttendance(ArrayList<Attendance> lists) {
          try {
               connection.setAutoCommit(false);
               for (Attendance list : lists) {
                    try {
                         String sql = "INSERT INTO [Attendance]\n"
                                 + "           (studentID\n"
                                 + "           ,sessionID\n"
                                 + "           ,[status]\n"
                                 + "           ,[description]\n"
                                 + "           ,recordTime)\n"
                                 + "     VALUES\n"
                                 + "           (?\n"
                                 + "           ,?\n"
                                 + "           ,?\n"
                                 + "           ,?\n"
                                 + "           ,?)";
                         PreparedStatement stm = connection.prepareStatement(sql);
                         stm.setString(1, list.getStudentID().getSid());
                         stm.setInt(2, list.getSessionID().getSessionID());
                         stm.setBoolean(3, list.isStatus());
                         stm.setString(4, list.getDescription());
                         stm.setTime(5, list.getRecordTime());
                         stm.executeUpdate();
                    } catch (SQLException ex) {
                         Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
          } catch (SQLException ex) {
               Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
               try {
                    connection.rollback();
               } catch (SQLException ex1) {
                    Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex1);
               }
          } finally {
               try {
                    connection.setAutoCommit(true);
               } catch (SQLException ex) {
                    Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
               }
          }
     }

     public void updateAttendance(ArrayList<Attendance> lists) {
          try {
               connection.setAutoCommit(false);
               for (Attendance list : lists) {
                    try {
                         String sql = "Update Attendance SET [status] = ?, [description]= ?, recordTime = ?\n"
                                 + "WHERE studentID = ? AND sessionID = ?";
                         PreparedStatement stm = connection.prepareStatement(sql);
                         stm.setBoolean(1, list.isStatus());
                         stm.setString(2, list.getDescription());
                         stm.setTime(3, list.getRecordTime());
                         stm.setString(4, list.getStudentID().getSid());
                         stm.setInt(5, list.getSessionID().getSessionID());
                         stm.executeUpdate();
                    } catch (SQLException ex) {
                         Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
               connection.commit();

          } catch (SQLException ex) {
               Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
               try {
                    connection.rollback();
               } catch (SQLException ex1) {
                    Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex1);
               }
          } finally {
               try {
                    connection.setAutoCommit(true);
               } catch (SQLException ex) {
                    Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
               }
          }
     }

     public ArrayList<Attendance> viewSessionAttendance(int sessionID) {
          ArrayList<Attendance> attendances = new ArrayList<>();
          try {
               String sql = "Select g.gid,g.GroupName,s.[sid],s.FullName,s.Email,a.[status],a.[description],se.[date],"
                       + "a.recordTime,se.insID as instructorForSession,g.gid as instructorForGroup,c.id,se.timeslot,se.roomID "
                       + "From Attendance a \n"
                       + "                    join Student s on a.StudentID = s.sid\n"
                       + "                    join [Session] se on a.SessionID = se.sessionID\n"
                       + "                    join [Group] g on g.gid = se.groupID\n"
                       + "                    join Course c on g.cid = c.id\n"
                       + "                    where a.SessionID = ?";
               PreparedStatement stm = connection.prepareStatement(sql);
               stm.setInt(1, sessionID);
               ResultSet rs = stm.executeQuery();
               while (rs.next()) {
                    Attendance a = new Attendance();
                    a.setStatus(rs.getBoolean("status"));
                    a.setDescription(rs.getString("description"));
                    a.setRecordTime(rs.getTime("recordTime"));
                    Student s = new Student();
                    s.setSid(rs.getString("sid"));
                    s.setFullName(rs.getString("FullName"));
                    s.setEmail(rs.getString("email"));
                    a.setStudentID(s);
                    Course c = new Course();
                    c.setId(rs.getString("id"));
                    Instructor instructorForGroup = new Instructor();
                    instructorForGroup.setId(rs.getString("instructorForGroup"));
                    Group g = new Group();
                    g.setGid(rs.getInt("gid"));
                    g.setGroupname(rs.getString("GroupName"));
                    g.setCourse(c);
                    g.setIns(instructorForGroup);
                    Session se = new Session();
                    se.setDate(rs.getDate("date"));
                    se.setGroupID(g);
                    TimeSlot t = new TimeSlot();
                    t.setSlot(rs.getInt("timeslot"));
                    se.setTimeslot(t);
                    Room r = new Room();
                    r.setRoom(rs.getString("roomID"));
                    se.setRoom(r);
                    Instructor instructorForSession = new Instructor();
                    instructorForSession.setId(rs.getString("instructorForSession"));
                    se.setInstructor(instructorForSession);
                    a.setSessionID(se);
                    attendances.add(a);
               }
          } catch (SQLException ex) {
               Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
          }
          return attendances;
     }

     @Override
     public ArrayList<Attendance> list() {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public Attendance get(int id) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void insert(Attendance model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void update(Attendance model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void delete(Attendance model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     public boolean isAttendanceTaken(int sessionID) {
          try {
               String sql = "Select * from Attendance where SessionID = ?";
               PreparedStatement stm = connection.prepareStatement(sql);
               stm.setInt(1, sessionID);
               ResultSet rs = stm.executeQuery();
               if (rs.next()) {
                    return true;
               }
          } catch (SQLException ex) {
               Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
          }
          return false;
     }
}
