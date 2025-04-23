package com.epf.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapsRepo {
    private final JdbcTemplate jdbcTemplate;

    public MapsRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapper pour convertir une ligne SQL en objet Maps
    private final RowMapper<Maps> mapsRowMapper = (rs, rowNum) -> new Maps(
            rs.getLong("id_map"),         // correspond à l'attribut id_map
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
    );

    // Ajouter une carte
    public void ajouterMap(Integer ligne, Integer colonne, String chemin_image) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, ligne, colonne, chemin_image);
        System.out.println("✅ Map ajoutée");
    }

    // Lister toutes les cartes
    public List<Maps> listerMaps() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, mapsRowMapper);
    }

    // Trouver une carte par ID
    public Maps trouverMapParId(Long id_map) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, mapsRowMapper, id_map);
    }
}
