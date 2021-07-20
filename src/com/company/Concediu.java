package com.company;

import java.util.Date;

public class Concediu{
    private long idConcediu;
    private Angajat angajat;
    private Date dataInceputConcediu;
    private Date dataSfarsitConcediu;

    public Concediu(long idConcediu, Angajat angajat, Date dataInceputConcediu, Date dataSfarsitConcediu){
      this.idConcediu=idConcediu;
      this.angajat=angajat;
      dataInceputConcediu=dataInceputConcediu;
      dataSfarsitConcediu=dataSfarsitConcediu;
    }
}
