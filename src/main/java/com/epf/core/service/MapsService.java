package com.epf.core.service;

import com.epf.core.model.Maps;
import com.epf.persistance.implementation.MapsImplementationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapsService {
    private final MapsImplementationDAO mapDAO;

    @Autowired
    public MapsService(MapsImplementationDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    public void ajouterMap(Maps map) {
        mapDAO.ajouterMap(map);
    }

    public List<Maps> listerMaps() {
        return mapDAO.listerMaps();
    }

    public  Maps trouverParId(long id) {
        return mapDAO.trouverParId(id);
    }

    public void mettreAJour(Maps map) {
        mapDAO.mettreAJour(map);
    }

    public void supprimer(long id) {
        mapDAO.supprimer(id);
    }
}
