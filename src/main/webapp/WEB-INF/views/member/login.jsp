<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>
	<link rel="stylesheet" href="/resources/css/reset.css" />
	<link rel="stylesheet" href="/resources/css/login.css" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<link rel="icon" href="/resources/images/favicon.png" />
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/login.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp" %>
	<div class="login_area">
		<h1>로그인</h1>
		<input type="text" id="user_id" placeholder="아이디를 입력해주세요"/>
		<input type="password" id="user_pwd" placeholder="비밀번호를 입력해주세요"/>
		<div class="options_area">
			<input type="checkbox" id="secure_login" />
			<label for="secure_login" id="secure_icon">
				<i class="fas fa-check"></i>
			</label>
			<label for="secure_login" id="secure_text">보안접속</label>
		</div>
		<button id="login">로그인</button>
		<a href="/member/join" id="join">회원가입</a>
	</div>
	<%@include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>