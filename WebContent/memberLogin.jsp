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

    <!-- ������ -->
    <div class="fadeIn first">
			<img src="css/usericon.png" alt="user img" width="30px" padding="20px">
    </div>

    <!-- �α��� -->
	<form action="login.do" method="post">
      <input type="text" class="fadeIn second" name=id placeholder="���̵�" required>
      <input type="password" class="fadeIn third" name="pw" placeholder="��й�ȣ" required>
      <input type="submit" class="fadeIn fourth" value="LogIn">
    </form>


    <div id="formFooter">
      <a class="underlineHover" href="memberJoin.jsp">���� ȸ���� �ƴϽŰ���?</a>
    </div>

  </div>
</div>
</body>
</html>

