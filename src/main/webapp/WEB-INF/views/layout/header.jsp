<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<title>라즈베파이 스트리밍 서비스</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/styles.css" />
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			<!-- Brand -->
			<a class="navbar-brand" href="#">홈</a>

			<!-- Toggler/collapsibe Button -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- Navbar links -->
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<c:choose>
						<c:when test="${empty principal}">
							<li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
							<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="/picture/uploadForm">사진업로드</a></li>
							<li class="nav-item"><a class="nav-link" href="/video/uploadForm">영상업로드</a></li>
							<li class="nav-item"><a class="nav-link" href="#">영상재생</a></li>
							<li class="nav-item"><a class="nav-link" href="#">사진재생</a></li>
							<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</nav>
	</header>
	<br />