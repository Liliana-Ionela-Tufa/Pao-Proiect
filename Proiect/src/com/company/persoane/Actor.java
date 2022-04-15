package com.company.persoane;

import com.company.filme.Film;

import java.util.ArrayList;
import java.util.List;

public class Actor extends Persoana{
    private int rating;
    protected List<Film> filme = new ArrayList<Film>();

    public Actor(){
    }

    public Actor(String nume, String prenume, int varsta, int rating, List<Film> filme) {
        this.setNume(nume);
        this.setPrenume(prenume);
        this.setVarsta(varsta);
        this.rating = rating;
        this.filme = filme;

    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Film> getFilme() {
        return filme;
    }

    public void setFilme(List<Film> filme) {
        this.filme = filme;
    }

    @Override
    public String toString(){
        String output =  "nume: " + getNume() + '\n';
        output += "pretume: " + getPrenume() + '\n';
        output += " rating: " + rating + '\n';
        output += " Fime: " + filme.toString();

        return output;
    }
}
