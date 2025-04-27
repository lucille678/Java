package testapi.testcontroller;

import com.epf.api.controller.MapsController;
import com.epf.api.DTO.MapsDTO;
import com.epf.core.service.MapsService;
import com.epf.core.service.ZombieService;
import com.epf.persistance.Maps;
import com.epf.persistance.Zombie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestMapsController {

    @Mock
    private MapsService mapsService;

    @Mock
    private ZombieService zombieService;

    @InjectMocks
    private MapsController mapsController;

    private MapsDTO validMapDTO;
    private Maps validMap;

    @Before
    public void setUp() {
        validMapDTO = new MapsDTO();
        validMapDTO.setId_map(1L);
        validMapDTO.setLigne(5);
        validMapDTO.setColonne(8);
        validMapDTO.setChemin_image("maps/test.png");

        validMap = validMapDTO.toModel();
    }

    @Test
    public void testAjouterMap_Valid() {
        ResponseEntity<String> response = mapsController.ajouterMap(validMapDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Map ajoutée avec succès !", response.getBody());
        verify(mapsService).ajouterMap(any(Maps.class));
    }

    @Test
    public void testAjouterMap_InvalidDimensions() {
        validMapDTO.setLigne(0);
        
        ResponseEntity<String> response = mapsController.ajouterMap(validMapDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("dimensions"));
    }

    @Test
    public void testListerMaps() {
        List<Maps> maps = Arrays.asList(validMap);
        when(mapsService.listerMaps()).thenReturn(maps);

        ResponseEntity<?> response = mapsController.listerMaps();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(mapsService).listerMaps();
    }

    @Test
    public void testTrouverMapParId_Existing() {
        when(mapsService.trouverParId(1L)).thenReturn(validMap);

        ResponseEntity<MapsDTO> response = mapsController.trouverMapParId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(validMapDTO.getId_map(), response.getBody().getId_map());
    }

    @Test
    public void testTrouverMapParId_NotFound() {
        when(mapsService.trouverParId(999L)).thenReturn(null);

        ResponseEntity<MapsDTO> response = mapsController.trouverMapParId(999L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testMettreAJourMap_Valid() {
        ResponseEntity<String> response = mapsController.mettreAJourMap(1L, validMapDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Map mise à jour avec succès !", response.getBody());
        verify(mapsService).mettreAJour(any(Maps.class));
    }

    @Test
    public void testSupprimerMap_Success() {
        // Setup
        when(mapsService.trouverParId(1L)).thenReturn(validMap);
        Zombie zombie = new Zombie();
        zombie.setId_zombie(1L);
        List<Zombie> zombies = Arrays.asList(zombie);
        when(zombieService.trouverParMap(1L)).thenReturn(zombies);
        doNothing().when(zombieService).supprimer(anyLong());
        doNothing().when(mapsService).supprimer(anyLong());

        // Act
        ResponseEntity<String> response = mapsController.supprimerMap(1L);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("succès"));
        verify(zombieService).trouverParMap(1L);
        verify(mapsService).supprimer(1L);
    }

    @Test
    public void testSupprimerMap_NotFound() {
        when(mapsService.trouverParId(999L)).thenReturn(null);

        ResponseEntity<String> response = mapsController.supprimerMap(999L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}