package testapi.testDTO;

import com.epf.persistance.Zombie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.epf.api.DTO.ZombieDTO;
class TestZombieDTO {

    @Test
    void testFromModel() {
        Zombie zombie = new Zombie(1L, "Zombie Sprinter", 90, 12, 50, 5, "path/image_zombie_sprinter.jpeg", 2L);
        ZombieDTO dto = ZombieDTO.fromModel(zombie);

        assertEquals(1L, dto.getId_zombie());
        assertEquals("Zombie Sprinter", dto.getNom());
        assertEquals(90, dto.getPoint_de_vie());
        assertEquals(12, dto.getAttaque_par_seconde());
        assertEquals(50, dto.getDegat_attaque());
        assertEquals(5, dto.getVitesse_de_deplacement());
        assertEquals("path/image_zombie_sprinter.jpeg", dto.getChemin_image());
        assertEquals(2L, dto.getId_map());
    }

    @Test
    void testToModel() {
        ZombieDTO dto = new ZombieDTO(2L, "Zombie Armé", 100, 20, 200, 2, "path/image_zombie_arme.jpeg", 1L);
        Zombie zombie = dto.toModel();

        assertEquals(2L, dto.getId_zombie());
        assertEquals("Zombie Armé", dto.getNom());
        assertEquals(100, dto.getPoint_de_vie());
        assertEquals(20, dto.getAttaque_par_seconde());
        assertEquals(200, dto.getDegat_attaque());
        assertEquals(2, dto.getVitesse_de_deplacement());
        assertEquals("path/image_zombie_arme.jpeg", dto.getChemin_image());
        assertEquals(1L, dto.getId_map());
    }
}

