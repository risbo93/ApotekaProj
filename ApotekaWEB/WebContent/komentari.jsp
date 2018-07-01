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
<title>Komentari</title>
</head>
<body>
<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    <form action="/ApotekaWEB/IndexServlet" method="get"><button type="submit" id="button" class="btn btn-primary btn-xs pull-right">Povratak nazad</button></form>
        <tr>
            <th>Komentar</th>
            <th>Lek</th>
            <th>Osoba</th>
        </tr>
    </thead>
    <tbody>
                <c:forEach var="kom" items="${komentari }">
						<tr>
							<td>${kom.komentar }</td>
							<td>${kom.lek.naziv }</td>
							<td>${kom.osoba.ime } ${kom.osoba.prezime }</td>
						</tr>
					</c:forEach>                             
              </tbody>
    </table>
    <form action="/ApotekaWEB/KomentarServlet" method="post" id="commForm">
    	<input type="text" name="text" class="form-control" placeholder="Tekst komentara"/>
    	<input name="idLeka" type="hidden" value="${odabraniLek }">
    	<button type="submit" id="button" class="btn btn-primary btn-xs pull-left">Komentarisi</button>
    </form>
<script type="text/javascript>">
	var form = document.getElementById('commForm');
	form.onsubmit = function(){
		console.log('nesto');
		//ovako samo zbog testiranja, da vidimo da se okinulo
		return true;
	}
</script>
<h2>${poruka2 }</h2>
    </div>
</div>
</body>
</html>