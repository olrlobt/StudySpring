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
	
	  <h2>전자기기 정보 등록</h2>
	  <form id="registForm" action="${root}/electronics/regist" method="post">
	    <div class="form-group">
	      <label for="electronicsCode">고유번호</label>
	      <input type="text" class="form-control" id="electronicsCode" name="electronicsCode" placeholder="고유번호 입력">
	    </div>
	    <div class="form-group">
	      <label for="model">모델명</label>
	      <input type="text" class="form-control" id="model" name="model" placeholder="모델명 입력">
	    </div>
   	    <div class="form-group">
	      <label for="etype">종류</label>
			<select class="form-select" name="type">
				<option value="휴대폰" selected>휴대폰</option>
				<option value="태블릿">태블릿</option>
				<option value="노트북">노트북</option>
				<option value="스마트워치">스마트워치</option>
			</select>
	    </div>
	    <div class="form-group">
	      <label for="price">가격</label>
	      <input type="number" class="form-control" id="price" name="price" placeholder="가격 입력" >
	    </div>
   	    <div class="form-group">
	      <label for="company">제조사</label>
	      <input type="text" class="form-control" id="company" name="company" placeholder="제조사 입력" >
	    </div>

	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="${root}/electronics/list" >취소</a>
	  </form>
	
	
	</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>