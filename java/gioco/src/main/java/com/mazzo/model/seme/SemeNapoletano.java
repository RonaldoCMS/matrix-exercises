package com.mazzo.model.seme;

public enum SemeNapoletano {
    DENARI(0), COPPE(1), SPADE(2), BASTONI(3);


    private int value;

    private SemeNapoletano(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
