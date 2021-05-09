package com.mm.challenges.app1.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.challenges.app1.registration.dao.UserDao;
import com.mm.challenges.app1.registration.model.User;


@WebServlet("/register")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/newUser.jsp");
    	dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddress(address);

        try {
            userDao.registerUser(user);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/newUserSuccess.jsp");
        	dispatcher.forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
