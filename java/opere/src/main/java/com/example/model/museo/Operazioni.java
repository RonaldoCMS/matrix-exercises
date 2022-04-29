package com.example.model.museo;

import com.example.model.opera.Opera;

public interface Operazioni {
    public boolean carica(Opera opera) throws Exception;

    public Opera cerca(int codice);

    public Opera cercaEdElimina(int codice);

    public String stampa();

}
