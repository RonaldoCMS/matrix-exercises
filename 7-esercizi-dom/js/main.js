"use strict";
let esercizi = [];
function handleInit() {
    _loadElementFromLocal();
    _loadEsercizi();
    _loadOptions();
    _hideFormEsercizio();
}
function handleShowAddEsercizio() {
    _hideSettingsEsercizio();
    _showFormEsercizio();
}
function handleAddEsercizio() {
    let inputRadio = document.getElementsByName("input-radio");
    let textArea = document.getElementById("input-textarea");
    if (inputRadio[0].checked) {
        esercizi.push(textArea.value);
    }
    else {
        let select = document.getElementById("input-select");
        let value = select.value;
        let tempEsercizi = [];
        for (let i = 0; i < esercizi.length; i++) {
            if (i == Number(value)) {
                tempEsercizi.push(textArea.value);
            }
            tempEsercizi.push(esercizi[i]);
        }
        esercizi = [];
        esercizi = tempEsercizi;
    }
    textArea.value = "";
    _updateEsercizi();
    _loadElementInLocal();
}
function handleAnnullaEsercizio() {
    _hideFormEsercizio();
    _showSettingsEsercizio();
}
function _loadElementFromLocal() {
    var _a;
    esercizi = (_a = JSON.parse(localStorage.getItem("esercizi"))) !== null && _a !== void 0 ? _a : []; //NON LO SO
    alert(typeof esercizi);
}
function _loadElementInLocal() {
    localStorage.clear();
    localStorage.setItem("esercizi", JSON.stringify(esercizi));
}
function _createElementEsercizio(value) {
    let element = document.createElement("div");
    //<div> </div>
    element.setAttribute("class", "content-esercizio my-4");
    //<div class="..."> </div>
    let paragraphy = document.createElement("p");
    let text = document.createTextNode(value);
    //<p> ciao </p>
    paragraphy.appendChild(text);
    //<div class=""> <p> ciao </p> </div>
    element.appendChild(paragraphy);
    return element;
}
function _loadEsercizi() {
    let body = document.getElementById("esercizio-content");
    //<div class="wrapper-esercizio-content">
    let content = esercizi.map((value) => _createElementEsercizio(value));
    for (let i = 0; i < content.length; i++) {
        body === null || body === void 0 ? void 0 : body.appendChild(content[i]);
    }
}
function _deleteEsercizi() {
    document.getElementById("esercizio-content").innerHTML = "";
    document.getElementById("input-select").innerHTML = "";
}
function _updateEsercizi() {
    _deleteEsercizi();
    _loadEsercizi();
    _loadOptions();
}
function _createOptionElement(index) {
    let option = document.createElement("option");
    option.setAttribute("value", "" + index);
    let paragraphy = document.createElement('p');
    let text = document.createTextNode("" + Number(index + 1));
    paragraphy.appendChild(text);
    option.appendChild(paragraphy);
    return option;
}
function _loadOptions() {
    let select = document.getElementById("input-select");
    let content = esercizi.map((value, index) => _createOptionElement(index));
    content.forEach((value) => select === null || select === void 0 ? void 0 : select.appendChild(value));
}
function hide(id) {
    document.getElementById(id).style.display = "none";
}
function show(id) {
    document.getElementById(id).style.display = "block";
}
let _hideFormEsercizio = () => hide("form-esercizio");
let _showFormEsercizio = () => show("form-esercizio");
let _hideSettingsEsercizio = () => hide("wrapper-settings");
let _showSettingsEsercizio = () => show("wrapper-settings");
