<%@page import="adminpages.Connector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Admin Control Panel</title>
		<link href="adminstyle.css" rel="stylesheet" type="text/css">
	</head>
	
	<!-- TÄMÄ OLI VANHAN PASKAN SIVUN TOIMINNAN KOKEILUA JSP MUODODSSA -->
	
	<body>
		<form action="/kirjauduUlos" method="GET">
			<td>
				<input id="submitnappi4" type="submit" value="Kirjaudu Ulos" name="btnLogout"/>
			</td>
		</form>
		<center>
			<table border='1' cellpadding='3' cellspacing='0'>
				</tr>
					<th>Ehdokasnumero</th>
					<th>Sukunimi</th>
					<th>Etunimi</th>
					<th>Puolue</th>
					<th>Kotipaikkakunta</th>
					<th>Ikä</th>
					<th>Miksi eduskuntaan</th>
					<th>Mitä edistät</th>
					<th>Ammatti</th>
				</tr>
				<tr>
					<form action="/buttonAction" method="GET">
						<td><textarea rows="10" cols="10" name="ehdokasnumero" placeholder="ehdokas numero"></textarea></td>
						<td><textarea rows="10" cols="21" name="sukunimi" placeholder="sukunimi"></textarea></td>
						<td><textarea rows="10" cols="21" name="etunimi" placeholder="etunimi"></textarea></td>
						<td><textarea rows="10" cols="21" name="puolue" placeholder="puolue"></textarea></td>
						<td><textarea rows="10" cols="21" name="kotipaikkakunta" placeholder="kotipaikkakunta"></textarea></td>
						<td><textarea rows="10" cols="21" name="ika" placeholder="ikä"></textarea></td>
						<td><textarea rows="10" cols="21" name="miksieduskuntaan" placeholder="miksi haluat eduskuntaan?"></textarea></td>
						<td><textarea rows="10" cols="24" name="mitaedistaa" placeholder="mitä asioita haluat edistää?"></textarea></td>
						<td><textarea rows="10" cols="21" name="ammatti" placeholder="ammatti"></textarea></td>
						<td><input type="submit" name="btn" value="Submit"></td>
					</form>
				</tr>
				
				<!-- The shitty way -->
				<% 	
					Connector conn = new Connector();
					out.println(conn.printEdit());
				%>
				
			</table>
		</center>
	</body>
</html>