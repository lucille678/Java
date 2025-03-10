package com.epf.persistance.implementation;

import com.epf.persistance.dao.PlanteDAO;
import com.epf.persistance.Plante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteImplementationDAO implements PlanteDAO {
    private final JdbcTemplate jdbcTemplate;

    // Injection du JdbcTemplate via le constructeur
    public PlanteImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapper : Convertit les résultats SQL en objets Plante
    private final RowMapper<Plante> planteRowMapper = (rs, rowNum) -> new Plante(
            rs.getInt("id"),
            rs.getString("nom"),
            rs.getInt("pv"),
            rs.getInt("attaque")
    );

    @Override
    public void ajouterPlante(Plante plante) {
        String sql = "INSERT INTO plante (nom, pv, attaque, type) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPv(), plante.getAttaque());
    }

    @Override
    public List<Plante> listerPlantes() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, planteRowMapper);
    }

    @Override
    public Plante trouverParId(int id) {
        String sql = "SELECT * FROM plante WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, planteRowMapper, id);
    }

    @Override
    public void mettreAJour(Plante plante) {
        String sql = "UPDATE plante SET nom = ?, pv = ?, attaque = ?, type = ? WHERE id = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPv(), plante.getAttaque(), plante.getId());
    }

    @Override
    public void supprimer(int id) {
        String sql = "DELETE FROM plante WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Plante> trouverParType(String type) {
        String sql = "SELECT * FROM plante WHERE type = ?";
        return jdbcTemplate.query(sql, planteRowMapper, type);
    }
}
