package testpersistance;

import com.epf.persistance.Zombie;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class TestZombie {
    
    private Zombie zombie;

    @Before
    public void setUp() {
        zombie = new Zombie();
    }

    @Test
    public void testConstructeurVide() {
        assertNotNull("L'instance ne devrait pas être nulle", zombie);
        assertNull(zombie.getId_zombie());
        assertNull(zombie.getNom());
        assertNull(zombie.getPoint_de_vie());
        assertNull(zombie.getAttaque_par_seconde());
        assertNull(zombie.getDegat_attaque());
        assertNull(zombie.getVitesse_de_deplacement());
        assertNull(zombie.getChemin_image());
        assertNull(zombie.getId_map());
    }

    @Test
    public void testConstructeurComplet() {
        zombie = new Zombie(
            1L, 
            "Zombie de base",
            100,
            new BigDecimal("1.0"),
            20,
            new BigDecimal("0.5"),
            "zombie/basic.png",
            1L
        );
        
        assertEquals(Long.valueOf(1L), zombie.getId_zombie());
        assertEquals("Zombie de base", zombie.getNom());
        assertEquals(Integer.valueOf(100), zombie.getPoint_de_vie());
        assertEquals(0, new BigDecimal("1.0").compareTo(zombie.getAttaque_par_seconde()));
        assertEquals(Integer.valueOf(20), zombie.getDegat_attaque());
        assertEquals(0, new BigDecimal("0.5").compareTo(zombie.getVitesse_de_deplacement()));
        assertEquals("zombie/basic.png", zombie.getChemin_image());
        assertEquals(Long.valueOf(1L), zombie.getId_map());
    }

    @Test
    public void testSettersEtGetters() {
        zombie.setId_zombie(1L);
        zombie.setNom("Zombie de base");
        zombie.setPoint_de_vie(100);
        zombie.setAttaque_par_seconde(new BigDecimal("1.0"));
        zombie.setDegat_attaque(20);
        zombie.setVitesse_de_deplacement(new BigDecimal("0.5"));
        zombie.setChemin_image("zombie/basic.png");
        zombie.setId_map(1L);

        assertEquals(Long.valueOf(1L), zombie.getId_zombie());
        assertEquals("Zombie de base", zombie.getNom());
        assertEquals(Integer.valueOf(100), zombie.getPoint_de_vie());
        assertEquals(0, new BigDecimal("1.0").compareTo(zombie.getAttaque_par_seconde()));
        assertEquals(Integer.valueOf(20), zombie.getDegat_attaque());
        assertEquals(0, new BigDecimal("0.5").compareTo(zombie.getVitesse_de_deplacement()));
        assertEquals("zombie/basic.png", zombie.getChemin_image());
        assertEquals(Long.valueOf(1L), zombie.getId_map());
    }

    @Test
    public void testToString() {
        zombie.setId_zombie(1L);
        zombie.setNom("Zombie de base");
        zombie.setPoint_de_vie(100);
        zombie.setAttaque_par_seconde(new BigDecimal("1.0"));
        zombie.setDegat_attaque(20);
        zombie.setVitesse_de_deplacement(new BigDecimal("0.5"));
        zombie.setChemin_image("zombie/basic.png");
        zombie.setId_map(1L);

        String expectedString = "Zombie{" +
                "id_zombie=" + 1L +
                ", nom='Zombie de base'" +
                ", point_de_vie=" + 100 +
                ", attaque_par_seconde=" + new BigDecimal("1.0") +
                ", degat_attaque=" + 20 +
                ", vitesse_de_deplacement=" + new BigDecimal("0.5") +
                ", chemin_image='zombie/basic.png'" +
                ", id_map=" + 1L +
                '}';

        assertEquals(expectedString, zombie.toString());
    }
}