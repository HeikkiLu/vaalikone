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
		<title>Vaalikone käyttäjän muokkaus</title>
		<script src="script.js"></script>
    </head>
    <body>

		<!-- Tuo navigointipalkin sivulle -->
		<jsp:include page="NavBar.jsp"/>

        <div class="wrapper">

			<!-- Tuo headerin sivulle -->
			<jsp:include page="Header.jsp"/>
            
            <div class="container-form">
                <form id="addForm" action="/buttonAction" method="get">
                	<header class="header-form">
                		<% if (Connector.confirmEdit) { %>
							<h2 class="success">Ehdokas muokattu onnistuneesti</h2>
							<% Connector.confirmEdit = false; %>
						<% } else { %>
							<h2>Muokkaa ehdokasta</h2>
						<% } %>
                	</header>
                    
					<!-- Tuo tekstikentät sivulle -->
					<jsp:include page="FormFields.jsp"/>

					<div class="container-buttons">
						<button class="button" name="btn" value="Hae" type="submit">Hae</button>
						<button class="button" name="btn" value="Yes" type="submit">Päivitä</button>
						<button class="button" name="btn" value="Confirm" type="submit">Poista</button>
						<button class="button" name="btn" type="button" onclick="clearFields()">Tyhjennä</button>
					</div>

				</form>
			</div>
		</div>
	</body>
</html>