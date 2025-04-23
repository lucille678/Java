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

    @PostMapping
    public ResponseEntity<String> ajouterMap(@RequestBody MapsDTO mapsDTO) {
        mapsService.ajouterMap(mapsDTO.toModel());
        return ResponseEntity.ok("Map ajoutée avec succès !");
    }

    @GetMapping
    public ResponseEntity<List<MapsDTO>> listerMaps() {
        List<MapsDTO> maps = mapsService.listerMaps()
                .stream()
                .map(MapsDTO::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(maps);
    }
}
