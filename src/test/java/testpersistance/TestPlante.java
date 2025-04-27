package testpersistance;


import com.epf.persistance.Plante;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class TestPlante {
    
    private Plante plante;

    @Before
    public void setUp() {
        plante = new Plante();
    }

    @Test
    public void testConstructeurVide() {
        assertNotNull("L'instance ne devrait pas être nulle", plante);
    }

    @Test
    public void testConstructeurComplet() {
        plante = new Plante(1, "Tournesol", 100, new BigDecimal("1.5"), 
            20, 50, new BigDecimal("0.5"), "Produit du soleil", "plante/tournesol.png");
        
        assertEquals(1, plante.getId_plante());
        assertEquals("Tournesol", plante.getNom());
        assertEquals(100, plante.getPoint_de_vie());
        assertEquals(0, new BigDecimal("1.5").compareTo(plante.getAttaque_par_seconde()));
        assertEquals(20, plante.getDegat_attaque());
        assertEquals(50, plante.getCout());
        assertEquals(0, new BigDecimal("0.5").compareTo(plante.getSoleil_par_seconde()));
        assertEquals("Produit du soleil", plante.getEffet());
        assertEquals("plante/tournesol.png", plante.getChemin_image());
    }

    @Test
    public void testSettersEtGetters() {
        plante.setId_plante(1);
        plante.setNom("Tournesol");
        plante.setPoint_de_vie(100);
        plante.setAttaque_par_seconde(new BigDecimal("1.5"));
        plante.setDegat_attaque(20);
        plante.setCout(50);
        plante.setSoleil_par_seconde(new BigDecimal("0.5"));
        plante.setEffet("Produit du soleil");
        plante.setChemin_image("plante/tournesol.png");

        assertEquals(1, plante.getId_plante());
        assertEquals("Tournesol", plante.getNom());
        assertEquals(100, plante.getPoint_de_vie());
        assertEquals(0, new BigDecimal("1.5").compareTo(plante.getAttaque_par_seconde()));
        assertEquals(20, plante.getDegat_attaque());
        assertEquals(50, plante.getCout());
        assertEquals(0, new BigDecimal("0.5").compareTo(plante.getSoleil_par_seconde()));
        assertEquals("Produit du soleil", plante.getEffet());
        assertEquals("plante/tournesol.png", plante.getChemin_image());
    }
}