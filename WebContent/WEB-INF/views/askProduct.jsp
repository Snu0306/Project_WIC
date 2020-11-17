<%
/* 
@Project : WIC
@File name : AskProduct.jsp
@Date : 2020.11.16
@Author : 문지연
*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="stylesheet" href="resource/style/memberEditPage-style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Ask Product</title>

</head>

<body>
	<header>
		<%@ include file="/WEB-INF/views/common/Top.jsp" %>  
	</header>

	<c:set var="prd_num" value="${requestScope.prd_num}" />
	<c:set var="id" value="${requestScope.id}" />
	<div class="container">
	<form action="<%= request.getContextPath()%>/write.askProduct" method="post">
		
		<input type="text" name="prd_num" value="${prd_num}" hidden/>
		
		<div class="form-control">
			<label for="id">ID</label>
			<input type="email" id="id" class="id" name="id" value="${id}" readonly/>
		</div>
		<div class="form-control">
			<label for="title">TITLE</label>
			<input type="text" id="title" name="title"/>
		</div>
		<div class="form-control">
			<label for="content">CONTENT</label>
			<input type="text" id="content" name="content"  />
		</div>
		
		<div style="width:100%;">
		<input type="submit" class="btn-confirm" value="CONFIRM">
		<input type="button" class="btn-cancel" value="CANCEL"
		onclick="location.href='<%= request.getContextPath()%>/managePage.Mg'">
		</div>
		
	</form>
</div>

</body>

</html>