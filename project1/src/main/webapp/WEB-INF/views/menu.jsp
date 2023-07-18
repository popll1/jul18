<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

nav {
	/* position: fixed; */
	top: 0;
	width: 100%;
	height: 50px;
	background-color: gray;
}

nav ul {
	margin: 0;
	padding: 0;
}

nav li {
	list-style: none; /* li 앞에 원을 없애줍니다. */
	float: left;
	width: 100px;
	height: 50px;
	line-height: 50px;
	text-align: center;
}

nav li:hover {
	background-color: rgba(255, 0, 0, 0.2);
	color: white;
}
</style>

	<nav>
		<ul>
			<li onclick="link('')">메인</li>
			<li onclick="link('board')">게시판</li>
			<li onclick="link('board2')">게시판2</li>
			<li onclick="link('mooni')">무늬사항</li>
			<li onclick="link('notice')">공지</li>
		</ul>
	</nav>
	<div style="height: 50px; width: 100%;"></div>
	
	<script>
	function link(url){
	location.href="./"+url;
		}
	</script>