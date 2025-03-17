package com.epf.api.DTO;

import com.epf.core.model.Maps;

public class MapsDTO {
    private Long id;
    private String nom;
    private int difficulte;

    // Constructeur vide pour Spring
    public MapsDTO() {
    }

    public MapsDTO(Long id, String nom, int difficulte) {
        this.id = id;
        this.nom = nom;
        this.difficulte = difficulte;
    }

    // Convertit un modèle en DTO
    public static MapsDTO fromModel(Maps map) {
        return new MapsDTO(map.getId(), map.getNom(), map.getDifficulte());
    }

    // Convertit un DTO en modèle
    public Maps toModel() {
        return new Maps(id, nom, difficulte);
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getDifficulte() { return difficulte; }
    public void setDifficulte(int difficulte) { this.difficulte = difficulte; }
}
