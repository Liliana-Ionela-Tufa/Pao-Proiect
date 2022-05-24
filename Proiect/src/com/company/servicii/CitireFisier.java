package com.company.servicii;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitireFisier {
    private static CitireFisier instance = null;

    public CitireFisier() {
    }

    public static CitireFisier getInstance() {
        if (instance == null) {
            instance = new CitireFisier();
        }
        return instance;
    }

    public List<String[]> citireF(String caleFisier) {
        List<String[]> fisierC = null;
        try {
            File input = new File(caleFisier);
            Scanner reader = new Scanner(input);
            fisierC = new ArrayList<>();

            String linie = reader.nextLine();
            while (linie != null) {
                String[] list = linie.split(",");
                fisierC.add(list);
                linie = reader.nextLine();
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Calea: " + caleFisier + " este inexistenta.");
        }
        return fisierC;
    }

}
