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
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Calcularea salariului unui angajat in functie de vechimea lui.");
        System.out.println("2. Afisarea tuturor concediilor din companie, a tuturor proiectelor si persoanele indisponibile.");
        System.out.println("3. Afisarea tuturor angajatilor dintr-un departament al companiei.");
        System.out.println("4. Afisarea tuturor proiectelor din cadrul companiei.");//
        System.out.println("5. Afisarea tuturor functiilor cu salarul de baza aferent fiecarei functii.");
        System.out.println("Introduceti optiunea dorita: ");
        int optiune = scan.nextInt();
        switch (optiune) {
            case 1:{
                    //Afisarea numelui tuturor Angajatilor
                    System.out.println("Afisarea numelui tuturor angajatilor: ");
                    List<Angajat> totiAngajatiiCompaniei = new ArrayList<>();
                    try {
                        totiAngajatiiCompaniei = Angajat.citireaTuturorAngajatilor();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < totiAngajatiiCompaniei.size(); i++) {
                        System.out.println(totiAngajatiiCompaniei.get(i).getIdAngajat() + "." +totiAngajatiiCompaniei.get(i).getNume());
                    }
                    // System.out.println("Angajatul cu numele " +Angajat.getAngajat(2).getNume()+" are o vechime in firma de "+ Angajat.calculVechime(2)+" ani");

                    // Citirea id angajatului dorit de la tastatura pentru calcularea salariului
                    System.out.println("Introduceti id-ul angajatului pentru care doriti sa se calculeze salariul: ");
                    long idA=scan.nextInt();

                    // Calcularea Salariului Angajatului introdus
                    System.out.println(Angajat.calculSalar(idA));
                break;
            }

            case 2: {
                //Afisarea tuturor concediilor din companie
                System.out.println("Afisarea tuturor concediilor din companie");
                List<Concediu> concediiAngajati = new ArrayList<>();
                try {
                    concediiAngajati =Concediu.citireaTuturorConcediilor();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < concediiAngajati.size(); i++) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println(formatter.format((concediiAngajati.get(i).getDataInceputConcediu()))+"-"+formatter.format((concediiAngajati.get(i).getDataSfarsitConcediu())));
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
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println(proiecteCompanie.get(i).getIdProiect()+"."+proiecteCompanie.get(i).getDenumireProiect()+":"+(formatter.format((proiecteCompanie.get(i).getDataInceput()))+"-"+(formatter.format((proiecteCompanie.get(i).getDataDeadline())))));
                }

                // Citirea denumirii proiectului pentru care doriti sa se afiseze toti angajatii indisponibili.
                System.out.println("Introduceti denumirea proiectului pentru care doriti sa se afiseze toti angajatii indisponibili: ");
                String numeleProiectului=scan.next();
                Proiect.numeAngajatiIndisponibili(numeleProiectului);
                break;
            }
            case 3: {
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

                // Citirea denumirii departamentului pentru care doriti sa se afiseze toti angajatii

                System.out.println("Introduceti denumirea departamentului pentru care doriti sa se afiseze toti angajatii: ");
                String numeleDepartamentului=scan.next();
                //Afisarea angajatilor din departamentul precizat
                System.out.println("Afisarea angajatilor din departamentul precizat");
                Departament.afisareTotiAngajatiDinDepartament(numeleDepartamentului);
                break;
            }
            case 4: {
                //Afisarea tuturor denumirilor proiectelor existente in companie
                System.out.println("Afisarea denumirilor tuturor proiectelor existente in companie: ");
                List<Proiect> proiecteCompanie = new ArrayList<>();
                try {
                    proiecteCompanie = Proiect.citireaTuturorProiectelor();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < proiecteCompanie.size(); i++) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println(proiecteCompanie.get(i).getIdProiect()+"."+proiecteCompanie.get(i).getDenumireProiect()+":"+(formatter.format((proiecteCompanie.get(i).getDataInceput()))+"-"+(formatter.format((proiecteCompanie.get(i).getDataDeadline())))));
                }
            }
            case 5: {
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
            }
            default:
                System.out.println("optiune invalida");
        }
    }
}





