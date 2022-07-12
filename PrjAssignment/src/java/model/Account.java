/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ngo Tung Son
 */
public class Account {
    private String username;
    private String password;
    private String displayname;
    private Boolean isAdmin;
    private Student sid;
    private Instructor insid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

     public Boolean getIsAdmin() {
          return isAdmin;
     }

     public void setIsAdmin(Boolean isAdmin) {
          this.isAdmin = isAdmin;
     }

     public Student getSid() {
          return sid;
     }

     public void setSid(Student sid) {
          this.sid = sid;
     }

     public Instructor getInsid() {
          return insid;
     }

     public void setInsid(Instructor insid) {
          this.insid = insid;
     }
    
}
