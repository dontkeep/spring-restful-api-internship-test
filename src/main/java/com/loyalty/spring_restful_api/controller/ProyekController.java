package com.loyalty.spring_restful_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.loyalty.spring_restful_api.model.ProyekEntity;
import com.loyalty.spring_restful_api.service.ProyekService;

import java.util.Set;

@RestController
@RequestMapping("/proyek")
public class ProyekController {
    @Autowired
    private ProyekService proyekService;

    @CrossOrigin(origins = "http://localhost")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProyekEntity> tambahProyek(
            @RequestBody ProyekEntity proyekEntity,
            @RequestParam Set<Long> lokasiIds) {
        ProyekEntity savedProyek = proyekService.tambahProyek(proyekEntity, lokasiIds);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProyek);
    }


    @CrossOrigin(origins = "http://localhost")
    @GetMapping
    public ResponseEntity<?> semuaProyek() {
        return ResponseEntity.ok(proyekService.semuaProyek());
    }

    @CrossOrigin(origins = "http://localhost")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProyekEntity> updateProyek(
            @PathVariable Long id,
            @RequestBody ProyekEntity proyek,
            @RequestParam Set<Long> lokasiIds) {
        ProyekEntity updatedProyek = proyekService.updateProyek(id, proyek, lokasiIds);
        return ResponseEntity.ok(updatedProyek);
    }

    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/{id}")
    public ResponseEntity<ProyekEntity> getProyekById(@PathVariable Long id) {
        ProyekEntity proyek = proyekService.getProyekById(id);
        return ResponseEntity.ok(proyek);
    }

    @CrossOrigin(origins = "http://localhost")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapusProyek(@PathVariable Long id) {
        proyekService.hapusProyek(id);
        return ResponseEntity.noContent().build();
    }
}