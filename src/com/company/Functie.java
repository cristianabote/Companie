package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Functie {
    private long idFunctie;
    private String denumireFunctie;
    private long salarBaza;

    public String getDenumireFunctie() {
        return denumireFunctie;
    }

    public void setDenumireFunctie(String denumireFunctie) {
        this.denumireFunctie = denumireFunctie;
    }

    public long getSalarBaza() {
        return salarBaza;
    }

    public void setSalarBaza(long salarBaza) {
        this.salarBaza = salarBaza;
    }

    public long getIdFunctie() {
        return idFunctie;
    }

    public void setIdFunctie(long idFunctie) {
        this.idFunctie = idFunctie;
    }

    public Functie(long idFunctie, String denumireFunctie, long salarBaza){
        this.idFunctie=idFunctie;
        this.denumireFunctie=denumireFunctie;
        this.salarBaza=salarBaza;
    }
    private static final String Functii_FILE = "c:\\InternshipBancaTransilvania\\Companie\\functiiCompanie.txt";

    public static List<Functie> citireaTuturorFunctiilor() throws IOException {
        List<Functie> listaFunctii = new ArrayList<>();
        try (BufferedReader functieReader = new BufferedReader(new FileReader(Functii_FILE))){
            String functieLine = null;
            while ((functieLine  = functieReader.readLine()) != null) {
                if (functieLine != null) {
                    String[] functiiCompanie = functieLine.split(";");
                    listaFunctii.add(new Functie(Long.parseLong(functiiCompanie[0]),functiiCompanie[1],Long.parseLong(functiiCompanie[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaFunctii;
    }
}
