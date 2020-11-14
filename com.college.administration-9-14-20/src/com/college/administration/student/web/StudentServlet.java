package com.college.administration.student.web;

import com.college.administration.student.model.Student;
import com.college.administration.student.dao.StudentDAO;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        doGet(request, response);
    	    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        String action = request.getServletPath();
    		
    
    try {
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertStudent(request, response);
                break;
            case "/delete":
                deleteStudent(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateStudent(request, response);
                break;
            default:
                listStudent(request, response);
                break;
        }
        
    } catch (SQLException ex) {
        throw new ServletException(ex);     
    
    }
    }   
    private void listStudent(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	        List <Student> listStudent = studentDAO.selectAllStudents();
    	        request.setAttribute("listStudent", listStudent);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
    	        dispatcher.forward(request, response);
    	    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	 List <Student> listStudent = studentDAO.selectAllStudents();
    	 		request.setAttribute("listStudent", listStudent);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("student-test-form.jsp");
    	        dispatcher.forward(request, response);
    	    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	        int student_id = Integer.parseInt(request.getParameter("student_id"));
    	        Student existingStudent = studentDAO.selectStudent(student_id);
    	        request.setAttribute("listStudent", student_id);
    	        request.setAttribute("student_id", existingStudent);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("student-edit-form.jsp");
    	        
    	        dispatcher.forward(request, response);

    	    }
    
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	        String firstName = request.getParameter("firstName");
    	        String lastName = request.getParameter("lastName");
    	        String email = request.getParameter("email");
    	        Student newStudent = new Student(firstName, lastName, email);
    	        studentDAO.insertStudent(newStudent);
    	        response.sendRedirect("list");
    	    }
    
    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	        int student_id = Integer.parseInt(request.getParameter("student_id"));
    	        String firstName = request.getParameter("firstName");
    	        String lastName = request.getParameter("lastName");
    	        String email = request.getParameter("email");

    	        Student student = new Student(student_id, firstName, lastName, email);
    	        studentDAO.updateStudent(student);
    	        response.sendRedirect("student-test-form.jsp");
    	    }
    
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	        int student_id = Integer.parseInt(request.getParameter("student_id"));
    	        studentDAO.deleteStudent(student_id);
    	        response.sendRedirect("list");

    	    }
}