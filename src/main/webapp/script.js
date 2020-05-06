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

    // VAIHDA eventlistener
}

// Kysymysten haku restistä
const responseField = document.querySelector('#kysymykset');
const apiurl = "http://localhost:8080/rest/kysymyksetservice/getall";

const getQuestions = () => {

    const xhr = new XMLHttpRequest();
    console.log(xhr);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            kysymykset = JSON.parse(xhr.response);
            let txt = "";
            for (index in kysymykset) {
            	let id = kysymykset[index].kysymysId;
                // Tänne väliin HTML setit EDIT ja DELETE napeille
                txt += '<span class="kysymys-span">'
                txt += '<button class="btn-edit" type="button" onclick="editKysymys()"><i class="fas fa-pen"></i></button>';
                txt += `<button class="btn-del" type="button" onclick="deleteKysymys(${id})"><i class="fas fa-trash-alt"></i></button>`;
                txt += '<p>'
                txt += kysymykset[index].kysymysId + ". "; //"&nbsp"
                txt += kysymykset[index].kysymys + "</p>";
                txt += '</span>'
            }
            responseField.innerHTML = txt;
        }
    };
    xhr.open('GET', apiurl, true);
    xhr.send();
}

const sendData = () => {

    let kys = new Object;
    kys.kysymys = document.getElementById("kysymys").value;

    let json = JSON.stringify(kys);
    const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            getQuestions(); // Päivittää kysymykset-listan sivulla
            clearFields(); // Tyhjentää tekstikentän
        }
    };

    xhr.open("POST", "/rest/kysymyksetservice/addkysymys", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}
const deleteKysymys = id => {

    let kys = new Object;
    kys.kysymysId = id;
    console.log(kys);
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
    console.log(json);
}
