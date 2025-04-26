package com.epf.core.service;

import com.epf.persistance.Plante;
import com.epf.persistance.implementation.PlanteImplementationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class PlanteService {
    private static final Logger logger = LoggerFactory.getLogger(PlanteService.class);
    private final PlanteImplementationDAO planteDAO;

    @Autowired
    public PlanteService(PlanteImplementationDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    public Plante trouverParId(long id) {
        try {
            logger.info("Recherche de la plante avec ID : {}", id);
            return planteDAO.trouverParId(id); // Assurez-vous que cette méthode accepte un long dans le DAO.
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération de la plante avec ID : {}", id, e);
            throw new RuntimeException("Erreur lors de la récupération de la plante avec ID : " + id, e);
        }
    }

    public void supprimer(long id) {
        logger.info("Suppression de la plante avec ID : {}", id);
        planteDAO.supprimer(id); // Assurez-vous que cette méthode accepte un long dans le DAO.
    }

    public void ajouterPlante(Plante plante) {
        if (plante.getNom() == null || plante.getNom().isEmpty()) {
            throw new IllegalArgumentException("Le nom de la plante est obligatoire.");
        }
        logger.info("Ajout d'une plante : {}", plante.getNom());
        planteDAO.ajouterPlante(plante); // Assurez-vous que cette méthode existe dans le DAO.
    }

    public List<Plante> listerPlantes() {
        logger.info("Récupération de toutes les plantes.");
        return planteDAO.listerPlantes(); // Assurez-vous que cette méthode existe dans le DAO.
    }

    public void mettreAJour(Plante plante) {
        if (plante.getId_plante() <= 0) {
            throw new IllegalArgumentException("L'ID de la plante est requis pour la mise à jour.");
        }
        logger.info("Mise à jour de la plante avec ID : {}", plante.getId_plante());
        planteDAO.mettreAJour(plante); // Assurez-vous que cette méthode existe dans le DAO.
    }
}


