let im = "X";
let fields = (document.getElementsByClassName("field") as HTMLCollectionOf<HTMLInputElement>);
let consiglio = (document.getElementById("advice1") as HTMLParagraphElement);
let computer = false;
let scoreX = 0;
let scoreO = 0;


function handleOnClickField(id : string) : void {
    let input = (document.getElementById(id) as HTMLInputElement);
    input.value = im;
    input.disabled = true;
    _isTris();
    if(computer) {
        _changePlayer();
        let computerInput = Math.floor(Math.random() * 9 + 1);
        while(_isAlreadyClick("f"+computerInput)) {
            computerInput = Math.floor(Math.random() * 9 + 1);
            console.log("STO CERCANDO NUOVO VALORE..." + computerInput+1);
        }
        console.log("FATTO" + computerInput);
        (document.getElementById("f"+computerInput) as HTMLInputElement).value="O";
        _isTris();
    }
    _changePlayer();
}

function handlePlayWithComputer() {
    
    computer = true;
}

function handlePlay(): void {
    (document.getElementById("start") as HTMLDivElement).style.display = "none";
    (document.getElementById("play") as HTMLDivElement).style.display = "block";

}



function _isAlreadyClick(id: string) : boolean {
    let field = document.getElementById(id) as HTMLInputElement;
    if(field.value == "") {
        return false;
    }
    return true;
}


function _isTris() : void {
    if(_detectGenericWinner(0,1,2) || _detectGenericWinner(3,4,5) ||
        _detectGenericWinner(6,7,8) || _detectGenericWinner(0,3,6) ||
        _detectGenericWinner(1,4,7) || _detectGenericWinner(2,5,8) ||
        _detectGenericWinner(0,4,8) || _detectGenericWinner(2,4,6)) {  
        let punteggio = (document.getElementById("punteggio"+im) as HTMLParagraphElement);
        if(im == "X") {
            punteggio.innerHTML = "X = " + ++scoreX;
        }
        else {            
            punteggio.innerHTML = "O = " + ++scoreO;
        }
        _reset();
    } else if(_isDraw()) {
        _reset();
    }
}


function _reset() : void {
    for(let i = 0; i<fields.length; i++) {
        fields[i].value = "";
        fields[i].disabled = false;
    }
}

function _isDraw() : boolean {
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

function _detectGenericWinner(field1: number, field2: number, field3: number) {
    return  _detectWinner(field1, field2, field3, "X") || _detectWinner(field1, field2, field3, "O");
} 

function _detectWinner(field1: number, field2: number, field3: number, type: String) {
    return fields[field1].value == type && fields[field2].value == type && fields[field3].value == type;
}

function _changePlayer() {
    if(im == "X") {
        im = "O";
        consiglio.innerHTML = "E' il turno di... O";
    }  else  {
        im = "X";
        consiglio.innerHTML = "E' il turno di... X";
    }
}



