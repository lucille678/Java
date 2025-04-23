package com.epf.core.service;

import com.epf.core.model.Zombie;
import com.epf.persistance.implementation.ZombieImplementationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZombieService {
    private final ZombieImplementationDAO zombieDAO;

    @Autowired
    public ZombieService(ZombieImplementationDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    // Ajouter un zombie
    public void ajouterZombie(Zombie zombie) {
        zombieDAO.ajouterZombie(zombie);
    }

    // Lister tous les zombies
    public List<Zombie> listerZombies() {
        return zombieDAO.listerZombies();
    }

    // Trouver un zombie par ID
    public Zombie trouverParId(Long id) {
        return zombieDAO.trouverParId(id);
    }

    // Mettre à jour un zombie
    public void mettreAJour(Zombie zombie) {
        zombieDAO.mettreAJour(zombie);
    }

    // Supprimer un zombie par ID
    public void supprimer(long id) {
        zombieDAO.supprimer(id);
    }
}
