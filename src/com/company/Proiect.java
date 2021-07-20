package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class Proiect {
    private long idProiect;
    private String denumireProiect;
    private Date dataInceput;
    private Date dataDeadline;
    private List<Angajat> angajati;

    public long getIdProiect() {
        return idProiect;
    }

    public void setIdProiect(long idProiect) {
        this.idProiect = idProiect;
    }

    public String getDenumireProiect() {
        return denumireProiect;
    }

    public void setDenumireProiect(String denumireProiect) {
        this.denumireProiect = denumireProiect;
    }

    public Date getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(Date dataInceput) {
        this.dataInceput = dataInceput;
    }

    public Date getDataDeadline() {
        return dataDeadline;
    }

    public void setDataDeadline(Date dataDeadline) {
        this.dataDeadline = dataDeadline;
    }

    public List<Angajat> getAngajati() {
        return angajati;
    }

    public void setAngajati(List<Angajat> angajati) {
        this.angajati = angajati;
    }

    public Proiect(long idProiect, String denumireProiect, Date dataInceput, Date dataDeadline){
        this.idProiect=idProiect;
        this.denumireProiect=denumireProiect;
        this.dataInceput=dataInceput;
        this.dataDeadline=dataDeadline;
    }
    private static final String Proiecte_FILE = "c:\\InternshipBancaTransilvania\\Companie\\proiecteCompanie.txt";

    public static List<Proiect> citireaTuturorProiectelor() throws IOException {
        List<Proiect> listaProiecte = new ArrayList<>();
        try (BufferedReader proiectReader = new BufferedReader(new FileReader(Proiecte_FILE))){
            String proiecteLine = null;
            while ((proiecteLine  = proiectReader.readLine()) != null) {
                if (proiecteLine != null) {
                    String[] proiecteCompanie = proiecteLine.split(";");
                    listaProiecte.add(new Proiect(Integer.parseInt(proiecteCompanie[0]),proiecteCompanie[1],new SimpleDateFormat("MM/dd/yyyy").parse(proiecteCompanie[2]),new SimpleDateFormat("MM/dd/yyyy").parse(proiecteCompanie[3])));
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return listaProiecte;
    }


}
