package Servicii;

import Cinema.Adresa;
import Cinema.Cinema;
import Cinema.Sala;
import Comparator.ComparareFilme;
import Filme.Film;
import Filme.GenFilm;
import Persoane.Actor;
import Persoane.Angajat;
import Persoane.Spectator;

import java.util.*;

public class Servicii {

    private Cinema cinema;
    private final List<Angajat> angajati = new ArrayList<>();
    private final List<Film> filme = new ArrayList<>();
    private final List<Sala> sali = new ArrayList<>();
    private final List<Spectator> spectatori = new ArrayList<>();
    private final List<Actor> actori = new ArrayList<>();




    public void afisareMeniu() {
        System.out.println("""
                Bun venit!
                1.Afisare detalii cinema
                2.Adaugare angajat nou
                3.Adaugare film nou
                4.Stergere angajat al carui nume este dat
                5.Stergere film al carui nume este dat
                6.Afisare nume filme care au un gen dat
                7.Afisare filme care au aparut dupa un an dat
                8.Sortarea filmelor dupa anul aparitiei
                9.Afisarea numarului de spectatori dintr-o sala cu id-ul dat
                10.Modificarea adresei """);
    }

    public void caseSwitch()
    {
        Scanner in = new Scanner(System.in);
        int optiune = 1;
        while (optiune>0 && optiune <11){

            System.out.print("Optiune: ");
            optiune = in.nextInt();

            switch (optiune) {
                case 1:
                    afisareCinema();
                    break;
                case 2:
                    adaugareAngajat();
                    break;
                case 3:
                    adaugareFilm();
                    break;
                case 4:
                    String numeA = in.nextLine();
                    stergereAngajat(angajati, numeA);
                    break;
                case 5:
                    String numeF = in.nextLine();
                    stergereFilm(filme, numeF);
                    break;
                case 6:
                    GenFilm gen = GenFilm.GenRandom();
                    filmeDupaGen(gen);
                    break;
                case 7:
                    int an = in.nextInt();
                    filmeAparuteDupaAn(an);
                    break;
                case 8:
                    sortareFilmeDupaAn(filme);
                    break;
                case 9:
                    int id = in.nextInt();
                    afisareNrSpectatori(id);
                    break;
                case 10:
                    setareAdresa();
                    break;
                default:
                    System.out.print("Ati introdus o optiune invalida!" + '\n');
            }
        }
    }

    //Afisare detalii cinema
    public void afisareCinema() {
        System.out.print(cinema.toString());
    }

    //Adaugare angajat nou
    public void adaugareAngajat() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nume: ");
        String nume = in.nextLine();

        System.out.print("Prenume: ");
        String prenume = in.nextLine();

        System.out.print("Nume job: ");
        String numejob = in.nextLine();

        System.out.print("Varsta: ");
        int varsta = Integer.parseInt(in.nextLine());

        Angajat angajatNou = new Angajat(nume, prenume, varsta, numejob);
        angajati.add(angajatNou);
    }

    public void adaugareFilm() {
        ArrayList<String> numeActori = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.print("Denumire: ");
        String denumire = in.nextLine();

        System.out.print("Rating: ");
        int rating = in.nextInt();

        System.out.print("An aparitie: ");
        int anAparitie = in.nextInt();


        GenFilm gen = GenFilm.GenRandom();

        System.out.print("Nr actori: ");
        int nrActori = in.nextInt();

        System.out.print("introduceti numele actorilor: ");

        for (int i = 0; i < nrActori; i++) {
            String nume = in.nextLine();
            numeActori.add(nume);
        }

        Film filmNou = new Film(denumire, rating, anAparitie, gen, numeActori);
        filme.add(filmNou);

    }


    //Stergere film dupa nume
    public void stergereFilm(List<Film> filme, String nume) {
        for (Film film : filme)
            if (film.getDenumire() == nume)
                filme.remove(film);
    }

    //Stergere angajat dupa nume
    public void stergereAngajat(List<Angajat> angajati, String nume) {
        for (Angajat angajat : angajati)
            if (angajat.getNume() == nume)
                angajati.remove(angajat);
    }


    //Afisare nume filme de acelasi gen
    public void filmeDupaGen(GenFilm gen) {
        for (Film film : filme) {
            if (film.getGen() == gen)
                System.out.print(film.getDenumire() + '\n');

        }
    }

    //Afisare nume filme care au aparut dupa un anumit an
    public void filmeAparuteDupaAn(int an) {
        for (Film film : filme) {
            if (film.getAnAparitie() > an)
                System.out.print(film.getDenumire() + '\n');

        }
    }


    //Sortarea filmelor dupa anul aparitiei
    public void sortareFilmeDupaAn(List<Film> filme)
    {
        filme.sort(new ComparareFilme());
        for (Film film : filme)
            System.out.print(film.getDenumire() + ' ' + film.getAnAparitie() + '\n');
    }

    //Numarul de spectatori a unei sali cu id-ul dat ca parametru
    public void afisareNrSpectatori(int idSala) {
        for (Sala sala : sali) {
            if (sala.getIdSala() == idSala)
                System.out.print(sala.getNrSpectatori()+ '\n');
        }
    }

    //Setare o noua adresa
    public void setareAdresa() {
        Scanner in = new Scanner(System.in);
        System.out.print("Tara: ");
        String tara = in.nextLine();

        System.out.print("Oras: ");
        String oras = in.nextLine();

        System.out.print("Strada: ");
        String strada = in.nextLine();

        System.out.print("Numar: ");
        int nr = in.nextInt();
        System.out.print("\n");

        cinema.getAdresa().setTara();
        cinema.getAdresa().setOras(oras);
        cinema.getAdresa().setStrada(strada);
        cinema.getAdresa().setNumar(nr);

        cinema.getAdresa().toString();
    }

    public void initializare(){

        Angajat a = new Angajat("Mircea", "Maria", 30, "Vanzator bilete");
        Angajat b = new Angajat("Popescu", "Andrei", 59, "Paznic");
        angajati.add(a);
        angajati.add(b);

        Spectator s = new Spectator("Dumitru", "Daniel", 20, 23, 3);
        Spectator ss = new Spectator("Popescu", "Ionut", 20, 23, 45);
        spectatori.add(s);
        spectatori.add(ss);

        Sala s1 = new Sala(23, 50, "The Batman");
        Sala s2 = new Sala(14, 100, "Twilight");
        sali.add(s1);
        sali.add(s2);

        String a1 = "Robert Pattinson";
        String a2 = "Zoe Kravitz";
        Film f1 = new Film("The Batman", 8, 2022, GenFilm.DRAMA, List.of(a1, a2) );

        String a3 = "Kristen Stewart";
        Film f2 = new Film("Twilight", 10, 2008, GenFilm.ROMANTIC, List.of(a1, a3));

        String a4 = "Brad Pitt";
        String a5 = "Claire Forlani";
        Film f3 = new Film("Meet Joe Black", 10, 1998, GenFilm.DRAMA, List.of(a4, a5));
        filme.add(f1);
        filme.add(f2);
        filme.add(f3);


        Actor act = new Actor("Pattinson", "Robert", 35, 10, List.of(f1, f2));
        Actor act1 = new Actor("Pitt", "Brad", 58,8, List.of(f3));
        actori.add(act);
        actori.add(act1);

        Adresa adresa = new Adresa("Romania", "Bucuresti", "Republicii", 23);
        Hashtable<String, Integer> ht1 = new Hashtable<>();
        ht1.put("Luni", 12);
        ht1.put("Marti", 16);
        ht1.put("Miercuri", 10);
        String st = "The batman";
        String st2 = "Twilight";
        String st3 = "Meet Joe Black";
        Cinema cinema = new Cinema(adresa, Set.of(st,st2, st3), ht1);
    }
}

