autos = [
    new Automobile("test", "test", "test", "test", "test", 1, 2),
    new Automobile("test1", "test", "test", "test", "test", 1, 2),
    new Automobile("test2", "test", "test", "test", "test", 1, 2),
    new Automobile("test3", "test", "test", "test", "test", 1, 2),
    new Automobile("test4", "test", "test", "test", "test", 1, 2),

];

function handleAddAuto() {
    let modello = document.getElementById("idModello").value;
    let marca = document.getElementById("idMarca").value;
    let targa = document.getElementById("idTarga").value;
    let colore = document.getElementById("idColore").value;
    let cilindrata = document.getElementById("idCilindrata").value;
    let prezzo = document.getElementById("idPrezzo").value;

    auto = new Automobile(modello, marca, targa, colore, cilindrata, prezzo);

    if(modello == '' || marca == '' 
    || targa == '' || colore == ''
    || cilindrata == '' || prezzo == '') {
        alert("Attenzione, mancano dei dati da compilare!");
    } else if(prezzo < 0 || cilindrata < 0) {
        alert("Attenzione, il prezzo e la cilindrata non possono avere valori negativi");
    } else {
        autos.push(auto);
    }

    console.log(autos);
}

function handleViewAuto() {
        Array.from(autos).forEach((element, index) => {
            document.getElementById("visualizzati").innerHTML += 
            ` 
            <div>
                <p>=================</p>
                <p>Modello : ${element.modello}</p>
                <p>Marca : ${element.marca}</p>
                <p>Targa : ${element.targa}</p>
                <p>Colore : ${element.colore}</p>
                <p>Cilindrata : ${element.cilindrata}</p>
                <p>Prezzo : ${element.prezzo}</p>
                <div class="input-group input-group-sm mb-3">
                    <input type="submit" onclick="handleDeleteAuto(${index})" value="RIMUOVI" class="form-control w-75" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <p>=================</p> 
            </div>
            `;
        });
        if(autos.length != 0) {
        document.getElementById("visualizzati").innerHTML += `
        <div class="input-group input-group-sm mb-3">
            <input type="submit" onclick="handleRemoveViewAuto()" value="NASCONDI" class="form-control w-75" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
        </div> `

       
        document.getElementById("visualizzati").innerHTML += `
        <div class="input-group input-group-sm mb-3">
        <input type="submit" onclick="handleRemoveAllAuto()" value="CANCELLA TUTTO" class="form-control w-75" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
        </div>
        `;
        } else {
            document.getElementById("visualizzati").innerHTML = `
            <p> Nessuna auto inserita </p>
            `;
        }
       
   // }

    console.log("Hello World");
}

function handleRemoveViewAuto() {
    document.getElementById("visualizzati").innerHTML = ""
}

function handleRemoveAllAuto() {
    let result = confirm("Sicuro?");
    if(result) {
        autos = [];
        handleRemoveViewAuto();
    }
}

function handleDeleteAuto(index) {

    let result = confirm("Vuoi eliminare per davvero l'auto?");

    if(result) {
        autos.splice(index, 1);
        console.log(autos);
        handleRemoveViewAuto();
        handleViewAuto();
    }
}