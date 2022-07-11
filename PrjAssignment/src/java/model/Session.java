/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class Session {
     private String sessionID;
     private String sessionNumber;
     private Group groupID;
     private Room room;
     private TimeSlot timeslot;
     private Instructor instructor;
     private Date date;

     public Instructor getInstructor() {
          return instructor;
     }

     public void setInstructor(Instructor instructor) {
          this.instructor = instructor;
     }

     public String getSessionID() {
          return sessionID;
     }

     public void setSessionID(String sessionID) {
          this.sessionID = sessionID;
     }

     public String getSessionNumber() {
          return sessionNumber;
     }

     public void setSessionNumber(String sessionNumber) {
          this.sessionNumber = sessionNumber;
     }

     public Group getGroupID() {
          return groupID;
     }

     public void setGroupID(Group groupID) {
          this.groupID = groupID;
     }

     public Room getRoom() {
          return room;
     }

     public void setRoom(Room room) {
          this.room = room;
     }

     public TimeSlot getTimeslot() {
          return timeslot;
     }

     public void setTimeslot(TimeSlot timeslot) {
          this.timeslot = timeslot;
     }

     public Date getDate() {
          return date;
     }

     public void setDate(Date date) {
          this.date = date;
     }

 
}
