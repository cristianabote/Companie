package com.company;

public class Departament {
    private long idDepartament;
    private String denumire;
    private Angajat directorUnic;

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

    public Angajat getDirectorUnic() {
        return directorUnic;
    }

    public void setDirectorUnic(Angajat directorUnic) {
        this.directorUnic = directorUnic;
    }

    public Departament(long idDepartament, String denumire, Angajat directorUnic){
        this.idDepartament=idDepartament;
        this.denumire=denumire;
        this.directorUnic=directorUnic;
    }
}
