<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザの削除</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg text-right">
				<ul class="nav navbar-nav navbar-right">
					<li class="navbar-text">${userInfo.name}さん</li>
					<li class="dropdown"><a href="LogoutServlet"
						class="navbar-link logout-link">ログアウト</a></li>
				</ul>
			</div>
		</div>
		<div class="row m-2">
			<div class="col-lg text-center">
				<h1>ユーザ削除確認</h1>
			</div>
		</div>
		<h4 class="text-center">ログインID:${UserId.loginId}</h4>
		<h4 class="text-center">を本当に削除してよろしいでしょうか。</h4>
		<br>
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<a href="UserListServlet" class="btn btn-primary"> キャンセル</a>
			</div>
			<div class="col-4 text-left">
				<form action="DeleteServlet" method="post">
					<input type="hidden" name="id" value="${UserId.id }">
					<button type="submit" class="btn btn-danger">ＯＫ</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>