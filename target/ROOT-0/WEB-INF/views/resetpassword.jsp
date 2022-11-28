<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- 	<%@ page import="com.nagarro.web.dao.*"%> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>

	<form action="updatePassword" onsubmit="fun()" method="post"
		style="width: 100%;">

		<input type="hidden" id="username" name="username"
			value="<%=request.getParameter("username")%>">

		<div class="container">
			<label for="pass1"><b>new Password</b></label> <input type="password"
				placeholder="enter new password" id="p1" name="pass1" required><br>

			<label for="pass2"><b>Confirm Password</b></label> <input
				onchange="fun()" type="password" placeholder="confirm password"
				id="p2" name="pass2" required><br>



			<button type="submit" id="button">Reset</button>


		</div>

	</form>

</body>
<script>
	p3 = document.getElementById("button").disabled = true;
	function fun() {
		var p1 = document.getElementById("p1");
		var p2 = document.getElementById("p2");

		if (p1.value == p2.value) {
			p3 = document.getElementById("button").disabled = false;
		} else {
			p3 = document.getElementById("button").disabled = true;
		}
	}
</script>
</html>

