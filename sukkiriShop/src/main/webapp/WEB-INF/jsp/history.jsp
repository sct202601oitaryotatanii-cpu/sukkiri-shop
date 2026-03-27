<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<h2>注文履歴</h2>

<c:forEach var="order" items="${orderList}">
    <h3>注文ID：${order.id} / 合計：$${order.total}</h3>

    <c:forEach var="item" items="${order.items}">
        <p>${item.name} × ${item.quantity}</p>
    </c:forEach>

    <hr>
</c:forEach>

<a href="HomeServlet">ホームへ戻る</a>
<a href="CartViewServlet">カートを見る</a>