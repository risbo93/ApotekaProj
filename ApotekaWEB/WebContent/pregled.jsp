<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style class="cp-pen-styles">		body, html {
			margin: 0;
			padding: 0;
			width: 100%;
			height: 100%;
			background-color:#26394E ;
		}

		#menu {
			height: 100%;
			position: fixed;
			background-color: #FED057;
			width: 300px;
			transition: 1000ms all cubic-bezier(0.19, 1, 0.22, 1);
			transform: translateX(-100%);
			left: 60px;
		}

		#menu.expanded {
			transform: translateX(0%);
			left: 0px;
		}

		.menu-inner {
			width: 100%;
			height: 100%;
			position: relative;
		}

		#blob {
			top: 0;
			z-index: -1;
			right: 60px;
			transform: translateX(100%);
			height: 100%;
			position: absolute;
		}

		#blob-path {
			height: 100%;
			fill:  #FED057;
		}

		.hamburger {
			right: 20px;
			position: absolute;
			width: 20px;
			height: 20px;
			margin-top: -10px;	
		}

		.hamburger .line {
			width: 100%;
			height: 4px;
			background-color: #fff;
			position: absolute;
		}

		.hamburger .line:nth-child(2) {
			top: 50%;
			margin-top: -2px;
		}

		.hamburger .line:nth-child(3) {
			bottom: 0;
		}

		h1 {
			position: fixed;
			right: 0;
			margin: 0;
		}

		ul {
			padding: 0;
			list-style: none;
			width: 80%;
			margin-left: 10%;
			position: absolute;
			top: 10px;
		}

		ul li {
			color: #fff;
			font-family: sans-serif;
			padding: 20px 0;
		}

		h2 {
			position: absolute;
		   left: 50%;
      color: #fff;
			margin: 0;
      font-size: 16px;
      font-family: sans-serif;
      font-weight: 100;
		}


	</style>
	<script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/mikel301292/pen/dMYRYZ?limit=all&page=12&q=svg" />
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="index.css">
<title>Index</title>
</head>
<body>
<div id="menu">
		<div class="hamburger">
			<div class="line"></div>
			<div class="line"></div>
			<div class="line"></div>
			<div class="line"></div>
		</div>
		<div class="menu-inner">
			
			<ul>
				<li><form action="/ApotekaWEB/IndexServlet" method="get"><button type="submit" id="button" class="btn btn-primary btn-lg login-button">Pocetna</button></form></li>
				<li><form action="/ApotekaWEB/BrisanjeServlet" method="get"><button type="submit" id="button" class="btn btn-primary btn-lg login-button">Pregled Lekova</button></form></li>
				<li><form action="/ApotekaWEB/DodavanjeLekaServlet" method="get"><button type="submit" id="button" class="btn btn-primary btn-lg login-button">Dodavanje Leka</button></form></li>
				<li><form action="/ApotekaWEB/ReportServlet" method="get"><button type="submit" id="button" class="btn btn-primary btn-lg login-button">PDF Cenovnik</button></form></li>
				<li><form action="/ApotekaWEB/ImenikServlet" method="get"><button type="submit" id="button" class="btn btn-primary btn-lg login-button">PDF Imenik</button></form></li>
			</ul>
		</div>
  
  
		
		<svg version="1.1" id="blob"xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
			<path id="blob-path" d="M60,500H0V0h60c0,0,20,172,20,250S60,900,60,500z"/>
		</svg>
	</div>


<h2> Dobrodosli u online apoteku!</h2>


<script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script><script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script >$(window).load(function(){
	var height = window.innerHeight,
  x= 0, y= height/2,
	curveX = 10,
	curveY = 0,
	targetX = 0,
	xitteration = 0,
	yitteration = 0,
	menuExpanded = false;
	
	blob = $('#blob'),
	blobPath = $('#blob-path'),

	hamburger = $('.hamburger');

	$(this).on('mousemove', function(e){
		x = e.pageX;
		
		y = e.pageY;
	});

	$('.hamburger, .menu-inner').on('mouseenter', function(){
		$(this).parent().addClass('expanded');
		menuExpanded = true;
	});

	$('.menu-inner').on('mouseleave', function(){
		menuExpanded = false;
		$(this).parent().removeClass('expanded');
	});

	function easeOutExpo(currentIteration, startValue, changeInValue, totalIterations) {
		return changeInValue * (-Math.pow(2, -10 * currentIteration / totalIterations) + 1) + startValue;
	}

	var hoverZone = 150;
	var expandAmount = 20;
	
	function svgCurve() {
		if ((curveX > x-1) && (curveX < x+1)) {
			xitteration = 0;
		} else {
			if (menuExpanded) {
				targetX = 0;
			} else {
				xitteration = 0;
				if (x > hoverZone) {
					targetX = 0;
				} else {
					targetX = -(((60+expandAmount)/100)*(x-hoverZone));
				}			
			}
			xitteration++;
		}

		if ((curveY > y-1) && (curveY < y+1)) {
			yitteration = 0;
		} else {
			yitteration = 0;
			yitteration++;	
		}

		curveX = easeOutExpo(xitteration, curveX, targetX-curveX, 100);
		curveY = easeOutExpo(yitteration, curveY, y-curveY, 100);

		var anchorDistance = 200;
		var curviness = anchorDistance - 40;

		var newCurve2 = "M60,"+height+"H0V0h60v"+(curveY-anchorDistance)+"c0,"+curviness+","+curveX+","+curviness+","+curveX+","+anchorDistance+"S60,"+(curveY)+",60,"+(curveY+(anchorDistance*2))+"V"+height+"z";

		blobPath.attr('d', newCurve2);

		blob.width(curveX+60);

		hamburger.css('transform', 'translate('+curveX+'px, '+curveY+'px)');
    
    $('h2').css('transform', 'translateY('+curveY+'px)');
		window.requestAnimationFrame(svgCurve);
	}

	window.requestAnimationFrame(svgCurve);
	
});
//# sourceURL=pen.js
</script>
</body>
</html>
