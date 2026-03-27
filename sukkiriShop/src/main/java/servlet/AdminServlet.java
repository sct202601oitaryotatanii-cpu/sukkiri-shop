package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.ProductDAO;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");

		if (!"admin".equals(role)) {
			response.sendRedirect("HomeServlet");
			return;
		}

		ProductDAO dao = new ProductDAO();
		request.setAttribute("productList", dao.findAll());

		RequestDispatcher dispatcher =
			request.getRequestDispatcher("WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("role=" + role);
	}
	
	
}
