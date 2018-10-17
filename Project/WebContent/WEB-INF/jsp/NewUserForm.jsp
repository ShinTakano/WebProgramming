<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォーム2</title>
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
				<h1>ユーザ新規登録</h1>
			</div>
		</div>
		<form>
			<div class="form-group row m-2">
				<label class="control-label col-4 text-center">ログインＩＤ</label>
				<div class="col-6">
					<input class="form-control" type="text">
				</div>
			</div>
			<br>
			<div class="form-group row m-2">
				<label class="control-label col-4 text-center">パスワード</label>
				<div class="col-6">
					<input class="form-control" type="password">
				</div>
			</div>
			<br>
			<div class="form-group row m-2">
				<label class="control-label col-4 text-center">パスワード（確認）</label>
				<div class="col-6">
					<input class="form-control" type="password">
				</div>
			</div>
			<br>
			<div class="form-group row m-2">
				<label class="control-label col-4 text-center">ユーザ名</label>
				<div class="col-6">
					<input class="form-control" type="text">
				</div>
			</div>
			<br>
			<div class="form-group row m-2">
				<label class="control-label col-4 text-center">生年月日</label>
				<div class="col-6">
					<input class="form-control" type="date">
				</div>
			</div>
			<div class="text-right">
				<button type="submit" class="btn btn-primary">登録</button>
			</div>
		</form>
		<div class="text-left">
			<a href="#">戻る</a>
		</div>
	</div>
</body>
</html>