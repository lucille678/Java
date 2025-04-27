package testcore.testservice;

import com.epf.core.service.PlanteService;
import com.epf.persistance.Plante;
import com.epf.persistance.implementation.PlanteImplementationDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestPlanteService {

    @Mock
    private PlanteImplementationDAO planteDAO;

    @InjectMocks
    private PlanteService planteService;

    private Plante validPlante;

    @Before
    public void setUp() {
        validPlante = new Plante();
        validPlante.setId_plante(1); 
        validPlante.setNom("Tournesol");
        validPlante.setPoint_de_vie(100);
        validPlante.setAttaque_par_seconde(new BigDecimal("1.5"));
        validPlante.setDegat_attaque(20);
        validPlante.setCout(50);
        validPlante.setSoleil_par_seconde(new BigDecimal("0.5"));
        validPlante.setEffet("Produit du soleil");
        validPlante.setChemin_image("plante/tournesol.png");
    }

    @Test
    public void testTrouverParId_ExistingPlante() {
        when(planteDAO.trouverParId(1L)).thenReturn(validPlante);
        
        Plante found = planteService.trouverParId(1L);
        
        assertNotNull(found);
        assertEquals(validPlante.getId_plante(), found.getId_plante());
        verify(planteDAO).trouverParId(1L);
    }

    @Test(expected = RuntimeException.class)
    public void testTrouverParId_ThrowsException() {
        when(planteDAO.trouverParId(999L)).thenThrow(new RuntimeException());
        
        planteService.trouverParId(999L);
    }

    @Test
    public void testListerPlantes() {
        List<Plante> expectedPlantes = Arrays.asList(validPlante);
        when(planteDAO.listerPlantes()).thenReturn(expectedPlantes);
        
        List<Plante> actualPlantes = planteService.listerPlantes();
        
        assertEquals(expectedPlantes.size(), actualPlantes.size());
        verify(planteDAO).listerPlantes();
    }

    @Test
    public void testAjouterPlante_Valid() {
        planteService.ajouterPlante(validPlante);
        
        verify(planteDAO).ajouterPlante(validPlante);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterPlante_NomNull() {
        validPlante.setNom(null);
        
        planteService.ajouterPlante(validPlante);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterPlante_NomVide() {
        validPlante.setNom("");
        
        planteService.ajouterPlante(validPlante);
    }

    @Test
    public void testMettreAJour_Valid() {
        planteService.mettreAJour(validPlante);
        
        verify(planteDAO).mettreAJour(validPlante);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMettreAJour_InvalidId() {
        validPlante.setId_plante(0);  // Changed from 0L to 0
        
        planteService.mettreAJour(validPlante);
    }

    @Test
    public void testSupprimer() {
        planteService.supprimer(1L);
        
        verify(planteDAO).supprimer(1L);
    }
}
