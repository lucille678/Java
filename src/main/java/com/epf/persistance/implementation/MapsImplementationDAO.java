package com.epf.persistance.implementation;

import com.epf.core.model.Maps;
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
        String sql = "INSERT INTO map (nom, difficulte) VALUES (?, ?)";
        jdbcTemplate.update(sql, map.getNom(), map.getDifficulte());
    }

    // 🔹 Récupérer toutes les maps
    public List<Maps> listerMaps() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, new MapsMapper());
    }

    // 🔹 Trouver une map par ID
    public Maps trouverParId(Long id) {
        String sql = "SELECT * FROM map WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new MapsMapper(), id);
    }

    // 🔹 Mettre à jour une map
    public void mettreAJour(Maps map) {
        String sql = "UPDATE map SET nom = ?, difficulte = ? WHERE id = ?";
        jdbcTemplate.update(sql, map.getNom(), map.getDifficulte(), map.getId());
    }

    // 🔹 Supprimer une map
    public void supprimer(Long id) {
        String sql = "DELETE FROM map WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
