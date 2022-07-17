/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerSt;

import dal.AttendanceDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Attendance;
import model.Session;
import model.Student;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class TakeAttendanceController extends HttpServlet {

     /**
      * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
      * methods.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     String sessionid;

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          try ( PrintWriter out = response.getWriter()) {
               /* TODO output your page here. You may use following sample code. */
               out.println("<!DOCTYPE html>");
               out.println("<html>");
               out.println("<head>");
               out.println("<title>Servlet TakeAttendanceController</title>");
               out.println("</head>");
               out.println("<body>");
               out.println("<h1>Servlet TakeAttendanceController at " + request.getContextPath() + "</h1>");
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
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          StudentDBContext sdb = new StudentDBContext();
          int groupid = Integer.parseInt(request.getParameter("group"));
          sessionid = request.getParameter("session");
          ArrayList<Student> students = sdb.listByGroup(groupid);
          request.setAttribute("students", students);
          request.getRequestDispatcher("view/teacher/takeAttendance.jsp").forward(request, response);
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
          Session ss = new Session();
          ss.setSessionID(Integer.parseInt(sessionid));
          String[] indexes = request.getParameterValues("index");
          ArrayList<Attendance> attendances = new ArrayList<>();
          AttendanceDBContext adb = new AttendanceDBContext();
          for (String index : indexes) {
               Attendance a = new Attendance();
               Student s = new Student();
               s.setSid(request.getParameter("sid" + index));
               a.setStudentID(s);
               a.setStatus(Boolean.parseBoolean(request.getParameter("status" + index)));
               a.setSessionID(ss);
               a.setDescription(request.getParameter("description" + index));
               a.setRecordTime(Time.valueOf(request.getParameter("recordtime"+index)));
               attendances.add(a);
          }
          adb.insertAttendance(attendances);
          request.setAttribute("action", "Take");
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
