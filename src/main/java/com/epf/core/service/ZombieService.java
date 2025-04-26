package com.epf.core.service;

import com.epf.persistance.Zombie;
import com.epf.persistance.implementation.ZombieImplementationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ZombieService {
    private static final Logger logger = LoggerFactory.getLogger(ZombieService.class);
    private final ZombieImplementationDAO zombieDAO;

    @Autowired
    public ZombieService(ZombieImplementationDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    // Ajouter un zombie
    public void ajouterZombie(Zombie zombie) {
        if (zombie.getNom() == null || zombie.getNom().isEmpty()) {
            throw new IllegalArgumentException("Le nom du zombie ne peut pas être vide.");
        }
        if (zombie.getPoint_de_vie() == null || zombie.getPoint_de_vie() <= 0) {
            throw new IllegalArgumentException("Les points de vie doivent être supérieurs à 0.");
        }
        logger.info("Ajout d'un zombie : {}", zombie.getNom());
        zombieDAO.ajouterZombie(zombie);
    }

    // Lister tous les zombies
    public List<Zombie> listerZombies() {
        logger.info("Récupération de tous les zombies.");
        return zombieDAO.listerZombies();
    }

    // Trouver un zombie par ID
    public Zombie trouverParId(Long id) {
        try {
            logger.info("Recherche du zombie avec ID : {}", id);
            return zombieDAO.trouverParId(id);
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération du zombie avec ID : {}", id, e);
            throw new RuntimeException("Erreur lors de la récupération du zombie avec ID : " + id, e);
        }
    }

    // Mettre à jour un zombie
    public void mettreAJour(Zombie zombie) {
        if (zombie.getId_zombie() == null) {
            throw new IllegalArgumentException("L'ID du zombie est requis pour la mise à jour.");
        }
        logger.info("Mise à jour du zombie avec ID : {}", zombie.getId_zombie());
        zombieDAO.mettreAJour(zombie);
    }

    // Supprimer un zombie par ID
    public void supprimer(long id) {
        logger.info("Suppression du zombie avec ID : {}", id);
        zombieDAO.supprimer(id);
    }
}
