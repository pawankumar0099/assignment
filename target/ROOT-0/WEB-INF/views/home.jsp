<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style><%@include file="style.css"%></style>
</head>
<body>
<div style="position: absolute;
  left: 50%;
  top: 50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);" >
<form action="login" method="post" style="width: 100%;">

  <div class="container">
    <label  for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required><br>

    <label for="passwoed"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required><br>
    <div>
<%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>
</div>
    
    <button type="submit">Login</button>
    
  </div>
  
  <div class="container">
    <span class="psw">Forgot <a href="veryfyusername">password?</a></span>
  </div>
</form>
</div>
</body>
</html>
