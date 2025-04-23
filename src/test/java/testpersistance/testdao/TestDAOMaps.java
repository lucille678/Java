package testpersistance.testdao;

import com.epf.persistance.DBConfig;
import com.epf.persistance.dao.MapsDAO;
import com.epf.persistance.Maps;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDAOMaps {
    public static void main(String[] args) {
        // Charger le contexte Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

        try {
            // Récupérer le DAO
            MapsDAO mapDao = context.getBean(MapsDAO.class);

            // Ajouter une carte (avec les bons paramètres)
            Maps jardin = new Maps(0L, 5, 5, "chemin_image_map"); // Exemple de valeurs
            mapDao.ajouterMap(jardin);
            System.out.println("🗺️ Map ajoutée : " + jardin);

            // Lister les cartes
            System.out.println("📋 Toutes les maps : " + mapDao.listerMaps());

            // Récupérer une carte spécifique par ID
            Maps map = mapDao.trouverParId(1); // Utilisation du type Long pour l'ID
            if (map != null) {
                System.out.println("🔍 Map trouvée : " + map);
            } else {
                System.out.println("⚠️ Aucun map trouvé avec l'ID 1");
            }

            // Mettre à jour la carte
            map.setLigne(6);
            map.setColonne(6);
            map.setChemin_image("nouveau_chemin_image");
            mapDao.mettreAJour(map);
            System.out.println("✅ Map mise à jour : " + mapDao.trouverParId(1));

            // Supprimer la carte
            mapDao.supprimer(1);
            System.out.println("🗑️ Map supprimée !");
        } finally {
            context.close();
        }
    }
}
