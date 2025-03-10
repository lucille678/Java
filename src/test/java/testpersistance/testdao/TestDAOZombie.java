package testpersistance.testdao;

import com.epf.persistance.DBConfig;
import com.epf.persistance.dao.ZombieDAO;
import com.epf.persistance.Zombie;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDAOZombie {
    public static void TestDAOZombie(String[] args) {
        // Charger le contexte Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

        // Récupérer le DAO
        ZombieDAO zombieDao = context.getBean(ZombieDAO.class);

        // Ajouter un zombie
        Zombie zombie = new Zombie(0, "Zombie Footballeur", 150, 30, 5);
        zombieDao.ajouterZombie(zombie);

        // Lister tous les zombies
        System.out.println("🧟‍♂️ Tous les zombies : " + zombieDao.listerZombies());

        // Récupérer un zombie par ID
        Zombie foundZombie = zombieDao.trouverParId(1);
        System.out.println("🔍 Zombie trouvé : " + foundZombie);

        context.close();
    }
}

