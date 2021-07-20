package com.company;

import java.util.Date;

public class Salariu {
    private long idSalariu;
    private Angajat angajat;
    private Date dataAcordare;
    private long suma;

    public long getIdSalariu() {
        return idSalariu;
    }

    public void setIdSalariu(long idSalariu) {
        this.idSalariu = idSalariu;
    }

    public Angajat getAngajat() {
        return angajat;
    }

    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }

    public Date getDataAcordare() {
        return dataAcordare;
    }

    public void setDataAcordare(Date dataAcordare) {
        this.dataAcordare = dataAcordare;
    }

    public long getSuma() {
        return suma;
    }

    public void setSuma(long suma) {
        this.suma = suma;
    }

    public Salariu(long idSalariu, Angajat angajat, Date dataAcordare, long suma){
        this.idSalariu=idSalariu;
        this.angajat=angajat;
        this.dataAcordare=dataAcordare;
        this.suma=suma;
    }
}
