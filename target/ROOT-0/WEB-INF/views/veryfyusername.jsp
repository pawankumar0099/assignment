<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-2 ml-0">
    <form action="validateUsername" method="post">

        <div class="row">
               <div class="col-md-1"> <label for="username"><b>Username</b></label></div>
               <div class="col-md-3">  <input class="form-control mb-2" type="text" placeholder="Enter Username"
                  name="username" required> </div>
            </div>

<button class="btn btn-success mt-2 mb-2" type="submit">Verify</button>
    <%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>

      </form>
  </div>
</body>
</html>