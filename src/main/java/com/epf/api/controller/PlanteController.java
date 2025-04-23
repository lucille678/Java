package com.epf.api.controller;

import com.epf.core.service.PlanteService;
import com.epf.api.DTO.PlanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/plantes")
public class PlanteController {

    private final PlanteService planteService;

    @Autowired
    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    // ✅ Ajouter une plante
    @PostMapping
    public ResponseEntity<String> ajouterPlante(@RequestBody PlanteDTO planteDTO) {
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
    public ResponseEntity<PlanteDTO> trouverPlanteParId(@PathVariable long id) {
        return ResponseEntity.ok(
                PlanteDTO.fromModel(planteService.trouverParId(id))
        );
    }

    // ✅ Mettre à jour une plante
    @PutMapping("/{id}")
    public ResponseEntity<String> mettreAJourPlante(@PathVariable long id, @RequestBody PlanteDTO planteDTO) {
        PlanteDTO planteAModifier = planteDTO;
        planteAModifier.setId(id);
        planteService.mettreAJour(planteAModifier.toModel());
        return ResponseEntity.ok("Plante mise à jour avec succès !");
    }

    // ✅ Supprimer une plante
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerPlante(@PathVariable long id) {
        planteService.supprimer(id);
        return ResponseEntity.ok("Plante supprimée avec succès !");
    }
}
