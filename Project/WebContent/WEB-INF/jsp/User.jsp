<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォーム4</title>
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
				ユーザー名さん <a href="#">ログアウト</a>
			</div>
		</div>
		<div class="row m-2">
			<div class="col-lg text-center">
				<h1>ユーザ情報詳細参照</h1>
			</div>
		</div>
		<c:forEach var="user" items="${UserList}">
		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">ログインＩＤ</label> <label
				class="control-label col-4 text-center">${user.loginId}</label>
		</div>
		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">ユーザ名</label> <label
				class="control-label col-4 text-center">${user.name}</label>
		</div>
		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">生年月日</label> <label
				class="control-label col-4 text-center">${user.birthDate}</label>
		</div>
		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">登録日時</label> <label
				class="control-label col-4 text-center">${user.createDate}</label>
		</div>
		<div class="row m-4">
			<div class="col-2"></div>
			<label class="control-label col-4 text-center">更新日時</label> <label
				class="control-label col-4 text-center">${user.updateDate}</label>
		</div>
		</c:forEach>
		<br>
		<br>
		<div class="text-left"><a href="#">戻る</a></div>
	</div>
</body>
</html>