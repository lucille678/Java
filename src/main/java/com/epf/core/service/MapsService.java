package com.epf.core.service;

import com.epf.persistance.Maps;
import com.epf.persistance.MapsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class MapsService {
    private static final Logger logger = LoggerFactory.getLogger(MapsService.class);
    private final MapsRepo mapsRepo;

    @Autowired
    public MapsService(MapsRepo mapsRepo) {
        this.mapsRepo = mapsRepo;
    }

    // ✅ Ajouter une map
    public void ajouterMap(Maps map) {
        if (map.getLigne() <= 0) {
            throw new IllegalArgumentException("Le nombre de lignes doit être supérieur à 0.");
        }
        if (map.getColonne() <= 0) {
            throw new IllegalArgumentException("Le nombre de colonnes doit être supérieur à 0.");
        }
        logger.info("Ajout d'une map avec {} lignes et {} colonnes.", map.getLigne(), map.getColonne());
        mapsRepo.ajouterMap(map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    // ✅ Lister toutes les maps
    public List<Maps> listerMaps() {
        logger.info("Récupération de toutes les maps.");
        return mapsRepo.listerMaps();
    }

    // ✅ Trouver une map par ID
    public Maps trouverParId(Long id_map) {
        try {
            logger.info("Recherche de la map avec ID : {}", id_map);
            return mapsRepo.trouverMapParId(id_map);
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération de la map avec ID : {}", id_map, e);
            throw new RuntimeException("Erreur lors de la récupération de la map avec ID : " + id_map, e);
        }
    }

    // ✅ Mettre à jour une map
    public void mettreAJour(Maps map) {
        if (map.getId_map() <= 0) {
            throw new IllegalArgumentException("L'ID de la map est requis pour la mise à jour.");
        }
        if (map.getLigne() <= 0) {
            throw new IllegalArgumentException("Le nombre de lignes doit être supérieur à 0.");
        }
        if (map.getColonne() <= 0) {
            throw new IllegalArgumentException("Le nombre de colonnes doit être supérieur à 0.");
        }
        logger.info("Mise à jour de la map avec ID : {}", map.getId_map());
        mapsRepo.mettreAJourMap(map.getId_map(), map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    // ✅ Supprimer une map
    public void supprimer(Long id_map) {
        if (id_map <= 0) {
            throw new IllegalArgumentException("L'ID de la map doit être valide.");
        }
        logger.info("Suppression de la map avec ID : {}", id_map);
        mapsRepo.supprimerMap(id_map);
    }
}
