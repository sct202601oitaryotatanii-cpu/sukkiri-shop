<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート一覧</title>
</head>
<body>
<h2>カート一覧</h2>

<c:choose>
  <c:when test="${empty sessionScope.cart}">
    <p>カートは空です</p>
  </c:when>

  <c:otherwise>

    <c:set var="total" value="0" />

    <c:forEach var="item" items="${sessionScope.cart}" varStatus="status">
      <p>
        ${item.product.name} × ${item.quantity}
        - $${item.product.price * item.quantity}
        <a href="DeleteCartServlet?index=${status.index}">削除</a>
      </p>

      <c:set var="total"
        value="${total + (item.product.price * item.quantity)}" />
    </c:forEach>

    <hr>
    <p>合計：$${total}</p>

    <form action="BuyServlet" method="post">
      <button type="submit">購入する</button>
    </form>

  </c:otherwise>
</c:choose>
<a href="HomeServlet">ホームへ戻る</a>
<a href="HistoryServlet">注文履歴</a>
</body>
</html>