package com.loyalty.spring_restful_api.service;

import com.loyalty.spring_restful_api.model.LokasiEntity;
import com.loyalty.spring_restful_api.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    public LokasiEntity tambahEntity(LokasiEntity lokasiEntity) {
        return lokasiRepository.save(lokasiEntity);
    }

    public List<LokasiEntity> semuaLokasi() {
        return lokasiRepository.findAll();
    }

    public LokasiEntity updateLokasi(Long id, LokasiEntity lokasiDetail) {
        LokasiEntity lokasiEntity = lokasiRepository.findById(id).orElseThrow(() -> new RuntimeException("Lokasi tidak ditemukan"));

        lokasiEntity.setNamaLokasi(lokasiDetail.getNamaLokasi());
        lokasiEntity.setNegara(lokasiDetail.getNegara());
        lokasiEntity.setProvinsi(lokasiDetail.getProvinsi());
        lokasiEntity.setKota(lokasiDetail.getKota());
        return lokasiRepository.save(lokasiEntity);
    }

    public void hapusLokasi(Long id) {
        LokasiEntity lokasiEntity = lokasiRepository.findById(id).orElseThrow(() -> new RuntimeException("Lokasi tidak ditemukan"));
        lokasiEntity.getProyek().forEach(proyek -> proyek.getLokasi().remove(lokasiEntity));
        lokasiRepository.deleteById(id);
    }

    public LokasiEntity getLokasiById(Long id) {
        return lokasiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lokasi tidak ditemukan"));
    }
}
