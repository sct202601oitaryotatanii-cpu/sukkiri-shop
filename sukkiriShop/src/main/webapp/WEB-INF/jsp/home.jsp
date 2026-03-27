<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>

<style>
body {
    font-family: Arial;
    background: #f5f5f5;
    margin: 0;
}

.header {
    background: white;
    padding: 10px;
}
.search {
    width: 90%;
    padding: 10px;
    border-radius: 20px;
}

.banner {
    margin: 15px;
    padding: 20px;
    border-radius: 15px;
    background: linear-gradient(to right, #ccc, #eee);
}

.categories {
    display: flex;
    justify-content: space-around;
    margin: 15px;
}

.products {
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
    margin: 15px;
}

.product {
    width: 45%;
    background: white;
    padding: 10px;
    border-radius: 10px;
}

.price {
    color: blue;
}
</style>

</head>
<body>

<div class="header">
    <input class="search" placeholder="Search...">
</div>

<div class="banner">
    <h2>Summer Essentials</h2>
    <button>Shop Collection</button>
</div>

<div class="categories">
    <div>Electronics</div>
    <div>Fashion</div>
    <div>Home</div>
    <div>Beauty</div>
</div>

<div class="products">
<c:forEach var="p" items="${productList}">
    <div class="product">
        <p>${p.name}</p>
        <p class="price">$${p.price}</p>

        <form action="CartServlet" method="post">
            <input type="hidden" name="id" value="${p.id}">
            <input type="hidden" name="name" value="${p.name}">
            <input type="hidden" name="price" value="${p.price}">
            <button type="submit">カートに追加</button>
        </form>

    </div>
</c:forEach>
</div>
<a href="CartViewServlet">カートを見る</a>
<a href="HistoryServlet">注文履歴</a>
</body>
</html>