package pl.coderslab.users;

import pl.coderslab.User;
import pl.coderslab.UserDao;
import pl.coderslab.utils.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/user/add")
public class AddNewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/users/addNewUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = ("password");
        User user = new User(username, email, password);
        UserDao userDao = new UserDao();
        userDao.create(user);
        response.sendRedirect("/user/list");

    }
}
