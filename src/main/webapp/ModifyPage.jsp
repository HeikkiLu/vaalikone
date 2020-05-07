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
        <title>Vaalikone käyttäjän muokkaus</title>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700&display=swap" rel="stylesheet">
		<script src="https://kit.fontawesome.com/4c791671b3.js" crossorigin="anonymous"></script>
		<script defer src="script.js"></script>
		<link rel="stylesheet" type="text/css" href="adminstyle.css">
    </head>
    <body onload="getCandidate()">

		<!-- Tuo navigointipalkin sivulle -->
		<jsp:include page="NavBar.jsp"/>

        <div class="wrapper">

			<!-- Tuo headerin sivulle -->
			<jsp:include page="Header.jsp"/>
            
            <div class="container-form">
                <form id="addForm" action="/buttonAction" method="get">
                	<header class="header-form">
						<% if (EhdokkaatDao.confirmEdit || EhdokkaatDao.confirmDelete) { %>
							<% if (EhdokkaatDao.confirmEdit) { %>
								<h2 class="success">Ehdokas muokattu onnistuneesti</h2>
								<% EhdokkaatDao.confirmEdit = false; %>
							<% } else { %>
								<h2 class="success">Ehdokas poistettu onnistuneesti</h2>
								<% EhdokkaatDao.confirmDelete = false; %>
							<% } %>
						<% } else { %>
							<h2>Muokkaa ehdokasta</h2>
						<% } %>
                	</header>
                    
					<!-- Tuo tekstikentät sivulle -->
					<jsp:include page="FormFields.jsp"/>

					<div class="container-buttons">
						<button class="button" name="btn" value="Hae" type="submit">Hae</button>
						<button class="button" name="btn" value="Yes" type="submit" onclick="getCandidate()">Päivitä</button>
						<button class="button" name="btn" value="Confirm" type="submit">Poista</button>
						<button class="button button-clear" name="btn" type="button" onclick="clearFields()">Tyhjennä</button>
					</div>

				</form>
			</div>
			<hr>
			<h2>Ehdokkaat</h2>
			<section id="ehdokkaat">
				<!-- Tänne ehdokkaat ilmestyy -->
			</section>
		</div>
	</body>
</html>