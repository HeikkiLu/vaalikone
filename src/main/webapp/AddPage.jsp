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
		<title>Vaalikone käyttäjän lisäys</title>
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
						<% if (Connector.confirmAdd) { %>
							<h2 class="success">Ehdokas lisätty onnistuneesti</h2>
							<% Connector.confirmAdd = false; %>
						<% } else { %>
							<h2>Lisää ehdokas</h2>
						<% } %>
                	</header>

					<!-- Tuo tekstikentät sivulle -->
					<jsp:include page="AddFormFields.jsp"/>

					<div class="container-buttons">
						<button class="button" name="btn" value="Submit" type="submit">Lisää</button>
						<button class="button" name="btn" type="button" onclick="clearFields()">Tyhjennä</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>