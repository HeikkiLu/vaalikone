<%@page import="adminpages.AdminControlPanel"%>
<%@page import="adminpages.buttonAction"%>
<%@page import="java.util.List"%>
<%@page import="adminpages.Connector"%>
<%@page import="persist.Ehdokkaat"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="adminstyle.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700&display=swap" rel="stylesheet">
		<title>Vaalikone kysymysten lisäys</title>
		<script src="script.js"></script>
    </head>
    <body>

		<!-- Tuo navigointipalkin sivulle -->
		<jsp:include page="NavBar.jsp"/>
		<% Connector.ehdokas = -1; %>

        <div class="wrapper">

			<!-- Tuo headerin sivulle -->
			<jsp:include page="Header.jsp"/>
            
            <div class="container-form">
                <form id="addForm" action="/buttonAction" method="get">
                	<header class="header-form">
						<% if (Connector.confirmAddQuestion) { %>
							<h2 class="success">Kysymys lisätty onnistuneesti</h2>
							<% Connector.confirmAddQuestion = false; %>
						<% } else { %>
							<h2>Lisää kysymys</h2>
						<% } %>
                	</header>

					<!-- Tuo tekstikentät sivulle -->
					<textarea id="kysymys" class="textbox-input" rows="5" type="text" name="kysymys" value="" required></textarea>

					<div class="container-buttons">
						<button class="button" name="btn" value="Q" type="submit">Lisää</button>
						<button class="button" name="btn" type="button" onclick="clearFields()">Tyhjennä</button>
					</div>
				</form>

				<ul class="kysymykset">
					<li class="kysymykset-list">Kysymys 1 tähän</li>
					<li class="kysymykset-list">Kysymys 2 tähän</li>
					<li class="kysymykset-list">Kysymys 3 tähän</li>
					<li class="kysymykset-list">Kysymys 4 tähän</li>
					<li class="kysymykset-list">Kysymys 5 tähän</li>
					<li class="kysymykset-list">Kysymys 6 tähän</li>
					<li class="kysymykset-list">jne...</li>
				</ul>
			</div>
		</div>
	</body>
</html>