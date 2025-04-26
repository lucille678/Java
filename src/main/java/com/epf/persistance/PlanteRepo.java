package com.epf.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PlanteRepo {
    private final JdbcTemplate jdbcTemplate;

    public PlanteRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 🎯 RowMapper corrigé avec les types corrects
    private final RowMapper<Plante> planteRowMapper = (rs, rowNum) -> new Plante(
            rs.getLong("id_plante"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getBigDecimal("attaque_par_seconde"), // Correction ici
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getBigDecimal("soleil_par_seconde"), // Correction ici
            rs.getString("effet"),
            rs.getString("chemin_image")
    );

    // ✅ Ajouter une plante
    public void ajouterPlante(Plante plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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

    // ✅ Mettre à jour une plante
    public void mettreAJourPlante(Plante plante) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? " +
                     "WHERE id_plante = ?";
        jdbcTemplate.update(sql,
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image(),
                plante.getId_plante()
        );
        System.out.println("✅ Plante mise à jour : " + plante.getNom());
    }

    // ✅ Supprimer une plante par son ID
    public void supprimerPlante(int id) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("✅ Plante supprimée avec ID : " + id);
    }
}
