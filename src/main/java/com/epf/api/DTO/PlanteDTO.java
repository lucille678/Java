package com.epf.api.DTO;

import com.epf.core.model.Plante;

public class PlanteDTO {
    private long id;
    private String nom;
    private int pv;
    private int attaque;

    // Constructeur vide pour Spring
    public PlanteDTO() {
    }

    public PlanteDTO(long id, String nom, int pv, int attaque) {
        this.id = id;
        this.nom = nom;
        this.pv = pv;
        this.attaque = attaque;
    }

    // Convertit un modèle en DTO
    public static PlanteDTO fromModel(Plante plante) {
        return new PlanteDTO(plante.getId(), plante.getNom(), plante.getPv(), plante.getAttaque());
    }

    // Convertit un DTO en modèle
    public Plante toModel() {
        return new Plante(id, nom, pv, attaque);
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
}
