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

    public void ajouterZombie(Zombie zombie) {
        zombieDAO.ajouterZombie(zombie);
    }

    public List<Zombie> listerZombies() {
        return zombieDAO.listerZombies();
    }

    public Zombie trouverParId(Long id) {
        return zombieDAO.trouverParId(id);
    }

    public void mettreAJour(Zombie zombie) {
        zombieDAO.mettreAJour(zombie);
    }

    public void supprimer(long id) {
        zombieDAO.supprimer(id);
    }
}

