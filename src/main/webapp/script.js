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
            kysymykset = JSON.parse(xhr.response);
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

const sendData = () => {

    let kys = new Object;
    kys.kysymys = document.getElementById("kysymys").value;

    console.log("Step 1: Form value = " + kys.kysymys);

    let json = JSON.stringify(kys);
    console.log("Step 2: " + json);
    
    const xhr = new XMLHttpRequest();
    console.log("Step 3: xhr = " + xhr);

    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
        	console.log("Step 8: onreadystatechange if-lause");
            document.getElementById("degubbe").innerHTML = this.responseText;
        }
    };

    console.log("Step 4: hypättiin onreadystatechangen yli");
    

    xhr.open("POST", "/rest/kysymyksetservice/addkysymys", true);
    console.log("Step 5: xhr.open")
    xhr.setRequestHeader("Content-type", "application/json");
    console.log("Step 6: xhr.setRequestHeader");
    xhr.send(json);
    console.log("Step 7: xhr.send");
}
