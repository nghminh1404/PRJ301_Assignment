/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Instructor {

     private String id;
     private String LastName;
     private String FirstName;
     private String Email;
     private String Password;
     private Course cid;
     private Instructor Insid;

     public Course getCid() {
          return cid;
     }

     public void setCid(Course cid) {
          this.cid = cid;
     }

     public Instructor getInsid() {
          return Insid;
     }

     public void setInsid(Instructor Insid) {
          this.Insid = Insid;
     }
     

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getLastName() {
          return LastName;
     }

     public void setLastName(String LastName) {
          this.LastName = LastName;
     }

     public String getFirstName() {
          return FirstName;
     }

     public void setFirstName(String FirstName) {
          this.FirstName = FirstName;
     }

     public String getEmail() {
          return Email;
     }

     public void setEmail(String Email) {
          this.Email = Email;
     }

     public String getPassword() {
          return Password;
     }

     public void setPassword(String Password) {
          this.Password = Password;
     }
     
}

