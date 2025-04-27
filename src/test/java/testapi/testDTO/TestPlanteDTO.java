package testapi.testDTO;

import com.epf.api.DTO.PlanteDTO;
import com.epf.persistance.Plante;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class TestPlanteDTO {
    
    private Plante validPlante;
    private PlanteDTO validPlanteDTO;

    @Before
    public void setUp() {
        // Initialiser un DTO valide
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

        // Initialiser une entité valide
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
    public void testToModel() {
        // Act
        Plante convertedPlante = validPlanteDTO.toModel();

        // Assert
        assertEquals(validPlanteDTO.getId_plante(), convertedPlante.getId_plante());
        assertEquals(validPlanteDTO.getNom(), convertedPlante.getNom());
        assertEquals(validPlanteDTO.getPointDeVie(), convertedPlante.getPoint_de_vie());
        assertEquals(0, validPlanteDTO.getAttaqueParSeconde().compareTo(convertedPlante.getAttaque_par_seconde()));
        assertEquals(validPlanteDTO.getDegatAttaque(), convertedPlante.getDegat_attaque());
        assertEquals(validPlanteDTO.getCout(), convertedPlante.getCout());
        assertEquals(0, validPlanteDTO.getSoleilParSeconde().compareTo(convertedPlante.getSoleil_par_seconde()));
        assertEquals(validPlanteDTO.getEffet(), convertedPlante.getEffet());
        assertEquals(validPlanteDTO.getCheminImage(), convertedPlante.getChemin_image());
    }

    @Test
    public void testFromModel() {
        // Act
        PlanteDTO convertedDTO = PlanteDTO.fromModel(validPlante);

        // Assert
        assertEquals(validPlante.getId_plante(), convertedDTO.getId_plante());
        assertEquals(validPlante.getNom(), convertedDTO.getNom());
        assertEquals(validPlante.getPoint_de_vie(), convertedDTO.getPointDeVie());
        assertEquals(0, validPlante.getAttaque_par_seconde().compareTo(convertedDTO.getAttaqueParSeconde()));
        assertEquals(validPlante.getDegat_attaque(), convertedDTO.getDegatAttaque());
        assertEquals(validPlante.getCout(), convertedDTO.getCout());
        assertEquals(0, validPlante.getSoleil_par_seconde().compareTo(convertedDTO.getSoleilParSeconde()));
        assertEquals(validPlante.getEffet(), convertedDTO.getEffet());
        assertEquals(validPlante.getChemin_image(), convertedDTO.getCheminImage());
    }

    @Test
    public void testConstructor() {
        // Act
        PlanteDTO dto = new PlanteDTO(1, "Test", 100, new BigDecimal("1.5"), 
            20, 50, new BigDecimal("0.5"), "Test effet", "test.png");

        // Assert
        assertEquals(1, dto.getId_plante());
        assertEquals("Test", dto.getNom());
        assertEquals(100, dto.getPointDeVie());
        assertEquals(0, new BigDecimal("1.5").compareTo(dto.getAttaqueParSeconde()));
        assertEquals(20, dto.getDegatAttaque());
        assertEquals(50, dto.getCout());
        assertEquals(0, new BigDecimal("0.5").compareTo(dto.getSoleilParSeconde()));
        assertEquals("Test effet", dto.getEffet());
        assertEquals("test.png", dto.getCheminImage());
    }
}