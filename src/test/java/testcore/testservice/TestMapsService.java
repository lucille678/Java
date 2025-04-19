package testcore.testservice;

import com.epf.core.model.Maps;
import com.epf.core.service.MapsService;
import com.epf.persistance.implementation.MapsImplementationDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.List;
import java.util.Optional;

import static javax.management.Query.times;
//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestMapsService {

    @Mock
    private MapsImplementationDAO mapDAO;

    @InjectMocks
    private MapsService mapsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}
/*
    @Test
    void testAjouterMap() {
        Maps map = new Maps(1L, "Forêt Sombre", 3);
        mapsService.ajouterMap(map);
        verify(mapDAO, times(1)).ajouterMap(map);
    }

    @Test
    void testListerMaps() {
        when(mapDAO.listerMaps()).thenReturn(List.of(new Maps(1L, "Désert", 2)));
        List<Maps> maps = mapsService.listerMaps();
        assertEquals(1, maps.size());
        assertEquals("Désert", maps.get(0).getNom());
    }

    @Test
    void testTrouverParId() {
        when(mapDAO.trouverParId(1L)).thenReturn(new Maps(1L, "Jungle", 4));
        Maps map = mapsService.trouverParId(1L);
        assertNotNull(map);
        assertEquals("Jungle", map.getNom());
    }



    @Test
    void testMettreAJour() {
        Maps map = new Maps(1L, "Plaine", 1);
        mapsService.mettreAJour(map);
        verify(mapDAO, times(1)).mettreAJour(map);
    }

    @Test
    void testSupprimer() {
        mapsService.supprimer(1L);
        verify(mapDAO, times(1)).supprimer(1L);
    }
}
*/
