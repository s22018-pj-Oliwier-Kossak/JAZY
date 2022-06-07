package com.example.movies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieEntity {
    public MovieEntity(){}

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nazwa;
    private String kategoria;
    private int budzet;
    private boolean isAvaible=false;

    public MovieEntity(String nazwa,String kategoria,int budzet,boolean isAvaible) {
        this.nazwa=nazwa;
        this.kategoria=kategoria;
        this.budzet=budzet;
        this.isAvaible=isAvaible;

    }

//    @Override
//    public String toString() {
//        return "MovieEntity{" +
//                "Id=" + id +
//                ", Nazwa='" + nazwa + '\'' +
//                ", Kategoria='" + kategoria + '\'' +
//                ", budzet=" + budzet +
//                ", isAvaible=" + isAvaible +
//                '}';
//    }

    public boolean isAvaible() {
        return isAvaible;
    }

    public void setAvaible(boolean avaible) {
        isAvaible = avaible;
    }

    public int getBudzet() {
        return budzet;
    }

    public void setBudzet(int budzet) {
        this.budzet = budzet;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        kategoria = kategoria;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        nazwa = nazwa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }
}
