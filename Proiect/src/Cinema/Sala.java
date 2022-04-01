package Cinema;

public class Sala {
    private int idSala, nrSpectatori;
    private String filmCurent;

    public Sala(){
    }

    public Sala(int idSala, int nrSpectatori, String filmCurent){
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

    public String getFilmCurent() {
        return filmCurent;
    }

    public void setFilmCurent(String filmCurent) {
        this.filmCurent = filmCurent;
    }

    @Override
    public String toString(){
        String output = "Sala numarul: " + idSala + '\n';
        output += " Spectatori prezenti: " + nrSpectatori + '\n';
        output += " La filmul: " + filmCurent;

        return  output;
    }
}
