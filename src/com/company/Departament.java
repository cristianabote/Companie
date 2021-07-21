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

    public Departament(long idDepartament, String denumire, String directorUnic) {
        this.idDepartament = idDepartament;
        this.denumire = denumire;
        this.directorUnic = directorUnic;
    }
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


    private static final String Departament_FILE = "c:\\InternshipBancaTransilvania\\Companie\\departamenteCompanie.txt";
    public static List<Departament> listaDepartamente = new ArrayList<>();
    public static List<Departament> citireaTuturorDepartamentelor() throws IOException {
        try (BufferedReader departamentReader = new BufferedReader(new FileReader(Departament_FILE))) {
            String departamenteLine = null;
            while ((departamenteLine = departamentReader.readLine()) != null) {
                if (departamenteLine != null) {
                    String[] departamenteCompanie = departamenteLine.split(";");
                    listaDepartamente.add(new Departament(Long.parseLong(departamenteCompanie[0]), departamenteCompanie[1], departamenteCompanie[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDepartamente;
    }

    public static void afisareTotiAngajatiDinDepartament(String denumireDepartament) throws IOException {
        List<Angajat> totiAngajatiiCompanie = new ArrayList<>();
        try {
            totiAngajatiiCompanie = Angajat.citireaTuturorAngajatilor();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0, gasit=0;
        long idDepartament=0;
            while(i<listaDepartamente.size()&&gasit==0){
                if (denumireDepartament.toLowerCase().equals(listaDepartamente.get(i).getDenumire().toLowerCase())){
                    gasit=1;
                    idDepartament=listaDepartamente.get(i).getIdDepartament();
                }
                i++;
            }
            if(gasit==0) {
                System.out.println("Departamentul nu a fost gasit.");
            }
            else{

                for (int k = 0; k < totiAngajatiiCompanie.size(); k++) {
                    if (totiAngajatiiCompanie.get(k).getIdDepartament()==idDepartament)
                    {
                    System.out.println(totiAngajatiiCompanie.get(k).getNume());
                    }
            }
        }
    }
}


