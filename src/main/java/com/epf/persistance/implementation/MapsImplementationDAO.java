package com.epf.persistance.implementation;

import com.epf.persistance.dao.MapsDAO;
import com.epf.persistance.Maps;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapsImplementationDAO implements MapsDAO {
    private final JdbcTemplate jdbcTemplate;

    // Injection de JdbcTemplate (constructeur)
    public MapsImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapper pour la table "map"
    private final RowMapper<Maps> mapRowMapper = (rs, rowNum) -> new Maps(
            rs.getInt("id"),
            rs.getString("nom"),
            rs.getInt("largeur"),
            rs.getInt("hauteur")
    );

    @Override
    public void ajouterMap(Maps map) {
        String sql = "INSERT INTO map (nom, largeur, hauteur) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getNom(), map.getLargeur(), map.getHauteur());
        System.out.println("✅ Map ajoutée : " + map);
    }

    @Override
    public List<Maps> listerMaps() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, mapRowMapper);
    }

    @Override
    public Maps trouverParId(int id) {
        String sql = "SELECT * FROM map WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, mapRowMapper, id);
    }

    @Override
    public void mettreAJour(Maps map) {
        String sql = "UPDATE map SET nom = ?, largeur = ?, hauteur = ?, WHERE id = ?";
        jdbcTemplate.update(sql, map.getNom(), map.getLargeur(), map.getHauteur(), map.getId());
    }

    @Override
    public void supprimer(int id) {
        String sql = "DELETE FROM map WHERE id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("🗑️ Map supprimée : ID " + id);
    }

}
