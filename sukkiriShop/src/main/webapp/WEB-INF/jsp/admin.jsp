<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2>管理者画面</h2>

<h3>商品一覧</h3>

<c:forEach var="p" items="${productList}">
    <p>
        ${p.name} - $${p.price}
        <a href="DeleteProductServlet?id=${p.id}">削除</a>
    </p>
</c:forEach>

<hr>

<h3>商品追加</h3>
<form action="AddProductServlet" method="post">
    名前：<input type="text" name="name"><br>
    価格：<input type="number" name="price"><br>
    <button type="submit">追加</button>
</form>