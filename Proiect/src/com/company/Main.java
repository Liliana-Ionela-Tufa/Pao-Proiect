package com.company;

import com.company.config.databaseConfig;
import com.company.repository.AdresaRepository;
import com.company.repository.AngajatRepository;
import com.company.repository.PersoanaRepository;
import com.company.servicii.Servicii;

public class Main {


    public static void main(String[] args) {
        Servicii serviciu = new Servicii();
        /*serviciu.initializare();
        serviciu.afisareMeniu();
        serviciu.caseSwitch(); */

        AngajatRepository tabelaAngajati = new AngajatRepository();
        PersoanaRepository tabelaPersoane = new PersoanaRepository();
        AdresaRepository tabelaAdrese = new AdresaRepository();
        tabelaAngajati.CreateTable();
        tabelaAdrese.CreateTable();
        tabelaPersoane.CreateTable();

        serviciu.Meniu();
        databaseConfig.closeDatabaseConfig();
    }
}