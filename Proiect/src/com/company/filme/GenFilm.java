package com.company.filme;

import java.util.Random;

public enum GenFilm {
    COMEDIE, ROMANTIC, DRAMA, HORROR, ACTIUNE;

    public static GenFilm GenRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
