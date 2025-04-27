package com.epf.persistance.dao;

import com.epf.persistance.Zombie;
import java.util.List;

public interface ZombieDAO {
    void ajouterZombie(Zombie zombie);         // CREATE
    List<Zombie> listerZombies();              // READ (tout)
    Zombie trouverParId(Long id);              // READ (un seul)
    void mettreAJour(Zombie zombie);           // UPDATE
    void supprimer(Long id);                   // DELETE
    List<Zombie> listerZombiesParMap(Long mapId); 
}
