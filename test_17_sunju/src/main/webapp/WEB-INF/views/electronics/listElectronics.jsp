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
	  <h2>전자기기 목록</h2>
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>고유번호</th>
	        <th>모델명</th>
	        <th>종류</th>
	        <th>가격</th>
	        <th>제조사</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<%-- 전자기기 정보 개수만큼 반복 출력 --%>
	    	<c:forEach items="${listDto }" var="dto">
				<tr >
					<td>${dto.electronicsCode}</td>
					<td><a href="${root}/electronics/view/${dto.electronicsCode}">${dto.model}</a></td>
					<td>${dto.type}</td>
					<td>${dto.price}</td>
					<td>${dto.company}</td>
				</tr>
				 <form id="form-param" method="get" action="">
			      <input type="hidden" name="model" id="model" value="${dto.model}">
			    </form>
			</c:forEach>
	    </tbody>
	  </table>
	</div>
	
	

<%@ include file="/WEB-INF/views/include/footer.jsp" %>