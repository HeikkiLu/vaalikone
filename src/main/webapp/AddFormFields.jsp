<%@page import="dao.EhdokkaatDao"%>
<%@page import="persist.Ehdokkaat"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- EHDOKASNUMERO -->
<label for="ehdokasnumero" class="textbox-label">Ehdokasnumero</label>
<input id="ehdokasnumero" class="textbox-input" type="text" name="ehdokasnumero" value="" required>

<!-- SUKUNIMI -->
<label for="ehdokasnumero" class="textbox-label">Sukunimi</label>
<input id="sukunimi" class="textbox-input" type="text" name="sukunimi" value="">

<!-- ETUNIMI -->
<label for="ehdokasnumero" class="textbox-label">Etunimi</label>
<input id="etunimi" class="textbox-input" type="text" name="etunimi" value="">

<!-- PUOLUE -->
<label for="ehdokasnumero" class="textbox-label">Puolue</label>
<input id="puolue" class="textbox-input" type="text" name="puolue" value="">

<!-- PAIKKAKUNTA -->
<label for="koti" class="textbox-label">Kotipaikkakunta</label>
<jsp:include page="Location.jsp"/>

<!-- IKÃ -->
<label for="ika" class="textbox-label">Ikä</label>
<input id="ika" class="textbox-input" type="text" name="ika" value="">

<!-- MIKSI -->
<label for="miksi" class="textbox-label">Miksi haluat eduskuntaan?</label>
<textarea id="miksieduskuntaan" rows="4" class="textbox-input" type="text" name="miksieduskuntaan" value=""></textarea>

<!-- MITÃ -->
<label for="mita" class="textbox-label">Mitä asioita haluat edistää?</label>
<textarea id="mitaedistaa" rows="4" class="textbox-input" type="text" name="mitaedistaa" value=""></textarea>

<!-- AMMATTI -->
<label for="ammatti" class="textbox-label">Ammatti</label>
<input id="ammatti" class="textbox-input" type="text" name="ammatti" value="">