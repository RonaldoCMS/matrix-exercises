package com.mazzo.model.seme;

public enum SemeFrancese {
    FIORI(0), PICCHE(1), QUADRI(2), CUORI(3);


    private int value;

    private SemeFrancese(int value) {
        this.value = value;
    }

    public int SemeFrancese() {
        return value;
    }
}
