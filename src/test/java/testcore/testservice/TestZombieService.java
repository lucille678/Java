package testcore.testservice;

import com.epf.persistance.Zombie;
import com.epf.core.service.ZombieService;
import com.epf.persistance.implementation.ZombieImplementationDAO;


class TestZombieService {
    /*

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
        Zombie zombie = new Zombie(1L, "Zombie Rapide", 90, new BigDecimal("12.00"), 50, new BigDecimal("5.00"), "path/image_zombie_rapide.jpeg", 2L);
        zombieService.ajouterZombie(zombie);
        verify(zombieDAO, times(1)).ajouterZombie(zombie);
    }

    @Test
    void testListerZombies() {
        when(zombieDAO.listerZombies()).thenReturn(List.of(
                new Zombie(1L, "Zombie Lent", 100, new BigDecimal("5.00"), 80, new BigDecimal("1.00"), "path/image_zombie_lent.jpeg", 2L)
        ));
        List<Zombie> zombies = zombieService.listerZombies();
        assertEquals(1, zombies.size());
        assertEquals("Zombie Lent", zombies.get(0).getNom());
        assertEquals(new BigDecimal("5.00"), zombies.get(0).getAttaque_par_seconde());
    }

    @Test
    void testTrouverParId() {
        Zombie zombie = new Zombie(1L, "Zombie Normal", 80, new BigDecimal("8.00"), 40, new BigDecimal("2.00"), "path/image_zombie_normal.jpeg", 1L);
        when(zombieDAO.trouverParId(1L)).thenReturn(zombie);

        Zombie result = zombieService.trouverParId(1L);
        assertNotNull(result);
        assertEquals("Zombie Normal", result.getNom());
        assertEquals(new BigDecimal("8.00"), result.getAttaque_par_seconde());
    }

    @Test
    void testMettreAJour() {
        Zombie zombie = new Zombie(1L, "Zombie Puissant", 120, new BigDecimal("15.00"), 60, new BigDecimal("3.00"), "path/image_zombie_puissant.jpeg", 1L);
        zombieService.mettreAJour(zombie);
        verify(zombieDAO, times(1)).mettreAJour(zombie);
    }

    @Test
    void testSupprimer() {
        zombieService.supprimer(1L);
        verify(zombieDAO, times(1)).supprimer(1L);
    }
    */
}