package testcore.testservice;

import com.epf.persistance.Maps;
import com.epf.core.service.MapsService;
import com.epf.persistance.implementation.MapsImplementationDAO;


class TestMapsService {
    /*

    @Mock
    private MapsImplementationDAO mapDAO;

    @InjectMocks
    private MapsService mapsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAjouterMap() {
        Maps map = new Maps(1L, 5, 5, "path/image_map.jpeg");
        mapsService.ajouterMap(map);
        verify(mapDAO, times(1)).ajouterMap(map);
    }

    @Test
    void testListerMaps() {
        when(mapDAO.listerMaps()).thenReturn(List.of(
                new Maps(1L, 5, 5, "path/image_map_1.jpeg"),
                new Maps(2L, 6, 6, "path/image_map_2.jpeg")
        ));

        List<Maps> maps = mapsService.listerMaps();
        assertEquals(2, maps.size());
        assertEquals(5, maps.get(0).getLigne());
        assertEquals(6, maps.get(1).getColonne());
    }

    @Test
    void testTrouverParId() {
        when(mapDAO.trouverParId(1)).thenReturn(new Maps(1L, 5, 5, "path/image_map.jpeg"));

        Maps map = mapsService.trouverParId(1L);
        assertNotNull(map);
        assertEquals(5, map.getLigne());
        assertEquals("path/image_map.jpeg", map.getChemin_image());
    }

    @Test
    void testMettreAJour() {
        Maps map = new Maps(1L, 7, 7, "path/image_map_updated.jpeg");
        mapsService.mettreAJour(map);
        verify(mapDAO, times(1)).mettreAJour(map);
    }

    @Test
    void testSupprimer() {
        mapsService.supprimer(1L);
        verify(mapDAO, times(1)).supprimer(1);
    }
    */
}
