package testapi.testcontroller;

import com.epf.api.controller.ZombieController;
import com.epf.api.DTO.ZombieDTO;
import com.epf.core.service.ZombieService;
import com.epf.persistance.Zombie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestZombieController {

    @Mock
    private ZombieService zombieService;

    @InjectMocks
    private ZombieController zombieController;

    private ZombieDTO validZombieDTO;
    private Zombie validZombie;

    @Before
    public void setUp() {
        validZombieDTO = new ZombieDTO();
        validZombieDTO.setId_zombie(1L);
        validZombieDTO.setNom("Zombie de base");
        validZombieDTO.setPoint_de_vie(100);
        validZombieDTO.setDegat_attaque(20);
        validZombieDTO.setId_map(1L);
        validZombieDTO.setChemin_image("zombie/basic.png");

        validZombie = validZombieDTO.toModel();
    }

    @Test
    public void testAjouterZombie_Valid() {
        ResponseEntity<String> response = zombieController.ajouterZombie(validZombieDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Zombie ajouté avec succès !", response.getBody());
        verify(zombieService).ajouterZombie(any(Zombie.class));
    }

    @Test
    public void testAjouterZombie_NomNull() {
        validZombieDTO.setNom(null);
        
        ResponseEntity<String> response = zombieController.ajouterZombie(validZombieDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("nom"));
    }

    @Test
    public void testAjouterZombie_PointDeVieInvalide() {
        validZombieDTO.setPoint_de_vie(0);
        
        ResponseEntity<String> response = zombieController.ajouterZombie(validZombieDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("points de vie"));
    }

    @Test
    public void testListerZombies() {
        when(zombieService.listerZombies()).thenReturn(Arrays.asList(validZombie));

        ResponseEntity<List<ZombieDTO>> response = zombieController.listerZombies();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testTrouverZombieParId_Found() {
        when(zombieService.trouverParId(1L)).thenReturn(validZombie);

        ResponseEntity<ZombieDTO> response = zombieController.trouverZombieParId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(validZombieDTO.getId_zombie(), response.getBody().getId_zombie());
    }

    @Test
    public void testTrouverZombieParId_NotFound() {
        when(zombieService.trouverParId(999L)).thenThrow(new RuntimeException());

        ResponseEntity<ZombieDTO> response = zombieController.trouverZombieParId(999L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testMettreAJourZombie_Valid() {
        ResponseEntity<String> response = zombieController.mettreAJourZombie(1L, validZombieDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Zombie mis à jour avec succès !", response.getBody());
        verify(zombieService).mettreAJour(any(Zombie.class));
    }

    @Test
    public void testMettreAJourZombie_NomInvalide() {
        validZombieDTO.setNom("");
        
        ResponseEntity<String> response = zombieController.mettreAJourZombie(1L, validZombieDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("nom"));
    }

    @Test
    public void testSupprimerZombie_Success() {
        doNothing().when(zombieService).supprimer(1L);

        ResponseEntity<String> response = zombieController.supprimerZombie(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Zombie supprimé avec succès !", response.getBody());
        verify(zombieService).supprimer(1L);
    }

    @Test
    public void testSupprimerZombie_NotFound() {
        doThrow(new RuntimeException()).when(zombieService).supprimer(999L);

        ResponseEntity<String> response = zombieController.supprimerZombie(999L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}