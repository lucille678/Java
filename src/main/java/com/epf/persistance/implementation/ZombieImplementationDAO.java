package com.epf.persistance.implementation;

import com.epf.persistance.Zombie;
import com.epf.persistance.dao.ZombieDAO;
import com.epf.persistance.mapper.ZombieMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombieImplementationDAO implements ZombieDAO {
    private final JdbcTemplate jdbcTemplate;

    public ZombieImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Ajouter un zombie
    @Override
    public void ajouterZombie(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map());
    }

    // Lister tous les zombies
    @Override
    public List<Zombie> listerZombies() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, new ZombieMapper());
    }

    // Trouver un zombie par ID
    @Override
    public Zombie trouverParId(Long id) {
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, new ZombieMapper(), id);
    }

    // Mettre à jour un zombie
    @Override
    public void mettreAJour(Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map(), zombie.getId_zombie());
    }

    // Supprimer un zombie
    @Override
    public void supprimer(Long id) {
        String sql = "DELETE FROM zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }

    // Lister les zombies par map_id
    @Override
    public List<Zombie> listerZombiesParMap(Long mapId) {
        String sql = "SELECT * FROM zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new ZombieMapper(), mapId);
    }
}

