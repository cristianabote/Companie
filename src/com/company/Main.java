package com.company;
import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws ParseException {

        List<Angajat> totiAngajatiiCompanie = new ArrayList<>();
        try {
            totiAngajatiiCompanie = Angajat.citireaTuturorAngajatilor();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < totiAngajatiiCompanie.size(); i++) {
            System.out.println(totiAngajatiiCompanie.get(i).getNume());

        }


            List<Functie> functiiCompanie = new ArrayList<>();
            try {
                functiiCompanie = Functie.citireaTuturorFunctiilor();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < functiiCompanie.size(); j++) {
                System.out.println(functiiCompanie.get(j).getDenumireFunctie() + functiiCompanie.get(j).getSalarBaza());
            }
       /* Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti id-ul angajatului pentru care doriti sa se calculeze salariul: ");
        long idA=scan.nextInt();
        if()
        //Angajat angajatCompanie=new Angajat(55,"Rovina", "Luiza", new SimpleDateFormat("MM/dd/yyyy").parse("10/02/2018"),1, 1,8);


            int salarActualizat;
            if(denumire==this.denumireFunctie)
                salarActualizat=this.salarBaza*calcul_vechime(getDataAngajarii(),data_curenta);
        }*/

        List<Proiect> proiecteCompanie = new ArrayList<>();
        try {
            proiecteCompanie = Proiect.citireaTuturorProiectelor();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < proiecteCompanie.size(); i++) {
            System.out.println(proiecteCompanie.get(i).getDenumireProiect());
        }

        System.out.println(Angajat.getAngajat(1).getNume());

        }

    }





