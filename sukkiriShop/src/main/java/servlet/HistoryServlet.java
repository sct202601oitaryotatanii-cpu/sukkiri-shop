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

import dao.OrderHistoryDAO;
import model.Order;

@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        OrderHistoryDAO dao = new OrderHistoryDAO();
        List<Order> orderList = dao.findByUserId(userId);

        request.setAttribute("orderList", orderList);

        RequestDispatcher dispatcher =
            request.getRequestDispatcher("WEB-INF/jsp/history.jsp");
        dispatcher.forward(request, response);
    }
}