package com.epf.core.model;

public class Plante {
    private Long id;
    private String nom;
    private Integer pointDeVie;
    private Integer attaqueParSeconde;
    private Integer degatAttaque;
    private Integer cout;
    private Integer soleilParSeconde;
    private String effet;
    private String cheminImage;

    public Plante() {}

    public Plante(Long id, String nom, Integer pointDeVie, Integer attaqueParSeconde, Integer degatAttaque,
                  Integer cout, Integer soleilParSeconde, String effet, String cheminImage) {
        this.id = id;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSeconde = soleilParSeconde;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }

    // Getters & Setters
    public Long getId_plante() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Integer getPoint_de_vie() { return pointDeVie; }
    public void setPointDeVie(Integer pointDeVie) { this.pointDeVie = pointDeVie; }

    public Integer getAttaque_par_seconde() { return attaqueParSeconde; }
    public void setAttaqueParSeconde(Integer attaqueParSeconde) { this.attaqueParSeconde = attaqueParSeconde; }

    public Integer getDegat_attaque() { return degatAttaque; }
    public void setDegatAttaque(Integer degatAttaque) { this.degatAttaque = degatAttaque; }

    public Integer getCout() { return cout; }
    public void setCout(Integer cout) { this.cout = cout; }

    public Integer getSoleil_par_seconde() { return soleilParSeconde; }
    public void setSoleilParSeconde(Integer soleilParSeconde) { this.soleilParSeconde = soleilParSeconde; }

    public String getEffet() { return effet; }
    public void setEffet(String effet) { this.effet = effet; }

    public String getChemin_image() { return cheminImage; }
    public void setCheminImage(String cheminImage) { this.cheminImage = cheminImage; }
}

