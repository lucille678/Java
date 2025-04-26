package com.epf.api.controller;

import com.epf.core.service.ZombieService;
import com.epf.api.DTO.ZombieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;

    @Autowired
    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    // Ajouter un zombie
    @PostMapping
    public ResponseEntity<String> ajouterZombie(@RequestBody ZombieDTO zombieDTO) {
        if (zombieDTO.getNom() == null || zombieDTO.getNom().isEmpty()) {
            return ResponseEntity.badRequest().body("Le nom du zombie est obligatoire.");
        }
        if (zombieDTO.getPoint_de_vie() == null || zombieDTO.getPoint_de_vie() <= 0) {
            return ResponseEntity.badRequest().body("Les points de vie doivent être supérieurs à 0.");
        }
        zombieService.ajouterZombie(zombieDTO.toModel());
        return ResponseEntity.ok("Zombie ajouté avec succès !");
    }

    // Lister tous les zombies
    @GetMapping
    public ResponseEntity<List<ZombieDTO>> listerZombies() {
        List<ZombieDTO> zombies = zombieService.listerZombies()
                .stream()
                .map(ZombieDTO::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(zombies);
    }

    // Récupérer un zombie par ID
    @GetMapping("/{id}")
    public ResponseEntity<ZombieDTO> trouverZombieParId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(
                    ZombieDTO.fromModel(zombieService.trouverParId(id))
            );
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Mettre à jour un zombie
    @PutMapping("/{id}")
    public ResponseEntity<String> mettreAJourZombie(@PathVariable("id") Long id, @RequestBody ZombieDTO zombieDTO) {
        try {
            if (zombieDTO.getNom() == null || zombieDTO.getNom().isEmpty()) {
                return ResponseEntity.badRequest().body("Le nom du zombie est obligatoire.");
            }
            if (zombieDTO.getPoint_de_vie() == null || zombieDTO.getPoint_de_vie() <= 0) {
                return ResponseEntity.badRequest().body("Les points de vie doivent être supérieurs à 0.");
            }
            zombieDTO.setId_zombie(id);
            zombieService.mettreAJour(zombieDTO.toModel());
            return ResponseEntity.ok("Zombie mis à jour avec succès !");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de la mise à jour: " + e.getMessage());
        }
    }

    // Supprimer un zombie
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerZombie(@PathVariable("id") Long id) {
        try {
            zombieService.supprimer(id);
            return ResponseEntity.ok("Zombie supprimé avec succès !");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}

