package testapi.testDTO;

import com.epf.api.DTO.MapsDTO;
import com.epf.persistance.Maps;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestMapsDTO {

    @Test
    void testFromModel() {
        // Création d'un objet Maps
        Maps map = new Maps(1L, 10, 20, "path/to/image.png");

        // Conversion de l'objet Maps en MapsDTO
        MapsDTO dto = MapsDTO.fromModel(map);

        // Vérification des attributs du DTO
        assertEquals(1L, dto.getId_map());
        assertEquals(10, dto.getLigne());
        assertEquals(20, dto.getColonne());
        assertEquals("path/to/image.png", dto.getChemin_image());
    }

    @Test
    void testToModel() {
        // Création d'un objet MapsDTO
        MapsDTO dto = new MapsDTO(2L, 15, 25, "path/to/another_image.png");

        // Conversion du MapsDTO en objet Maps
        Maps map = dto.toModel();

        // Vérification des attributs du modèle Maps
        assertEquals(2L, map.getId_map());
        assertEquals(15, map.getLigne());
        assertEquals(25, map.getColonne());
        assertEquals("path/to/another_image.png", map.getChemin_image());
    }
}


