package com.epf.api.DTO;

import com.epf.persistance.Plante;

public class PlanteDTO {
    private int id;
    private String nom;
    private int pointDeVie;
    private int attaqueParSeconde;
    private int degatAttaque;
    private int cout;
    private int soleilParSeconde;
    private String effet;
    private String cheminImage;

    public PlanteDTO() {}

    public PlanteDTO(int id, String nom, int pointDeVie, int attaqueParSeconde, int degatAttaque,
                     int cout, int soleilParSeconde, String effet, String cheminImage) {
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

    public static PlanteDTO fromModel(Plante plante) {
        return new PlanteDTO(
                plante.getId_plante(),
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image()
        );
    }

    public Plante toModel() {
        return new Plante(
                id,
                nom,
                pointDeVie,
                attaqueParSeconde,
                degatAttaque,
                cout,
                soleilParSeconde,
                effet,
                cheminImage
        );
    }

    // Getters & Setters
    public long getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getPoint_de_vie() { return pointDeVie; }
    public void setPointDeVie(int pointDeVie) { this.pointDeVie = pointDeVie; }

    public int getAttaque_par_seconde() { return attaqueParSeconde; }
    public void setAttaqueParSeconde(int attaqueParSeconde) { this.attaqueParSeconde = attaqueParSeconde; }

    public int getDegat_attaque() { return degatAttaque; }
    public void setDegatAttaque(int degatAttaque) { this.degatAttaque = degatAttaque; }

    public int getCout() { return cout; }
    public void setCout(int cout) { this.cout = cout; }

    public int getSoleil_par_seconde() { return soleilParSeconde; }
    public void setSoleilParSeconde(int soleilParSeconde) { this.soleilParSeconde = soleilParSeconde; }

    public String getEffet() { return effet; }
    public void setEffet(String effet) { this.effet = effet; }

    public String getChemin_image() { return cheminImage; }
    public void setCheminImage(String cheminImage) { this.cheminImage = cheminImage; }
}
