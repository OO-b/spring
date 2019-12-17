<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
    <h2> 회원가입 </h2>
    <hr/>
    <form method="post" action="memberSave">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>이름</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td>주민번호</td>
                <td><input type="text" name="identifyNo"/></td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="전송"/>
    </form>
</div>
</body>
</html>
