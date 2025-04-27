package testcore.testservice;

import com.epf.core.service.ZombieService;
import com.epf.persistance.Zombie;
import com.epf.persistance.implementation.ZombieImplementationDAO;
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
public class TestZombieService {

    @Mock
    private ZombieImplementationDAO zombieDAO;

    @InjectMocks
    private ZombieService zombieService;

    private Zombie validZombie;

    @Before
    public void setUp() {
        validZombie = new Zombie();
        validZombie.setId_zombie(1L);      
        validZombie.setNom("Zombie de base");
        validZombie.setPoint_de_vie(100);
        validZombie.setDegat_attaque(20);
        validZombie.setId_map(1L);         
        validZombie.setChemin_image("zombie/basic.png");
    }

    @Test
    public void testListerZombies() {
        List<Zombie> expectedZombies = Arrays.asList(validZombie);
        when(zombieDAO.listerZombies()).thenReturn(expectedZombies);

        List<Zombie> actualZombies = zombieService.listerZombies();

        assertEquals(expectedZombies.size(), actualZombies.size());
        verify(zombieDAO).listerZombies();
    }

    @Test
    public void testTrouverParId_ExistingZombie() {
        when(zombieDAO.trouverParId(1L)).thenReturn(validZombie);

        Zombie found = zombieService.trouverParId(1L);

        assertNotNull(found);
        assertEquals(validZombie.getId_zombie(), found.getId_zombie());
        verify(zombieDAO).trouverParId(1L);
    }

    @Test(expected = RuntimeException.class)
    public void testTrouverParId_ThrowsException() {
        when(zombieDAO.trouverParId(999L)).thenThrow(new RuntimeException());
        
        zombieService.trouverParId(999L);
    }

    @Test
    public void testTrouverParMap() {
        List<Zombie> expectedZombies = Arrays.asList(validZombie);
        when(zombieDAO.listerZombiesParMap(1L)).thenReturn(expectedZombies);

        List<Zombie> actualZombies = zombieService.trouverParMap(1L);

        assertEquals(expectedZombies.size(), actualZombies.size());
        verify(zombieDAO).listerZombiesParMap(1L);
    }

    @Test
    public void testAjouterZombie_Valid() {
        zombieService.ajouterZombie(validZombie);
        
        verify(zombieDAO).ajouterZombie(validZombie);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterZombie_NomNull() {
        validZombie.setNom(null);
        
        zombieService.ajouterZombie(validZombie);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterZombie_PointDeVieInvalide() {
        validZombie.setPoint_de_vie(-1);
        
        zombieService.ajouterZombie(validZombie);
    }

    @Test
    public void testMettreAJour_Valid() {
        zombieService.mettreAJour(validZombie);
        
        verify(zombieDAO).mettreAJour(validZombie);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMettreAJour_IdNull() {
        validZombie.setId_zombie(null);
        
        zombieService.mettreAJour(validZombie);
    }

    @Test
    public void testSupprimer() {
        zombieService.supprimer(1L);
        
        verify(zombieDAO).supprimer(1L);
    }
}