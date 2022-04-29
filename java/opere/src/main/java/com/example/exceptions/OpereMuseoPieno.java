package com.example.exceptions;

public class OpereMuseoPieno extends Exception{ 
    OpereMuseoPieno() {
        super("Il museo non ha spazio per altre opere.");
    }
    
}
