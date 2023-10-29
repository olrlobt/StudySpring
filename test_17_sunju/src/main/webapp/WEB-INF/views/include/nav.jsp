<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/electronics/list">전자기기 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/electronics/regist">전자기기 정보 등록</a></li>
	</ul>
	<c:choose>
		<c:when test="${empty userInfo}">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="${root}/user/login">로그인</a>
				</li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul class="navbar-nav">
				<li class="nav-item">
					<div class="nav-link">${userInfo.id} 님 반갑습니다.</div>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${root}/user/logout">로그아웃</a>
				</li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>