package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.AccountsDAO;
import model.Account;
import util.HashUtil;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String pass = HashUtil.hash(request.getParameter("pass"));
        String mail = request.getParameter("mail");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        Account account = new Account(userId, pass, mail, name, age);

        AccountsDAO dao = new AccountsDAO();
        boolean result = dao.create(account);

        if (result) {
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("WEB-INF/jsp/registerOK.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("RegisterServlet");
        }
        System.out.println("登録OK：" + result);
    }
    
}
