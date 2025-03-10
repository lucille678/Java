package com.epf.persistance;

public class Zombie {
    private int id;
    private String nom;
    private int pv;
    private int attaque;
    private int vitesse;

    public Zombie() {}

    public Zombie(int id, String nom, int pv, int attaque, int vitesse) {
        this.id = id;
        this.nom = nom;
        this.pv = pv;
        this.attaque = attaque;
        this.vitesse = vitesse;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getPv() { return pv; }
    public void setPv(int pv) { this.pv = pv; }

    public int getAttaque() { return attaque; }
    public void setAttaque(int attaque) { this.attaque = attaque; }

    public int getVitesse() { return vitesse; }
    public void setVitesse(int vitesse) { this.vitesse = vitesse; }

    @Override
    public String toString() {
        return "Zombie{id=" + id + ", nom='" + nom + "', pv=" + pv + ", attaque=" + attaque + ", vitesse=" + vitesse + "}";
    }
}
