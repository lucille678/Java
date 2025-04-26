package testpersistance.testdao;


import com.epf.persistance.dao.PlanteDAO;
import com.epf.persistance.Plante;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDAOPlante {
    
/*
    public static void TestDAOPlante(String[] args) {
        // Charger le contexte Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

        // Récupérer le DAO
        PlanteDAO planteDao = context.getBean(PlanteDAO.class);

        // Ajouter une plante
        Plante tournesol = new Plante();
        tournesol.setId_plante(0L);
        tournesol.setNom("Tournesol");
        tournesol.setPoint_de_vie(100);
        tournesol.setAttaque_par_seconde(1);
        tournesol.setDegat_attaque(10);
        tournesol.setCout(50);
        tournesol.setSoleil_par_seconde(25);
        tournesol.setEffet("génère des soleils");
        tournesol.setChemin_image("/images/tournesol.png");

        planteDao.ajouterPlante(tournesol);
        System.out.println("🌻 Plante ajoutée : " + tournesol);

        // Lister toutes les plantes
        System.out.println("🌱 Liste des plantes : " + planteDao.listerPlantes());

        // Récupérer une plante par ID
        Plante plante = planteDao.trouverParId(1);
        System.out.println("🔍 Plante trouvée : " + plante);

        // Mettre à jour la plante
        plante.setPoint_de_vie(150);
        planteDao.mettreAJour(plante);
        System.out.println("✅ Plante mise à jour : " + planteDao.trouverParId(1));

        // Supprimer la plante
        planteDao.supprimer(1);
        System.out.println("🗑️ Plante supprimée !");

        context.close();
    }
    */
}
