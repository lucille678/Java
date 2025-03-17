package com.epf.core.model;

public class Maps {
    private Long id;
    private String nom;
    private Integer difficulte;

    public Maps() {
    }

    public Maps(Long id, String nom, Integer difficulte) {
        this.id = id;
        this.nom = nom;
        this.difficulte = difficulte;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Integer getDifficulte() { return difficulte; }
    public void setDifficulte(Integer difficulte) { this.difficulte = difficulte; }
}
