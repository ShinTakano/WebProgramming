<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class ="text-center m-4">ログイン画面</h1>
		<br>
		<form class="form-signin" action="LoginServlet" method="post">
			<div class="form-group row m-2">
				<label class="control-label col-4 text-center">ログインＩＤ:</label>
				<div class="col-6">
					<input type="text" name="loginId" id="inputLoginId"
						class="form-control" placeholder="ログインID" required autofocus>
				</div>
			</div>
			<br>
			<div class="form-group row m-2">
				<label class="control-label col-4 text-center">パスワード:</label>
				<div class="col-6">
					<input type="password" name="password" id="inputPassword"
						class="form-control" placeholder="パスワード" required>
				</div>
			</div>
			<br>
			<div class="text-center">
			<button type="submit" class="btn btn-primary">送信する</button>
			</div>
		</form>
	</div>
	</div>
</body>
</html>