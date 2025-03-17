package com.epf.core.model;

public class Zombie {
    private Long id;
    private String nom;
    private Integer pv;
    private Integer attaque;
    private Integer vitesse;

    public Zombie() {
    }

    public Zombie(Long id, String nom, Integer pv, Integer attaque, Integer vitesse) {
        this.id = id;
        this.nom = nom;
        this.pv = pv;
        this.attaque = attaque;
        this.vitesse = vitesse;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Integer getPv() { return pv; }
    public void setPv(Integer pv) { this.pv = pv; }
    public Integer getAttaque() { return attaque; }
    public void setAttaque(Integer attaque) { this.attaque = attaque; }
    public Integer getVitesse() { return vitesse; }
    public void setVitesse(Integer vitesse) { this.vitesse = vitesse; }
}
