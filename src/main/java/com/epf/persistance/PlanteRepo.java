package com.epf.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PlanteRepo {
    private final JdbcTemplate jdbcTemplate;

    // Injection du JdbcTemplate
    public PlanteRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapper pour convertir une ligne SQL en objet Plante
    private final RowMapper<Plante> planteRowMapper = (rs, rowNum) -> new Plante(
            rs.getInt("id"),
            rs.getString("nom"),
            rs.getInt("pv"),
            rs.getInt("attaque")
    );

    // 🟢 Ajouter une plante
    public void ajouterPlante(String nom, int pv, int attaque) {
        String sql = "INSERT INTO plante (nom, pv, attaque) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, nom, pv, attaque);
        System.out.println("✅ Plante ajoutée : " + nom);
    }

    // 🟢 Lister toutes les plantes
    public List<Plante> listerPlantes() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, planteRowMapper);
    }

    // 🟢 Trouver une plante par ID
    public Plante trouverPlanteParId(int id) {
        String sql = "SELECT * FROM plante WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, planteRowMapper, id);
    }
}
