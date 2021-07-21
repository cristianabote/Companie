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
        System.out.println("Afisarea numelui tuturor angajatilor: ");
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
        System.out.println("Afisarea denumirii tuturor functiilor si a salariilor de baza a acestora: ");
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
        System.out.println("Afisarea denumirilor tuturor proiectelor existente in companie: ");
        List<Proiect> proiecteCompanie = new ArrayList<>();
        try {
            proiecteCompanie = Proiect.citireaTuturorProiectelor();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < proiecteCompanie.size(); i++) {
            System.out.println(proiecteCompanie.get(i).getDenumireProiect());
        }

        //Afisarea tuturor denumirilor departamentelor din companie
        System.out.println("Afisarea denumirilor tuturor departamentelor din companie: ");
        List<Departament> departamenteCompanie = new ArrayList<>();
        try {
            departamenteCompanie = Departament.citireaTuturorDepartamentelor();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < departamenteCompanie.size(); i++) {
            System.out.println(departamenteCompanie.get(i).getDenumire());
        }


        System.out.println(Angajat.getAngajat(1).getNume());
        System.out.println("Angajatul cu numele " +Angajat.getAngajat(2).getNume()+" are o vechime in firma de "+ Angajat.calculVechime(2)+" ani");


 // Citirea id angajatului dorit de la tastatura pentru calcularea salariului
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti id-ul angajatului pentru care doriti sa se calculeze salariul: ");
        long idA=scan.nextInt();
 // Calcularea Salariului Angajatului introdus
        System.out.println(Angajat.calculSalar(idA));


// Citirea denumirii departamentului pentru care doriti sa se afiseze toti angajatii
        System.out.println("Introduceti denumirea departamentului pentru care doriti sa se afiseze toti angajatii: ");
        String numeleDepartamentului=scan.next();
//Afisarea angajatilor din departamentul precizat
        
    }
}





