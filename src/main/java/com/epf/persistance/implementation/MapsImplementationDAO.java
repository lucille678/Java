package com.epf.persistance.implementation;

import com.epf.persistance.Maps;
import com.epf.persistance.mapper.MapsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MapsImplementationDAO {
    private final JdbcTemplate jdbcTemplate;

    public MapsImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 🔹 Ajouter une map
    public void ajouterMap(Maps map) {
        // Mise à jour de la requête pour inclure tous les champs
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    // 🔹 Récupérer toutes les maps
    public List<Maps> listerMaps() {
        String sql = "SELECT * FROM map";
        // Utilisation du MapMapper pour récupérer toutes les maps
        return jdbcTemplate.query(sql, new MapsMapper());
    }

    // 🔹 Trouver une map par ID
    public Maps trouverParId(Long id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";  // Assure-toi que la table utilise 'id_map' comme colonne
        return jdbcTemplate.queryForObject(sql, new MapsMapper(), id);
    }

    // 🔹 Mettre à jour une map
    public void mettreAJour(Maps map) {
        // Mise à jour de la requête SQL pour mettre à jour les nouveaux champs
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image(), map.getId_map());
    }

    // 🔹 Supprimer une map
    public void supprimer(Long id) {
        String sql = "DELETE FROM map WHERE id_map = ?";  // Utilisation de 'id_map' pour la suppression
        jdbcTemplate.update(sql, id);
    }
}
