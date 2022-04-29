package com.example.exceptions;

public class OperaEsistenteException extends Exception {
    public OperaEsistenteException() {
        super("Opera con id già esistente!");
    }
}
