<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕 나는 인덱스야??</title>
<link rel="stylesheet" href="./css/menu.css">
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file ="menu.jsp"%>

	<h1>index</h1>
	<%=request.getHeader("User-Agent") %>
</body>
</html>