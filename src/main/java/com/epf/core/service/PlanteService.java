package com.epf.core.service;

import com.epf.core.model.Plante;
import com.epf.persistance.implementation.PlanteImplementationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanteService {
    private final PlanteImplementationDAO planteDAO;

    @Autowired
    public PlanteService(PlanteImplementationDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    public void ajouterPlante(Plante plante) {
        planteDAO.ajouterPlante(plante);
    }

    public List<Plante> listerPlantes() {
        return planteDAO.listerPlantes();
    }

    public Plante trouverParId(int id) {
        return planteDAO.trouverParId(id);
    }

    public void mettreAJour(Plante plante) {
        planteDAO.mettreAJour(plante);
    }

    public void supprimer(int id) {
        planteDAO.supprimer(id);
    }
}

