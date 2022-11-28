<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nagarro.model.*"%>
<%@ page import="com.nagarro.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style type="text/css">
h3 {
	text-align: center;
	margin-bottom: 20px;
}
</style>
</head>

<body>
	<div class="container mt-4">
		<form action="logout" style="float: right">
            <button class="btn btn-primary" type="submit">Logout</button>
         </form>
		<h3>Product Search</h3>
		
		<form action="search">
			<div  class="row">
				<div class="col-md-2">
				<label for="color"><b>Choose Colour:</b></label>
				</div>
				
				 <select class="form-select mb-2 ml-0" name="color"
					id="color">
					<option value="black">Black</option>
					<option value="blue">Blue</option>
					<option value="yellow">Yellow</option>
					<option value="maroon">Maroon</option>
					<option value="grey">Grey</option>
					<option value="white">White</option>
					<option value="pink">Pink</option>
					<option value="purple">Purple</option>
					<option value="orange">Orange</option>
				</select>
			</div>
			<div  class="row">
				<div class="col-md-2">
				<label for="size"><b>Choose size:</b></label>
				</div>
				
				 <select class="form-select mb-2 ml-0" name="size"
					id="size">
					<option value="s">Small</option>
					<option value="m">Medium</option>
					<option value="l">Large</option>
					<option value="xl">X-Large</option>
					<option value="xxl">XX-Large</option>
				</select>
			</div>
			
			
			<div  class="row">
				<div class="col-md-2">
				<label for="gender"><b>Choose gender:</b></label>
				</div>
				 <select class="form-select mb-2" name="gender"
					id="gender">
					<option value="m">Male</option>
					<option value="f">Female</option>
				</select>
			</div>
			
			<div  class="row">
				<div class="col-md-2">
				<label for="outputp"><b>Output Pref:</b></label>
				</div>
				 <select class="form-select mb-2" name="outputp"
					id="outputp">
					<option value="price">Price</option>
					<option value="rating">Rating</option>
				</select>
			</div>
			

			<button class="btn btn-success mt-2 mb-2" type="submit">search</button>
		</form>

		<table class="table table-bordered mt-5" id="td">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>COLOUR</th>
					<th>GENDER</th>
					<th>SIZE</th>
					<th>PRICE</th>
					<th>RATING</th>

				</tr>
			</thead>

			<c:forEach items="${list}" var="temp">

				<tr>
					<td>${temp.id}</td>
					<td>${temp.name}</td>
					<td>${temp.color}</td>
					<td>${temp.gender}</td>
					<td>${temp.size}</td>
					<td>${temp.price}</td>
					<td>${temp.rating}</td>


				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>