package Filme;

import java.util.ArrayList;
import java.util.List;


public class Film {
    private String denumire;
    private int rating, anAparitie;
    private GenFilm gen;
    protected List<String> actori = new ArrayList<>();

    public Film(){
    }

    public Film(String denumire, int rating, int anAparitie, GenFilm gen, List<String> actori){
        this.denumire = denumire;
        this.rating = rating;
        this.anAparitie = anAparitie;
        this.gen = gen;
        this.actori = actori;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(int anAparitie) {
        this.anAparitie = anAparitie;
    }

    public List<String> getActori() {
        return actori;
    }

    public void setActori(List<String> actori) {
        this.actori = actori;
    }

    public GenFilm getGen() {
        return gen;
    }

    public void setGen(GenFilm gen) {
        this.gen = gen;
    }


    @Override
    public String toString(){
        String output =  "denumire: " + denumire + '\n';
        output += "an aparitie: " + anAparitie + '\n';
        output += " rating: " + rating + '\n';
        output += " gen: " + gen + '\n';
        output += " Actori: " + actori.toString();

        return output;
    }
}
