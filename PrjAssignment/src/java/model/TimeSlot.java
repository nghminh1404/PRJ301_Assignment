/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author PC
 */
public class TimeSlot {

     private int slot;
     private Time startTime;
     private Time endTime;

     public int getSlot() {
          return slot;
     }

     public void setSlot(int slot) {
          this.slot = slot;
     }

     public Time getStartTime() {
          return startTime;
     }

     public void setStartTime(Time startTime) {
          this.startTime = startTime;
     }

     public Time getEndTime() {
          return endTime;
     }

     public void setEndTime(Time endTime) {
          this.endTime = endTime;
     }

}
