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

    // Mapper pour convertir une ligne SQL en objet Map
    private final RowMapper<Maps> mapRowMapper = (rs, rowNum) -> new Maps(
            rs.getInt("id"),
            rs.getString("nom"),
            rs.getInt("largeur"),
            rs.getInt("hauteur")
    );

    // Ajouter une map
    public void ajouterMap(String nom, int largeur, int hauteur) {
        String sql = "INSERT INTO map (nom, largeur, hauteur) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, nom, largeur, hauteur);
        System.out.println("✅ Map ajoutée : " + nom);
    }

    // Lister toutes les maps
    public List<Maps> listerMaps() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, mapRowMapper);
    }
}