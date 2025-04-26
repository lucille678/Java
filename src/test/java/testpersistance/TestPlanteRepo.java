package testpersistance;

import com.epf.persistance.Plante;


public class TestPlanteRepo {
    /*
    private final PlanteImplementationDAO planteRepo;

    public TestPlanteRepo() {
        // Configuration manuelle de la source de données
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/votre_base_de_donnees");
        dataSource.setUsername("votre_utilisateur");
        dataSource.setPassword("votre_mot_de_passe");

        // Initialisation de JdbcTemplate et du DAO
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        this.planteRepo = new PlanteImplementationDAO(jdbcTemplate);
    }

    @Test
    void testAjouterPlante() {
        Plante plante = new Plante(
                0L, // Utilisation de long pour l'ID
                "Tournesol",
                100,
                new BigDecimal("0.00"),
                0,
                50,
                new BigDecimal("2.00"),
                "normal",
                "path/image_tournesol.jpeg"
        );
        planteRepo.ajouterPlante(plante);
        System.out.println("✅ Test d'ajout de plante réussi !");
    }
    */
}