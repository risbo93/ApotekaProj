<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="login.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>
</head>
<body>
<div class="container">
	<div class="login-container">
            <div id="output"></div>
            <div class="avatar"></div>
            <div class="form-box">
                <form action="/ApotekaWEB/LoginServlet" method="post">
                    <input name="username" type="text" placeholder="username">
                    <input name="password" type="password" placeholder="password">
                    <button class="btn btn-info btn-block login" type="submit">Login</button>
                </form>
                 <form action="/ApotekaWEB/RegistracijaServlet" method="get">
                    <button class="btn btn-info btn-block login" type="submit">Register</button>
                </form>
                <form action="/ApotekaWEB/IndexServlet" method="get">
                    <button class="btn btn-info btn-block login" type="submit">Pocetna</button>
                </form> 
               <h5> ${poruka } </h5>
            </div>
        </div>
        
</div>
</body>
</html>