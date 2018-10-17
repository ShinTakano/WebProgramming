<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォーム3</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="userCreate.html">ユーザ管理システム</a>
				</div>

				<ul class="nav navbar-nav navbar-right">
					<li class="navbar-text">${userInfo.name}さん</li>
					<li class="dropdown"><a href="LogoutServlet"
						class="navbar-link logout-link">ログアウト</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<div class="container">
		<div class="text-right">
			<a href="userCreate.html">新規登録</a>
		</div>

		<form method="post" action="#" class="form-horizontal">
			<div class="form group row m-3">
				<label for="code" class="control-label col-2">ログインＩＤ</label>
				<div class="col-7">
					<input type="text" name="login-id" id="login-id"
						class="form-control" />
				</div>
			</div>
			<div class="form group row m-3">
				<label class="control-label col-2">ユーザー名</label>
				<div class="col-7">
					<input type="text" name="user-name" id="user-name"
						class="form-control" />
				</div>
			</div>
			<div class="form group row m-3">
				<label class="control-label col-2">生年月日</label>
				<div class="col-3">
					<input type="date" name="date-start" id="date-start"
						class="form-control" />
				</div>
				<label class="control-label col-1">～</label>
				<div class="col-3">
					<input type="date" name="date-end" id="date-end"
						class="form-control" />
				</div>
			</div>
			<div class="text-right">
				<input type="submit" class="search-submit" value="検索">
			</div>
		</form>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">ログインＩＤ</th>
					<th scope="col">ユーザ名</th>
					<th scope="col">生年月日</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">id0001</th>
					<td>田中太郎</td>
					<td>1989年04月26日</td>
					<td><button type="button" class="btn btn-primary ">詳細</button>
						<button type="button" class="btn btn-success">更新</button>
						<button type="button" class="btn btn-danger">削除</button></td>
				</tr>
				<tr>
					<th scope="row">id0002</th>
					<td>佐藤二朗</td>
					<td>2001年11月12日</td>
					<td><button type="button" class="btn btn-primary ">詳細</button>
						<button type="button" class="btn btn-success">更新</button>
						<button type="button" class="btn btn-danger">削除</button></td>
				</tr>
				<tr>
					<th scope="row">id0003</th>
					<td>佐川真司</td>
					<td>2000年01月01月</td>
					<td>
						<button type="button" class="btn btn-primary ">詳細</button>
						<button type="button" class="btn btn-success">更新</button>
						<button type="button" class="btn btn-danger">削除</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>