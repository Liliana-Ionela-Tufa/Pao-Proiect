package Persoane;

public class Angajat extends Persoana{
    private String NumeJob;

    public Angajat(){
    }

    public Angajat(String nume, String prenume, int varsta, String NumeJob){
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.NumeJob = NumeJob;
    }

    public String getNumeJob() {
        return NumeJob;
    }

    public void setNumeJob(String numeJob) {
        NumeJob = numeJob;
    }

    @Override
    public String toString(){
        String output =  "nume: " + nume + '\n';
        output += "prenume: " + prenume + '\n';
        output += " varsta: " + varsta;
        output += " Nume Job: " + NumeJob;

        return output;
    }
}
