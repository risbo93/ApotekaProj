<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="registracija.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Dodavanje Leka</title>
</head>
<body>
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<h5>Unesite podatke o leku:</h5>
					<form action="/ApotekaWEB/DodavanjeLekaServlet" method="post">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Naziv</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="naziv" id="naziv"  placeholder="Unesite naziv leka"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Cena</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="cena" id="cena"  placeholder="Unesite cenu leka"/>
								</div>
							</div>
						</div>
						

						<div class="form-group ">
							<button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Dodaj</button>
						</div>
						
					</form>
					<form action="/ApotekaWEB/IndexServlet" method="post">
						<div class="form-group ">
							<button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Povratak nazad</button>
						</div>
					</form>
					<h5>${poruka1 }</h5>
				</div>
			</div>
		</div>

		 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>