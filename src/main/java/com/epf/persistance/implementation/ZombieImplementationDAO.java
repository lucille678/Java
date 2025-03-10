package com.epf.persistance.implementation;

import com.epf.persistance.dao.ZombieDAO;
import com.epf.persistance.Zombie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombieImplementationDAO implements ZombieDAO {
    private final JdbcTemplate jdbcTemplate;

    // Injection du JdbcTemplate via le constructeur
    public ZombieImplementationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapper : Convertit les résultats SQL en objets Zombie
    private final RowMapper<Zombie> zombieRowMapper = (rs, rowNum) -> new Zombie(
            rs.getInt("id"),
            rs.getString("nom"),
            rs.getInt("pv"),
            rs.getInt("attaque"),
            rs.getInt("vitesse")
    );

    @Override
    public void ajouterZombie(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, pv, attaque, vitesse) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPv(), zombie.getAttaque(), zombie.getVitesse());
    }

    @Override
    public List<Zombie> listerZombies() {
        return jdbcTemplate.query("SELECT * FROM zombie", zombieRowMapper);
    }

    @Override
    public Zombie trouverParId(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM zombie WHERE id = ?", zombieRowMapper, id);
    }

    @Override
    public void mettreAJour(Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, pv = ?, attaque = ?, vitesse = ? WHERE id = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPv(), zombie.getAttaque(), zombie.getVitesse(), zombie.getId());
    }

    @Override
    public void supprimer(int id) {
        jdbcTemplate.update("DELETE FROM zombie WHERE id = ?", id);
    }

    // Récupérer les zombies liés à une map spécifique
    @Override
    public List<Zombie> listerZombiesParMap(int mapId) {
        String sql = "SELECT * FROM zombie WHERE map_id = ?";
        return jdbcTemplate.query(sql, zombieRowMapper, mapId);
    }
}
