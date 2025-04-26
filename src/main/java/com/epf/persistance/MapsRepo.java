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

    // 🎯 RowMapper pour convertir une ligne SQL en objet Maps
    private final RowMapper<Maps> mapsRowMapper = (rs, rowNum) -> new Maps(
            rs.getLong("id_map"), // Correction : Utilisation de getLong pour id_map
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
    );

    // ✅ Ajouter une map
    public void ajouterMap(int ligne, int colonne, String cheminImage) {
        String sql = "INSERT INTO maps (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, ligne, colonne, cheminImage);
    }

    // ✅ Lister toutes les maps
    public List<Maps> listerMaps() {
        String sql = "SELECT * FROM maps";
        return jdbcTemplate.query(sql, mapsRowMapper);
    }

    // ✅ Trouver une map par ID
    public Maps trouverMapParId(Long id_map) {
        String sql = "SELECT * FROM maps WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, mapsRowMapper, id_map);
    }

    // ✅ Mettre à jour une map
    public void mettreAJourMap(Long id_map, int ligne, int colonne, String cheminImage) {
        String sql = "UPDATE maps SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, ligne, colonne, cheminImage, id_map);
    }

    // ✅ Supprimer une map
    public void supprimerMap(Long id_map) {
        String sql = "DELETE FROM maps WHERE id_map = ?";
        jdbcTemplate.update(sql, id_map);
    }
}
