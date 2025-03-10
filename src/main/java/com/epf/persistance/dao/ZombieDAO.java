package com.epf.persistance.dao;
import com.epf.persistance.Zombie;
import java.util.List;

public interface ZombieDAO {
    void ajouterZombie(Zombie zombie);         // CREATE
    List<Zombie> listerZombies();              // READ (All)
    Zombie trouverParId(int id);               // READ (One)
    void mettreAJour(Zombie zombie);           // UPDATE
    void supprimer(int id);                    // DELETE

    // Récupérer les zombies par map_id
    List<Zombie> listerZombiesParMap(int mapId);
}
