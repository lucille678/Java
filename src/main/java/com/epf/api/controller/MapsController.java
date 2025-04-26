package com.epf.api.controller;

import com.epf.core.service.ZombieService;
import com.epf.persistance.Zombie;
import com.epf.core.service.MapsService;
import com.epf.api.DTO.MapsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maps")
public class MapsController {

    private final MapsService mapsService;
    private final ZombieService zombieService;

    @Autowired
    public MapsController(MapsService mapsService, ZombieService zombieService) {
        this.mapsService = mapsService;
        this.zombieService = zombieService;
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
    @GetMapping("/{id}")  // Enlever le préfixe /maps/
    public ResponseEntity<MapsDTO> trouverMapParId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(
                    MapsDTO.fromModel(mapsService.trouverParId(id))
            );
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> mettreAJourMap(@PathVariable("id") Long id, @RequestBody MapsDTO mapsDTO) {
        try {
            mapsDTO.setId_map(id);  // Important: mettre à jour l'ID
            mapsService.mettreAJour(mapsDTO.toModel());
            return ResponseEntity.ok("Map mise à jour avec succès !");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de la mise à jour: " + e.getMessage());
        }
    }

    // ✅ Supprimer une map
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerMap(@PathVariable("id") Long id) {
        try {
            // Vérifier si la map existe
            if (mapsService.trouverParId(id) == null) {
                return ResponseEntity.notFound().build();
            }
            
            try {
                // Supprimer d'abord tous les zombies associés à cette map
                List<Zombie> zombiesAssocies = zombieService.trouverParMap(id);
                for (Zombie zombie : zombiesAssocies) {
                    zombieService.supprimer(zombie.getId_zombie());
                }
                
                // Puis supprimer la map
                mapsService.supprimer(id);
                return ResponseEntity.ok("Map et zombies associés supprimés avec succès !");
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(500)
                    .body("Erreur lors de la suppression : " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500)
                .body("Erreur lors de la suppression de la map: " + e.getMessage());
        }
    }
}
