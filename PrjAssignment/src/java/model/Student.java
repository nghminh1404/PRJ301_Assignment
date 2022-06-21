/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Student {
     private String sid;
     private String MemberCode;
     private String LastName;
     private String MiddleName;
     private String FirstName;
     private String FullName;
     private String Email;
     private String Password;
     private Group group;

     public Group getGroup() {
          return group;
     }

     public void setGroup(Group group) {
          this.group = group;
     }

     public String getSid() {
          return sid;
     }

     public void setSid(String sid) {
          this.sid = sid;
     }

     public String getMemberCode() {
          return MemberCode;
     }

     public void setMemberCode(String MemberCode) {
          this.MemberCode = MemberCode;
     }

     public String getLastName() {
          return LastName;
     }

     public void setLastName(String LastName) {
          this.LastName = LastName;
     }

     public String getMiddleName() {
          return MiddleName;
     }

     public void setMiddleName(String MiddleName) {
          this.MiddleName = MiddleName;
     }

     public String getFirstName() {
          return FirstName;
     }

     public void setFirstName(String FirstName) {
          this.FirstName = FirstName;
     }

     public String getFullName() {
          return FullName;
     }

     public void setFullName(String FullName) {
          this.FullName = FullName;
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
