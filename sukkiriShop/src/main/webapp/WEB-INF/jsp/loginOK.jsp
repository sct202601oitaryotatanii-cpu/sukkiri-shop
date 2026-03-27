<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<c:choose>
  <c:when test="${not empty userId}">
    ようこそ ${userId} さん<br>
    <a href="LogoutServlet">ログアウト</a>
  </c:when>
  <c:otherwise>
    <a href="LoginServlet">ログイン</a>
  </c:otherwise>
</c:choose>
<a href="WelcomeServlet">トップへ</a>
<a href="HomeServlet">ホームへ</a>
<a href="AdminServlet">管理画面へ</a>
</body>
</html>