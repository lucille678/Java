package testpersistance;

import com.epf.persistance.Maps;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMaps {
    
    private Maps map;

    @Before
    public void setUp() {
        map = new Maps();
    }

    @Test
    public void testConstructeurVide() {
        assertNotNull("L'instance ne devrait pas être nulle", map);
        assertNull(map.getId_map());
        assertNull(map.getLigne());
        assertNull(map.getColonne());
        assertNull(map.getChemin_image());
    }

    @Test
    public void testConstructeurComplet() {
        map = new Maps(1L, 5, 8, "maps/test.png");
        
        assertEquals(Long.valueOf(1L), map.getId_map());
        assertEquals(Integer.valueOf(5), map.getLigne());
        assertEquals(Integer.valueOf(8), map.getColonne());
        assertEquals("maps/test.png", map.getChemin_image());
    }

    @Test
    public void testSettersEtGetters() {
        map.setId_map(1L);
        map.setLigne(5);
        map.setColonne(8);
        map.setChemin_image("maps/test.png");

        assertEquals(Long.valueOf(1L), map.getId_map());
        assertEquals(Integer.valueOf(5), map.getLigne());
        assertEquals(Integer.valueOf(8), map.getColonne());
        assertEquals("maps/test.png", map.getChemin_image());
    }

    @Test
    public void testToString() {
        map.setId_map(1L);
        map.setLigne(5);
        map.setColonne(8);
        map.setChemin_image("maps/test.png");

        String expectedString = "Maps{" +
                "id_map=" + 1L +
                ", ligne=" + 5 +
                ", colonne=" + 8 +
                ", chemin_image='maps/test.png'" +
                '}';

        assertEquals(expectedString, map.toString());
    }
}