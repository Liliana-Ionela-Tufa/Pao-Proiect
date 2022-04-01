package Persoane;

public class Spectator extends Persoana{
    private int nrSala, nrLoc;

    public Spectator(){
    }

    public Spectator(String nume, String prenume, int varsta, int nrSala, int nrLoc) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
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
        String output =  "nume: " + nume + '\n';
        output += " prenume: " + prenume + '\n';
        output += " varsta: " + varsta + '\n';
        output += " sala: " + nrSala + '\n';
        output += " numar loc: " + nrLoc;

        return output;
    }
}
