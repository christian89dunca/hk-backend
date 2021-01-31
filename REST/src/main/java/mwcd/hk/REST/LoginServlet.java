package mwcd.hk.REST;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
// * @email
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail(email);
        loginBean.setPassword(password);

        try {
            if (loginDao.validate(loginBean)) {
//                HttpSession session = request.getSession();
                // session.setAttribute("email",email);
                response.sendRedirect("/login");
                System.out.println("Login successful");
            } else {
//                HttpSession session = request.getSession();
                //session.setAttribute("user", email);
                response.sendRedirect("/login");
                System.out.println("Login failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
    }
}