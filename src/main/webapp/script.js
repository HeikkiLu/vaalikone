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
const getQuestions = () => {
    const responseField = document.querySelector('#kysymykset');
    const apiurl = "http://localhost:8080/rest/kysymyksetservice/getall";
    const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {

            kysymykset = JSON.parse(xhr.response);
            let txt = "";

            for (index in kysymykset) {
                let id = kysymykset[index].kysymysId;
                let kys = kysymykset[index].kysymys;

                txt += '<span class="kysymys-span">'
                txt += `<button class="btn-edit" type="button" onclick="openModal('${kys}', ${id})"><i class="fas fa-pen"></i></button>`;
                txt += `<button class="btn-del" type="button" onclick="deleteKysymys(${id})"><i class="fas fa-trash-alt"></i></button>`;
                txt += '<p>'
                txt += id + ". "; //"&nbsp"
                txt += kys + "</p>";
                txt += '</span>'
            }

            responseField.innerHTML = txt;
        }
    };

    xhr.open('GET', apiurl, true);
    xhr.send();
}

// Kysymysten lisäys restillä
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

const getCandidate = () => {
    const responseField = document.querySelector('#ehdokkaat');
    const apiurl = "http://localhost:8080/rest/ehdokkaatservice/getall";
    const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            ehdokkaat = JSON.parse(xhr.response);
            let txt = "";
            for (index in ehdokkaat) {
                txt += ehdokkaat[index].ehdokasnumero + "&nbsp";
                txt += ehdokkaat[index].sukunimi + "&nbsp";
                txt += ehdokkaat[index].etunimi + "&nbsp";
                txt += ehdokkaat[index].puolue + "&nbsp";
                txt += "<br>";
            }

            responseField.innerHTML = txt;
        }
    };

    xhr.open('GET', apiurl, true);
    xhr.send();
}

/* Theme switcher */

// DOM elements
const darkButton = document.getElementById('dark');
const lightButton = document.getElementById('light');
const body = document.body;

const theme = localStorage.getItem('theme');

if (theme) {
    body.classList.add(theme);
}

// Button event handlers
darkButton.onclick = () => {
    body.classList.replace('light', 'dark');
    localStorage.setItem('theme', 'dark');
};

lightButton.onclick = () => {
    body.classList.replace('dark', 'light');
    localStorage.setItem('theme', 'light');
};

// Modal
const modalBg = document.querySelector('.modal-bg');
const modalClose = document.querySelector('.modal-close');
const modalText = document.querySelector('.muokkaaKysymys');

modalClose.addEventListener('click', function () {
    modalBg.classList.remove('active');
});


let editID;

const openModal = (kys, id) => {
    modalBg.classList.add('active');
    modalText.value = kys;
    editID = id;
};

const editKysymys = () => {

    let editedkys = new Object;
    editedkys.kysymys = modalText.value;
    editedkys.kysymysId = editID;

    let json = JSON.stringify(editedkys);
    const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            getQuestions(); // Päivittää kysymykset-listan sivulla
        }
    };

    xhr.open("POST", "/rest/kysymyksetservice/modifykysymys", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);

    modalBg.classList.remove('active');

}

// Sulkee modaalin liian herkästi
// modalBg.addEventListener('click', function () {
//     modalBg.classList.remove('active');
// });