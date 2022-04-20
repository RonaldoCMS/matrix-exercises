package com.logic;

import java.util.ArrayList;
import java.util.List;

public class Studente {
   private Esame esame;
   private String nome;
   private String cognome;
   private String classe;

   Studente(String nome, String cognome, String classe, Esame esame) {
       this.nome = nome;
       this.cognome = cognome;
       this.classe = classe;
       this.esame = esame;
   }

   public String getCognome() {
       return cognome;
   }

   public String getClasse() {
       return classe;
   }

   public Esame getEsame() {
       return esame;
   }

   public String getNome() {
       return nome;
   }


}
