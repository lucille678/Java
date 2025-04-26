package testpersistance.testdao;


import com.epf.persistance.dao.ZombieDAO;
import com.epf.persistance.Zombie;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class TestDAOZombie {
    /*
    public static void main(String[] args) {
        // Charger le contexte Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

        // Récupérer le DAO
        ZombieDAO zombieDao = context.getBean(ZombieDAO.class);

        // Ajouter un zombie
        Zombie zombie = new Zombie(
                0L,
                "Zombie Footballeur",
                150,
                new BigDecimal("30.00"), // Correction ici
                60,
                new BigDecimal("5.00"), // Correction ici
                "path/image_zombie_footballer.jpeg",
                1L
        );
        zombieDao.ajouterZombie(zombie);

        // Lister tous les zombies
        System.out.println("🧟‍♂️ Tous les zombies : " + zombieDao.listerZombies());

        // Récupérer un zombie par ID
        Zombie foundZombie = zombieDao.trouverParId(1L);
        System.out.println("🔍 Zombie trouvé : " + foundZombie);

        context.close();

            // Mettre à jour un zombie
        Zombie updatedZombie = new Zombie(
                1L,
                "Zombie Mis à Jour",
                200,
                new BigDecimal("40.00"),
                80,
                new BigDecimal("6.00"),
                "path/image_zombie_updated.jpeg",
                2L
        );
        zombieDao.mettreAJour(updatedZombie);
        System.out.println("🛠️ Zombie mis à jour : " + zombieDao.trouverParId(1L));

        // Supprimer un zombie par ID
        zombieDao.supprimer(1L);
        System.out.println("🗑️ Zombie supprimé : " + zombieDao.trouverParId(1L)); // Devrait être null ou lancer une exception

        
    }*/
}

