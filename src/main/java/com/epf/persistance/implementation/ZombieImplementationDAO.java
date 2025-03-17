package com.epf.persistance.implementation;

import com.epf.core.model.Zombie;
import com.epf.persistance.mapper.ZombieMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ZombieImplementationDAO {
    private final JdbcTemplate jdbcTemplate;

    public ZombieImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 🔹 Ajouter un zombie
    public void ajouterZombie(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, pv, attaque, vitesse) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPv(), zombie.getAttaque(), zombie.getVitesse());
    }

    // 🔹 Récupérer tous les zombies
    public List<Zombie> listerZombies() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, new ZombieMapper());
    }

    // 🔹 Trouver un zombie par son ID
    public Zombie trouverParId(Long id) {
        String sql = "SELECT * FROM zombie WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new ZombieMapper(), id);
    }

    // 🔹 Mettre à jour un zombie
    public void mettreAJour(Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, pv = ?, attaque = ?, vitesse = ? WHERE id = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPv(), zombie.getAttaque(), zombie.getVitesse(), zombie.getId());
    }

    // 🔹 Supprimer un zombie
    public void supprimer(Long id) {
        String sql = "DELETE FROM zombie WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
