package com.epf.persistance.implementation;

import com.epf.persistance.Maps;
import com.epf.persistance.dao.MapsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapsImplementationDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MapsImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Maps> listerMaps() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Maps(
                rs.getLong("id_map"),
                rs.getInt("ligne"),
                rs.getInt("colonne"),
                rs.getString("chemin_image")
            )
        );
    }

    public Maps trouverParId(Long id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Maps(
                    rs.getLong("id_map"),
                    rs.getInt("ligne"),
                    rs.getInt("colonne"),
                    rs.getString("chemin_image")
                )
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void ajouterMap(Maps map) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 
            map.getLigne(),
            map.getColonne(),
            map.getChemin_image()
        );
    }

    public void supprimer(Long id) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        int result = jdbcTemplate.update(sql, id);
        if (result == 0) {
            throw new EmptyResultDataAccessException(1);
        }
    }
}
