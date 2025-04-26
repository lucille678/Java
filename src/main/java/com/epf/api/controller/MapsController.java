package com.epf.api.controller;

import com.epf.core.service.MapsService;
import com.epf.api.DTO.MapsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/maps")
public class MapsController {

    private final MapsService mapsService;

    @Autowired
    public MapsController(MapsService mapsService) {
        this.mapsService = mapsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapsDTO> trouverMapParId(@PathVariable Long id) { // Correction : Utilisation de Long
        try {
            return ResponseEntity.ok(
                    MapsDTO.fromModel(mapsService.trouverParId(id))
            );
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerMap(@PathVariable Long id) { // Correction : Utilisation de Long
        try {
            mapsService.supprimer(id);
            return ResponseEntity.ok("Map supprimée avec succès !");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}