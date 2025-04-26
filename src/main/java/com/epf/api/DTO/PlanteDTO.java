package com.epf.api.DTO;

import com.epf.persistance.Plante;

import java.math.BigDecimal;

public class PlanteDTO {
    private long id;
    private String nom;
    private int pointDeVie;
    private BigDecimal attaqueParSeconde; // Correction ici
    private int degatAttaque;
    private int cout;
    private BigDecimal soleilParSeconde; // Correction ici
    private String effet;
    private String cheminImage;

    public PlanteDTO() {}

    public PlanteDTO(long id, String nom, int pointDeVie, BigDecimal attaqueParSeconde, int degatAttaque,
                     int cout, BigDecimal soleilParSeconde, String effet, String cheminImage) {
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
    public long getId_plante() { return id; }
    public void setId_plante(long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getPointDeVie() { return pointDeVie; }
    public void setPointDeVie(int pointDeVie) { this.pointDeVie = pointDeVie; }

    public BigDecimal getAttaqueParSeconde() { return attaqueParSeconde; }
    public void setAttaqueParSeconde(BigDecimal attaqueParSeconde) { this.attaqueParSeconde = attaqueParSeconde; }

    public int getDegatAttaque() { return degatAttaque; }
    public void setDegatAttaque(int degatAttaque) { this.degatAttaque = degatAttaque; }

    public int getCout() { return cout; }
    public void setCout(int cout) { this.cout = cout; }

    public BigDecimal getSoleilParSeconde() { return soleilParSeconde; }
    public void setSoleilParSeconde(BigDecimal soleilParSeconde) { this.soleilParSeconde = soleilParSeconde; }

    public String getEffet() { return effet; }
    public void setEffet(String effet) { this.effet = effet; }

    public String getCheminImage() { return cheminImage; }
    public void setCheminImage(String cheminImage) { this.cheminImage = cheminImage; }
}
