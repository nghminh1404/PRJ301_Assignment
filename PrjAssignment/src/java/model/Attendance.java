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
public class Attendance {
     private Student studentID;
     private Session sessionID;
     private boolean status;
     private String description;
     private Date recordTime;

     public Student getStudentID() {
          return studentID;
     }

     public void setStudentID(Student studentID) {
          this.studentID = studentID;
     }

     public Session getSessionID() {
          return sessionID;
     }

     public void setSessionID(Session sessionID) {
          this.sessionID = sessionID;
     }

     public boolean isStatus() {
          return status;
     }

     public void setStatus(boolean status) {
          this.status = status;
     }

     public Date getRecordTime() {
          return recordTime;
     }

     public void setRecordTime(Date recordTime) {
          this.recordTime = recordTime;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }
     
     
}
