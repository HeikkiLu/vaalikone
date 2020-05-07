<%@page import="dao.EhdokkaatDao"%>
<%@page import="persist.Ehdokkaat"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% EhdokkaatDao conn = new EhdokkaatDao(); %>
<% Ehdokkaat ehdokasJPA; %>

<% 	
try{
	ehdokasJPA = conn.findEhdokas(conn.ehdokas);
} catch (Exception e) {
	ehdokasJPA = null;
}

if (ehdokasJPA != null) { 
	try {
		conn.currentID = ehdokasJPA.getEhdokasId();
	} catch (NumberFormatException e) {
		
	} 
}
%>

<!-- EHDOKASNUMERO -->
<label for="ehdokasnumero" class="textbox-label">Ehdokasnumero</label>
<input id="ehdokasnumero" class="textbox-input" type="text" name="ehdokasnumero" value="
<%if (EhdokkaatDao.event == 'H' && ehdokasJPA != null) { out.println(ehdokasJPA.getEhdokasnumero()); }%>" required>

<!-- SUKUNIMI -->
<label for="ehdokasnumero" class="textbox-label">Sukunimi</label>
<input id="sukunimi" class="textbox-input" type="text" name="sukunimi" value="
<%if (EhdokkaatDao.event == 'H' && ehdokasJPA != null) { out.println(ehdokasJPA.getSukunimi()); }%>">

<!-- ETUNIMI -->
<label for="ehdokasnumero" class="textbox-label">Etunimi</label>
<input id="etunimi" class="textbox-input" type="text" name="etunimi" value="
<%if (EhdokkaatDao.event == 'H' && ehdokasJPA != null) { out.println(ehdokasJPA.getEtunimi()); }%>">

<!-- PUOLUE -->
<label for="ehdokasnumero" class="textbox-label">Puolue</label>
<input id="puolue" class="textbox-input" type="text" name="puolue" value="
<%if (EhdokkaatDao.event == 'H' && ehdokasJPA != null) { out.println(ehdokasJPA.getPuolue()); }%>">

<!-- PAIKKAKUNTA -->
<label for="koti" class="textbox-label">Kotipaikkakunta</label>
<%
	if (EhdokkaatDao.event == 'H') {
%>
    <input id="kotipaikkakunta" class="textbox-input" type="text" name="kotipaikkakunta" value="<%//out.println(ehdokas.get(4)); // RESULTSET 
    if (ehdokasJPA != null) { out.println(ehdokasJPA.getKotipaikkakunta()); } // JPA%>">
<%
	} else {
%>
    <!-- Tuo paikkakuntalistan sivulle -->
    <jsp:include page="Location.jsp"/>
<%
	}
%>

<!-- IKÃ -->
<label for="ika" class="textbox-label">Ikä</label>
<input id="ika" class="textbox-input" type="text" name="ika" value="
<%if (EhdokkaatDao.event == 'H' && ehdokasJPA != null) { out.println(ehdokasJPA.getIka()); }%>">

<!-- MIKSI -->
<label for="miksi" class="textbox-label">Miksi haluat eduskuntaan?</label>
<textarea id="miksieduskuntaan" rows="4" class="textbox-input" type="text" name="miksieduskuntaan" value="">
<%
	if (EhdokkaatDao.event == 'H' && ehdokasJPA != null) { out.println(ehdokasJPA.getMiksiEduskuntaan()); }
%> </textarea>

<!-- MITÃ -->
<label for="mita" class="textbox-label">Mitä asioita haluat edistää?</label>
<textarea id="mitaedistaa" rows="4" class="textbox-input" type="text" name="mitaedistaa" value="">
<%
	if (EhdokkaatDao.event == 'H' && ehdokasJPA != null) { out.println(ehdokasJPA.getMitaAsioitaHaluatEdistaa()); }
%> </textarea>

<!-- AMMATTI -->
<label for="ammatti" class="textbox-label">Ammatti</label>
<input id="ammatti" class="textbox-input" type="text" name="ammatti" value="
<%if (EhdokkaatDao.event == 'H' && ehdokasJPA != null) { out.println(ehdokasJPA.getAmmatti()); }%>">