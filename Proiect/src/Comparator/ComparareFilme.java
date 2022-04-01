package Comparator;
import Filme.Film;

import java.util.Comparator;


public class ComparareFilme implements Comparator<Film>{

    public int comparare(Film a, Film b){
        if(a.getAnAparitie() > b.getAnAparitie())
            return 1;
        else
            return -1;
    }

    @Override
    public int compare(Film o1, Film o2) {
        return 0;
    }
}
