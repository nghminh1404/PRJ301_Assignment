/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Group {
     private int gid;
     private String groupname;
     private Course course;
     private Instructor ins;

     public int getGid() {
          return gid;
     }

     public void setGid(int gid) {
          this.gid = gid;
     }

     public String getGroupname() {
          return groupname;
     }

     public void setGroupname(String groupname) {
          this.groupname = groupname;
     }

     public Course getCourse() {
          return course;
     }

     public void setCourse(Course course) {
          this.course = course;
     }

     public Instructor getIns() {
          return ins;
     }

     public void setIns(Instructor ins) {
          this.ins = ins;
     }
     
}
