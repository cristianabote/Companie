package com.company;
import java.util.Date;
import java.util.List;

    public class Angajat {
        private long idAngajat;
        private String nume;
        private String prenume;
        private Date dataAngajarii;
        private Angajat superior;
        private Departament departament;
        private Functie functie;
        private List<Proiect> proiecte;
        private List<Salariu> salarii;
        private List<Concediu> concedii;


        public Angajat(long idAngajat, String nume, String prenume, Date dataAngajarii, Angajat superior, Departament departament, Functie functie){
            this.idAngajat=idAngajat;
            this.nume=nume;
            this.prenume=prenume;
            this.dataAngajarii=dataAngajarii;
            this.superior=superior;
            this.departament=departament;
            this.functie=functie;

        }

    }


