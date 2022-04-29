package com.example.model.museo;

import java.util.Arrays;

import com.example.model.opera.Opera;

public class Sala implements Operazioni {
    private Opera[] opera = new Opera[10];
    private String nome;

    Sala(String nome) {
        this.nome = nome;
    }

    public Opera[] getOpera() {
        return opera;
    }

    public void setOpera(Opera[] opera) {
        this.opera = opera;
    }

    @Override
    public boolean carica(Opera opera) {
        for(int i = 0; i < this.opera.length; i++) {
            if(this.opera[i] == null) {
                this.opera[i] = opera;
                return true;
            }
        }
        return false;
    }

    @Override
    public Opera cerca(int codice) {
        for(int i = 0; i < this.opera.length; i++) {
            if( this.opera[i] != null &&  this.opera[i].getCodice() == codice) {
                return  this.opera[i];
            }
        }
        return null;
    }

    @Override
    public Opera cercaEdElimina(int codice) {
        for(int i = 0; i < this.opera.length; i++) {
            if(this.opera[i] != null &&  this.opera[i].getCodice() == codice) {
                Opera opera = this.opera[i];
                this.opera[i] = null;
                return  opera;
            }
        }
        return null;
    }



    @Override
    public String stampa() {
        return toString();
    }

    @Override
    public String toString() {
        return "Sala [nome=" + nome + ", opera=" + Arrays.toString(opera) + "]";
    }

    

}
