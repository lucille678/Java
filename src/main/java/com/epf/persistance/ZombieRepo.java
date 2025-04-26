package com.epf.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ZombieRepo {
    private final JdbcTemplate jdbcTemplate;

    public ZombieRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapper pour convertir une ligne SQL en objet Zombie
    private final RowMapper<Zombie> zombieRowMapper = (rs, rowNum) -> new Zombie(
            rs.getLong("id_zombie"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getBigDecimal("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getBigDecimal("vitesse_de_deplacement"),
            rs.getString("chemin_image"),
            rs.getObject("id_map") != null ? rs.getLong("id_map") : null
    );

    // Ajouter un zombie
    public void ajouterZombie(String nom, int point_de_vie, BigDecimal attaque_par_seconde, int degat_attaque,
                              BigDecimal vitesse_de_deplacement, String chemin_image, Long id_map) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, " +
                "vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, nom, point_de_vie, attaque_par_seconde, degat_attaque,
                vitesse_de_deplacement, chemin_image, id_map);
        System.out.println("✅ Zombie ajouté : " + nom);
    }

    // Lister tous les zombies
    public List<Zombie> listerZombies() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, zombieRowMapper);
    }

    // Trouver un zombie par ID
    public Zombie trouverZombieParId(int id) {
        try {
            String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
            return jdbcTemplate.queryForObject(sql, zombieRowMapper, id);
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la recherche du zombie avec ID : " + id);
            e.printStackTrace();
            return null;
        }
    }
}

