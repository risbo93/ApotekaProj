<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="brisanje.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Kupovina</title>
</head>
<body>
<script>
    function ukupnaCena()
    {
        var total = 0;

        for (i=0; i < votes.length; ++i)
            {
                total += votes[i];
            }
            return total;
    }

</script>
<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    <form action="/ApotekaWEB/PregledServlet" method="get"><button type="submit" id="button" class="btn btn-primary btn-xs pull-right">Povratak nazad</button></form>
        <tr>
            <th>ID</th>
            <th>Ime</th>
            <th>Prezime</th>
            <th>Grad</th>
            <th>Ulica</th>
            <th>Lekovi</th>
            <th>Cena po Komadu</th>
            <th>Kolicina</th>
            <th>Iznos</th>
            <th>Kurirska Sluzba</th>
        </tr>
    </thead>
    <tbody>
                <c:forEach var="kupovina" items="${kupovine }">
                <c:set var="ukupnaCena" value="${0}" />
						<tr>
							<td>${kupovina.idKupovina }</td>
							<td>${kupovina.osoba.ime }</td>
							<td>${kupovina.osoba.prezime }</td>
							<td>${kupovina.osoba.grad }</td>
							<td>${kupovina.osoba.ulica }</td>
							<td>
							<c:forEach var="stavka" items="${kupovina.stavkas }">
							<p>${stavka.lek.naziv }</p>
							<c:set var="ukupnaCena" value="${ukupnaCena + stavka.lek.cena * stavka.kolicina}" />
							</c:forEach>
							</td>
							<td>
							<c:forEach var="stavka" items="${kupovina.stavkas }">
							<p>${stavka.lek.cena }</p>
							</c:forEach>
							</td>
							<td>
							<c:forEach var="stavka" items="${kupovina.stavkas }">
							<p>${stavka.kolicina }</p>
							</c:forEach>
							</td>
							<td>${ukupnaCena }</td>
							<td>${kupovina.kurirskaSluzba.naziv }</td>
						</tr>
					</c:forEach>                             
              </tbody>
    </table>
    <form action="/ApotekaWEB/KupovineReportServlet" method="get">
			<button type="submit" id="button"
							class="btn btn-primary btn-lg login-button">Export to pdf</button>
	</form>
    </div>
</div>
</body>
</html>