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

    @Override
    public void ajouterZombie(Zombie zombie) {
        try {
            String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(),
                    zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map());
            System.out.println("Zombie ajouté : " + zombie.getNom());
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du zombie : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Lister tous les zombies
    @Override
    public List<Zombie> listerZombies() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, new ZombieMapper());
    }

    @Override
    public Zombie trouverParId(Long id) {
        try {
            String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
            return jdbcTemplate.queryForObject(sql, new ZombieMapper(), id);
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche du zombie avec ID : " + id);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void mettreAJour(Zombie zombie) {
        try {
            String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
            jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(),
                    zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map(), zombie.getId_zombie());
            System.out.println("Zombie mis à jour : " + zombie.getNom());
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour du zombie : " + e.getMessage());
            e.printStackTrace();
        }
    }

  
    @Override
    public void supprimer(Long id) {
        try {
            String sql = "DELETE FROM zombie WHERE id_zombie = ?";
            jdbcTemplate.update(sql, id);
            System.out.println("Zombie supprimé avec ID : " + id);
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du zombie avec ID : " + id);
            e.printStackTrace();
        }
    }

    @Override
    public List<Zombie> listerZombiesParMap(Long mapId) {
        return jdbcTemplate.query(
            "SELECT * FROM zombie WHERE id_map = ?",
            new Object[]{mapId},
            new ZombieMapper()
        );
    }
}

