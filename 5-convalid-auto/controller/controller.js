autoModel = new AutoModel();

function initAutos() {
    console.log(autoModel);
    autoModel.initialise();
    console.log("INIT END \t autos \t" + autoModel.autos);
}

function _autoIsValid(auto) {
    if(auto.modello == '' || auto.marca == '' 
    || auto.targa == '' || auto.colore == ''
    || auto.cilindrata == '' || auto.prezzo == '') {
       return -2;
    } else if(auto.prezzo < 0 || auto.cilindrata < 0) {
       return -1;
    } else {
        return 0;
    }
}

function handleSearchAuto() {
   let chars = document.getElementById("inputSearch").value;
   let type=  document.getElementById("select-type").value;
   console.log("TYPE -> " + type);
   let tempAutos = [];

   if(chars.length <= 0) {
    autoModel.initialise();
    console.log("true");
   } else {
       if(type == "Targa") {
           autoModel.autos = Array.from(autoModel.autos).filter((value) => value["targa"].includes(chars));  
       } else {
        autoModel.autos = Array.from(autoModel.autos).filter((value) => value["modello"].includes(chars));
       }
      
   }


   console.log("temp \t ->" + tempAutos);
   handleRemoveViewAuto();
   handleViewAuto();
   //autoModel.autos = [];
   //console.log("modello \t -> " + autoModel.autos[0]["modello"]);
   //console.log("Contiene? -> " + autoModel.autos[0]["targa"].includes(chars))
   //console.log("chars " + chars + "\ntype: " + type + "\nautos " + autoModel.autos);
}

function handleAddAuto() {
    let modello = document.getElementById("idModello").value;
    let marca = document.getElementById("idMarca").value;
    let targa = document.getElementById("idTarga").value;
    let colore = document.getElementById("idColore").value;
    let cilindrata = document.getElementById("idCilindrata").value;
    let prezzo = document.getElementById("idPrezzo").value;

    auto = new Automobile(modello, marca, targa, colore, cilindrata, prezzo);
    let isValid = _autoIsValid(auto);
    if(isValid == -2) {
        alert("Attenzione, mancano dei dati da compilare!");
    } else if(isValid == -1) {
        alert("Attenzione, il prezzo e la cilindrata non possono avere valori negativi");
    } else {
        autoModel.push(auto);
    }
    console.log(autos);
}

function handleViewAuto() {
    
    document.getElementById('input-view').style.display = "none";
    document.getElementById('insert-autos').style.display = "none";
    document.getElementById('search-bar').style.display = "block";

    
    let body = document.getElementById('body-autos');
    let views = document.createElement('div');
    views.setAttribute("id", "visualizzati");
    body.appendChild(views);

  
    /*views.innerHTML += `
        <div class="container" style="display:inline">
         <div class="row">

      
         <p class="w-25 m-2"> Ricerca per </p>
         <select id="select-type" class="form-select w-25">   
             <option>Targa</option>
             <option>Marca</option>
         </select>
         <input id="inputSearch" onkeypress="handleSearchAuto()" class="input-group-text w-25">
         </div>
     </div>
    `; */
    
    let table = document.createElement('table');
    table.setAttribute("class", "table text-white w-100");

    table.innerHTML += `
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Modello</th>
            <th scope="col">Marca</th>
            <th scope="col">Targa</th>
            <th scope="col">Colore</th>
            <th scope="col">Cilindrata</th>
            <th scope="col">Prezzo</th>
        </tr>
    </thead>
    <tbody>
    `;

        Array.from(autoModel.autos).forEach((element, index) => {
            table.innerHTML += `
            <tr>
                <th scope="row">${index}</th>
                <td>${element['modello']}</td>
                <td>${element['marca']}</td>
                <td>${element['targa']}</td>
                <td>${element['colore']}</td>
                <td>${element['cilindrata']}</td>
                <td>${element['prezzo']}</td>
                <td><input type="button" onclick=handleDeleteAuto(${index}) value="RIMUOVI"></td>
            </tr>
            `
        });

        table.innerHTML +=  ` 
        </tbody>
        </table>`;

        document.getElementById("visualizzati").appendChild(table);
        if(autoModel.autos.length != 0) {
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
}

function handleRemoveViewAuto() {
    document.getElementById('input-view').style.display = "block";
    document.getElementById('insert-autos').style.display = "block";
    document.getElementById('search-bar').style.display = "none";

    document.getElementById("visualizzati").remove();
}

function handleRemoveAllAuto() {
    let result = confirm("Sicuro?");
    if(result) {
        AutoModel.clean();
        handleRemoveViewAuto();
    }
}

function handleDeleteAuto(index) {
    let result = confirm("Vuoi eliminare per davvero l'auto?");
    if(result) {
        autoModel.remove(index);
        handleRemoveViewAuto();
        handleViewAuto();
    }
}