package testapi.testcontroller;

import com.epf.api.controller.PlanteController;
import com.epf.api.DTO.PlanteDTO;
import com.epf.core.service.PlanteService;
import com.epf.persistance.Plante;
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
public class TestPlanteController {

    @Mock
    private PlanteService planteService;

    @InjectMocks
    private PlanteController planteController;

    private PlanteDTO validPlanteDTO;
    private Plante validPlante;

    @Before
    public void setUp() {
        validPlanteDTO = new PlanteDTO();
        validPlanteDTO.setId_plante(1);
        validPlanteDTO.setNom("Tournesol");
        validPlanteDTO.setPointDeVie(100);
        validPlanteDTO.setAttaqueParSeconde(new BigDecimal("1.5"));
        validPlanteDTO.setDegatAttaque(20);
        validPlanteDTO.setCout(50);
        validPlanteDTO.setSoleilParSeconde(new BigDecimal("0.5"));
        validPlanteDTO.setEffet("Produit du soleil");
        validPlanteDTO.setCheminImage("plante/tournesol.png");

        validPlante = validPlanteDTO.toModel();
    }

    @Test
    public void testAjouterPlante_Valid() {
        ResponseEntity<String> response = planteController.ajouterPlante(validPlanteDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Plante ajoutée avec succès !", response.getBody());
        verify(planteService).ajouterPlante(any(Plante.class));
    }

    @Test
    public void testAjouterPlante_NomNull() {
        validPlanteDTO.setNom(null);
        
        ResponseEntity<String> response = planteController.ajouterPlante(validPlanteDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("nom"));
    }

    @Test
    public void testAjouterPlante_CoutInvalide() {
        validPlanteDTO.setCout(0);
        
        ResponseEntity<String> response = planteController.ajouterPlante(validPlanteDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("coût"));
    }

    @Test
    public void testListerPlantes() {
        when(planteService.listerPlantes()).thenReturn(Arrays.asList(validPlante));

        ResponseEntity<List<PlanteDTO>> response = planteController.listerPlantes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testTrouverPlanteParId_Found() {
        when(planteService.trouverParId(1)).thenReturn(validPlante);

        ResponseEntity<PlanteDTO> response = planteController.trouverPlanteParId(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testTrouverPlanteParId_NotFound() {
        when(planteService.trouverParId(999)).thenReturn(null);

        ResponseEntity<PlanteDTO> response = planteController.trouverPlanteParId(999);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testMettreAJourPlante_Valid() {
        ResponseEntity<String> response = planteController.mettreAJourPlante(1L, validPlanteDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Plante mise à jour avec succès !", response.getBody());
        verify(planteService).mettreAJour(any(Plante.class));
    }

    @Test
    public void testSupprimerPlante_Success() {
        when(planteService.trouverParId(1L)).thenReturn(validPlante);
        doNothing().when(planteService).supprimer(1L);

        ResponseEntity<String> response = planteController.supprimerPlante(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Plante supprimée avec succès !", response.getBody());
    }

    @Test
    public void testSupprimerPlante_NotFound() {
        when(planteService.trouverParId(999L)).thenReturn(null);

        ResponseEntity<String> response = planteController.supprimerPlante(999L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testSupprimerPlante_ForeignKeyConstraint() {
        when(planteService.trouverParId(1L)).thenReturn(validPlante);
        doThrow(new RuntimeException("foreign key constraint"))
            .when(planteService).supprimer(1L);

        ResponseEntity<String> response = planteController.supprimerPlante(1L);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertTrue(response.getBody().contains("parties associées"));
    }
}