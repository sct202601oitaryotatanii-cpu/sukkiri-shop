package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Account; // ← ★これ追加
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) 
		throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(
			"WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) 
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		Login login = new Login(userId, pass);
		LoginLogic bo = new LoginLogic();
		Account account = bo.execute(login);

		if (account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", account.getUserId());
			session.setAttribute("role", account.getRole());

			RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect("LoginServlet");
		}
		System.out.println("sessionID=" + request.getSession().getId());
	}
}
