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

    public static void main(String[] args) throws ParseException, IOException {
        //Afisarea numelui tuturor Angajatilor
        List<Angajat> totiAngajatiiCompanie = new ArrayList<>();
        try {
            totiAngajatiiCompanie = Angajat.citireaTuturorAngajatilor();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < totiAngajatiiCompanie.size(); i++) {
            System.out.println(totiAngajatiiCompanie.get(i).getNume());

        }

//Afisare denumirii si a salariilor de baza a tuturor functiilor
            List<Functie> functiiCompanie = new ArrayList<>();
        try {
            functiiCompanie = Functie.citireaTuturorFunctiilor();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < functiiCompanie.size(); j++) {
            System.out.println(functiiCompanie.get(j).getDenumireFunctie() + functiiCompanie.get(j).getSalarBaza());
        }

//Afisarea tuturor denumirilor proiectelor existente in companie
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
        System.out.println("Angajatul cu numele " +Angajat.getAngajat(2).getNume()+" are o vechime in firma de "+ Angajat.calculVechime(2)+" ani");

        //Angajat angajatCompanie=new Angajat(55,"Rovina", "Luiza", new SimpleDateFormat("MM/dd/yyyy").parse("10/02/2018"),1, 1,8);
 // Citirea id angajatului dorit de la tastatura pentru calcularea salariului
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti id-ul angajatului pentru care doriti sa se calculeze salariul: ");
        long idA=scan.nextInt();
        System.out.println(Angajat.calculSalar(idA));


    }
}





