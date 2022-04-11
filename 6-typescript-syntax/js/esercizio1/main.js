"use strict";
/*  Esercizio 2
    
    Scrivere uno script che funzioni su qualsiasi documento HTML e che sia tale che:

    • ogni volta che il puntatore passa su un qualsiasi elemento div, questo cambia colore,
    ovvero se il colore attuale `e quello di default, passa al colore rosso, e viceversa;

    • ogni volta che l’utente clicca su un qualsiasi elemento di classe c1, questo diventa di
    colore blu;

    • ogni volta che l’utente fa doppio click su un qualsiasi elemento di classe c1, questo
    sparisce;

    • ogni volta che l’utente clicca su un qualsiasi elemento span di classe c2, questo elemento
    diventa di colore verde.
*/
(() => {
    var c1 = document.getElementsByClassName("c1");
    for (let i = 0; i < c1.length; i++) {
        c1[i].addEventListener("onmouseenter", (e) => {
            c1[i].setAttribute("class", "blue");
        });
        c1[i].addEventListener("onclick", (e) => {
            c1[i].style.display = "none";
        });
        c1[i].addEventListener("onmouseexit", (e) => {
            c1[i].removeAttribute("blue");
        });
    }
})();
(() => {
    var divs = document.getElementsByTagName("div");
    for (let i = 0; i < divs.length; i++) {
        divs[i].onmouseenter = (e) => {
            divs[i].setAttribute("class", "red");
        };
        divs[i].onmouseleave = (e) => {
            divs[i].removeAttribute("red");
        };
    }
})();
