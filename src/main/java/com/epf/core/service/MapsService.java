package com.epf.core.service;

import com.epf.persistance.Maps;
import com.epf.persistance.implementation.MapsImplementationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class MapsService {
    private static final Logger logger = LoggerFactory.getLogger(MapsService.class);
    private final MapsImplementationDAO mapsImpl;

    @Autowired
    public MapsService(MapsImplementationDAO mapsImpl) {
        this.mapsImpl = mapsImpl;
    }

    // Lister toutes les maps
    public List<Maps> listerMaps() {
        logger.info("Récupération de toutes les maps");
        return mapsImpl.listerMaps();
    }

    // Trouver une map par ID
    public Maps trouverParId(Long id) {
        logger.info("Recherche de la map avec ID : {}", id);
        Maps map = mapsImpl.trouverParId(id);
        if (map == null) {
            logger.warn("Aucune map trouvée avec l'ID : {}", id);
        }
        return map;
    }

    // Ajouter une map
    public void ajouterMap(Maps map) {
        if (map.getLigne() <= 0) {
            throw new IllegalArgumentException("Le nombre de lignes doit être supérieur à 0.");
        }
        if (map.getColonne() <= 0) {
            throw new IllegalArgumentException("Le nombre de colonnes doit être supérieur à 0.");
        }
        logger.info("Ajout d'une nouvelle map");
        mapsImpl.ajouterMap(map);
    }

    // Supprimer une map
    public void supprimer(Long id) {
        try {
            logger.info("Suppression de la map avec ID : {}", id);
            mapsImpl.supprimer(id);
        } catch (EmptyResultDataAccessException e) {
            logger.error("La map avec l'ID {} n'existe pas", id);
            throw new IllegalArgumentException("La map avec l'ID " + id + " n'existe pas");
        }
    }

    // Added missing method
    public void mettreAJour(Maps map) {
        if (map == null) {
            throw new IllegalArgumentException("La map ne peut pas être null");
        }
        if (map.getId_map() == null) {
            throw new IllegalArgumentException("L'ID de la map est requis pour la mise à jour");
        }
        if (map.getLigne() <= 0) {
            throw new IllegalArgumentException("Le nombre de lignes doit être supérieur à 0");
        }
        if (map.getColonne() <= 0) {
            throw new IllegalArgumentException("Le nombre de colonnes doit être supérieur à 0");
        }
        
        logger.info("Mise à jour de la map avec ID : {}", map.getId_map());
        mapsImpl.mettreAJour(map);
    }
}
