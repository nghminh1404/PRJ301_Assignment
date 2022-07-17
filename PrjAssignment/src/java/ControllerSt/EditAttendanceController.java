/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerSt;

import dal.AttendanceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.ArrayList;
import model.Attendance;
import model.Session;
import model.Student;

/**
 *
 * @author PC
 */
public class EditAttendanceController extends HttpServlet {

     /**
      * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
      * methods.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          try ( PrintWriter out = response.getWriter()) {
               /* TODO output your page here. You may use following sample code. */
               out.println("<!DOCTYPE html>");
               out.println("<html>");
               out.println("<head>");
               out.println("<title>Servlet EditAttendanceController</title>");
               out.println("</head>");
               out.println("<body>");
               out.println("<h1>Servlet EditAttendanceController at " + request.getContextPath() + "</h1>");
               out.println("</body>");
               out.println("</html>");
          }
     }

     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     /**
      * Handles the HTTP <code>GET</code> method.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     int sessionID;
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          sessionID = Integer.parseInt(request.getParameter("session"));
          AttendanceDBContext adb = new AttendanceDBContext();
          ArrayList<Attendance> attendances = adb.viewSessionAttendance(sessionID);
          request.setAttribute("attendances", attendances);
          request.getRequestDispatcher("view/teacher/EditAttendance.jsp").forward(request, response);
     }

     /**
      * Handles the HTTP <code>POST</code> method.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          Session se = new Session();
          se.setSessionID(sessionID);
          String[] indexes = request.getParameterValues("index");
          AttendanceDBContext adb = new AttendanceDBContext();
          ArrayList<Attendance> attendances = new ArrayList<>();
          for (String index : indexes) {
               Attendance a = new Attendance();
               Student s = new Student();
               s.setSid(request.getParameter("sid" + index));
               a.setStudentID(s);
               a.setSessionID(se);
               a.setStatus(Boolean.parseBoolean(request.getParameter("status" + index)));        
               a.setDescription(request.getParameter("description" + index));
               a.setRecordTime(Time.valueOf(request.getParameter("recordtime"+index)));
               attendances.add(a);
          }
          adb.updateAttendance(attendances);
          request.setAttribute("action", "updated");
          request.getRequestDispatcher("view/teacher/confirmPage.jsp").forward(request, response);
     }

     /**
      * Returns a short description of the servlet.
      *
      * @return a String containing servlet description
      */
     @Override
     public String getServletInfo() {
          return "Short description";
     }// </editor-fold>

}
