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
import model.Group;
import model.Student;

/**
 *
 * @author PC
 */
public class StudentDBContext extends DBContext<Student> {

     public ArrayList<Student> listByGroup(int gid) {
          ArrayList<Student> stds = new ArrayList<>();
          try {
               String sql = "Select s.sid,s.MemberCode,s.FullName,g.GroupName\n"
                       + "from Student s INNER JOIN StGr sg ON s.sid= sg.sid INNER JOIN [Group] g ON g.gid=sg.gid\n"
                       + "WHERE g.gid= ?";
               PreparedStatement stm = connection.prepareStatement(sql);
               stm.setInt(1, gid);
               ResultSet rs = stm.executeQuery();
               while (rs.next()) {
                    Student s = new Student();
                    s.setSid(rs.getString("sid"));
                    s.setFullName(rs.getString("FullName"));
                    s.setMemberCode(rs.getString("MemberCode"));
                    Group g = new Group();
                    g.setGroupname(rs.getString("GroupName"));
                    s.setGroup(g);
                    stds.add(s);
               }
          } catch (SQLException ex) {
               Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
          }
          return stds;
     }

     @Override
     public ArrayList<Student> list() {
          ArrayList<Student> st = new ArrayList<>();
          try {
               String sql = "Select sid, MemberCode,FirstName,MiddleName,LastName from Student";
               PreparedStatement stm = connection.prepareStatement(sql);
               ResultSet rs = stm.executeQuery();
               while (rs.next()) {
                    Student s = new Student();
                    s.setSid(rs.getString("sid"));
                    s.setMemberCode(rs.getString("MemberCode"));
                    s.setFirstName(rs.getString("FirstName"));
                    s.setMiddleName(rs.getString("MiddleName"));
                    s.setLastName(rs.getString("LastName"));
                    st.add(s);
               }
          } catch (SQLException ex) {
               Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
          }
          return st;
     }

     @Override
     public Student get(int id) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void insert(Student model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void update(Student model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void delete(Student model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

}
