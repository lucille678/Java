package com.epf.api.controller;

import com.epf.core.service.PlanteService;
import com.epf.api.DTO.PlanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;

    @Autowired
    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    // ✅ Ajouter une plante
    @PostMapping
    public ResponseEntity<String> ajouterPlante(@RequestBody PlanteDTO planteDTO) {
        if (planteDTO.getNom() == null || planteDTO.getNom().isEmpty()) {
            return ResponseEntity.badRequest().body("Le nom de la plante est obligatoire.");
        }
        if (planteDTO.getCout() <= 0) {
            return ResponseEntity.badRequest().body("Le coût doit être supérieur à 0.");
        }
        planteService.ajouterPlante(planteDTO.toModel());
        return ResponseEntity.ok("Plante ajoutée avec succès !");
    }

    // ✅ Lister toutes les plantes
    @GetMapping
    public ResponseEntity<List<PlanteDTO>> listerPlantes() {
        List<PlanteDTO> plantes = planteService.listerPlantes()
                .stream()
                .map(PlanteDTO::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(plantes);
    }

    // ✅ Récupérer une plante par ID
    @GetMapping("/{id}")
    public ResponseEntity<PlanteDTO> trouverPlanteParId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(
                    PlanteDTO.fromModel(planteService.trouverParId(id))
            );
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Mettre à jour une plante
    @PutMapping("/{id}")
    public ResponseEntity<String> mettreAJourPlante(@PathVariable("id") long id, @RequestBody PlanteDTO planteDTO) {
        if (planteDTO.getNom() == null || planteDTO.getNom().isEmpty()) {
            return ResponseEntity.badRequest().body("Le nom de la plante est obligatoire.");
        }
        if (planteDTO.getCout() <= 0) {
            return ResponseEntity.badRequest().body("Le coût doit être supérieur à 0.");
        }
        planteDTO.setId(id);
        planteService.mettreAJour(planteDTO.toModel());
        return ResponseEntity.ok("Plante mise à jour avec succès !");
    }

    // ✅ Supprimer une plante
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerPlante(@PathVariable("id") long id) {
        try {
            // Vérifier d'abord si la plante existe
            if (planteService.trouverParId(id) == null) {
                return ResponseEntity.notFound().build();
            }
            
            try {
                planteService.supprimer(id);
                return ResponseEntity.ok("Plante supprimée avec succès !");
            } catch (Exception e) {
                // Vérifier s'il y a une violation de contrainte de clé étrangère
                if (e.getMessage().contains("foreign key constraint")) {
                    return ResponseEntity.status(409)  // HTTP 409 Conflict
                        .body("Impossible de supprimer la plante car elle est utilisée dans une partie. " +
                            "Supprimez d'abord les parties associées.");
                }
                throw e;  // Re-throw if it's a different error
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500)
                .body("Erreur lors de la suppression de la plante: " + e.getMessage());
        }
    }
}