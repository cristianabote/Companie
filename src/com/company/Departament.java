package com.company;

public class Departament {
    private long idDepartament;
    private String denumire;
    private Angajat directorUnic;

    public Departament(long idDepartament, String denumire, Angajat directorUnic){
        this.idDepartament=idDepartament;
        this.denumire=denumire;
        this.directorUnic=directorUnic;
    }
}
