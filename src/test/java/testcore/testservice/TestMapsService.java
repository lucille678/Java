package testcore.testservice;


import com.epf.persistance.Maps;
import com.epf.persistance.implementation.MapsImplementationDAO;
import com.epf.core.service.MapsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestMapsService {

    @Mock
    private MapsImplementationDAO mapsImpl;

    @InjectMocks
    private MapsService mapsService;

    private Maps validMap;

    @Before
    public void setUp() {
        validMap = new Maps();
        validMap.setId_map(1L);
        validMap.setLigne(5);
        validMap.setColonne(8);
        validMap.setChemin_image("maps/map1.png");
    }

    @Test
    public void testListerMaps() {
        // Arrange
        List<Maps> expectedMaps = Arrays.asList(validMap);
        when(mapsImpl.listerMaps()).thenReturn(expectedMaps);

        // Act
        List<Maps> actualMaps = mapsService.listerMaps();

        // Assert
        assertEquals(expectedMaps, actualMaps);
        verify(mapsImpl).listerMaps();
    }

    @Test
    public void testTrouverParId_ExistingMap() {
        // Arrange
        when(mapsImpl.trouverParId(1L)).thenReturn(validMap);

        // Act
        Maps foundMap = mapsService.trouverParId(1L);

        // Assert
        assertNotNull(foundMap);
        assertEquals(validMap.getId_map(), foundMap.getId_map());
        verify(mapsImpl).trouverParId(1L);
    }

    @Test
    public void testTrouverParId_NonExistingMap() {
        // Arrange
        when(mapsImpl.trouverParId(999L)).thenReturn(null);

        // Act
        Maps foundMap = mapsService.trouverParId(999L);

        // Assert
        assertNull(foundMap);
        verify(mapsImpl).trouverParId(999L);
    }

    @Test
    public void testAjouterMap_Valid() {
        // Act
        mapsService.ajouterMap(validMap);

        // Assert
        verify(mapsImpl).ajouterMap(validMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterMap_InvalidLignes() {
        // Arrange
        validMap.setLigne(0);

        // Act
        mapsService.ajouterMap(validMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterMap_InvalidColonnes() {
        // Arrange
        validMap.setColonne(-1);

        // Act
        mapsService.ajouterMap(validMap);
    }

    @Test
    public void testMettreAJour_Valid() {
        // Act
        mapsService.mettreAJour(validMap);

        // Assert
        verify(mapsImpl).mettreAJour(validMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMettreAJour_NullMap() {
        mapsService.mettreAJour(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMettreAJour_NullId() {
        // Arrange
        validMap.setId_map(null);

        // Act
        mapsService.mettreAJour(validMap);
    }

    @Test
    public void testSupprimer_ExistingMap() {
        // Act
        mapsService.supprimer(1L);

        // Assert
        verify(mapsImpl).supprimer(1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSupprimer_NonExistingMap() {
        // Arrange
        doThrow(new EmptyResultDataAccessException(1))
            .when(mapsImpl).supprimer(999L);

        // Act
        mapsService.supprimer(999L);
    }
}