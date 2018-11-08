<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ一覧</title>
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
			<a href="NewUserFormServlet">新規登録</a>
		</div>

		<form method="post" action="UserListServlet">
			<div class="form group row m-3">
				<label for="code" class="control-label col-2">ログインＩＤ</label>
				<div class="col-7">
					<input type="text" name="loginid" class="form-control" />
				</div>
			</div>
			<div class="form group row m-3">
				<label class="control-label col-2">ユーザー名</label>
				<div class="col-7">
					<input type="text" name="name" class="form-control" />
				</div>
			</div>
			<div class="form group row m-3">
				<label class="control-label col-2">生年月日</label>
				<div class="col-3">
					<input type="date" name="birthdate1" class="form-control" />
				</div>
				<label class="control-label col-1">～</label>
				<div class="col-3">
					<input type="date" name="birthdate2" class="form-control" />
				</div>
			</div>
			<div class="text-right">
				<input type="submit" class="search-submit" value="検索">
			</div>
		</form>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ログインID</th>
						<th>ユーザ名</th>
						<th>生年月日</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${UserList}">
						<tr>
							<td>${user.loginId}</td>
							<td>${user.name}</td>
							<td>${user.birthDate}</td>
							<!-- TODO 未実装；ログインボタンの表示制御を行う -->
							<td><a class="btn btn-primary"
								href="UserDetailServlet?id=${user.id}">詳細</a>
								<c:if test="${userInfo.loginId == user.loginId ||userInfo.loginId == 'admin'}">
								<a
								class="btn btn-success" href="UpdateServlet?id=${user.id}">更新</a></c:if>
								<c:if test="${userInfo.loginId =='admin'}">
								<a class="btn btn-danger" href="DeleteServlet?id=${user.id}">削除</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>