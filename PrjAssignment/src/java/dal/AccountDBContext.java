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
import model.Account;
import model.Instructor;
import model.Student;

/**
 *
 * @author PC
 */
public class AccountDBContext extends DBContext<Account> {

     public Account getAccount(String username, String password) {
          try {
               String sql = "SELECT username\n"
                       + "      ,[password]\n"
                       + "      ,[isAdmin]\n"
                       + "      ,displayname\n"
                       + "      ,sid\n"
                       + "      ,insid\n"
                       + "  FROM Account\n"
                       + "where username = ? and password = ?";
               PreparedStatement stm = connection.prepareStatement(sql);
               stm.setString(1, username);
               stm.setString(2, password);
               ResultSet rs = stm.executeQuery();
               if (rs.next()) {
                    Account account = new Account();
                    account.setUsername(rs.getString("username"));
                    account.setDisplayname(rs.getString("displayname"));
                    account.setIsAdmin(rs.getBoolean("isAdmin"));
                    Student s = new Student();
                    s.setSid(rs.getString("sid"));
                    account.setSid(s);
                    Instructor i = new Instructor();
                    i.setId(rs.getString("insid"));
                    account.setInsid(i);
                    return account;
               }
          } catch (SQLException ex) {
               Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
     }

     @Override
     public ArrayList<Account> list() {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public Account get(int id) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void insert(Account model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void update(Account model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void delete(Account model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

}
