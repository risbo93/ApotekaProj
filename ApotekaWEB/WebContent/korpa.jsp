<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Korpa</title>
<link rel="stylesheet" type="text/css" href="brisanje.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    <form action="/ApotekaWEB/KupovinaServlet" method="get"><button type="submit" id="button" class="btn btn-primary btn-xs pull-right">Povratak nazad</button></form>
        <tr>
            <th>Naziv Leka</th>
            <th>Kolicina</th>
            <th>Cena</th>
            <th class="text-center">Akcija</th>
        </tr>
    </thead>
    <tbody>
                <c:forEach var="stavka" items="${stavke }">
						<tr>
							<td>${stavka.lek.naziv }</td>
							<td>${stavka.kolicina }</td>
							<td>${stavka.lek.cena }</td>
							<td><form action="/ApotekaWEB/BrisanjeServlet" method="post">
						<input name="odabraniLek" type="hidden" value="${lek.idLek }">
						 <button type="submit" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Obrisi</button>
						</form></td>
						</tr>
					</c:forEach>                             
              </tbody>
    </table>
    <form action="/ApotekaWEB/KorpaServlet" method="post">
    <h4>Odaberite kurirsku sluzbu:</h4>
    <p></p>
    <div class="cols-sm-10">
							<div class="input-group">
								<select name="odabranaKS" class="form-control">
									<c:forEach var="kur" items="${kurirskeSluzbe }">
										<option value="${kur.idKurirskaSluzba }">${kur.naziv }</option>
									</c:forEach>
								</select> 
							</div>
						</div>
						<p></p>
						<h4>Iznos vase kupovine je: ${cena }</h4>
						<p></p>
						<p>${poruka3 }
		<button type="submit" id="button"class="btn btn-primary btn-lg btn-block login-button">Potvrdi</button>
</form>
    </div>
</div>
</body>
</html>