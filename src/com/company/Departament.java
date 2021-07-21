package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Departament {
    private long idDepartament;
    private String denumire;
    private String directorUnic;

    public long getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(long idDepartament) {
        this.idDepartament = idDepartament;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDirectorUnic() {
        return directorUnic;
    }

    public void setDirectorUnic(String directorUnic) {
        this.directorUnic = directorUnic;
    }

    public Departament(long idDepartament, String denumire, String directorUnic){
        this.idDepartament=idDepartament;
        this.denumire=denumire;
        this.directorUnic=directorUnic;
    }

    private static final String Departament_FILE = "c:\\InternshipBancaTransilvania\\Companie\\departamenteCompanie.txt";
    public static List<Departament> citireaTuturorDepartamentelor() throws IOException {
        List<Departament> listaDepartamente = new ArrayList<>();
        try (BufferedReader departamentReader = new BufferedReader(new FileReader(Departament_FILE))){
            String departamenteLine = null;
            while ((departamenteLine  = departamentReader.readLine()) != null) {
                if (departamenteLine != null) {
                    String[] departamenteCompanie = departamenteLine.split(";");
                    listaDepartamente.add(new Departament(Long.parseLong(departamenteCompanie[0]),departamenteCompanie[1],departamenteCompanie[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDepartamente;
    }
    public String afisareTotiAngajatiDinDepartament(String denumireDepartament) throws IOException {
        List<Angajat> totiAngajatiiCompanie = new ArrayList<>();
        try {
            totiAngajatiiCompanie = Angajat.citireaTuturorAngajatilor();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < totiAngajatiiCompanie.size(); i++) {

            if (denumireDepartament == this.denumire) {
                if (Angajat.getAngajat(i).getDepartament().equals(this.getIdDepartament()))
                    return (Angajat.getAngajat(i).getNume());
            }
        }return null;
    }
}
