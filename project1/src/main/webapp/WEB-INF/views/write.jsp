<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 Get</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="./css/menu.css">
<link rel="stylesheet" href="./css/write.css">
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>


</head>
<body>
	<%@ include file="menu.jsp"%>
	<h1>글쓰기</h1>
	<form action="./write" method="post">
		<div class="write-div">
			<input class=ipt type="text" name="title">
			<textarea id="summernote" name="content"></textarea>
			<button class="btn" type="submit">글쓰기</button>
	</div>
	</form>
	<!-- type="submit" => 제출버튼. 폼데이터로 데이터 전송 -->

	<script type="text/javascript">
		/* JQuery문법 : 문서가 모두 로딩되었다면,
		textarea에 서머노트를 실행해 주세요.*/
		$(document).ready(function() {
			$('#summernote').smernote();
			height: 400
		});
	</script>um
</body>
</html>