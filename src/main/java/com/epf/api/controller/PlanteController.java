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
        if (planteDTO.getPointDeVie() <= 0) {
            return ResponseEntity.badRequest().body("Les points de vie doivent être supérieurs à 0.");
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
    @GetMapping("/plantes/{id}")
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
    @PutMapping("/plantes/{id}")
    public ResponseEntity<String> mettreAJourPlante(@PathVariable long id, @RequestBody PlanteDTO planteDTO) {
        if (planteDTO.getNom() == null || planteDTO.getNom().isEmpty()) {
            return ResponseEntity.badRequest().body("Le nom de la plante est obligatoire.");
        }
        if (planteDTO.getPointDeVie() <= 0) {
            return ResponseEntity.badRequest().body("Les points de vie doivent être supérieurs à 0.");
        }
        if (planteDTO.getCout() <= 0) {
            return ResponseEntity.badRequest().body("Le coût doit être supérieur à 0.");
        }
        planteDTO.setId(id);
        planteService.mettreAJour(planteDTO.toModel());
        return ResponseEntity.ok("Plante mise à jour avec succès !");
    }

    // ✅ Supprimer une plante
    @DeleteMapping("/plantes/{id}")
    public ResponseEntity<String> supprimerPlante(@PathVariable long id) {
        try {
            planteService.supprimer(id);
            return ResponseEntity.ok("Plante supprimée avec succès !");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}