package com.epf.persistance.dao;

import com.epf.persistance.Zombie;
import java.util.List;

public interface ZombieDAO {
    void ajouterZombie(Zombie zombie);         // CREATE
    List<Zombie> listerZombies();              // READ (All)
    Zombie trouverParId(Long id);              // READ (One) avec Long pour l'ID
    void mettreAJour(Zombie zombie);           // UPDATE
    void supprimer(Long id);                   // DELETE

    // Récupérer les zombies par map_id
    List<Zombie> listerZombiesParMap(Long mapId); // ID_MAP est un Long
}

