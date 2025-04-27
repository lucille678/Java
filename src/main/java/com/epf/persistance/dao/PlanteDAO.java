package com.epf.persistance.dao;

import com.epf.persistance.Plante;
import java.util.List;

public interface PlanteDAO {
    void ajouterPlante(Plante plante);         // CREATE
    List<Plante> listerPlantes();              // READ (tout)
    Plante trouverParId(long id);               // READ (un seul)
    void mettreAJour(Plante plante);           // UPDATE
    void supprimer(long id);                    // DELETE
}
