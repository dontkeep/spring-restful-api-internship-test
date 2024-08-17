package com.loyalty.spring_restful_api.service;

import com.loyalty.spring_restful_api.model.LokasiEntity;
import com.loyalty.spring_restful_api.model.ProyekEntity;
import com.loyalty.spring_restful_api.repository.LokasiRepository;
import com.loyalty.spring_restful_api.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProyekService {
    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    public ProyekEntity tambahProyek(ProyekEntity proyekEntity, Set<Long> lokasiIds) {
        Set<LokasiEntity> lokasiSet = new HashSet<>();
        for (Long lokasiId : lokasiIds) {
            LokasiEntity lokasi = lokasiRepository.findById(lokasiId)
                    .orElseThrow(() -> new RuntimeException("Lokasi tidak ditemukan"));
            lokasiSet.add(lokasi);
        }
        proyekEntity.setLokasi(lokasiSet);
        return proyekRepository.save(proyekEntity);
    }

    public List<ProyekEntity> semuaProyek() {
        return proyekRepository.findAll();
    }

    public ProyekEntity updateProyek(Long id, ProyekEntity proyekDetails, Set<Long> lokasiIds) {
        ProyekEntity proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek tidak ditemukan"));

        proyek.setNamaProyek(proyekDetails.getNamaProyek());
        proyek.setClient(proyekDetails.getClient());
        proyek.setTglMulai(proyekDetails.getTglMulai());
        proyek.setTglSelesai(proyekDetails.getTglSelesai());
        proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
        proyek.setKeterangan(proyekDetails.getKeterangan());

        Set<LokasiEntity> lokasiSet = new HashSet<>();
        for (Long lokasiId : lokasiIds) {
            LokasiEntity lokasi = lokasiRepository.findById(lokasiId)
                    .orElseThrow(() -> new RuntimeException("Lokasi tidak ditemukan"));
            lokasiSet.add(lokasi);
        }
        proyek.setLokasi(lokasiSet);
        return proyekRepository.save(proyek);
    }

    public void hapusProyek(Long id) {
        proyekRepository.deleteById(id);
    }

    public ProyekEntity getProyekById(Long id) {
        return proyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek tidak ditemukan"));
    }
}