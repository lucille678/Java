package com.epf.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteRepo {
    private final JdbcTemplate jdbcTemplate;

    public PlanteRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 🎯 RowMapper mis à jour avec les nouveaux champs
    private final RowMapper<Plante> planteRowMapper = (rs, rowNum) -> new Plante(
            rs.getInt("id_plante"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getInt("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getInt("soleil_par_seconde"),
            rs.getString("effet"),
            rs.getString("chemin_image")
    );

    // ✅ Ajouter une plante (version complète avec tous les champs)
    public void ajouterPlante(Plante plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image()
        );
        System.out.println("✅ Plante ajoutée : " + plante.getNom());
    }

    // ✅ Lister toutes les plantes
    public List<Plante> listerPlantes() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, planteRowMapper);
    }

    // ✅ Trouver une plante par son ID
    public Plante trouverPlanteParId(int id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, planteRowMapper, id);
    }
}
