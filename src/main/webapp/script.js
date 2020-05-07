// Tyhjentää formin kentät ilman sivun päivittymistä
const clearFields = () => {
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

    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {

            kysymykset = JSON.parse(xhr.response);
            let txt = "";

            for (index in kysymykset) {
                let id = kysymykset[index].kysymysId;

                txt += '<span class="kysymys-span">'
                txt += `<button class="btn-edit" type="button" onclick="editKysymys(${id})"><i class="fas fa-pen"></i></button>`;
                txt += `<button class="btn-del" type="button" onclick="deleteKysymys(${id})"><i class="fas fa-trash-alt"></i></button>`;
                
                txt += kysymykset[index].kysymysId + ". "; //"&nbsp"
                txt += '<input class="textbox-input" type="text" value="'
                txt += kysymykset[index].kysymys + '">';
                txt += '</span>'
            }

            responseField.innerHTML = txt;
        }
    };

    xhr.open('GET', apiurl, true);
    xhr.send();
}

// Kysymysten lisäys restillä
const sendurl = "/rest/kysymyksetservice/addkysymys";
const userInput = document.getElementById("kysymys").value;

const sendData = () => {

    let kys = new Object;
    kys.kysymys = userInput;

    let json = JSON.stringify(kys);
    const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            getQuestions(); // Päivittää kysymykset-listan sivulla
            clearFields(); // Tyhjentää tekstikentän
        }
    };

    xhr.open("POST", sendurl, true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

// Kysymysten poisto restillä
const deleteKysymys = id => {

    let kys = new Object;
    kys.kysymysId = id;

    let json = JSON.stringify(kys);
    const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            getQuestions(); // Päivittää kysymykset-listan sivulla
        }
    };

    xhr.open("DELETE", "/rest/kysymyksetservice/deletekysymys", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

// Ei vielä toimi kaikissa formeissa event listener
const button_clear = document.querySelector(".button-clear");
button_clear.addEventListener('click', clearFields);