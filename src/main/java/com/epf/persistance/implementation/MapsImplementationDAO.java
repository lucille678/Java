package com.epf.persistance.implementation;

import com.epf.persistance.Maps;
import com.epf.persistance.dao.MapsDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapsImplementationDAO implements MapsDAO {

    private final JdbcTemplate jdbcTemplate;

    public MapsImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Maps> mapsRowMapper = (rs, rowNum) -> new Maps(
            rs.getLong("id_map"), // Correction : Utilisation de getLong
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
    );

    @Override
    public void ajouterMap(Maps map) {
        String sql = "INSERT INTO maps (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    @Override
    public List<Maps> listerMaps() {
        String sql = "SELECT * FROM maps";
        return jdbcTemplate.query(sql, mapsRowMapper);
    }

    @Override
    public Maps trouverParId(long id) { // Correction : Utilisation de long
        String sql = "SELECT * FROM maps WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, mapsRowMapper, id);
    }

    @Override
    public void mettreAJour(Maps map) {
        String sql = "UPDATE maps SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image(), map.getId_map());
    }

    @Override
    public void supprimer(long id) { // Correction : Utilisation de long
        String sql = "DELETE FROM maps WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
    }
}
