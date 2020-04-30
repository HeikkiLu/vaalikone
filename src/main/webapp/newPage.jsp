<%@page import="adminpages.AdminControlPanel"%>
<%@page import="adminpages.buttonAction"%>
<%@page import="java.util.List"%>
<%@page import="adminpages.Connector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="adminstyle.css">
    </head>
    <body>
        <div class="wrapper">
        
        

            <% Connector conn = new Connector(); %>
            <% List ehdokas = conn.haeEhdokkaanTiedot(conn.ehdokas); %>
            
            <div class="container-photo">
            	<!-- Tähän ehdokkaan kuva jos ehtii -->
				<form action="/kirjauduUlos" method="GET">
					<input class="button-logout" type="submit" value="Kirjaudu Ulos" name="btnLogout"/>
				</form>
            </div>
            
            <div class="container-form">
                <form action="/buttonAction" method="get">
                	<header class="header-form">
                		<h2>Vaalikoneen hallinta</h2>
                		
                	</header>
		            
		            <!-- if (conn.event == 'H') == Hae-nappia painettiin, näytä ehdokkaan tiedot kentässä -->

                	<!-- NUMERO -->
                    <label for="ehdokasnumero" class="textbox-label">Ehdokasnumero</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="ehdokasnumero" value="<% out.println(ehdokas.get(9)); %>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="ehdokasnumero" required>
                    <% } %>

					<!-- SUKUNIMI -->
                    <label for="sukunimi" class="textbox-label">Sukunimi</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="sukunimi" value="<% out.println(ehdokas.get(1)); %>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="ehdokasnumero">
                    <% } %>

					<!-- ETUNIMI -->
                    <label for="etunimi" class="textbox-label">Etunimi</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="etunimi" value="<% out.println(ehdokas.get(2)); %>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="etunimi">
                    <% } %>
					
					<!-- PUOLUE -->
                    <label for="puolue" class="textbox-label">Puolue</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="puolue" value="<% out.println(ehdokas.get(3)); %>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="puolue">
                    <% } %>
					
					<!-- PAIKKAKUNTA -->
                    <label for="koti" class="textbox-label">Kotipaikkakunta</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="kotipaikkakunta" value="<% out.println(ehdokas.get(4)); %>">
                    <% } else { %>
                    <select class="textbox-input" name="kotipaikkakunta" >

                        <label for="null">Valitse kunta</label>
                        <option value="null" >Valitse kunta</option>

                        <optgroup label="Ahvenanmaa">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alajärvi</label>
                            <option value="alajarvi">Alajärvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Etelä-Karjala">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alajärvi</label>
                            <option value="alajarvi">Alajärvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Etelä-Pohjanmaa">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alajärvi</label>
                            <option value="alajarvi">Alajärvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Etelä-Savo">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alajärvi</label>
                            <option value="alajarvi">Alajärvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Kainuu">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alajärvi</label>
                            <option value="alajarvi">Alajärvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Keski-Pohjanmaa">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alajärvi</label>
                            <option value="alajarvi">Alajärvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Keski-Suomi">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alajärvi</label>
                            <option value="alajarvi">Alajärvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>

                        <optgroup label="Kymenlaakso">
                            <label for="Akaa">Akaa</label>
                            <option value="Akaa">Akaa</option>

                            <label for="alajarvi">Alajärvi</label>
                            <option value="alajarvi">Alajärvi</option>

                            <label for="alavus">Alavus</label>
                            <option value="alavus">Alavus</option>

                            <label for="Aapeli">Aapeli</label>
                            <option value="aapeli">Aapeli</option>
                        </optgroup>
					
                    </select>
					<% } %>
					
					<!-- IKÄ -->
                    <label for="ika" class="textbox-label">Ikä</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="ika" value="<% out.println(ehdokas.get(5)); %>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="ika">
                    <% } %>

					<!-- MIKSI -->
                    <label for="miksi" class="textbox-label">Miksi haluat eduskuntaan?</label>
                    <% if (conn.event == 'H') { %>
                    <textarea rows="5" id="miksi" class="textbox-input" type="text" name="miksieduskuntaan"> <% out.println(ehdokas.get(6)); %> </textarea>
                    <% } else { %>
                    <textarea rows="5" id="miksi" class="textbox-input" type="text" name="miksieduskuntaan"></textarea>
                    <% } %>
                    
					<!-- MITÄ -->
                    <label for="mita" class="textbox-label">Mitä asioita haluat edistää?</label>
                    <% if (conn.event == 'H') { %>
                    <textarea rows="5" id="miksi" class="textbox-input" type="text" name="mitaedistaa"> <% out.println(ehdokas.get(7)); %> </textarea>
                    <% } else { %>
                    <textarea rows="5" id="miksi" class="textbox-input" type="text" name="mitaedistaa"></textarea>
                    <% } %>
					
					<!-- AMMATTI -->
                    <label for="ammatti" class="textbox-label">Ammatti</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="ammatti" value="<% out.println(ehdokas.get(8)); %>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="ammatti">
                    <% } %>
                    
                   	<!-- 
                   	Napeille voitaisiin miettiä järkevämmät arvot kun toi char[0]
                   	Esim numerot, value-kohtaan 1-5
                   	 -->
                    
                    <div class="container-buttons">
	                    <button class="button" name="btn" value="Submit" type="submit">Lisää</button>
	                    <button class="button" name="btn" value="Hae" type="submit">Hae</button>
	                    <button class="button" name="btn" value="Yes" type="submit">Päivitä</button>
	                    <button class="button" name="btn" value="Confirm" type="submit">Poista</button>
	                    <button class="button" name="btn" value="ZZZ" type="submit">Tyhjennä</button>
                    </div>
                    
                </form> 
            </div>
            <div class="container-protip">
            	<p>Lisää uusi ehdokas täyttämällä kenttiin ehdokkaan tiedot, ja painamalla "Lisää"-painiketta.</p>
            	<p>Hae ehdokasta syöttämällä Ehdokasnumero-kenttään ehdokkaan numero, ja painamalla "Hae"-painiketta.</p>
            	<p>Päivitä ehdokkaan tiedot ensin hakemalla ehdokasta (ohjeet yllä), muuttamalla tietoja, ja painamalla "Päivitä"-painiketta</p>
            	<p>Poista ehdokas hakemalla ehdokasta (ohjeet yllä), ja painamalla "Poista"-painiketta.</p>
            </div>
        </div>
    </body>
</html>