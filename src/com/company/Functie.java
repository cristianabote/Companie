package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Functie {
    private long idFunctie;
    private String denumireFunctie;
    private long salarBaza;

    public Functie(long idFunctie, String denumireFunctie, long salarBaza){
        this.idFunctie=idFunctie;
        this.denumireFunctie=denumireFunctie;
        this.salarBaza=salarBaza;
    }

   // LocalDate data_curenta=LocalDate.now();
   /* public int calcul_vechime(Date data_angajarii, Date data_curenta) {
        int vechime = Period.between(super.getData_angajarii(), data_curenta).getYears();
        if (vechime==0||vechime==1)
            return 1;
        else
            if(vechime>1)
                return vechime;
    }

        public int calcul_Salar(String nume, String denumire){
        int salar_actualizat;
        if(denumire==this.denumire)
            salar_actualizat=this.salar_baza*calcul_vechime(getData_angajarii(),data_curenta);
    }*/
}
