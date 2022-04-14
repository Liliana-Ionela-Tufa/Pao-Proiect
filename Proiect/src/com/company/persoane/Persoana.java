package com.company.persoane;

public class Persoana {
    private String nume, prenume;
    private int varsta;

    public Persoana(){
    }

    public Persoana(String nume, String prenume, int varsta){
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString(){
        String output =  "nume: " + nume + '\n';
        output += "prenume: " + prenume + '\n';
        output += " varsta: " + varsta;

        return output;
    }
}
