package com.company.cinema;

import java.util.*;

public class Cinema {
    private Adresa adresa;
    private Set<String> filme;
    private HashMap<String, Integer> nrOreDeschisPeZi = new HashMap<>(7);
    private List<String> zile = new ArrayList<>();

    public Cinema(){
    }

    public Cinema(Adresa adresa, Set<String>filme, HashMap<String, Integer> NrOreDeschisPeZi){
        this.adresa = adresa;
        this.filme = filme;
        this.nrOreDeschisPeZi = NrOreDeschisPeZi;
    }

    public Set<String> getFilme() {
        return filme;
    }

    public void setFilme(Set<String> filme) {
        this.filme = filme;
    }

    public HashMap<String, Integer> getNrOreDeschisPeZi() {
        return nrOreDeschisPeZi;
    }

    public void setNrOreDeschisPeZi(HashMap<String, Integer> nrOreDeschisPeZi) {
        nrOreDeschisPeZi = nrOreDeschisPeZi;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }


    @Override
    public String toString(){
        String output = "Detalii cinema:" + '\n';
        if(filme.size()==0)
            System.out.println("Nu exista filme" + '\n');
        output += "Filmele disponibile sunt: ";
        output += '\n';
        for(String film : filme)
            output += film + '\n';
        if(adresa == null)
            output += "Nu exista adresa" + '\n';
        else
            output += "Adresa cinema: " + '\n' + adresa.toString() + '\n';


        return output;
    }
}
