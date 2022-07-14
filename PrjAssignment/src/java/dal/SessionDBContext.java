/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Group;
import model.Instructor;
import model.Room;
import model.Session;
import model.TimeSlot;

/**
 *
 * @author PC
 */
public class SessionDBContext extends DBContext<Session> {

     public ArrayList<Session> getSessionByWeek(Date startWeek, Date endWeek) {
          ArrayList<Session> sessions = new ArrayList<>();
          try {
               String sql = "Select ts.Slot,ts.startTime,ts.endTime,se.SessionID,se.SessionNumber,se.[date],se.roomID,se.insID,g.gid,g.GroupName,g.Insid,c.id,c.[Name] \n"
                       + "from [Time] ts join [Session] se On ts.Slot = se.timeslot \n"
                       + "join [Group] g On se.GroupID = g.gid\n"
                       + "join Course c On g.cid = c.id\n"
                       + "join Instructor i on se.insID = i.id\n"
                       + "Where se.[date] = ? And se.insID = ? ";
               PreparedStatement stm = connection.prepareStatement(sql);
               stm.setDate(1, startWeek);
               stm.setDate(2, endWeek);
               ResultSet rs = stm.executeQuery();
               while (rs.next()) {
                    Session se = new Session();
                    se.setSessionID(rs.getInt("SessionID"));
                    se.setSessionNumber(rs.getInt("SessionNumber"));
                    se.setDate(rs.getDate("SessionDate"));
                    Room r = new Room();
                    r.setRoom(rs.getString("room"));
                    se.setRoom(r);
                    Group g = new Group();
                    g.setGid(rs.getInt("gid"));
                    g.setGroupname(rs.getString("GroupName"));
                    Instructor i = new Instructor();
                    i.setId(rs.getString("id"));
                    g.setIns(i);
                    Course c = new Course();
                    c.setId(rs.getString("id"));
                    c.setName(rs.getString("Name"));
                    g.setCourse(c);
                    se.setGroupID(g);
                    TimeSlot ts = new TimeSlot();
                    ts.setSlot(rs.getInt("Slot"));
                    ts.setStartTime(rs.getTime("startTime"));
                    ts.setEndTime(rs.getTime("endTime"));
                    se.setTimeslot(ts);
                    sessions.add(se);
               }
          } catch (SQLException ex) {
               Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
          }
          return sessions;
     }

     public ArrayList<Session> getDailySession(Date today, String instructorID) {
          ArrayList<Session> sessions = new ArrayList<>();
          try {
               String sql = "Select ts.Slot,ts.startTime,ts.endTime,se.SessionID,se.SessionNumber,se.[date],se.roomID,se.insID,g.gid,g.GroupName,g.Insid,c.id,c.[Name] \n"
                       + "from [Time] ts join [Session] se On ts.Slot = se.timeslot \n"
                       + "join [Group] g On se.GroupID = g.gid\n"
                       + "join Course c On g.cid = c.id\n"
                       + "join Instructor i on se.insID = i.id\n"
                       + "Where se.[date] = ? And se.insID = ? ";
               PreparedStatement stm = connection.prepareStatement(sql);
               stm.setDate(1, today);
               stm.setString(2, instructorID);
               ResultSet rs = stm.executeQuery();
               while (rs.next()) {
                    Session se = new Session();
                    se.setSessionID(rs.getInt("sessionID"));
                    se.setSessionNumber(rs.getInt("sessionNumber"));
                    se.setDate(rs.getDate("date"));
                    Room r = new Room();
                    r.setRoom(rs.getString("ROOMID"));
                    se.setRoom(r);
                    Group g = new Group();
                    g.setGid(rs.getInt("gid"));
                    g.setGroupname(rs.getString("GroupName"));
                    Instructor i = new Instructor();
                    i.setId(rs.getString("insid"));
                    g.setIns(i);
                    Course c = new Course();
                    c.setId(rs.getString("id"));
                    c.setName(rs.getString("Name"));
                    g.setCourse(c);
                    se.setGroupID(g);
                    TimeSlot ts = new TimeSlot();
                    ts.setSlot(rs.getInt("Slot"));
                    ts.setStartTime(rs.getTime("startTime"));
                    ts.setEndTime(rs.getTime("endTime"));
                    se.setTimeslot(ts);
                    sessions.add(se);
               }
          } catch (SQLException ex) {
               Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
          }
          return sessions;
     }

     @Override
     public ArrayList<Session> list() {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public Session get(int id
     ) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void insert(Session model
     ) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void update(Session model
     ) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void delete(Session model
     ) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

}
