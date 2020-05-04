// Tyhjentää formin kentät ilman sivun päivittymistä
function clearFields() {
    document.getElementById("addForm").reset();
    document.getElementById("ehdokasnumero").value = "";
    document.getElementById("sukunimi").value = "";
    document.getElementById("etunimi").value = "";
    document.getElementById("puolue").value = "";
    document.getElementById("ika").value = "";
    document.getElementById("kotipaikkakunta").value = "";
    document.getElementById("miksieduskuntaan").value = "";
    document.getElementById("mitaedistaa").value = "";
    document.getElementById("ammatti").value = "";
}

