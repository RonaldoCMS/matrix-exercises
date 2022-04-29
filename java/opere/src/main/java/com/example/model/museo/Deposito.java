package com.example.model.museo;

import java.util.ArrayList;

import com.example.exceptions.OperaEsistenteException;
import com.example.model.opera.Opera;

public class Deposito implements Operazioni {

    ArrayList<Opera> opera = new ArrayList<Opera>();

    @Override
    public boolean carica(Opera opera) throws OperaEsistenteException {
        if (cerca(opera.getCodice()) == null) {
            this.opera.add(opera);
        }
        throw new OperaEsistenteException();
    }

    @Override
    public Opera cerca(int codice) {
        for (Opera newOpera : opera) {
            if (newOpera.getCodice() == codice) {
                return newOpera;
            }
        }
        return null;
    }

    @Override
    public Opera cercaEdElimina(int codice) {
        Opera toReturn = null;
        for (int i = 0; i < opera.size(); i++) {
            if (opera.get(i).getCodice() == codice) {
                toReturn = opera.get(i);
                opera.remove(i);
                break;
            }
        }
        return toReturn;
    }

    @Override
    public String stampa() {
        return toString();
    }

    @Override
    public String toString() {
        return "Deposito [opera=" + opera + "]";
    }

}
