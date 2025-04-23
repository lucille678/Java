package com.epf.core.service;

import com.epf.persistance.Maps;
import com.epf.persistance.MapsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapsService {
    private final MapsRepo mapsRepo;

    @Autowired
    public MapsService(MapsRepo mapsRepo) {
        this.mapsRepo = mapsRepo;
    }

    public void ajouterMap(Maps map) {
        mapsRepo.ajouterMap(map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    public List<Maps> listerMaps() {
        return mapsRepo.listerMaps();
    }

    public Maps trouverParId(Long id_map) {
        return mapsRepo.trouverMapParId(id_map);
    }

    public void mettreAJour(Maps map) {
        // Code pour mettre à jour la carte
    }

    public void supprimer(Long id_map) {
        // Code pour supprimer la carte
    }
}
