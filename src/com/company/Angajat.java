package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
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
        private List<Proiect> listaProiecte;
        private List<Salariu> listaSalarii;
        private List<Concediu> listaConcedii;


        public long getIdAngajat() {
            return idAngajat;
        }

        public void setIdAngajat(long idAngajat) {
            this.idAngajat = idAngajat;
        }

        public String getNume() {
            return nume;
        }

        public void setNume(String nume) {
            this.nume = nume;
        }

        public String getPrenume() {
            return prenume;
        }

        public void setPrenume(String prenume) {
            this.prenume = prenume;
        }

        public Date getDataAngajarii() {
            return dataAngajarii;
        }

        public void setDataAngajarii(Date dataAngajarii) {
            this.dataAngajarii = dataAngajarii;
        }

        public Angajat getSuperior() {
            return superior;
        }

        public void setSuperior(Angajat superior) {
            this.superior = superior;
        }

        public Departament getDepartament() {
            return departament;
        }

        public void setDepartament(Departament departament) {
            this.departament = departament;
        }

        public void setListaSalarii(List<Salariu> listaSalarii) {
            this.listaSalarii = listaSalarii;
        }

        public void setListaConcedii(List<Concediu> listaConcedii) {
            this.listaConcedii = listaConcedii;
        }

        public Functie getFunctie() {
            return functie;
        }

        public void setFunctie(Functie functie) {
            this.functie = functie;
        }

        public List<Proiect> getListaProiecte() {
            return listaProiecte;
        }

        public void setListaProiecte(List<Proiect> listaProiecte) {
            this.listaProiecte = listaProiecte;
        }

        public List<Salariu> getListaSalarii() {
            return listaSalarii;
        }

        public List<Concediu> getListaConcedii() {
            return listaConcedii;
        }

        public Angajat(long idAngajat, String nume, String prenume, Date dataAngajarii, long idSuperior, long idDepartament, long idFunctie) {
            this.idAngajat = idAngajat;
            this.nume = nume;
            this.prenume = prenume;
            this.dataAngajarii = dataAngajarii;
            this.superior = getAngajat(idSuperior);
            this.departament = departament;
            this.functie = functie;
        }

        private static final String Angajati_FILE = "c:\\InternshipBancaTransilvania\\Companie\\angajatiCompanie.txt";
        public static List<Angajat> listaAngajati = new ArrayList<>();

        public static List<Angajat> citireaTuturorAngajatilor() throws IOException {
            try (BufferedReader angajatReader = new BufferedReader(new FileReader(Angajati_FILE))) {
                String angajatLine = null;
                while ((angajatLine = angajatReader.readLine()) != null) {
                    if (angajatLine != null) {
                        String[] angajatiCompanie = angajatLine.split(";");
                        listaAngajati.add(new Angajat(Long.parseLong(angajatiCompanie[0]), angajatiCompanie[1], angajatiCompanie[2], new SimpleDateFormat("MM/dd/yyyy").parse(angajatiCompanie[3]), Long.parseLong(angajatiCompanie[4]), Long.parseLong(angajatiCompanie[5]), Long.parseLong(angajatiCompanie[6])));
                    }
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            return listaAngajati;
        }

        public static Angajat getAngajat(long idAngajat) {

            for (int i = 0; i < listaAngajati.size(); i++) {
                if (listaAngajati.get(i).idAngajat == idAngajat)
                    return listaAngajati.get(i);
            }
            return null;
        }

        public static long calculVechime(long idAngajat) throws IOException {

            try {
                int vechime = Period.between(Angajat.getAngajat(idAngajat).getDataAngajarii().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
                if (vechime == 0) return 1;
                else return vechime;
            } catch (Exception e) {
                return 0;
            }
        }



        public static long calculSalar(long idAngajat) throws IOException {
            List<Functie> functiiCompanie = new ArrayList<>();
            long salarActualizat = 0;
            try {
                functiiCompanie = Functie.citireaTuturorFunctiilor();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < functiiCompanie.size(); j++) {
                if (functiiCompanie.get(j).getIdFunctie() == Angajat.getAngajat(idAngajat).getFunctie().getIdFunctie()) {
                    salarActualizat = Angajat.calculVechime(idAngajat) * functiiCompanie.get(j).getSalarBaza();
                }
            }
        return salarActualizat;
        }


    }