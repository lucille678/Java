package com.epf.persistance.dao;

import com.epf.persistance.Maps;
import java.util.List;

public interface MapsDAO {
    void ajouterMap(Maps map);              // CREATE
    List<Maps> listerMaps();                // READ (tout)
    Maps trouverParId(long id);              // READ (un seul)
    void mettreAJour(Maps map);             // UPDATE
    void supprimer(long id);                 // DELETE
}
