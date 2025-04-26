package testpersistance.testdao;


import com.epf.persistance.dao.MapsDAO;
import com.epf.persistance.Maps;


public class TestDAOMaps {
    /*
    public static void main(String[] args) {
        // Charger le contexte Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

        try {
            // Récupérer le DAO
            MapsDAO mapDao = context.getBean(MapsDAO.class);

            // Ajouter une carte
            Maps jardin = new Maps(0L, 5, 5, "chemin_image_map");
            mapDao.ajouterMap(jardin);
            System.out.println("🗺️ Map ajoutée : " + jardin);

            // Lister les cartes
            System.out.println("📋 Toutes les maps : " + mapDao.listerMaps());

            // Récupérer une carte spécifique par ID
            Maps map = mapDao.trouverParId(1); // Remplacez 1 par un ID valide si nécessaire
            if (map != null) {
                System.out.println("🔍 Map trouvée : " + map);
            } else {
                System.out.println("⚠️ Aucun map trouvé avec l'ID 1");
            }

            // Mettre à jour la carte
            if (map != null) {
                map.setLigne(6);
                map.setColonne(6);
                map.setChemin_image("nouveau_chemin_image");
                mapDao.mettreAJour(map);
                System.out.println("✅ Map mise à jour : " + mapDao.trouverParId(map.getId_map()));
            }

            // Supprimer la carte
            if (map != null) {
                mapDao.supprimer(map.getId_map().intValue());
                System.out.println("🗑️ Map supprimée !");
            }

            // Vérifier que la carte a bien été supprimée
            System.out.println("📋 Toutes les maps après suppression : " + mapDao.listerMaps());
        } finally {
            context.close();
        }
    }
    */
}
