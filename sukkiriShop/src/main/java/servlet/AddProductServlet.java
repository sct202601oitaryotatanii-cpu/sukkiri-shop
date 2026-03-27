package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ProductDAO;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));

		ProductDAO dao = new ProductDAO();
		dao.insert(name, price);

		response.sendRedirect("AdminServlet");
	}
}
