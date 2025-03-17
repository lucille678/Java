package com.epf.api.DTO;

import com.epf.core.model.Zombie;

public class ZombieDTO {
    private Long id;
    private String nom;
    private int pv;
    private int attaque;
    private int vitesse;

    // Constructeur vide pour Spring
    public ZombieDTO() {
    }

    public ZombieDTO(Long id, String nom, int pv, int attaque, int vitesse) {
        this.id = id;
        this.nom = nom;
        this.pv = pv;
        this.attaque = attaque;
        this.vitesse = vitesse;
    }

    // Convertit un modèle en DTO
    public static ZombieDTO fromModel(Zombie zombie) {
        return new ZombieDTO(zombie.getId(), zombie.getNom(), zombie.getPv(), zombie.getAttaque(), zombie.getVitesse());
    }

    // Convertit un DTO en modèle
    public Zombie toModel() {
        return new Zombie(id, nom, pv, attaque, vitesse);
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getPv() { return pv; }
    public void setPv(int pv) { this.pv = pv; }

    public int getAttaque() { return attaque; }
    public void setAttaque(int attaque) { this.attaque = attaque; }

    public int getVitesse() { return vitesse; }
    public void setVitesse(int vitesse) { this.vitesse = vitesse; }
}
