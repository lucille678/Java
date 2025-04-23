package testapi.testDTO;

import com.epf.persistance.Zombie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.epf.api.DTO.ZombieDTO;
class TestZombieDTO {

    @Test
    void testFromModel() {
        Zombie zombie = new Zombie(1L, "Zombie Sprinter", 90, 12, 5);
        ZombieDTO dto = ZombieDTO.fromModel(zombie);

        assertEquals(1L, dto.getId());
        assertEquals("Zombie Sprinter", dto.getNom());
        assertEquals(90, dto.getPv());
        assertEquals(12, dto.getAttaque());
        assertEquals(5, dto.getVitesse());
    }

    @Test
    void testToModel() {
        ZombieDTO dto = new ZombieDTO(2L, "Zombie Armé", 100, 20, 2);
        Zombie zombie = dto.toModel();

        assertEquals(2L, zombie.getId());
        assertEquals("Zombie Armé", zombie.getNom());
        assertEquals(100, zombie.getPv());
        assertEquals(20, zombie.getAttaque());
        assertEquals(2, zombie.getVitesse());
    }
}

