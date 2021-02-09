<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="wrapper fadeInDown">

  <div id="formContent">
  
    <h2 class="active">Login</h2>
    <a href="memberJoin.jsp"><h2 class="inactive underlineHover">Sign Up</h2></a>

    <!-- 아이콘 -->
    <div class="fadeIn first">
			<img src="css/usericon.png" alt="user img" width="30px" padding="20px">
    </div>

    <!-- 로그인 -->
	<form action="login.do" method="post">
      <input type="text" class="fadeIn second" name=id placeholder="아이디" required>
      <input type="password" class="fadeIn third" name="pw" placeholder="비밀번호" required>
      <input type="submit" class="fadeIn fourth" value="LogIn">
    </form>


    <div id="formFooter">
      <a class="underlineHover" href="memberJoin.jsp">아직 회원이 아니신가요?</a>
    </div>

  </div>
</div>
</body>
</html>

