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

    // ✅ Ajouter une map
    @PostMapping
    public ResponseEntity<String> ajouterMap(@RequestBody MapsDTO mapsDTO) {
        if (mapsDTO.getLigne() <= 0 || mapsDTO.getColonne() <= 0) {
            return ResponseEntity.badRequest().body("Les dimensions doivent être supérieures à 0.");
        }
        if (mapsDTO.getChemin_image() == null || mapsDTO.getChemin_image().isEmpty()) {
            return ResponseEntity.badRequest().body("Le chemin de l'image est obligatoire.");
        }
        mapsService.ajouterMap(mapsDTO.toModel());
        return ResponseEntity.ok("Map ajoutée avec succès !");
    }

     // ✅ Lister toutes les maps
    @GetMapping
    public ResponseEntity<?> listerMaps() {
        try {
            List<MapsDTO> maps = mapsService.listerMaps()
                    .stream()
                    .map(MapsDTO::fromModel)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(maps);
        } catch (Exception e) {
            e.printStackTrace(); // Pour le débogage
            return ResponseEntity.status(500)
                .body("Erreur lors de la récupération des maps: " + e.getMessage());
        }
    }

    // ✅ Récupérer une map par ID
    @GetMapping("/{id}")
    public ResponseEntity<MapsDTO> trouverMapParId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(
                    MapsDTO.fromModel(mapsService.trouverParId(id))
            );
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Supprimer une map
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerMap(@PathVariable Long id) {
        try {
            mapsService.supprimer(id);
            return ResponseEntity.ok("Map supprimée avec succès !");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}