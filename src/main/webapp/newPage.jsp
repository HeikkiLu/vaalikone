<%@page import="adminpages.AdminControlPanel"%>
<%@page import="adminpages.buttonAction"%>
<%@page import="java.util.List"%>
<%@page import="adminpages.Connector"%>
<%@page import="persist.Ehdokkaat"%>
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
        	
        	<!-- Haetaan ehdokas-olio jolloin voidaan käyttää gettereitä tiedon hakuun 
        		Tällä hetkellä haku tapahtuu ID:n perusteella, eli syötä Ehdokasnumero kenttään EHDOKAS_ID jotta homma toimii
        		Täytyy tehdä rakentaja Ehdokkaat-luokkaan jotta voidaan hakea ehdokasnumerolla
        	-->
            <% Connector conn = new Connector(); %>
            <% //List ehdokas = conn.haeEhdokkaanTiedot(conn.ehdokas); %>
            <% Ehdokkaat ehdokasJPA = conn.findEhdokas(conn.ehdokas); %>
            
            
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
                    	<input class="textbox-input" type="text" name="ehdokasnumero" value="<% 
                    	// out.println(ehdokas.get(9)); // RESULTSET
                    	if (ehdokasJPA != null) { out.println(ehdokasJPA.getEhdokasId()); } // JPA
                    	%>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="ehdokasnumero" required>
                    <% } %>

					<!-- SUKUNIMI -->
                    <label for="sukunimi" class="textbox-label">Sukunimi</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="sukunimi" value=" <% 
                    	//out.println(ehdokas.get(1)); // RESULTSET
                    	if (ehdokasJPA != null) { out.println(ehdokasJPA.getSukunimi()); } // JPA
                    	%>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="ehdokasnumero">
                    <% } %>

					<!-- ETUNIMI -->
                    <label for="etunimi" class="textbox-label">Etunimi</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="etunimi" value="<% 
                    	//out.println(ehdokas.get(2)); // RESULTSET 
                    	if (ehdokasJPA != null) { out.println(ehdokasJPA.getEtunimi()); } // JPA
                    	%>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="etunimi">
                    <% } %>
					
					<!-- PUOLUE -->
                    <label for="puolue" class="textbox-label">Puolue</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="puolue" value="<% 
                    	//out.println(ehdokas.get(3)); // RESULTSET
                    	if (ehdokasJPA != null) { out.println(ehdokasJPA.getPuolue()); } // JPA
                    	%>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="puolue">
                    <% } %>
					
					<!-- PAIKKAKUNTA -->
                    <label for="koti" class="textbox-label">Kotipaikkakunta</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="kotipaikkakunta" value="<% 
                    	//out.println(ehdokas.get(4)); // RESULTSET 
                    	if (ehdokasJPA != null) { out.println(ehdokasJPA.getKotipaikkakunta()); } // JPA
                    	%>">
                    <% } else { %>
                    <select class="textbox-input" name="kotipaikkakunta" >

                        <label for="null">Valitse kunta</label>
                        <option value="null" >Valitse kunta</option>

					<optgroup label="Ahvenanmaa">
						<label for="Brändö">Brändö</label>
						<option value="Brändö">Brändö</option>
						<label for="Eckerö">Eckerö</label>
						<option value="Eckerö">Eckerö</option>
						<label for="Finström">Finström</label>
						<option value="Finström">Finström</option>
						<label for="Föglö">Föglö</label>
						<option value="Föglö">Föglö</option>
						<label for="Geta">Geta</label>
						<option value="Geta">Geta</option>
						<label for="Hammarland">Hammarland</label>
						<option value="Hammarland">Hammarland</option>
						<label for="Jomala">Jomala</label>
						<option value="Jomala">Jomala</option>
						<label for="Kumlinge">Kumlinge</label>
						<option value="Kumlinge">Kumlinge</option>
						<label for="Kökar">Kökar</label>
						<option value="Kökar">Kökar</option>
					</optgroup>
					<optgroup label="Etelä-Pohjanmaa">
						<label for="Seinäjoki">Seinäjoki</label>
						<option value="Seinäjoki">Seinäjoki</option>
						<label for="Kurikka">Kurikka</label>
						<option value="Kurikka">Kurikka</option>
						<label for="Ilmajoki">Ilmajoki</label>
						<option value="Ilmajoki">Ilmajoki</option>
						<label for="Lapua">Lapua</label>
						<option value="Lapua">Lapua</option>
						<label for="Kauhajoki">Kauhajoki</label>
						<option value="Kauhajoki">Kauhajoki</option>
						<label for="Kauhava">Kauhava</label>
						<option value="Kauhava">Kauhava</option>
						<label for="Alajärvi">Alajärvi</label>
						<option value="Alajärvi">Alajärvi</option>
						<label for="Alavus">Alavus</label>
						<option value="Alavus">Alavus</option>
						<label for="Ähtäri">Ähtäri</label>
						<option value="Ähtäri">Ähtäri</option>
						<label for="Kurikka">Kurikka</label>
						<option value="Kurikka">Kurikka</option>
						<label for="Teuva">Teuva</label>
						<option value="Teuva">Teuva</option>
					</optgroup>
					<optgroup label="Etelä-Savo">
						<label for="Enonkoski">Enonkoski</label>
						<option value="Enonkoski">Enonkoski</option>
						<label for="Heinävesi">Heinävesi</label>
						<option value="Heinävesi">Heinävesi</option>
						<label for="Hirvensalmi">Hirvensalmi</label>
						<option value="Hirvensalmi">Hirvensalmi</option>
						<label for="Joroinen">Joroinen</label>
						<option value="Joroinen">Joroinen</option>
						<label for="Juva">Juva</label>
						<option value="Juva">Juva</option>
						<label for="Kangasniemi">Kangasniemi</label>
						<option value="Kangasniemi">Kangasniemi</option>
						<label for="Mikkeli">Mikkeli</label>
						<option value="Mikkeli">Mikkeli</option>
						<label for="Mäntyharju">Mäntyharju</label>
						<option value="Mäntyharju">Mäntyharju</option>
						<label for="Pertunmaa">Pertunmaa</label>
						<option value="Pertunmaa">Pertunmaa</option>
						<label for="Pieksämäki">Pieksämäki</label>
						<option value="Pieksämäki">Pieksämäki</option>
						<label for="Puumala">Puumala</label>
						<option value="Puumala">Puumala</option>
						<label for="Rantasalmi">Rantasalmi</label>
						<option value="Rantasalmi">Rantasalmi</option>
						<label for="Savonlinna">Savonlinna</label>
						<option value="Savonlinna">Savonlinna</option>
						<label for="Sulkava">Sulkava</label>
						<option value="Sulkava">Sulkava</option>
					</optgroup>
					<optgroup label="Kainuu">
						<label for="Hyrynsalmi">Hyrynsalmi</label>
						<option value="Hyrynsalmi">Hyrynsalmi</option>
						<label for="Kajaani">Kajaani</label>
						<option value="Kajaani">Kajaani</option>
						<label for="Kuhmo">Kuhmo</label>
						<option value="Kuhmo">Kuhmo</option>
						<label for="Paltamo">Paltamo</label>
						<option value="Paltamo">Paltamo</option>
						<label for="Puolanka">Puolanka</label>
						<option value="Puolanka">Puolanka</option>
						<label for="Ristijärvi">Ristijärvi</label>
						<option value="Ristijärvi">Ristijärvi</option>
						<label for="Sotkamo">Sotkamo</label>
						<option value="Sotkamo">Sotkamo</option>
						<label for="Suomussalmi">Suomussalmi</label>
						<option value="Suomussalmi">Suomussalmi</option>
					</optgroup>
					<optgroup label="Kanta-Häme">
						<label for="Forssa">Forssa</label>
						<option value="Forssa">Forssa</option>
						<label for="Hattula">Hattula</label>
						<option value="Hattula">Hattula</option>
						<label for="Hausjärvi">Hausjärvi</label>
						<option value="Hausjärvi">Hausjärvi</option>
						<label for="Humppila">Humppila</label>
						<option value="Humppila">Humppila</option>
						<label for="Hämeenlinna">Hämeenlinna</label>
						<option value="Hämeenlinna">Hämeenlinna</option>
						<label for="Janakkala">Janakkala</label>
						<option value="Janakkala">Janakkala</option>
						<label for="Jokioinen">Jokioinen</label>
						<option value="Jokioinen">Jokioinen</option>
						<label for="Loppi">Loppi</label>
						<option value="Loppi">Loppi</option>
						<label for="Riihimäki">Riihimäki</label>
						<option value="Riihimäki">Riihimäki</option>
						<label for="Tammela">Tammela</label>
						<option value="Tammela">Tammela</option>
						<label for="Ypäjä">Ypäjä</label>
						<option value="Ypäjä">Ypäjä</option>
					</optgroup>
					<optgroup label="Keski-Pohjanmaa">
						<label for="Halsua">Halsua</label>
						<option value="Halsua">Halsua</option>
						<label for="Kannus">Kannus</label>
						<option value="Kannus">Kannus</option>
						<label for="Kaustinen">Kaustinen</label>
						<option value="Kaustinen">Kaustinen</option>
						<label for="Kokkola">Kokkola</label>
						<option value="Kokkola">Kokkola</option>
						<label for="Lestijärvi">Lestijärvi</label>
						<option value="Lestijärvi">Lestijärvi</option>
						<label for="Perho">Perho</label>
						<option value="Perho">Perho</option>
						<label for="Toholampi">Toholampi</label>
						<option value="Toholampi">Toholampi</option>
						<label for="Veteli">Veteli</label>
						<option value="Veteli">Veteli</option>
					</optgroup>
					<optgroup label="Keski-Suomi">
						<option value="Hankasalmi">Hankasalmi</option>
						<label for="Joutsa">Joutsa</label>
						<option value="Joutsa">Joutsa</option>
						<label for="Jyväskylä">Jyväskylä</label>
						<option value="Jyväskylä">Jyväskylä</option>
						<label for="Jämsä">Jämsä</label>
						<option value="Jämsä">Jämsä</option>
						<label for="Kannonkoski">Kannonkoski</label>
						<option value="Kannonkoski">Kannonkoski</option>
						<label for="Karstula">Karstula</label>
						<option value="Karstula">Karstula</option>
						<label for="Keuruu">Keuruu</label>
						<option value="Keuruu">Keuruu</option>
						<label for="Kinnula">Kinnula</label>
						<option value="Kinnula">Kinnula</option>
						<label for="Kivijärvi">Kivijärvi</label>
						<option value="Kivijärvi">Kivijärvi</option>
						<label for="Konnevesi">Konnevesi</label>
						<option value="Konnevesi">Konnevesi</option>
						<label for="Kuhmoinen">Kuhmoinen</label>
						<option value="Kuhmoinen">Kuhmoinen</option>
						<label for="Kyyjärvi">Kyyjärvi</label>
						<option value="Kyyjärvi">Kyyjärvi</option>
						<label for="Laukaa">Laukaa</label>
						<option value="Laukaa">Laukaa</option>
						<label for="Luhanka">Luhanka</label>
						<option value="Luhanka">Luhanka</option>
						<label for="Multia">Multia</label>
						<option value="Multia">Multia</option>
						<label for="Muurame">Muurame</label>
						<option value="Muurame">Muurame</option>
						<label for="Petäjävesi">Petäjävesi</label>
						<option value="Petäjävesi">Petäjävesi</option>
						<label for="Pihtipudas">Pihtipudas</label>
						<option value="Pihtipudas">Pihtipudas</option>
						<label for="Saarijärvi">Saarijärvi</label>
						<option value="Saarijärvi">Saarijärvi</option>
						<label for="Toivakka">Toivakka</label>
						<option value="Toivakka">Toivakka</option>
						<label for="Uurainen">Uurainen</label>
						<option value="Uurainen">Uurainen</option>
						<label for="Viitasaari">Viitasaari</label>
						<option value="Viitasaari">Viitasaari</option>
						<label for="Äänekoski">Äänekoski</label>
						<option value="Äänekoski">Äänekoski</option>
					</optgroup>
					<optgroup label="Kymenlaakso">
						<label for="Hamina">Hamina</label>
						<option value="Hamina">Hamina</option>
						<label for="Iitti">Iitti</label>
						<option value="Iitti">Iitti</option>
						<label for="Kotka">Kotka</label>
						<option value="Kotka">Kotka</option>
						<label for="Kouvola">Kouvola</label>
						<option value="Kouvola">Kouvola</option>
						<label for="Miehikkala">Miehikkala</label>
						<option value="Miehikkala">Miehikkala</option>
						<label for="Pyhtää">Pyhtää</label>
						<option value="Pyhtää">Pyhtää</option>
						<label for="Virolahti">Virolahti</label>
						<option value="Virolahti">Virolahti</option>
					</optgroup>
					<optgroup label="Lappi">
						<label for="Enontekiö">Enontekiö</label>
						<option value="Enontekiö">Enontekiö</option>
						<label for="Inari">Inari</label>
						<option value="Inari">Inari</option>
						<label for="Kemi">Kemi</label>
						<option value="Kemi">Kemi</option>
						<label for="Kemijärvi">Kemijärvi</label>
						<option value="Kemijärvi">Kemijärvi</option>
						<label for="Keminmaa">Keminmaa</label>
						<option value="Keminmaa">Keminmaa</option>
						<label for="Kittilä">Kittilä</label>
						<option value="Kittilä">Kittilä</option>
						<label for="Kolari">Kolari</label>
						<option value="Kolari">Kolari</option>
						<label for="Muonio">Muonio</label>
						<option value="Muonio">Muonio</option>
						<label for="Pelkosenniemi">Pelkosenniemi</label>
						<option value="Pelkosenniemi">Pelkosenniemi</option>
						<label for="Pello">Pello</label>
						<option value="Pello">Pello</option>
						<label for="Posio">Posio</label>
						<option value="Posio">Posio</option>
						<label for="Ranua">Ranua</label>
						<option value="Ranua">Ranua</option>
						<label for="Rovaniemi">Rovaniemi</label>
						<option value="Rovaniemi">Rovaniemi</option>
						<label for="Salla">Salla</label>
						<option value="Salla">Salla</option>
						<label for="Savukoski">Savukoski</label>
						<option value="Savukoski">Savukoski</option>
						<label for="Simo">Simo</label>
						<option value="Simo">Simo</option>
						<label for="Sodankylä">Sodankylä</label>
						<option value="Sodankylä">Sodankylä</option>
						<label for="Tervola">Tervola</label>
						<option value="Tervola">Tervola</option>
						<label for="Tornio">Tornio</label>
						<option value="Tornio">Tornio</option>
						<label for="Utsjoki">Utsjoki</label>
						<option value="Utsjoki">Utsjoki</option>
						<label for="Ylitornio">Ylitornio</label>
						<option value="Ylitornio">Ylitornio</option>
					</optgroup>
					<optgroup label="Pirkanmaa">
						<label for="Akaa">Akaa</label>
						<option value="Akaa">Akaa</option>
						<label for="Hämeenkyrö">Hämeenkyrö</label>
						<option value="Hämeenkyrö">Hämeenkyrö</option>
						<label for="Ikaalinen">Ikaalinen</label>
						<option value="Ikaalinen">Ikaalinen</option>
						<label for="Juupajoki">Juupajoki</label>
						<option value="Juupajoki">Juupajoki</option>
						<label for="Kangasala">Kangasala</label>
						<option value="Kangasala">Kangasala</option>
						<label for="Kihniö">Kihniö</label>
						<option value="Kihniö">Kihniö</option>
						<label for="Lempäälä">Lempäälä</label>
						<option value="Lempäälä">Lempäälä</option>
						<label for="Mänttä-Vilppula">Mänttä-Vilppula</label>
						<option value="Mänttä-Vilppula">Mänttä-Vilppula</option>
						<label for="Nokia">Nokia</label>
						<option value="Nokia">Nokia</option>
						<label for="Orivesi">Orivesi</label>
						<option value="Orivesi">Orivesi</option>
						<label for="Parkano">Parkano</label>
						<option value="Parkano">Parkano</option>
						<label for="Pirkkala">Pirkkala</label>
						<option value="Pirkkala">Pirkkala</option>
						<label for="Punkalaidun">Punkalaidun</label>
						<option value="Punkalaidun">Punkalaidun</option>
						<label for="Pälkäne">Pälkäne</label>
						<option value="Pälkäne">Pälkäne</option>
						<label for="Ruovesi">Ruovesi</label>
						<option value="Ruovesi">Ruovesi</option>
						<label for="Sastamala">Sastamala</label>
						<option value="Sastamala">Sastamala</option>
						<label for="Tampere">Tampere</label>
						<option value="Tampere">Tampere</option>
						<label for="Urjala">Urjala</label>
						<option value="Urjala">Urjala</option>
						<label for="Valkeakoski">Valkeakoski</label>
						<option value="Valkeakoski">Valkeakoski</option>
						<label for="Vesilahti">Vesilahti</label>
						<option value="Vesilahti">Vesilahti</option>
						<label for="Virrat">Virrat</label>
						<option value="Virrat">Virrat</option>
						<label for="Ylöjärvi">Ylöjärvi</label>
						<option value="Ylöjärvi">Ylöjärvi</option>
					</optgroup>
					<optgroup label="Pohjanmaa">
						<label for="Isokyrö">Isokyrö</label>
						<option value="Isokyrö">Isokyrö</option>
						<label for="Kaskinen">Kaskinen</label>
						<option value="Kaskinen">Kaskinen</option>
						<label for="Kristiinankaupunki">Kristiinankaupunki</label>
						<option value="Kristiinankaupunki">Kristiinankaupunki</option>
						<label for="Kruunupyy">Kruunupyy</label>
						<option value="Kruunupyy">Kruunupyy</option>
						<label for="Laihia">Laihia</label>
						<option value="Laihia">Laihia</option>
						<label for="Luoto">Luoto</label>
						<option value="Luoto">Luoto</option>
						<label for="Maalahti">Maalahti</label>
						<option value="Maalahti">Maalahti</option>
						<label for="Mustasaari">Mustasaari</label>
						<option value="Mustasaari">Mustasaari</option>
						<label for="Närpiö">Närpiö</label>
						<option value="Närpiö">Närpiö</option>
						<label for="Pedersören kunta">Pedersören kunta</label>
						<option value="Pedersören kunta">Pedersören kunta</option>
						<label for="Pietarsaari">Pietarsaari</label>
						<option value="Pietarsaari">Pietarsaari</option>
						<label for="Uusikaarlepyy">Uusikaarlepyy</label>
						<option value="Uusikaarlepyy">Uusikaarlepyy</option>
						<label for="Vaasa">Vaasa</label>
						<option value="Vaasa">Vaasa</option>
						<label for="Vöyri">Vöyri</label>
						<option value="Vöyri">Vöyri</option>
					</optgroup>
					<optgroup label="Pohjois-Karjala">
						<label for="Ilomantsi">Ilomantsi</label>
						<option value="Ilomantsi">Ilomantsi</option>
						<label for="Joensuu">Joensuu</label>
						<option value="Joensuu">Joensuu</option>
						<label for="Juuka">Juuka</label>
						<option value="Juuka">Juuka</option>
						<label for="Kitee">Kitee</label>
						<option value="Kitee">Kitee</option>
						<label for="Kontiolahti">Kontiolahti</label>
						<option value="Kontiolahti">Kontiolahti</option>
						<label for="Lieksa">Lieksa</label>
						<option value="Lieksa">Lieksa</option>
						<label for="Liperi">Liperi</label>
						<option value="Liperi">Liperi</option>
						<label for="Nurmes">Nurmes</label>
						<option value="Nurmes">Nurmes</option>
						<label for="Outokumpu">Outokumpu</label>
						<option value="Outokumpu">Outokumpu</option>
						<label for="Polvijärvi">Polvijärvi</label>
						<option value="Polvijärvi">Polvijärvi</option>
						<label for="Rääkkylä">Rääkkylä</label>
						<option value="Rääkkylä">Rääkkylä</option>
						<label for="Tohmajärvi">Tohmajärvi</label>
						<option value="Tohmajärvi">Tohmajärvi</option>
					</optgroup>
					<optgroup label="Pohjois-Pohjanmaa">
						<label for="Alavieska">Alavieska</label>
						<option value="Alavieska">Alavieska</option>
						<label for="Haapajäri">Haapajäri</label>
						<option value="Haapajäri">Haapajäri</option>
						<label for="Haapavesi">Haapavesi</label>
						<option value="Haapavesi">Haapavesi</option>
						<label for="Hailuoto">Hailuoto</label>
						<option value="Hailuoto">Hailuoto</option>
						<label for="Ii">Ii</label>
						<option value="Ii">Ii</option>
						<label for="Kalajoki">Kalajoki</label>
						<option value="Kalajoki">Kalajoki</option>
						<label for="Kempele">Kempele</label>
						<option value="Kempele">Kempele</option>
						<label for="Kuusamo">Kuusamo</label>
						<option value="Kuusamo">Kuusamo</option>
						<label for="Kärsämäki">Kärsämäki</label>
						<option value="Kärsämäki">Kärsämäki</option>
						<label for="Liminka">Liminka</label>
						<option value="Liminka">Liminka</option>
						<label for="Lumijoki">Lumijoki</label>
						<option value="Lumijoki">Lumijoki</option>
						<label for="Merijärvi">Merijärvi</label>
						<option value="Merijärvi">Merijärvi</option>
						<label for="Muhos">Muhos</label>
						<option value="Muhos">Muhos</option>
						<label for="Nivalan ">Nivalan </label>
						<option value="Nivalan ">Nivalan</option>
						<label for="Oulainen">Oulainen</label>
						<option value="Oulainen">Oulainen</option>
						<label for="Oulun ">Oulun </label>
						<option value="Oulun ">Oulun</option>
						<label for="Pudasjärvi">Pudasjärvi</label>
						<option value="Pudasjärvi">Pudasjärvi</option>
						<label for="Pyhäjoki">Pyhäjoki</label>
						<option value="Pyhäjoki">Pyhäjoki</option>
						<label for="Pyhäjärvi">Pyhäjärvi</label>
						<option value="Pyhäjärvi">Pyhäjärvi</option>
						<label for="Pyhäjärvi">Pyhäjärvi</label>
						<option value="Pyhäjärvi">Pyhäjärvi</option>
						<label for="Pyhäntä">Pyhäntä</label>
						<option value="Pyhäntä">Pyhäntä</option>
						<label for="Raahe">Raahe</label>
						<option value="Raahe">Raahe</option>
						<label for="Reisjärvi">Reisjärvi</label>
						<option value="Reisjärvi">Reisjärvi</option>
						<label for="Sievi">Sievi</label>
						<option value="Sievi">Sievi</option>
						<label for="Siikajoki">Siikajoki</label>
						<option value="Siikajoki">Siikajoki</option>
						<label for="Siikalatva">Siikalatva</label>
						<option value="Siikalatva">Siikalatva</option>
						<label for="Taivalkoski">Taivalkoski</label>
						<option value="Taivalkoski">Taivalkoski</option>
						<label for="Tyrnävä">Tyrnävä</label>
						<option value="Tyrnävä">Tyrnävä</option>
						<label for="Utajärvi">Utajärvi</label>
						<option value="Utajärvi">Utajärvi</option>
						<label for="Vaala">Vaala</label>
						<option value="Vaala">Vaala</option>
						<label for="Ylivieska">Ylivieska</label>
						<option value="Ylivieska">Ylivieska</option>
					</optgroup>
					<optgroup label="Pohjois-Savo">
						<label for="Iisalmi">Iisalmi</label>
						<option value="Iisalmi">Iisalmi</option>
						<label for="Kaavi">Kaavi</label>
						<option value="Kaavi">Kaavi</option>
						<label for="Keitele">Keitele</label>
						<option value="Keitele">Keitele</option>
						<label for="Kiuruvesi">Kiuruvesi</label>
						<option value="Kiuruvesi">Kiuruvesi</option>
						<label for="Kuopio">Kuopio</label>
						<option value="Kuopio">Kuopio</option>
						<label for="Lapinlahti">Lapinlahti</label>
						<option value="Lapinlahti">Lapinlahti</option>
						<label for="Leppävirta">Leppävirta</label>
						<option value="Leppävirta">Leppävirta</option>
						<label for="Pielavesi">Pielavesi</label>
						<option value="Pielavesi">Pielavesi</option>
						<label for="Rautalampi">Rautalampi</label>
						<option value="Rautalampi">Rautalampi</option>
						<label for="Rautavaara">Rautavaara</label>
						<option value="Rautavaara">Rautavaara</option>
						<label for="Siilinjärvi">Siilinjärvi</label>
						<option value="Siilinjärvi">Siilinjärvi</option>
						<label for="Sonkajärvi">Sonkajärvi</label>
						<option value="Sonkajärvi">Sonkajärvi</option>
						<label for="Suonenjoki">Suonenjoki</label>
						<option value="Suonenjoki">Suonenjoki</option>
						<label for="Tervo">Tervo</label>
						<option value="Tervo">Tervo</option>
						<label for="Tuusniemi">Tuusniemi</label>
						<option value="Tuusniemi">Tuusniemi</option>
						<label for="Varkaus">Varkaus</label>
						<option value="Varkaus">Varkaus</option>
						<label for="Vesanto">Vesanto</label>
						<option value="Vesanto">Vesanto</option>
						<label for="Vieremä">Vieremä</label>
						<option value="Vieremä">Vieremä</option>
					</optgroup>
					<optgroup label="Etelä-Karjala">
						<label for="Imatra">Imatra</label>
						<option value="Imatra">Imatra</option>
						<label for="Lappeenranta">Lappeenranta</label>
						<option value="Lappeenranta">Lappeenranta</option>
						<label for="Luumäki">Luumäki</label>
						<option value="Luumäki">Luumäki</option>
						<label for="Parikkala">Parikkala</label>
						<option value="Parikkala">Parikkala</option>
						<label for="Rautjärvi">Rautjärvi</label>
						<option value="Rautjärvi">Rautjärvi</option>
						<label for="Ruokolahti">Ruokolahti</label>
						<option value="Ruokolahti">Ruokolahti</option>
						<label for="Savitaipale">Savitaipale</label>
						<option value="Savitaipale">Savitaipale</option>
						<label for="Taipalsaari">Taipalsaari</label>
						<option value="Taipalsaari">Taipalsaari</option>
					</optgroup>
					<optgroup label="Päijät-Häme">
						<label for="Asikkala">Asikkala</label>
						<option value="Asikkala">Asikkala</option>
						<label for="Hartola">Hartola</label>
						<option value="Hartola">Hartola</option>
						<label for="Heinola">Heinola</label>
						<option value="Heinola">Heinola</option>
						<label for="Hollola">Hollola</label>
						<option value="Hollola">Hollola</option>
						<label for="Kärkölä">Kärkölä</label>
						<option value="Kärkölä">Kärkölä</option>
						<label for="Lahti">Lahti</label>
						<option value="Lahti">Lahti</option>
						<label for="Orimattila">Orimattila</label>
						<option value="Orimattila">Orimattila</option>
						<label for="Padasjoki">Padasjoki</label>
						<option value="Padasjoki">Padasjoki</option>
						<label for="Sysmä">Sysmä</label>
						<option value="Sysmä">Sysmä</option>
					</optgroup>
					<optgroup label="Satakunta">
						<label for="Eura">Eura</label>
						<option value="Eura">Eura</option>
						<label for="Eurajoki">Eurajoki</label>
						<option value="Eurajoki">Eurajoki</option>
						<label for="Harjavalta">Harjavalta</label>
						<option value="Harjavalta">Harjavalta</option>
						<label for="Honkajoki">Honkajoki</label>
						<option value="Honkajoki">Honkajoki</option>
						<label for="Huittinen">Huittinen</label>
						<option value="Huittinen">Huittinen</option>
						<label for="Jämijärvi">Jämijärvi</label>
						<option value="Jämijärvi">Jämijärvi</option>
						<label for="Kankaanpää">Kankaanpää</label>
						<option value="Kankaanpää">Kankaanpää</option>
						<label for="Karvia">Karvia</label>
						<option value="Karvia">Karvia</option>
						<label for="Kokemäki">Kokemäki</label>
						<option value="Kokemäki">Kokemäki</option>
						<label for="Merikarvia">Merikarvia</label>
						<option value="Merikarvia">Merikarvia</option>
						<label for="Nakkila">Nakkila</label>
						<option value="Nakkila">Nakkila</option>
						<label for="Pomarkku">Pomarkku</label>
						<option value="Pomarkku">Pomarkku</option>
						<label for="Pori">Pori</label>
						<option value="Pori">Pori</option>
						<label for="Rauma">Rauma</label>
						<option value="Rauma">Rauma</option>
						<label for="Siikainen">Siikainen</label>
						<option value="Siikainen">Siikainen</option>
						<label for="Säkylä">Säkylä</label>
						<option value="Säkylä">Säkylä</option>
						<label for="Ulvila">Ulvilan</label>
						<option value="Ulvila">Ulvilan</option>
					</optgroup>
					<optgroup label="Uusimaa">
						<label for="Askola">Askola</label>
						<option value="Askola">Askola</option>
						<label for="Espoo">Espoo</label>
						<option value="Espoo">Espoo</option>
						<label for="Hanko">Hanko</label>
						<option value="Hanko">Hanko</option>
						<label for="Helsinki">Helsinki</label>
						<option value="Helsinki">Helsinki</option>
						<label for="Hyvinkää">Hyvinkää</label>
						<option value="Hyvinkää">Hyvinkää</option>
						<label for="Inkoo">Inkoo</label>
						<option value="Inkoo">Inkoo</option>
						<label for="Järvenpää">Järvenpää</label>
						<option value="Järvenpää">Järvenpää</option>
						<label for="Karkkila">Karkkila</label>
						<option value="Karkkila">Karkkila</option>
						<label for="Kauniainen">Kauniainen</label>
						<option value="Kauniainen">Kauniainen</option>
						<label for="Kerava">Kerava</label>
						<option value="Kerava">Kerava</option>
						<label for="Kirkkonummi">Kirkkonummi</label>
						<option value="Kirkkonummi">Kirkkonummi</option>
						<label for="Lapinjärvi">Lapinjärvi</label>
						<option value="Lapinjärvi">Lapinjärvi</option>
						<label for="Lohja">Lohja</label>
						<option value="Lohja">Lohja</option>
						<label for="Loviisa">Loviisa</label>
						<option value="Loviisa">Loviisa</option>
						<label for="Myrskylä">Myrskylä</label>
						<option value="Myrskylä">Myrskylä</option>
						<label for="Mäntsälä">Mäntsälä</label>
						<option value="Mäntsälä">Mäntsälä</option>
						<label for="Nurmijärvi">Nurmijärvi</label>
						<option value="Nurmijärvi">Nurmijärvi</option>
						<label for="Pornainen">Pornainen</label>
						<option value="Pornainen">Pornainen</option>
						<label for="Porvoo">Porvoo</label>
						<option value="Porvoo">Porvoo</option>
						<label for="Pukkila">Pukkila</label>
						<option value="Pukkila">Pukkila</option>
						<label for="Raasepori">Raasepori</label>
						<option value="Raasepori">Raasepori</option>
						<label for="Sipoo">Sipoo</label>
						<option value="Sipoo">Sipoo</option>
						<label for="Siuntio">Siuntio</label>
						<option value="Siuntio">Siuntio</option>
						<label for="Tuusula">Tuusula</label>
						<option value="Tuusula">Tuusula</option>
						<label for="Vantaa">Vantaa</label>
						<option value="Vantaa">Vantaa</option>
						<label for="Vihti">Vihti</label>
						<option value="Vihti">Vihti</option>
					</optgroup>
					<optgroup label="Varsinais-Suomi">
						<label for="Aura">Aura</label>
						<option value="Aura">Aura</option>
						<label for="Kaarina">Kaarina</label>
						<option value="Kaarina">Kaarina</option>
						<label for="Kemiönsaari">Kemiönsaari</label>
						<option value="Kemiönsaari">Kemiönsaari</option>
						<label for="Koski">Koski</label>
						<option value="Koski">Koski</option>
						<label for="Kustavi">Kustavi</label>
						<option value="Kustavi">Kustavi</option>
						<label for="Laitila">Laitila</label>
						<option value="Laitila">Laitila</option>
						<label for="Lieto">Lieto</label>
						<option value="Lieto">Lieto</option>
						<label for="Loimaa">Loimaa</label>
						<option value="Loimaa">Loimaa</option>
						<label for="Marttila">Marttila</label>
						<option value="Marttila">Marttila</option>
						<label for="Masku">Masku</label>
						<option value="Masku">Masku</option>
						<label for="Mynämäki">Mynämäki</label>
						<option value="Mynämäki">Mynämäki</option>
						<label for="Naantali">Naantali</label>
						<option value="Naantali">Naantali</option>
						<label for="Nousiainen">Nousiainen</label>
						<option value="Nousiainen">Nousiainen</option>
						<label for="Oripää">Oripää</label>
						<option value="Oripää">Oripää</option>
						<label for="Paimio">Paimio</label>
						<option value="Paimio">Paimio</option>
						<label for="Parainen">Parainen</label>
						<option value="Parainen">Parainen</option>
						<label for="Pyhäranta">Pyhäranta</label>
						<option value="Pyhäranta">Pyhäranta</option>
						<label for="Pöytyä">Pöytyä</label>
						<option value="Pöytyä">Pöytyä</option>
						<label for="Raisio">Raisio</label>
						<option value="Raisio">Raisio</option>
						<label for="Rusko">Rusko</label>
						<option value="Rusko">Rusko</option>
						<label for="Salo">Salo</label>
						<option value="Salo">Salo</option>
						<label for="Sauvo">Sauvo</label>
						<option value="Sauvo">Sauvo</option>
						<label for="Somero">Somero</label>
						<option value="Somero">Somero</option>
						<label for="Taivassalo">Taivassalo</label>
						<option value="Taivassalo">Taivassalo</option>
						<label for="Turku">Turku</label>
						<option value="Turku">Turku</option>
						<label for="Uusikaupunki">Uusikaupunki</label>
						<option value="Uusikaupunki">Uusikaupunki</option>
						<label for="Vehmaa">Vehmaa</label>
						<option value="Vehmaa">Vehmaa</option>
					</optgroup>
					
                    </select>
					<% } %>
					
					<!-- IKÄ -->
                    <label for="ika" class="textbox-label">Ikä</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="ika" value="<% 
                    	//out.println(ehdokas.get(5)); // RESULTSET 
                    	if (ehdokasJPA != null) { out.println(ehdokasJPA.getIka()); } // JPA
                    	%>">
                    <% } else { %>
                    	<input class="textbox-input" type="text" name="ika">
                    <% } %>

					<!-- MIKSI -->
                    <label for="miksi" class="textbox-label">Miksi haluat eduskuntaan?</label>
                    <% if (conn.event == 'H') { %>
	                    <textarea rows="5" id="miksi" class="textbox-input" type="text" name="miksieduskuntaan"> <% 
	                    //out.println(ehdokas.get(6)); //  RESULTSET
	                    if (ehdokasJPA != null) { out.println(ehdokasJPA.getMiksiEduskuntaan()); } // JPA
	                    %> </textarea>
                    <% } else { %>
                    <textarea rows="5" id="miksi" class="textbox-input" type="text" name="miksieduskuntaan"></textarea>
                    <% } %>
                    
					<!-- MITÄ -->
                    <label for="mita" class="textbox-label">Mitä asioita haluat edistää?</label>
                    <% if (conn.event == 'H') { %>
	                    <textarea rows="5" id="miksi" class="textbox-input" type="text" name="mitaedistaa"> <% 
	                    //out.println(ehdokas.get(7)); // RESULTSET
	                    if (ehdokasJPA != null) { out.println(ehdokasJPA.getMitaAsioitaHaluatEdistaa()); } // JPA
	                    %> </textarea>
                    <% } else { %>
                    <textarea rows="5" id="miksi" class="textbox-input" type="text" name="mitaedistaa"></textarea>
                    <% } %>
					
					<!-- AMMATTI -->
                    <label for="ammatti" class="textbox-label">Ammatti</label>
                    <% if (conn.event == 'H') { %>
                    	<input class="textbox-input" type="text" name="ammatti" value="<% 
                    	//out.println(ehdokas.get(8)); // RESULTSET
                    	if (ehdokasJPA != null) { out.println(ehdokasJPA.getAmmatti()); } // JPA
                    	%>">
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
			<p>Lisää uusi ehdokas täyttämällä kenttiin ehdokkaan tiedot, ja
				painamalla "Lisää"-painiketta.</p>
			<p>Hae ehdokasta syöttämällä Ehdokasnumero-kenttään ehdokkaan
				numero, ja painamalla "Hae"-painiketta.</p>
			<p>Päivitä ehdokkaan tiedot ensin hakemalla ehdokasta (ohjeet
				yllä), muuttamalla tietoja, ja painamalla "Päivitä"-painiketta</p>
			<p>Poista ehdokas hakemalla ehdokasta (ohjeet yllä), ja
				painamalla "Poista"-painiketta.</p>
		</div>
	</div>
</body>
</html>