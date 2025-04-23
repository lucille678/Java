package com.epf.persistance.implementation;

import com.epf.persistance.Plante;
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
    }

    public List<Plante> listerPlantes() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, new PlanteMapper());
    }

    public Plante trouverParId(Long id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, new PlanteMapper(), id);
    }

    public void mettreAJour(Plante plante) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
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
    }

    public void supprimer(Long id) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }
}
