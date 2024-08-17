CREATE DATABASE IF NOT EXISTS `proyek_new`;

USE `proyek_new`;

CREATE TABLE lokasi_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nama_Lokasi VARCHAR(255) NOT NULL,
    negara VARCHAR(255),
    provinsi VARCHAR(255),
    kota VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE proyek_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nama_proyek VARCHAR(255) NOT NULL,
    client VARCHAR(255),
    tgl_mulai DATETIME,
    tgl_selesai DATETIME,
    pimpinan_proyek VARCHAR(255),
    keterangan TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE proyek_lokasi (
    proyek_id BIGINT,
    lokasi_id BIGINT,
    PRIMARY KEY (proyek_id, lokasi_id),
    FOREIGN KEY (proyek_id) REFERENCES proyek_entity(id),
    FOREIGN KEY (lokasi_id) REFERENCES lokasi_entity(id)
);
