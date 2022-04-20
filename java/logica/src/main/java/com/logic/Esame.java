package com.logic;

import com.logic.App.Giorno;

public class Esame {
    private int provaScritta;
    private int provaPratica;
    Giorno giorno;

    public Esame(int provaScritta, int provaPratica) {
        setProvaScritta(provaScritta);
        setProvaPratica(provaPratica);
        giorno = Giorno.LUNEDI;
    }


    public void setProvaPratica(int provaPratica) {
        if(provaPratica < -8) {
            this.provaPratica = -8;
        } else if(provaPratica > 8) {
            this.provaPratica = 8;
        }  else {
            this.provaPratica = provaPratica;
        }
    }
    
    public void setProvaScritta(int provaScritta) {
        if(provaScritta < 0) {
            this.provaScritta = 0;
        } else if(provaScritta > 24) {
            this.provaScritta = 24;
        }   else {
            this.provaScritta = provaScritta;
        }

    }    

    public int sommaRisultati() {
        return provaPratica + provaScritta;
    }

    public boolean isBocciato() {
        if(sommaRisultati() < 18) return true;

        if(provaScritta < 18 && provaPratica <= 0) return true;

        return false;
    }

    public String promozione() {
        if(sommaRisultati() > 30) return "Congratulazioni: 30 e lode";
        if(isBocciato()) return "Mi dispiace sei stato bocciato! voto: " + sommaRisultati();
        else return "Sei stato promosso! voto: " + sommaRisultati();
    }

}
