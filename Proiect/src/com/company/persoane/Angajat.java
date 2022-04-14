package com.company.persoane;

public class Angajat extends Persoana{
    private String numeJob;

    public Angajat(){
    }

    public Angajat(String nume, String prenume, int varsta, String NumeJob){
        this.setNume(nume);
        this.setPrenume(prenume);
        this.setVarsta(varsta);
        this.numeJob = NumeJob;
    }

    public String getNumeJob() {
        return numeJob;
    }

    public void setNumeJob(String numeJob) {
        numeJob = numeJob;
    }

    @Override
    public String toString(){
        String output =  "nume: " + getNume() + '\n';
        output += "prenume: " + getPrenume() + '\n';
        output += " varsta: " + getVarsta();
        output += " Nume Job: " + numeJob;

        return output;
    }
}
