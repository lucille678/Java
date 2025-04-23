package testcore.testservice;

import com.epf.persistance.Zombie;
import com.epf.core.service.ZombieService;
import com.epf.persistance.implementation.ZombieImplementationDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestZombieService {

    @Mock
    private ZombieImplementationDAO zombieDAO;

    @InjectMocks
    private ZombieService zombieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAjouterZombie() {
        Zombie zombie = new Zombie(1L, "Zombie Rapide", 50, 10, 3);
        zombieService.ajouterZombie(zombie);
        verify(zombieDAO, times(1)).ajouterZombie(zombie);
    }

    @Test
    void testListerZombies() {
        when(zombieDAO.listerZombies()).thenReturn(List.of(new Zombie(1L, "Zombie Lent", 100, 5, 1)));
        List<Zombie> zombies = zombieService.listerZombies();
        assertEquals(1, zombies.size());
        assertEquals("Zombie Lent", zombies.get(0).getNom());
    }
}
/*
    @Test
    void testTrouverParId() {
        when(zombieDAO.trouverParId(1L)).thenReturn(Optional.of(new Zombie(1L, "Zombie Normal", 80, 8, 2)));
        Optional<Zombie> zombie = zombieService.trouverParId(1L);
        assertTrue(zombie.isPresent());
        assertEquals("Zombie Normal", zombie.get().getNom());
    }

    @Test
    void testMettreAJour() {
        Zombie zombie = new Zombie(1L, "Zombie Puissant", 120, 15, 2);
        zombieService.mettreAJour(zombie);
        verify(zombieDAO, times(1)).mettreAJour(zombie);
    }

    @Test
    void testSupprimer() {
        zombieService.supprimer(1L);
        verify(zombieDAO, times(1)).supprimer(1L);
    }
}
*/