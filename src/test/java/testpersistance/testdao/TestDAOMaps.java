package testpersistance.testdao;

import com.epf.persistance.DBConfig;
import com.epf.persistance.dao.MapsDAO;
import com.epf.persistance.Maps;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDAOMaps {
    public static void TestDAOMaps(String[] args) {
        // Charger le contexte Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

        // Récupérer le DAO
        MapsDAO mapDao = context.getBean(MapsDAO.class);

        // Ajouter une carte
        Maps jardin = new Maps(0, "Jardin", 1, 2);
        mapDao.ajouterMap(jardin);
        System.out.println("🗺️ Map ajoutée : " + jardin);

        // Lister les cartes
        System.out.println("📋 Toutes les maps : " + mapDao.listerMaps());

        // Récupérer une carte spécifique
        Maps map = mapDao.trouverParId(1);
        System.out.println("🔍 Map trouvée : " + map);

        // Mettre à jour la carte
        map.setLargeur(4);
        map.setHauteur(8);
        mapDao.mettreAJour(map);
        System.out.println("✅ Map mise à jour : " + mapDao.trouverParId(1));

        // Supprimer la carte
        mapDao.supprimer(1);
        System.out.println("🗑️ Map supprimée !");

        context.close();
    }
}

