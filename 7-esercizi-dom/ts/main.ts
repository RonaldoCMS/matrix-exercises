
let esercizi : string[] = [];


function handleInit(): void {
    _loadElementFromLocal();
    _loadEsercizi();
    _loadOptions();
    _hideFormEsercizio();
  }

function handleShowAddEsercizio() : void {
    _hideSettingsEsercizio();
    _showFormEsercizio();
}


function handleAddEsercizio() : void {
    let inputRadio = document.getElementsByName("input-radio");
    let textArea = (document.getElementById("input-textarea") as HTMLTextAreaElement)
    if((inputRadio[0] as HTMLInputElement).checked) {
        esercizi.push(textArea.value)
    } else {
        let select = document.getElementById("input-select");
        let value = (select as HTMLSelectElement).value;
        
        let tempEsercizi : string[] = [];
        for(let i = 0; i < esercizi.length; i++) {
            if(i == Number(value)) {
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

function handleAnnullaEsercizio() : void {
    _hideFormEsercizio();
    _showSettingsEsercizio();
}

function _loadElementFromLocal() : void {
    esercizi = JSON.parse(localStorage.getItem("esercizi") as any) ?? []; //NON LO SO
   alert(typeof esercizi);
}

function _loadElementInLocal() : void{
    localStorage.clear();
    localStorage.setItem("esercizi", JSON.stringify(esercizi));
}
function _createElementEsercizio(value: string) : HTMLDivElement {
    let element = document.createElement("div");
    //<div> </div>
    element.setAttribute("class", "content-esercizio my-4")
    //<div class="..."> </div>
    let paragraphy = document.createElement("p");
    let text = document.createTextNode(value);
    //<p> ciao </p>
    paragraphy.appendChild(text);
    //<div class=""> <p> ciao </p> </div>
    element.appendChild(paragraphy);
    return element;
}

function _loadEsercizi() : void {
    let body = document.getElementById("esercizio-content");
    //<div class="wrapper-esercizio-content">
    let content = esercizi.map((value) => _createElementEsercizio(value));
    for(let i = 0 ; i < content.length ; i++) {
        body?.appendChild(content[i]);
    }
}

function _deleteEsercizi() : void {
    (document.getElementById("esercizio-content") as HTMLElement).innerHTML = "";
    (document.getElementById("input-select") as HTMLElement).innerHTML = "";
}

function _updateEsercizi() : void {
    _deleteEsercizi();
    _loadEsercizi();
    _loadOptions();

}

function _createOptionElement(index: number) : HTMLElement {
    let option = document.createElement("option");
    option.setAttribute("value", "" + index);
    let paragraphy = document.createElement('p');
    let text = document.createTextNode("" + Number(index+1));
    paragraphy.appendChild(text);
    
    option.appendChild(paragraphy);
    return option;
}

function _loadOptions() : void {
    let select = document.getElementById("input-select");
    let content = esercizi.map((value, index) => _createOptionElement(index));
    content.forEach((value) => select?.appendChild(value));
}





function hide(id: string) {
    document.getElementById(id)!.style.display = "none";
}

function show(id: string) {
    document.getElementById(id)!.style.display = "block"
}

let _hideFormEsercizio = () =>  hide("form-esercizio");
let _showFormEsercizio = () =>  show("form-esercizio")

let _hideSettingsEsercizio = () =>  hide("wrapper-settings");
let _showSettingsEsercizio = () =>  show("wrapper-settings");

