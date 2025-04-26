package testpersistance;

import com.epf.persistance.Zombie;


public class TestZombie {
    /*

    @Test
    void testConstructeurEtGetters() {
        // Création d'un zombie avec le constructeur
        Zombie zombie = new Zombie(
                1L,
                "Zombie Test",
                100,
                new BigDecimal("10.50"),
                50,
                new BigDecimal("2.75"),
                "path/image_zombie_test.jpeg",
                2L
        );

        // Vérification des getters
        assertEquals(1L, zombie.getId_zombie());
        assertEquals("Zombie Test", zombie.getNom());
        assertEquals(100, zombie.getPoint_de_vie());
        assertEquals(new BigDecimal("10.50"), zombie.getAttaque_par_seconde());
        assertEquals(50, zombie.getDegat_attaque());
        assertEquals(new BigDecimal("2.75"), zombie.getVitesse_de_deplacement());
        assertEquals("path/image_zombie_test.jpeg", zombie.getChemin_image());
        assertEquals(2L, zombie.getId_map());
    }

    @Test
    void testSetters() {
        // Création d'un zombie vide
        Zombie zombie = new Zombie();

        // Utilisation des setters
        zombie.setId_zombie(2L);
        zombie.setNom("Zombie Modifié");
        zombie.setPoint_de_vie(120);
        zombie.setAttaque_par_seconde(new BigDecimal("15.00"));
        zombie.setDegat_attaque(60);
        zombie.setVitesse_de_deplacement(new BigDecimal("3.50"));
        zombie.setChemin_image("path/image_zombie_modified.jpeg");
        zombie.setId_map(3L);

        // Vérification des setters
        assertEquals(2L, zombie.getId_zombie());
        assertEquals("Zombie Modifié", zombie.getNom());
        assertEquals(120, zombie.getPoint_de_vie());
        assertEquals(new BigDecimal("15.00"), zombie.getAttaque_par_seconde());
        assertEquals(60, zombie.getDegat_attaque());
        assertEquals(new BigDecimal("3.50"), zombie.getVitesse_de_deplacement());
        assertEquals("path/image_zombie_modified.jpeg", zombie.getChemin_image());
        assertEquals(3L, zombie.getId_map());
    }

    @Test
    void testToString() {
        // Création d'un zombie
        Zombie zombie = new Zombie(
                1L,
                "Zombie String",
                80,
                new BigDecimal("8.00"),
                40,
                new BigDecimal("1.50"),
                "path/image_zombie_string.jpeg",
                null
        );

        // Vérification de la méthode toString
        String expected = "Zombie{id_zombie=1, nom='Zombie String', point_de_vie=80, attaque_par_seconde=8.00, " +
                "degat_attaque=40, vitesse_de_deplacement=1.50, chemin_image='path/image_zombie_string.jpeg', id_map=null}";
        assertEquals(expected, zombie.toString());
    }
    */
}
