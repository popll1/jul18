<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕 나는 게시판이야?</title>
<link rel="stylesheet" href="./css/board.css">
<link rel="stylesheet" href="./css/menu.css">
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
</head>
<body>
         
<%@ include file ="menu.jsp"%>
	<h1>보드</h1>
	<a href="./index">index로 가기</a>
	
      <table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th>좋아요</th>
		</tr>
		<c:forEach items="${list }" var="row">
			<!--onclick 자바스크립트 페이지 이동, ?파라미터 =값  -->
			<tr onclick="location.href='./detail?bno=${row.bno}'">
				<td class="td1">${row.bno }</td>
				<td class="title">${row.btitle }</td>
				<td class="td1">${row.bwrite }</td>
				<td class="td2">${row.bdate }</td>
				<td class="td1">${row.blike }</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="location.href='write'">글쓰기</button>

      
  
</body>
</html>	