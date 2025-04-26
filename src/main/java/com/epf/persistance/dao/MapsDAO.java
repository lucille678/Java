package com.epf.persistance.dao;

import com.epf.persistance.Maps;
import java.util.List;

public interface MapsDAO {
    void ajouterMap(Maps map);              // CREATE
    List<Maps> listerMaps();                // READ (All)
    Maps trouverParId(long id);              // READ (One)
    void mettreAJour(Maps map);             // UPDATE
    void supprimer(long id);                 // DELETE
}
