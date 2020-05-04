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

// Kysymysten haku restistä
const responseField = document.querySelector('#kysymykset');
const apiurl = "http://localhost:8080/rest/kysymyksetservice/getall";

const getQuestions = () => {

    const xhr = new XMLHttpRequest();
    console.log(xhr);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {

            kysymykset = JSON.parse(this.responseText); // <-- Uncaught SyntaxError: Unexpected token u in JSON at position 0 ?
            
            let txt = "";

            
            for (index in kysymykset) {
                txt += kysymykset[index].kysymysId + "&nbsp";
                txt += kysymykset[index].kysymys + "<br>";
            }
            
            responseField.innerHTML = txt;
        }
    };
    xhr.open('GET', apiurl, true);
    xhr.send();
}