package com.epf.persistance.implementation;

import com.epf.persistance.Plante;
import com.epf.persistance.dao.PlanteDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PlanteImplementationDAO implements PlanteDAO {
    private final JdbcTemplate jdbcTemplate;

    public PlanteImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapper pour convertir une ligne SQL en objet Plante
    private final RowMapper<Plante> planteRowMapper = (rs, rowNum) -> new Plante(
            rs.getLong("id_plante"),   //jai mis long a la place de int
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getBigDecimal("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getBigDecimal("soleil_par_seconde"),
            rs.getString("effet"),
            rs.getString("chemin_image")
    );

    @Override
    public void ajouterPlante(Plante plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image());
    }

    @Override
    public List<Plante> listerPlantes() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, planteRowMapper);
    }

    @Override
    public Plante trouverParId(long id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, planteRowMapper, id);
    }

    @Override
    public void mettreAJour(Plante plante) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image(), plante.getId_plante());
    }

    @Override
    public void supprimer(long id) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }
}
