package com.epf.persistance.dao;
import com.epf.persistance.Plante;
import java.util.List;

public interface PlanteDAO {
    void ajouterPlante(Plante plante);       // CREATE
    List<Plante> listerPlantes();            // READ (All)
    Plante trouverParId(int id);             // READ (One)
    void mettreAJour(Plante plante);         // UPDATE
    void supprimer(int id);                  // DELETE

    // Méthode spécifique : Trouver les plantes par type
    List<Plante> trouverParType(String type);
}
