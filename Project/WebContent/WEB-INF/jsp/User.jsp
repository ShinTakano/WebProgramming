<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
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
				<h1>ユーザ情報詳細参照</h1>
			</div>
		</div>

		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">ログインＩＤ</label> <label
				class="control-label col-4 text-center">${UserId.loginId}</label>
		</div>
		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">ユーザ名</label> <label
				class="control-label col-4 text-center">${UserId.name}</label>
		</div>
		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">生年月日</label> <label
				class="control-label col-4 text-center">${UserId.birthDate}</label>
		</div>
		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">登録日時</label> <label
				class="control-label col-4 text-center">${UserId.createDate}</label>
		</div>
		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">更新日時</label> <label
				class="control-label col-4 text-center">${UserId.updateDate}</label>
		</div>
		<br> <br>
		<div class="text-left">
			<a href="UserListServlet" onclick="history.back()">戻る</a>
		</div>
	</div>
</body>
</html>