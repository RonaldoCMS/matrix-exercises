package com.example.model.museo;
import com.example.exceptions.OperaEsistenteException;
import com.example.model.opera.Opera;

public class Museo {
    private Deposito deposito = new Deposito();
    private Sale sale = new Sale();

    public boolean carica(Opera opera) throws OperaEsistenteException {
       if(!sale.carica(opera)) {
            if(!deposito.carica(opera)) {
                return false;
            }
       }
        return true;
    }

    public Opera cerca(int codice) {
        Opera toReturn = sale.cerca(codice);

        if(toReturn != null) {
            return toReturn;
        }

        toReturn = deposito.cerca(codice);
        if(toReturn != null) {
            return toReturn;
        }

        return null;
    }

    public Opera cercaEdElimina(int codice) {


        
        Opera toReturn = sale.cercaEdElimina(codice);
        if(toReturn != null) {
            return toReturn;
        }

        toReturn = deposito.cercaEdElimina(codice);
        if(toReturn != null) {
            return toReturn;
        }

        return null;
    }

    public int cercaDove(int codice) {
        Opera toReturn = sale.cerca(codice);
        if(toReturn != null) {
            return 0;
        }
        toReturn = deposito.cerca(codice);
        if(toReturn != null) {
            return -1;
        }

        return -2;
    }

    public Opera spostaInMuseo(int codice) throws OperaEsistenteException {
        int dove = cercaDove(codice);
        if(dove != -2 && dove != -1) {
            Opera opera = deposito.cercaEdElimina(codice);
            if(opera != null){
                sale.carica(opera);
            }
            return opera;
        }

        return null;
    }

    public Opera spostaInDeposito(int codice) throws OperaEsistenteException {
        int dove = cercaDove(codice);
        if(dove == 0) {
            Opera opera = sale.cercaEdElimina(codice);
            if(opera != null) {
                deposito.carica(opera);

            }
        }
        return null;
    }

    public String stampaSale() {
        return sale.stampa();
    }

    public String stampaDeposito() {
        return deposito.stampa();
    }
}
