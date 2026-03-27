package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.OrderDAO;
import model.CartItem;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String userId = (String) session.getAttribute("userId");
        List<CartItem> cart =
            (List<CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("CartViewServlet");
            return;
        }

        OrderDAO dao = new OrderDAO();
        dao.insert(userId, cart);

        // カート削除
        session.removeAttribute("cart");

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("WEB-INF/jsp/buyOK.jsp");
        dispatcher.forward(request, response);
    }
}
