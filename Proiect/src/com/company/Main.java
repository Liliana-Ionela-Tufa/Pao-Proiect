package com.company;

import com.company.servicii.Servicii;

public class Main {


    public static void main(String[] args) {
        Servicii serviciu = new Servicii();
        serviciu.initializare();
        serviciu.afisareMeniu();
        serviciu.caseSwitch();
    }
}