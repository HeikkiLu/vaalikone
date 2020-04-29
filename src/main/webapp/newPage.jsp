<%@page import="adminpages.AdminControlPanel"%>
<%@page import="adminpages.buttonAction"%>
<%@page import="java.util.List"%>
<%@page import="adminpages.Connector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="adminstyle.css">
    </head>
    <body>
        <div class="wrapper">
            <nav>
                <h2>Lis�� uusi ehdokas</h2>
            </nav>
            
            <% Connector conn = new Connector(); %>
            <% List ehdokas = conn.haeEhdokkaanTiedot(conn.ehdokas); %>
            
            <div class="menu-adduser">
                <form action="/buttonAction" method="get">
                	
                	<!-- NUMERO -->
                    <label for="ehdokasnumero" class="Titles">Ehdokasnumero</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="txt" type="text" name="ehdokasnumero" value="<% out.println(ehdokas.get(9)); %>">
                    <% } else { %>
                    	<input class="txt" type="text" name="ehdokasnumero">
                    <% } %>

					<!-- SUKUNIMI -->
                    <label for="sukunimi" class="Titles">Sukunimi</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="txt" type="text" name="sukunimi" value="<% out.println(ehdokas.get(1)); %>">
                    <% } else { %>
                    	<input class="txt" type="text" name="ehdokasnumero">
                    <% } %>

					<!-- ETUNIMI -->
                    <label for="etunimi" class="Titles">Etunimi</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="txt" type="text" name="etunimi" value="<% out.println(ehdokas.get(2)); %>">
                    <% } else { %>
                    	<input class="txt" type="text" name="etunimi">
                    <% } %>
					
					<!-- PUOLUE -->
                    <label for="puolue" class="Titles">Puolue</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="txt" type="text" name="puolue" value="<% out.println(ehdokas.get(3)); %>">
                    <% } else { %>
                    	<input class="txt" type="text" name="puolue">
                    <% } %>
					
					<!-- PAIKKAKUNTA -->
                    <label for="koti" class="Titles">Kotipaikkakunta</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="txt" type="text" name="kotipaikkakunta" value="<% out.println(ehdokas.get(4)); %>">
                    <% } else { %>
                    <select id="koti" name="kotipaikkakunta" >

                        <label for="null">Valitse kunta</label>
                        <option value="null" >Valitse kunta</option>

                        <optgroup label="Ahvenanmaa">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alaj�rvi</label>
                            <option value="alajarvi">Alaj�rvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Etel�-Karjala">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alaj�rvi</label>
                            <option value="alajarvi">Alaj�rvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Etel�-Pohjanmaa">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alaj�rvi</label>
                            <option value="alajarvi">Alaj�rvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Etel�-Savo">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alaj�rvi</label>
                            <option value="alajarvi">Alaj�rvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Kainuu">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alaj�rvi</label>
                            <option value="alajarvi">Alaj�rvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Keski-Pohjanmaa">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alaj�rvi</label>
                            <option value="alajarvi">Alaj�rvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Keski-Suomi">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alaj�rvi</label>
                            <option value="alajarvi">Alaj�rvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Kymenlaakso">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alaj�rvi</label>
                            <option value="alajarvi">Alaj�rvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>
					
                    </select>
					<% } %>
					
					<!-- IK� -->
                    <label for="ika" class="Titles">Ik�</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="txt" type="text" name="ika" value="<% out.println(ehdokas.get(5)); %>">
                    <% } else { %>
                    	<input class="txt" type="text" name="ika">
                    <% } %>

					<!-- MIKSI -->
                    <label for="miksi" class="Titles">Miksi haluat eduskuntaan?</label>
                    <% if (conn.event == 'H') { %>
                    <textarea rows="5" id="miksi" class="txt" type="text" name="miksieduskuntaan"> <% out.println(ehdokas.get(6)); %> </textarea>
                    <% } else { %>
                    <textarea rows="5" id="miksi" class="txt" type="text" name="miksieduskuntaan"></textarea>
                    <% } %>
                    
					<!-- MIT� -->
                    <label for="mita" class="Titles">Mit� asioita haluat edist��?</label>
                    <% if (conn.event == 'H') { %>
                    <textarea rows="5" id="miksi" class="txt" type="text" name="mitaedistaa"> <% out.println(ehdokas.get(7)); %> </textarea>
                    <% } else { %>
                    <textarea rows="5" id="miksi" class="txt" type="text" name="mitaedistaa"></textarea>
                    <% } %>
					
					<!-- AMMATTI -->
                    <label for="ammatti" class="Titles">Ammatti</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="txt" type="text" name="ammatti" value="<% out.println(ehdokas.get(8)); %>">
                    <% } else { %>
                    	<input class="txt" type="text" name="ammatti">
                    <% } %>
					
					<!-- SUBMIT -->
                    <input class="submit-button" type="submit" name="btn" value="Submit">
                    <input class="submit-button" type="submit" name="btn" value="Hae">
                    <input class="submit-button" type="submit" name="btn" value="ZZZ">
                </form> 
            </div>
        </div>
    </body>
</html>