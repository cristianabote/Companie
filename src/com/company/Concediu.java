package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Concediu{
    private long idConcediu;
    private Angajat angajat;
    private Date dataInceputConcediu;
    private Date dataSfarsitConcediu;

    public long getIdConcediu() {
        return idConcediu;
    }

    public void setIdConcediu(long idConcediu) {
        this.idConcediu = idConcediu;
    }

    public Angajat getAngajat() {
        return angajat;
    }

    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }

    public Date getDataInceputConcediu() {
        return dataInceputConcediu;
    }

    public void setDataInceputConcediu(Date dataInceputConcediu) {
        this.dataInceputConcediu = dataInceputConcediu;
    }

    public Date getDataSfarsitConcediu() {
        return dataSfarsitConcediu;
    }

    public void setDataSfarsitConcediu(Date dataSfarsitConcediu) {
        this.dataSfarsitConcediu = dataSfarsitConcediu;
    }

    public Concediu(long idConcediu, Angajat angajat, Date dataInceputConcediu, Date dataSfarsitConcediu){
      this.idConcediu=idConcediu;
      this.angajat=angajat;
      dataInceputConcediu=dataInceputConcediu;
      dataSfarsitConcediu=dataSfarsitConcediu;
    }
    private static final String Concedii_FILE = "c:\\InternshipBancaTransilvania\\Companie\\concediiAngajati.txt";

    public List<Concediu> citireaTuturorConcediilor() throws IOException {
        List<Concediu> listaConcedii = new ArrayList<>();
        try (BufferedReader concediiReader = new BufferedReader(new FileReader(Concedii_FILE))){
            String concediiLine = null;
            while ((concediiLine  = concediiReader.readLine()) != null) {
                if (concediiLine != null) {
                    String[] concediiAngajati = concediiLine.split(";");
                    listaConcedii.add(new Concediu(Integer.parseInt(concediiAngajati[0]),Angajat.getAngajat(Long.parseLong(concediiAngajati[1])),new SimpleDateFormat("MM/dd/yyyy").parse(concediiAngajati[2]), new SimpleDateFormat("MM/dd/yyyy").parse(concediiAngajati[3])));
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return listaConcedii;
    }
}
