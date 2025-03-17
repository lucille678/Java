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

    @PostMapping
    public ResponseEntity<String> ajouterPlante(@RequestBody PlanteDTO planteDTO) {
        planteService.ajouterPlante(planteDTO.toModel());
        return ResponseEntity.ok("Plante ajoutée avec succès !");
    }

    @GetMapping
    public ResponseEntity<List<PlanteDTO>> listerPlantes() {
        List<PlanteDTO> plantes = planteService.listerPlantes()
                .stream()
                .map(PlanteDTO::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(plantes);
    }
}
