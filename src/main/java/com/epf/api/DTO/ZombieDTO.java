package com.epf.api.DTO;

import com.epf.core.model.Zombie;

public class ZombieDTO {
    private Long id_zombie;
    private String nom;
    private Integer point_de_vie;
    private Integer attaque_par_seconde;
    private Integer degat_attaque;
    private Integer vitesse_de_deplacement;
    private String chemin_image;
    private Long id_map;

    // Constructeur vide pour Spring
    public ZombieDTO() {
    }

    public ZombieDTO(Long id_zombie, String nom, Integer point_de_vie, Integer attaque_par_seconde,
                     Integer degat_attaque, Integer vitesse_de_deplacement, String chemin_image,
                     Long id_map) {
        this.id_zombie = id_zombie;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.chemin_image = chemin_image;
        this.id_map = id_map;
    }

    // Convertit un modèle en DTO
    public static ZombieDTO fromModel(Zombie zombie) {
        return new ZombieDTO(zombie.getId_zombie(), zombie.getNom(), zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(), zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(), zombie.getId_map());
    }

    // Convertit un DTO en modèle
    public Zombie toModel() {
        return new Zombie(id_zombie, nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement,
                chemin_image, id_map);
    }

    // Getters et Setters
    public Long getId_zombie() { return id_zombie; }
    public void setId_zombie(Long id_zombie) { this.id_zombie = id_zombie; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Integer getPoint_de_vie() { return point_de_vie; }
    public void setPoint_de_vie(Integer point_de_vie) { this.point_de_vie = point_de_vie; }

    public Integer getAttaque_par_seconde() { return attaque_par_seconde; }
    public void setAttaque_par_seconde(Integer attaque_par_seconde) { this.attaque_par_seconde = attaque_par_seconde; }

    public Integer getDegat_attaque() { return degat_attaque; }
    public void setDegat_attaque(Integer degat_attaque) { this.degat_attaque = degat_attaque; }

    public Integer getVitesse_de_deplacement() { return vitesse_de_deplacement; }
    public void setVitesse_de_deplacement(Integer vitesse_de_deplacement) { this.vitesse_de_deplacement = vitesse_de_deplacement; }

    public String getChemin_image() { return chemin_image; }
    public void setChemin_image(String chemin_image) { this.chemin_image = chemin_image; }

    public Long getId_map() { return id_map; }
    public void setId_map(Long id_map) { this.id_map = id_map; }
}

