package com.epf.persistance.implementation;

import com.epf.core.model.Plante;
import com.epf.persistance.mapper.PlanteMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PlanteImplementationDAO {
    private final JdbcTemplate jdbcTemplate;

    public PlanteImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void ajouterPlante(Plante plante) {
        String sql = "INSERT INTO plante (nom, pv, attaque) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPv(), plante.getAttaque());
    }

    public List<Plante> listerPlantes() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, new PlanteMapper());
    }

    public Plante trouverParId(Long id) {
        String sql = "SELECT * FROM plante WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new PlanteMapper(), id);
    }

    public void mettreAJour(Plante plante) {
        String sql = "UPDATE plante SET nom = ?, pv = ?, attaque = ? WHERE id = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPv(), plante.getAttaque(), plante.getId());
    }

    public void supprimer(Long id) {
        String sql = "DELETE FROM plante WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
