package com.company;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code here text
        Scanner scan =new Scanner(System.in);
        //System.out.println("Introduceti id angajatului pentru care doriti sa se calculeze salariul: ");
        //Angajat angajatCompanie=new Angajat(55,"Rovina", "Luiza", new SimpleDateFormat("MM/dd/yyyy").parse("10/02/2018"),1, 1,8);
        /* List<Functie> functiiCompanie= new ArrayList<>();
        try {
            functiiCompanie=Functie.citireaTuturorFunctiilor();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for(int i =0 ; i<functiiCompanie.size();i++)
        {
            System.out.println(functiiCompanie.get(i).getDenumireFunctie());
    }*/


        List<Proiect> proiecteCompanie= new ArrayList<>();
        try {
            proiecteCompanie=Proiect.citireaTuturorProiectelor();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0 ; i<proiecteCompanie.size();i++)
        {
            System.out.println(proiecteCompanie.get(i).getDenumireProiect());
        }

        }
    }

    /*
        LocalDate data_curenta=LocalDate.now();
    public int calcul_vechime(Date data_angajarii, Date data_curenta) {
        int vechime = Period.between(super.getDataAngajarii(), data_curenta).getYears();
        if (vechime==0||vechime==1)
            return 1;
        else
        if(vechime>1)
            return vechime;
    }

    public int calcul_Salar(String nume, String denumire){
        int salarActualizat;
        if(denumire==this.denumireFunctie)
            salarActualizat=this.salarBaza*calcul_vechime(getDataAngajarii(),data_curenta);
    }*/


