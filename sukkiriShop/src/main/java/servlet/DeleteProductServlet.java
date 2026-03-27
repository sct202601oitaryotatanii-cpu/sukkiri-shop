package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ProductDAO;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		ProductDAO dao = new ProductDAO();
		dao.delete(id);

		response.sendRedirect("AdminServlet");
	}
}