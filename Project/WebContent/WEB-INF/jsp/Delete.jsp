<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォーム6</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
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
				<h1>ユーザ削除確認</h1>
			</div>
		</div>
		<h4 class="text-center">ログインID:Id0001</h4>
		<h4 class="text-center">を本当に削除してよろしいでしょうか。</h4>
		<br>
		<div class="row">
		<div class="col-4"></div>
		<div class="col-4">
		<button type="button" class="btn btn-right btn-lg">キャンセル</button>
		<button type="button" class="btn btn-danger btn-lg">ＯＫ</button>
		</div>
		</div>
	</div>
</body>
</html>