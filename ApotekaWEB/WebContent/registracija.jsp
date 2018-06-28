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
<title>Registracija</title>
</head>
<body>
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<h5>Unesite svoje podatke:</h5>
					<form class="" method="post" action="#">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Ime</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ime" id="ime"  placeholder="Unesite vase Ime"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Prezime:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="prezime" id="prezime"  placeholder="Unesite vase Prezime"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Godine</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="godine" id="godine"  placeholder="Unesite vase Godine"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="Unesite Username"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Unesite Password"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Potvrdite Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Potvrdite Password"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Grad stanovanja</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="grad" id="grad"  placeholder="Unesite vas Grad"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Ulica stanovanja</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ulica" id="ulica"  placeholder="Unesite vasu Ulicu i Broj"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Broj telefona</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="telefon" id="telefon"  placeholder="Unesite vasu Broj Telefona"/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>

		 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>