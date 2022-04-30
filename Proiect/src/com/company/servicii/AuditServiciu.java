package com.company.servicii;

import java.sql.Timestamp;
import java.util.ArrayList;

public class AuditServiciu {
    private static AuditServiciu instance = null;
    private ScrieFisier scrieFisier = ScrieFisier.getInstance();
    private AuditServiciu(){
    }

    public static AuditServiciu getInstance(){
        if(instance == null){
            instance = new AuditServiciu();
        }
        return instance;
    }

    public void logCommand(String numeActiune){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ArrayList<String> fisierAudit = new ArrayList<String>();
        fisierAudit.add(numeActiune);
        fisierAudit.add(String.valueOf(timestamp));
        scrieFisier.scrieF("src\\com\\company\\data\\audit.csv", fisierAudit);
    }
}
