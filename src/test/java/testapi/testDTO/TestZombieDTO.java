package testapi.testDTO;

import com.epf.api.DTO.ZombieDTO;
import com.epf.persistance.Zombie;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestZombieDTO {

    @Test
    public void testToModel() {
        // Arrange
        ZombieDTO dto = new ZombieDTO();
        dto.setId_zombie(1L);
        dto.setNom("Test Zombie");
        dto.setPoint_de_vie(100);

        // Act
        Zombie zombie = dto.toModel();

        // Assert
        assertEquals(dto.getId_zombie(), zombie.getId_zombie());
        assertEquals(dto.getNom(), zombie.getNom());
        assertEquals(dto.getPoint_de_vie(), zombie.getPoint_de_vie());
    }

    @Test
    public void testFromModel() {
        // Arrange
        Zombie zombie = new Zombie();
        zombie.setId_zombie(1L);
        zombie.setNom("Test Zombie");
        zombie.setPoint_de_vie(100);

        // Act
        ZombieDTO dto = ZombieDTO.fromModel(zombie);

        // Assert
        assertEquals(zombie.getId_zombie(), dto.getId_zombie());
        assertEquals(zombie.getNom(), dto.getNom());
        assertEquals(zombie.getPoint_de_vie(), dto.getPoint_de_vie());
    }
}

