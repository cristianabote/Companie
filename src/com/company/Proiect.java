package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
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
    public static List<Proiect> listaProiecte = new ArrayList<>();
    public static List<Proiect> citireaTuturorProiectelor() throws IOException {

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
   public void numeAngajatiIndisponibili(String denumireProiect) throws IOException {
        List<Angajat> totiAngajatiiCompanie = new ArrayList<>();
        List<Concediu> concediuAngajat = new ArrayList<>();
        try {
            totiAngajatiiCompanie = Angajat.citireaTuturorAngajatilor();
            concediuAngajat =Concediu.citireaTuturorConcediilor();
        } catch (IOException e) {
            e.printStackTrace();
        }
       int i=0, gasit=0;
       long idProiect=0;
       while(i<listaProiecte.size()&&gasit==0){
           if (denumireProiect.toLowerCase().equals(listaProiecte.get(i).getDenumireProiect().toLowerCase())){
               gasit=1;
               idProiect=listaProiecte.get(i).getIdProiect();
           }
           i++;
       }
       if(gasit==0) {
           System.out.println("Proiectul nu a fost gasit.");
       }
  /*      for (int k = 0; k < totiAngajatiiCompanie.size(); i++) {
           boolean ok = LocalDate.parse(concediuAngajat.get(k).getDataSfarsitConcediu()).isbefore(LocalDate.parse(listaProiecte.get(k).getDataInceput()))||LocalDate.parse(concediuAngajat.get(k).getDataInceputConcediu()).isAfter(LocalDate.parse(listaProiecte.get(k).getDataInceput()));
           boolean notok=LocalDate.parse(concediuAngajat.get(k).getDataInceputConcediu()).isAfter(LocalDate.parse(listaProiecte.get(k).getDataInceput()))&&LocalDate.parse(concediuAngajat.get(k).getDataInceputConcediu()).
                   isBefore(LocalDate.parse(listaProiecte.get(k).getDataDeadline()))||LocalDate.parse(concediuAngajat.get(k).getDataSfarsitConcediu()).isAfter(LocalDate.parse(listaProiecte.get(k).getDataInceput()));

            if (totiAngajatiiCompanie.get(k).getIdAngajat()==concediuAngajat.get(k).getAngajat().getIdAngajat())

            {
                System.out.println(totiAngajatiiCompanie.get(k).getNume());
                }
            }*/
    }
}
    /*google
    the relationship of a date to another can be determined to occur before or after another date:
  boolean notBefore = LocalDate.parse("2016-06-12")
            .isBefore(LocalDate.parse("2016-06-11"));


    boolean isAfter = LocalDate.parse("2016-06-12")
            .isAfter(LocalDate.parse("2016-06-11"));

   boolean ok = dataendconcediu.isbefore(datastartproiect)||(datstartconcediu.isafter(dataendproiect));
   boolean notok = (datastartconcediu.isafter(datastatproiect)&&datastartoncediu.isbefore(dataendproiect))||(dataendconcediu.isafter(datastartproiect))*/