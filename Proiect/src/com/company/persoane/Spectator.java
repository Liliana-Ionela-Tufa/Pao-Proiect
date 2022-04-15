package com.company.persoane;

public class Spectator extends Persoana{
    private int nrSala, nrLoc;

    public Spectator(){
    }

    public Spectator(String nume, String prenume, int varsta, int nrSala, int nrLoc) {
        this.setNume(nume);
        this.setPrenume(prenume);
        this.setVarsta(varsta);
        this.nrSala = nrSala;
        this.nrLoc = nrLoc;
    }

    public int getNrSala() {
        return nrSala;
    }

    public void setNrSala(int nrSala) {
        this.nrSala = nrSala;
    }

    public int getNrLoc() {
        return nrLoc;
    }

    public void setNrLoc(int nrLoc) {
        this.nrLoc = nrLoc;
    }

    @Override
    public String toString(){
        String output =  "nume: " + getNume() + '\n';
        output += " prenume: " + getPrenume() + '\n';
        output += " varsta: " + getVarsta() + '\n';
        output += " sala: " + nrSala + '\n';
        output += " numar loc: " + nrLoc;

        return output;
    }
}
