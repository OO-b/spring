<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		Spring MVC 요청하기
		<a href="hello.htm">hello.htm 요청하기</a>
		<a href="intro.htm">intro.htm 요청하기</a>
</body>
</html>


<!-- 
> 여기서 부터 시작해서 > xml로가서 DispatcherServlet이 .htm으로 오는 모든걸 잡음 (DispatcherServlet 구동)
> 받은 주소에 해당하는 컨트롤러를 찾아달라고 (HandlerMapping에게 보냄 > xml에서 bean객체에서 id같은거 찾음 > HelloController실행시킴 > handleRequest()가 자동실행됨)
> 그 함수는 클라이언트가 보낸 모든 요청 객체를 다 찾아냄 request(parameter) 
> 그럼 자기만의 컨테이너 만들어서 작업  -->