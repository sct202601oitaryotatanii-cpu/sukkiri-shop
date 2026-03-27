<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h2>ユーザー登録</h2>
<form action="RegisterServlet" method="post">
ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type="password" name="pass"><br>
メール：<input type="text" name="mail"><br>
名前：<input type="text" name="name"><br>
年齢：<input type="number" name="age"><br>
<input type="submit" value="登録">
</form>
</body>
</html>