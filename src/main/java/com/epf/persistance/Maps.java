package com.epf.persistance;


public class Maps {
    private int id;
    private String nom;
    private int largeur;
    private int hauteur;

    public Maps() {}

    public Maps(int id, String nom, int largeur, int hauteur) {
        this.id = id;
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getLargeur() { return largeur; }
    public void setLargeur(int largeur) { this.largeur = largeur; }

    public int getHauteur() { return hauteur; }
    public void setHauteur(int hauteur) { this.hauteur = hauteur; }

    @Override
    public String toString() {
        return "Map{id=" + id + ", nom='" + nom + "', largeur=" + largeur + ", hauteur=" + hauteur + "}";
    }
}

