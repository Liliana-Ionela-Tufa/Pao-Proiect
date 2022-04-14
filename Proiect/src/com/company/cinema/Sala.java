package com.company.cinema;

import com.company.filme.Film;

public class Sala {
    private int idSala, nrSpectatori;
    private Film filmCurent;

    public Sala(){
    }

    public Sala(int idSala, int nrSpectatori, Film filmCurent){
        this.idSala = idSala;
        this.nrSpectatori = nrSpectatori;
        this.filmCurent = filmCurent;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getNrSpectatori() {
        return nrSpectatori;
    }

    public void setNrSpectatori(int nrSpectatori) {
        this.nrSpectatori = nrSpectatori;
    }

    public void setFilmCurent(Film filmCurent) {
        this.filmCurent = filmCurent;
    }
    public Film getFilmCurent() {
        return filmCurent;
    }

    @Override
    public String toString(){
        String output = "Sala numarul: " + idSala + '\n';
        output += " Spectatori prezenti: " + nrSpectatori + '\n';
        output += " La filmul: " + filmCurent.getDenumire();

        return  output;
    }
}
