let im = "X";

let punteggioX = 0;
let punteggioO = 0;


function changeIm() {
    let consiglio = (document.getElementById("consiglio1") as HTMLParagraphElement);
    if(im == "X") {
        im = "O";
        consiglio.innerHTML = "E' il turno di... O";
    }  else  {
        im = "X";
        consiglio.innerHTML = "E' il turno di... X";
    }
}

let fields = (document.getElementsByClassName("field") as HTMLCollectionOf<HTMLInputElement>)


function handleOnClickField(id : string) : void {
    (document.getElementById(id) as HTMLInputElement).value = im;
    (document.getElementById(id) as HTMLInputElement).disabled = true;
    isTris();
    changeIm();
}


function isTris() : void {
    if(watchTris2Option(0,1,2) || watchTris2Option(3,4,5) ||
        watchTris2Option(6,7,8) || watchTris2Option(0,3,6) ||
        watchTris2Option(1,4,7) || watchTris2Option(2,5,8) ||
        watchTris2Option(0,4,8) || watchTris2Option(2,4,6)) {  
        let punteggio = (document.getElementById("punteggio"+im) as HTMLParagraphElement);
        if(im == "X") {
            punteggio.innerHTML = "X = " + ++punteggioX;
        }
        else {            
            punteggio.innerHTML = "O = " + ++punteggioO;
        }
        reset();
    } else if(isDraw()) {
        reset();
    }
}

function watchTris2Option(case1: number, case2: number, case3: number) {
    return  watchTris(case1, case2, case3, "X") || watchTris(case1, case2, case3, "O");
} 

function watchTris(case1: number, case2: number, case3: number, type: String) {
    return fields[case1].value == type && fields[case2].value == type && fields[case3].value == type;
}


function reset() : void {
    for(let i = 0; i<fields.length; i++) {
        fields[i].value = "";
        fields[i].disabled = false;
    }
}

function isDraw() : boolean {
    let counter = 0;
    for(let i = 0; i<fields.length; i++) {
        if(fields[i].value != "") 
            counter++;
    }
    if(counter == 9) {
       return true;
    }

    return false;
}




