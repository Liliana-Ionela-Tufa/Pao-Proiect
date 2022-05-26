package com.company.servicii;

import com.company.cinema.Adresa;
import com.company.cinema.Cinema;
import com.company.cinema.Sala;
import com.company.comparator.ComparareFilme;
import com.company.config.databaseConfig;
import com.company.filme.Film;
import com.company.filme.GenFilm;
import com.company.persoane.Actor;
import com.company.persoane.Angajat;
import com.company.persoane.Spectator;
import com.company.repository.AdresaRepository;
import com.company.repository.AngajatRepository;
import com.company.repository.PersoanaRepository;

import java.util.*;

public class Servicii {

    public com.company.config.databaseConfig databaseConfig;
    private Adresa adresa;
    private Cinema cinema;
    private final List<Angajat> angajati = new ArrayList<>();
    private final List<Film> filme = new ArrayList<>();
    private final List<Sala> sali = new ArrayList<>();
    private final List<Spectator> spectatori = new ArrayList<>();
    private final List<Actor> actori = new ArrayList<>();
    private final ScrieFisier scrieFisier = ScrieFisier.getInstance();
    private final AuditServiciu auditServiciu = AuditServiciu.getInstance();


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

    public void caseSwitch() {
        Scanner in = new Scanner(System.in);
        int optiune = 1;
        while (optiune > 0 && optiune < 11) {

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
                    System.out.print("S-a ales genul: " + gen + '\n');
                    filmeDupaGen(gen);
                    break;
                case 7:
                    int an;
                    while (true) {
                        System.out.print("An: ");
                        try {
                            an = Integer.parseInt(in.next());
                            break;
                        } catch (Exception e) {
                            System.out.println("Trebuie introdus un integer!");
                        }
                    }
                    filmeAparuteDupaAn(an);
                    break;
                case 8:
                    sortareFilmeDupaAn(filme);
                    break;
                case 9:
                    int id;
                    while (true) {
                        System.out.print("Id: ");
                        try {
                            id = Integer.parseInt(in.next());
                            break;
                        } catch (Exception e) {
                            System.out.println("Trebuie introdus un integer!");
                        }
                    }
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


    //Afisare detalii com.company.cinema
    public void afisareCinema() {
        Adresa adresa = new Adresa("Romania", "Bucuresti", "Republicii", 23);
        HashMap<String, Integer> ht1 = new HashMap<>();
        ht1.put("Luni", 12);
        ht1.put("Marti", 16);
        ht1.put("Miercuri", 10);
        String st = "The batman";
        String st2 = "Twilight";
        String st3 = "Meet Joe Black";
        Cinema cinema = new Cinema(adresa, Set.of(st, st2, st3), ht1);
        System.out.print(cinema.toString());
    }

    //Adaugare angajat nou
    public void adaugareAngajat() {
        ArrayList<String> list = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        System.out.print("Nume: ");
        String nume = in.nextLine();
        list.add(nume);

        System.out.print("Prenume: ");
        String prenume = in.nextLine();
        list.add(prenume);


        int varsta;
        while (true) {
            System.out.print("Varsta: ");
            try {
                varsta = Integer.parseInt(in.nextLine());
                list.add(String.valueOf(varsta));
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer!");
            }
        }
        System.out.print("Nume job: ");
        String numejob = in.nextLine();
        list.add(numejob);

        Angajat angajatNou = new Angajat(nume, prenume, varsta, numejob);
        angajati.add(angajatNou);

        scrieFisier.scrieF("C:\\pao\\Pao-Proiect\\Proiect\\src\\com\\company\\data\\angajat.csv", list);
        auditServiciu.logCommand("adaugare angajat");
    }

    public void adaugareFilm() {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> numeActori = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.print("Denumire: ");
        String denumire = in.nextLine();
        list.add(denumire);

        int rating;
        while (true) {
            System.out.print("Rating: ");
            try {
                rating = Integer.parseInt(in.next());
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer!");
            }
        }
        list.add(String.valueOf(rating));

        int anAparitie;
        while (true) {
            System.out.print("An aparitie: ");
            try {
                anAparitie = Integer.parseInt(in.next());
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer!");
            }
        }
        list.add(String.valueOf(anAparitie));

        GenFilm gen = GenFilm.GenRandom();
        list.add(String.valueOf(gen));

        int nrActori;
        while (true) {
            System.out.print("Nr actori: ");
            try {
                nrActori = Integer.parseInt(in.next());
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer!");
            }
        }

        System.out.print("introduceti numele actorilor: ");

        for (int i = 0; i < nrActori; i++) {
            String nume = in.next();
            numeActori.add(nume);
        }

        list.add(String.valueOf(numeActori));
        Film filmNou = new Film(denumire, rating, anAparitie, gen, numeActori);
        filme.add(filmNou);

        scrieFisier.scrieF("C:\\pao\\Pao-Proiect\\Proiect\\src\\com\\company\\data\\film.csv", list);
        auditServiciu.logCommand("adaugare film");

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


    //Afisare nume com.company.filme de acelasi gen
    public void filmeDupaGen(GenFilm gen) {
        for (Film film : filme) {
            if (film.getGen() == gen)
                System.out.print(film.getDenumire() + '\n');

        }
    }

    //Afisare nume com.company.filme care au aparut dupa un anumit an
    public void filmeAparuteDupaAn(int an) {
        for (Film film : filme) {
            if (film.getAnAparitie() > an)
                System.out.print(film.getDenumire() + '\n');

        }
    }


    //Sortarea filmelor dupa anul aparitiei
    public void sortareFilmeDupaAn(List<Film> filme) {
        filme.sort(new ComparareFilme());
        for (Film film : filme)
            System.out.print(film.getDenumire() + ' ' + film.getAnAparitie() + '\n');
    }

    //Numarul de spectatori a unei sali cu id-ul dat ca parametru
    public void afisareNrSpectatori(int idSala) {
        for (Sala sala : sali) {
            if (sala.getIdSala() == idSala)
                System.out.print(sala.getNrSpectatori() + '\n');
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

        int nr;
        while (true) {
            System.out.print("Numar: ");
            try {
                nr = Integer.parseInt(in.next());
                break;
            } catch (Exception e) {
                System.out.println("Trebuie introdus un integer!");
            }
        }

        System.out.print("\n");
        adresa.setTara(tara);
        adresa.setOras(oras);
        adresa.setStrada(strada);
        adresa.setNumar(nr);

        cinema.setAdresa(adresa);
        cinema.toString();
    }

    public void adaugareDate() {
        CitireFisier citireFisier = CitireFisier.getInstance();
        /*
        //sala.csv
        List<String[]> fisierC = citireFisier.citireF("src\\com\\company\\com.company.data\\sala.csv");
        for (String[] linie : fisierC) {
            int idSala = Integer.parseInt(linie[0]);
            int nrSpectatori = Integer.parseInt(linie[1]);

        } */

        //spectator.csv
        List<String[]> fisierC = citireFisier.citireF("src\\com\\company\\com.company.data\\spectator.csv");
        for (String[] linie : fisierC) {
            Spectator spectator = new Spectator(linie[0], linie[1], Integer.parseInt(linie[2]), Integer.parseInt(linie[3]), Integer.parseInt(linie[4]));
            spectatori.add(spectator);
        }

        //angajat.csv
        fisierC = citireFisier.citireF("src\\com\\company\\com.company.data\\angajat.csv");
        for (String[] linie : fisierC) {
            Angajat angajat = new Angajat(linie[0], linie[1], Integer.parseInt(linie[2]), linie[3]);
            angajati.add(angajat);
        }

        //film.csv
        fisierC = citireFisier.citireF("src\\com\\company\\com.company.data\\film.csv");
        for (String[] linie : fisierC) {
            String denumire = linie[0];
            int rating = Integer.parseInt(linie[1]);
            int anAparitie = Integer.parseInt(linie[2]);
            GenFilm gen = GenFilm.valueOf(linie[3]);

            String actor = String.valueOf(linie[4]);

            Film film = new Film(denumire, rating, anAparitie, gen, List.of(actor));
            filme.add(film);
        }


    }

    public void initializare() {

        Angajat a = new Angajat("Mircea", "Maria", 30, "Vanzator bilete");
        Angajat b = new Angajat("Popescu", "Andrei", 59, "Paznic");
        angajati.add(a);
        angajati.add(b);

        Spectator s = new Spectator("Dumitru", "Daniel", 20, 23, 3);
        Spectator ss = new Spectator("Popescu", "Ionut", 20, 23, 45);
        spectatori.add(s);
        spectatori.add(ss);


        String a1 = "Robert Pattinson";
        String a2 = "Zoe Kravitz";
        Film f1 = new Film("The Batman", 8, 2022, GenFilm.DRAMA, List.of(a1, a2));

        String a3 = "Kristen Stewart";
        Film f2 = new Film("Twilight", 10, 2008, GenFilm.ROMANTIC, List.of(a1, a3));

        Sala s1 = new Sala(23, 50, f1);
        Sala s2 = new Sala(14, 100, f2);
        sali.add(s1);
        sali.add(s2);

        String a4 = "Brad Pitt";
        String a5 = "Claire Forlani";
        Film f3 = new Film("Meet Joe Black", 10, 1998, GenFilm.DRAMA, List.of(a4, a5));
        filme.add(f1);
        filme.add(f2);
        filme.add(f3);


        Actor act = new Actor("Pattinson", "Robert", 35, 10, List.of(f1, f2));
        Actor act1 = new Actor("Pitt", "Brad", 58, 8, List.of(f3));
        actori.add(act);
        actori.add(act1);

        Adresa adresa = new Adresa("Romania", "Bucuresti", "Republicii", 23);
        HashMap<String, Integer> ht1 = new HashMap<>();
        ht1.put("Luni", 12);
        ht1.put("Marti", 16);
        ht1.put("Miercuri", 10);
        String st = "The batman";
        String st2 = "Twilight";
        String st3 = "Meet Joe Black";
        Cinema cinema = new Cinema(adresa, Set.of(st, st2, st3), ht1);
    }

    public void Meniu() {
        System.out.println("Alegeti un nr: 1-Angajat, 2-Persoana, 3-Adresa: ");
        int optiune = 1;
        while (optiune > 0 && optiune < 3) {
            Scanner in = new Scanner(System.in);
            System.out.print("Optiune: ");
            optiune = in.nextInt();

            switch (optiune) {
                case 1:
                    TabelaAngajati();
                    break;
                case 2:
                    TabelaPersoane();
                    break;
                case 3:
                    TabelaAdrese();
                    break;
                default:
                    System.out.print("Ati introdus o optiune invalida!" + '\n');
            }
        }
    }

    public void TabelaAngajati() {
        System.out.println("Alegeti un nr: 1-Add, 2-Update, 3-Delete, 4-Print: ");
        int optiune = 1;
        while (optiune > 0 && optiune < 4) {
            Scanner in = new Scanner(System.in);
            System.out.print("Optiune: ");
            optiune = in.nextInt();
            switch (optiune) {
                case 1:
                    System.out.print("Nume: ");
                    String nume = in.next();
                    System.out.print("Preume: ");
                    String prenume = in.next();
                    System.out.println("Varsta: ");
                    int varsta = Integer.parseInt(in.next());
                    System.out.println("Nume job: ");
                    String numeJob = in.next();

                    AngajatRepository tabelaAngajati = new AngajatRepository();
                    tabelaAngajati.AddAngajat(nume, prenume, varsta, numeJob);
                    auditServiciu.logCommand("adaugare angajat");
                    break;
                case 2:
                    System.out.print("Numele angajatului caruia vreti sa i schimbati jobul: ");
                    nume = in.next();
                    System.out.print("Job nou: ");
                    numeJob = in.next();
                    tabelaAngajati = new AngajatRepository();
                    tabelaAngajati.UpdateNumeJob(nume, numeJob);
                    auditServiciu.logCommand("update angajat");

                    break;
                case 3:
                    System.out.print("Numele angajatului pe care vreti sa il stergeti: ");
                    nume = in.next();
                    tabelaAngajati = new AngajatRepository();
                    tabelaAngajati.DeleteAngajat(nume);
                    auditServiciu.logCommand("stergere angajat");
                    break;
                case 4:
                    tabelaAngajati = new AngajatRepository();
                    tabelaAngajati.Print();
                    auditServiciu.logCommand("afisare angajati");

                    break;
                default:
                    System.out.print("Ati introdus o optiune invalida!" + '\n');

            }
        }
    }

    public void TabelaPersoane() {
        System.out.println("Alegeti un nr: 1-Add, 2-Update, 3-Delete, 4-Print: ");
        int optiune = 1;
        while (optiune > 0 && optiune < 4) {
            Scanner in = new Scanner(System.in);
            System.out.print("Optiune: ");
            optiune = in.nextInt();
            switch (optiune) {
                case 1:
                    System.out.print("Nume: ");
                    String nume = in.next();
                    System.out.print("Preume: ");
                    String prenume = in.next();
                    System.out.println("Varsta: ");
                    int varsta = Integer.parseInt(in.next());

                    PersoanaRepository tabelaPersoane = new PersoanaRepository();
                    tabelaPersoane.AddPersoana(nume, prenume, varsta);
                    auditServiciu.logCommand("adaugare persoana");

                    break;
                case 2:
                    System.out.print("Numele angajatului caruia vreti sa i schimbati varsta: ");
                    nume = in.next();
                    System.out.print("Varsta: ");
                    varsta = Integer.parseInt(in.next());

                    tabelaPersoane = new PersoanaRepository();
                    tabelaPersoane.UpdateVarsta(nume, varsta);
                    auditServiciu.logCommand("update persoana");

                    break;
                case 3:
                    System.out.print("Numele persoanei pe care vreti sa il stergeti: ");
                    nume = in.next();
                    tabelaPersoane = new PersoanaRepository();
                    tabelaPersoane.DeletePersoana(nume);
                    auditServiciu.logCommand("sterge persoana");

                    break;
                case 4:
                    tabelaPersoane = new PersoanaRepository();
                    tabelaPersoane.Print();
                    auditServiciu.logCommand("afisare persoane");

                    break;
                default:
                    System.out.print("Ati introdus o optiune invalida!" + '\n');
            }
        }
    }

    public void TabelaAdrese() {
        System.out.println("Alegeti un nr: 1-Add, 2-Update, 3-Delete, 4-Print: ");
        int optiune = 1;
        while (optiune > 0 && optiune < 4) {
            Scanner in = new Scanner(System.in);
            System.out.print("Optiune: ");
            optiune = in.nextInt();
            switch (optiune) {
                case 1:
                    System.out.print("tara: ");
                    String tara = in.next();
                    System.out.print("oras: ");
                    String oras = in.next();
                    System.out.println("Strada: ");
                    String strada = in.next();
                    System.out.println("numar: ");
                    int numar = Integer.parseInt(in.next());

                    AdresaRepository tabelaAdrese = new AdresaRepository();
                    tabelaAdrese.AddAdresa(tara, oras, strada, numar);
                    auditServiciu.logCommand("adaugare adresa");

                    break;
                case 2:
                    System.out.println("Strada: ");
                    strada = in.next();
                    System.out.println("numar: ");
                    numar = Integer.parseInt(in.next());

                    tabelaAdrese = new AdresaRepository();
                    tabelaAdrese.UpdateNumar(strada, numar);
                    auditServiciu.logCommand("update adresa");

                    break;
                case 3:
                    System.out.println("Strada: ");
                    strada = in.next();
                    tabelaAdrese = new AdresaRepository();
                    tabelaAdrese.DeleteAdresa(strada);
                    auditServiciu.logCommand("sterge adresa");

                    break;
                case 4:
                    tabelaAdrese = new AdresaRepository();
                    tabelaAdrese.Print();
                    auditServiciu.logCommand("afisare adrese");

                    break;
                default:
                    System.out.print("Ati introdus o optiune invalida!" + '\n');

            }
        }
    }
}

