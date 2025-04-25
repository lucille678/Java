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
            rs.getLong("id_zombie"), // correspond à l'attribut id_zombie
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getInt("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("vitesse_de_deplacement"),
            rs.getString("chemin_image"),
            rs.getLong("id_map") // Peut être null
    );

    // Ajouter un zombie
    public void ajouterZombie(String nom, int point_de_vie, int attaque_par_seconde, int degat_attaque,
                              int vitesse_de_deplacement, String chemin_image, long id_map) {
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
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, zombieRowMapper, id);
    }
}

