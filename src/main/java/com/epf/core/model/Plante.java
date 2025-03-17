package com.epf.core.model;

public class Plante {
    private Long id;
    private String nom;
    private Integer pv;
    private Integer attaque;

    public Plante() {
    }

    public Plante(Long id, String nom, Integer pv, Integer attaque) {
        this.id = id;
        this.nom = nom;
        this.pv = pv;
        this.attaque = attaque;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Integer getPv() { return pv; }
    public void setPv(Integer pv) { this.pv = pv; }
    public Integer getAttaque() { return attaque; }
    public void setAttaque(Integer attaque) { this.attaque = attaque; }
}

