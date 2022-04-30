package com.company.servicii;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ScrieFisier {
    private static ScrieFisier instance = null;

    public ScrieFisier() {
    }

    public static ScrieFisier getInstance() {
        if (instance == null) {
            instance = new ScrieFisier();
        }
        return instance;
    }

    public void scrieF(String caleFisier, List<String> list) {
        File output = new File(caleFisier);

        try {

            FileWriter writer = new FileWriter(output, true);
            StringBuilder fisierS = new StringBuilder();
            int nr = 0;
            for (String sir : list) {
                fisierS.append(sir);
                nr++;
                if (nr != list.size()) {
                    fisierS.append(',');
                }
            }
            fisierS.append('\n');
            writer.write(fisierS.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("Eroare!");
            e.printStackTrace();
        }
    }
}
