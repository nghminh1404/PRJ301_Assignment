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

/**
 *
 * @author PC
 */
public class GroupDBContext extends DBContext<Group> {

     @Override
     public ArrayList<Group> list() {
          ArrayList<Group> gr = new ArrayList<>();
          try {
               String sql = "SELECT gid,GroupName FROM [Group]";
               PreparedStatement stm = connection.prepareStatement(sql);
               ResultSet rs = stm.executeQuery();
               while (rs.next()) {
                    Group g = new Group();
                    g.setGid(rs.getInt("gid"));
                    g.setGroupname(rs.getString("GroupName"));
                    gr.add(g);
               }
          } catch (SQLException ex) {
               Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
          }
          return gr;
     }

     @Override
     public Group get(int id) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void insert(Group model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void update(Group model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void delete(Group model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

}
