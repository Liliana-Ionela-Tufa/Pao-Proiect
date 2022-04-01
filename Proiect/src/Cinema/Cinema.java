package Cinema;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Cinema {
    private Adresa adresa;
    private Set<String> filme;
    Hashtable<String, Integer> NrOreDeschisPeZi = new Hashtable<>(7);
    private List<String> zile = new ArrayList<>();

    public Cinema(){
    }

    public Cinema(Adresa adresa, Set<String>filme, Hashtable<String, Integer> NrOreDeschisPeZi){
        this.adresa = adresa;
        this.filme = filme;
        this.NrOreDeschisPeZi = NrOreDeschisPeZi;
    }

    public Set<String> getFilme() {
        return filme;
    }

    public void setFilme(Set<String> filme) {
        this.filme = filme;
    }

    public Hashtable<String, Integer> getNrOreDeschisPeZi() {
        return NrOreDeschisPeZi;
    }

    public void setNrOreDeschisPeZi(Hashtable<String, Integer> nrOreDeschisPeZi) {
        NrOreDeschisPeZi = nrOreDeschisPeZi;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }




    @Override
    public String toString(){
        String output = "Filmele disponibile sunt: ";
        for(String film : filme)
            output += film + " ";
        if(adresa != null)
            output += "Adresa cinema: " + adresa.toString() + '\n';

        return output;
    }
}
