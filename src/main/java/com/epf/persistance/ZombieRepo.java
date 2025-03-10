package com.epf.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ZombieRepo {
    private final JdbcTemplate jdbcTemplate;

    public ZombieRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapper pour convertir une ligne SQL en objet Zombie
    private final RowMapper<Zombie> zombieRowMapper = (rs, rowNum) -> new Zombie(
            rs.getInt("id"),
            rs.getString("nom"),
            rs.getInt("pv"),
            rs.getInt("attaque"),
            rs.getInt("vitesse")
    );

    //  Ajouter un zombie
    public void ajouterZombie(String nom, int pv, int attaque, int vitesse) {
        String sql = "INSERT INTO zombie (nom, pv, attaque, vitesse) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, nom, pv, attaque, vitesse);
        System.out.println("✅ Zombie ajouté : " + nom);
    }

    //  Lister tous les zombies
    public List<Zombie> listerZombies() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, zombieRowMapper);
    }

    //  Trouver un zombie par ID
    public Zombie trouverZombieParId(int id) {
        String sql = "SELECT * FROM zombie WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, zombieRowMapper, id);
    }
}
