package com.company;

import java.util.Date;
import java.util.List;

public class Proiect {
    private long idProiect;
    private String denumireProiect;
    private Date dataInceput;
    private Date dataDeadline;
    private List<Angajat> angajati;

    public Proiect(long idProiect, String denumireProiect, Date dataInceput, Date dataDeadline){
        this.idProiect=idProiect;
        this.denumireProiect=denumireProiect;
        this.dataInceput=dataInceput;
        this.dataDeadline=dataDeadline;
    }


}
