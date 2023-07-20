<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/detail.css">
<link rel="stylesheet" href="./css/menu.css">
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/icon">
<script type="text/javascript">
function edit(){
	if(confirm("수정하시겠습니까?")){
		location.href="./edit?bno=${dto.bno }";
	}
}

function del(){
	let chk = confirm("삭제하시겠습니까?"); //참 거짓으로 나옵니다.
	//alert(chk);
	if(chk){
		location.href="./delete?bno=${dto.bno }";
		//http://172.30.1.19/delete?bno=150
	}
}
</script>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h1>상세보기</h1>
	<!-- 2023-07-18 / 데이터베이스 구현/ 메뉴만들기, 글쓰기 -->
	<div class="detail-content">

		<div class="title">
			${dto.bno } /${dto.btitle } <img alt="" src="/img/up1.png"
				onclick="edit()" /> &nbsp;<img alt="" src="/img/down2.png"
				onclick="del()" />
		</div>
		<div class="namebar"></div>
		<div class="name">${dto.bwrite }</div>
		<div class="data">${dto.bdate }</div>
		<div class="ip">${dto.bip } ${dto.bcontent }</div>
		<div class="content">${dto.bcontent }</div>
	</div>


</body>
</html>