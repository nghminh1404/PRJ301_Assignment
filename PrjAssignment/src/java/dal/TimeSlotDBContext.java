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
import model.TimeSlot;

/**
 *
 * @author PC
 */
public class TimeSlotDBContext extends DBContext<TimeSlot> {

     @Override
     public ArrayList<TimeSlot> list() {
        ArrayList<TimeSlot> timeslot = new ArrayList<>();
        try {            
            String sql = "SELECT Slot\n"
                    + "      ,startTime\n"
                    + "      ,endTime\n"
                    + "  FROM [Time]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                TimeSlot t = new TimeSlot();
                t.setSlot(rs.getInt("Slot"));
                t.setStartTime(rs.getTime("startTime"));
                t.setEndTime(rs.getTime("endTime"));
                timeslot.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timeslot;     }

     @Override
     public TimeSlot get(int id) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void insert(TimeSlot model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void update(TimeSlot model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

     @Override
     public void delete(TimeSlot model) {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }
     
}
