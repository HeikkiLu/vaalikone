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
        <title>Vaalikone kysymysten lisäys</title>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700&display=swap" rel="stylesheet">
		<script src="https://kit.fontawesome.com/4c791671b3.js" crossorigin="anonymous"></script>
		<script defer src="script.js"></script>
		<link rel="stylesheet" type="text/css" href="adminstyle.css">
    </head>
    <body class="light" onload="getQuestions()">

		<!-- Tuo navigointipalkin sivulle -->
		<jsp:include page="NavBar.jsp"/>
		<jsp:include page="Modal.jsp"/>
		<% EhdokkaatDao.ehdokas = -1; %>

        <div class="wrapper">

			<!-- Tuo headerin sivulle -->
			<jsp:include page="Header.jsp"/>
            
            <div class="container-form">
                <form id="addForm" action="/buttonAction" method="get">
                	<header class="header-form">
						<% if (EhdokkaatDao.confirmAddQuestion) { %>
							<h2 class="success">Kysymys lisätty onnistuneesti</h2>
						<% EhdokkaatDao.confirmAddQuestion = false; %>
						<% } else { %>
							<h2>Lisää kysymys</h2>
						<% } %>
                	</header>

					<input id="kysymys" class="textbox-input" rows="5" type="text" name="kysymys" value="" required>

					<div class="container-buttons">
						<button class="button" name="btn" value="Q" type="button" onclick="sendData()">Lisää</button>
						<button class="button button-clear" name="btn" type="button" onclick="clearFields()">Tyhjennä</button>
					</div>
				</form>
				<hr>
				<h2>Kysymykset</h2>
				<section id="kysymykset">
					<!-- Tänne kysymykset ilmestyy -->
				</section>
			</div>
		</div>
	</body>
</html>