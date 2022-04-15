package com.company.cinema;

public class Adresa {
    private String tara, oras, strada;
    private int numar;

    public Adresa(){
    }

    public Adresa(String tara, String oras, String strada, int numar){
        this.tara = tara;
        this.oras = oras;
        this.strada = strada;
        this.numar = numar;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public String toString(){
        String output ="tara: " + tara + '\n';
        output +="oras: " + oras + '\n';
        output +=" strada: " + strada + '\n';
        output +="numar: " + numar;

        return output;
    }
}
