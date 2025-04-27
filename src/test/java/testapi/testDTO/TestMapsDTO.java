
package testapi.testDTO;
import com.epf.api.DTO.MapsDTO;
import com.epf.persistance.Maps;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMapsDTO {
    
    private Maps validMap;
    private MapsDTO validMapDTO;

    @Before
    public void setUp() {
        validMap = new Maps();
        validMap.setId_map(1L);
        validMap.setLigne(5);
        validMap.setColonne(8);
        validMap.setChemin_image("maps/test.png");

        validMapDTO = new MapsDTO();
        validMapDTO.setId_map(1L);
        validMapDTO.setLigne(5);
        validMapDTO.setColonne(8);
        validMapDTO.setChemin_image("maps/test.png");
    }

    @Test
    public void testToModel() {
        // Act
        Maps convertedMap = validMapDTO.toModel();

        // Assert
        assertEquals(validMapDTO.getId_map(), convertedMap.getId_map());
        assertEquals(validMapDTO.getLigne(), convertedMap.getLigne());
        assertEquals(validMapDTO.getColonne(), convertedMap.getColonne());
        assertEquals(validMapDTO.getChemin_image(), convertedMap.getChemin_image());
    }

    @Test
    public void testFromModel() {
        // Act
        MapsDTO convertedDTO = MapsDTO.fromModel(validMap);

        // Assert
        assertEquals(validMap.getId_map(), convertedDTO.getId_map());
        assertEquals(validMap.getLigne(), convertedDTO.getLigne());
        assertEquals(validMap.getColonne(), convertedDTO.getColonne());
        assertEquals(validMap.getChemin_image(), convertedDTO.getChemin_image());
    }

    @Test
    public void testConstructor() {
        // Act
        MapsDTO dto = new MapsDTO(1L, 5, 8, "maps/test.png");

        // Assert
        assertEquals(Long.valueOf(1L), dto.getId_map());
        assertEquals(Integer.valueOf(5), dto.getLigne());
        assertEquals(Integer.valueOf(8), dto.getColonne());
        assertEquals("maps/test.png", dto.getChemin_image());
    }
}


