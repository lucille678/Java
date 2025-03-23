package testapi.testDTO;


import com.epf.api.DTO.MapsDTO;
import com.epf.core.model.Maps;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestMapsDTO {

    @Test
    void testFromModel() {
        Maps map = new Maps(1L, "Ville Fantôme", 5);
        MapsDTO dto = MapsDTO.fromModel(map);

        assertEquals(1L, dto.getId());
        assertEquals("Ville Fantôme", dto.getNom());
        assertEquals(5, dto.getDifficulte());
    }

    @Test
    void testToModel() {
        MapsDTO dto = new MapsDTO(2L, "Lac Maudit", 4);
        Maps map = dto.toModel();

        assertEquals(2L, map.getId());
        assertEquals("Lac Maudit", map.getNom());
        assertEquals(4, map.getDifficulte());
    }
}
