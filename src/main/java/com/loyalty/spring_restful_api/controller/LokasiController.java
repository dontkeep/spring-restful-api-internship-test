package com.loyalty.spring_restful_api.controller;

import com.loyalty.spring_restful_api.model.LokasiEntity;
import com.loyalty.spring_restful_api.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {
    @Autowired
    private LokasiService lokasiService;


    @CrossOrigin(origins = "http://localhost")
    @PostMapping(consumes = "application/json")
    public ResponseEntity<LokasiEntity> tambahLokasi(@RequestBody LokasiEntity lokasiEntity) {
        LokasiEntity savedLokasi = lokasiService.tambahEntity(lokasiEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLokasi);
    }

    @CrossOrigin(origins = "http://localhost")
    @GetMapping
    public ResponseEntity<?> semuaLokasi() {
        return ResponseEntity.ok(lokasiService.semuaLokasi());
    }

    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/{id}")
    public ResponseEntity<LokasiEntity> getLokasiById(@PathVariable Long id) {
        LokasiEntity lokasi = lokasiService.getLokasiById(id);
        return ResponseEntity.ok(lokasi);
    }

    @CrossOrigin(origins = "http://localhost")
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<LokasiEntity> updateLokasi(@PathVariable Long id, @RequestBody LokasiEntity lokasiDetail) {
        LokasiEntity updatedLokasi = lokasiService.updateLokasi(id, lokasiDetail);
        return ResponseEntity.ok(updatedLokasi);
    }

    @CrossOrigin(origins = "http://localhost")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapusLokasi(@PathVariable Long id) {
        lokasiService.hapusLokasi(id);
        return ResponseEntity.noContent().build();
    }
}
