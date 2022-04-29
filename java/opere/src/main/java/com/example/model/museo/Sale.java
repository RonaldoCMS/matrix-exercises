package com.example.model.museo;

import com.example.model.opera.Opera;

public class Sale implements Operazioni {
    private Sala[] sala = new Sala[5];

    public Sala[] getSala() {
        return sala;
    }

    @Override
    public boolean carica(Opera opera) {
        if(cerca(opera.getCodice()) != null) {
            for(int i = 0; i < sala.length; i++) {
                if(sala[i] != null) {
                    return sala[i].carica(opera);
                }
            }
        }
        return false;
    }

    @Override
    public Opera cerca(int codice) {
        for(int i = 0; i < sala.length; i++) {
            if(sala[i] != null) {
                for(int j = 0; j < sala[i].getOpera().length; j++) {
                        if(sala[i].cerca(codice) != null) {
                            return sala[i].cerca(codice);
                        }
                }
            }
        }
        return null;
    }

    @Override
    public Opera cercaEdElimina(int codice) {
        for(int i = 0; i < this.sala.length; i++) {
            if(sala[i] != null) {
                return sala[i].cercaEdElimina(codice);
            }
        }
        return null;
    }

    @Override
    public String stampa() {
        String allSale = "";
        for(Sala sala : this.sala) {
            allSale.concat(sala.stampa());
        }

        return allSale;
    }
}
