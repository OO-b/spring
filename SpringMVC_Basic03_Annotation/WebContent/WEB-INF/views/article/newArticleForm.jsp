<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 화면</title>
</head>
<body>
	<h3>게시판 글쓰기 입력 폼</h3>
	<h3>**form 태그에 action 주소값: 현재 URL 창에 있는 주소가 action 주소**</h3>
	<form method="post">  <!-- action주소가 없으면 위에 url이 자신의 주소값 다시 그 창으로 보내 줄라고  // 화면단은 get으로 / 처리단은 post로 구분함-->
		<input type="hidden" name="parentId" value="0">
		제목:<input type="text" name="title"><br>
		
		내용:<input type="text" name="content"><br>
			 <input type="submit" value="전송">
	</form>
</body>
</html>