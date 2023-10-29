<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>전자기기 상세 정보</h2>
  	  <c:if test="${not empty userInfo.id}">
  	  	<a class="btn btn-danger" href="${root}/electronics/remove/${dto.electronicsCode}">삭제</a>
  	  </c:if>
	  <table class="table table-striped">
	      <tr>
	        <td>고유번호</td><td>${dto.electronicsCode}</td>
	      </tr>
	      <tr>
	        <td>모델명</td><td>${dto.model}</td>
	      </tr>
   	      <tr>
	        <td>종류</td><td>${dto.type}</td>
	      </tr>
	      <tr>
	        <td>가격</td><td>${dto.price}</td>
	      </tr>
	      <tr>
	        <td>제조사</td><td>${dto.company}</td>
	      </tr>
	  </table>
	
	</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>