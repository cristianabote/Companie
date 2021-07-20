package com.company;

import java.util.Date;

public class Salariu {
    private long idSalariu;
    private Angajat angajat;
    private Date dataAcordare;
    private long suma;

    public Salariu(long idSalariu, Angajat angajat, Date dataAcordare, long suma){
        this.idSalariu=idSalariu;
        this.angajat=angajat;
        this.dataAcordare=dataAcordare;
        this.suma=suma;
    }
}
