package com.company.comparator;
import com.company.filme.Film;

import java.util.Comparator;


public class ComparareFilme implements Comparator<Film>{

    @Override
    public int compare(Film a, Film b) {
        if(a.getAnAparitie() > b.getAnAparitie())
            return 1;
        else
            return -1;
    }
}
