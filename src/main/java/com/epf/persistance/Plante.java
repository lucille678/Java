package com.epf.persistance;

public class Plante {
    private int id;
    private String nom;
    private int pv;
    private int attaque;

    public Plante() {} // Constructeur vide requis par Spring

    public Plante(int id, String nom, int pv, int attaque) {
        this.id = id;
        this.nom = nom;
        this.pv = pv;
        this.attaque = attaque;
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

    @Override
    public String toString() {
        return "Plante{id=" + id + ", nom='" + nom + "', pv=" + pv + ", attaque=" + attaque + "}";
    }
}
