<%@page import="adminpages.AdminControlPanel"%>
<%@page import="adminpages.buttonAction"%>
<%@page import="java.util.List"%>
<%@page import="dao.EhdokkaatDao"%>
<%@page import="persist.Ehdokkaat"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Vaalikone etusivu</title>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700&display=swap" rel="stylesheet">
		<script src="https://kit.fontawesome.com/4c791671b3.js" crossorigin="anonymous"></script>
		<script defer src="script.js"></script>
		<link rel="stylesheet" type="text/css" href="adminstyle.css">
    </head>
    <body class="light">

		<!-- Tuo navigointipalkin sivulle -->
		<jsp:include page="NavBar.jsp"/>
		<% EhdokkaatDao.ehdokas = -1; %>
		
        <div class="wrapper">

			<!-- Tuo headerin sivulle -->
	        <jsp:include page="Header.jsp"/>
			
			<div class="container-mainpage">	
				<header>
					<h2>Tervetuloa Diginide vaalikoneen hallintasivulle</h2>
					<p class="alaotsikko">Vasemmasta reunasta voit valita seuraavia toimintoja</p>
					<ul>
						<li>Uuden ehdokkaan lisäys</li>
						<li>Ehdokkaan muokkaus tai poisto</li>
						<li>Kysymysten lisäys</li>
					</ul>
				</header>
			</div>
		</div>
	</body>
</html>