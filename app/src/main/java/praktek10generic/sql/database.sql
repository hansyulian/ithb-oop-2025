CREATE TYPE TipeStaff AS ENUM ('DOSEN_TETAP', 'DOSEN_HONORER');

CREATE TABLE staff (
    nik VARCHAR(50) PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    tipe TipeStaff NOT NULL,
    gajiPokok DOUBLE PRECISION,
    honorPerSks DOUBLE PRECISION
);

CREATE TABLE matkul (
    kode VARCHAR(50) PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    sks INTEGER NOT NULL
);

INSERT INTO staff (nik, nama, tipe, gajiPokok, honorPerSks) VALUES
('S001', 'Alexander Tan', 'DOSEN_TETAP', 8000000, NULL),
('S002', 'Bernardus Lim', 'DOSEN_TETAP', 7600000, NULL),
('S003', 'Catherine Wijaya', 'DOSEN_TETAP', 8300000, NULL),
('S004', 'David Gunawan', 'DOSEN_TETAP', 9000000, NULL),
('S005', 'Elizabeth Hartono', 'DOSEN_TETAP', 8700000, NULL),
('S006', 'Felix Tjahjadi', 'DOSEN_HONORER', NULL, 200000),
('S007', 'Grace Sutanto', 'DOSEN_HONORER', NULL, 180000),
('S008', 'Herman Salim', 'DOSEN_HONORER', NULL, 220000),
('S009', 'Irene Lie', 'DOSEN_HONORER', NULL, 250000),
('S010', 'Josephine Lau', 'DOSEN_HONORER', NULL, 210000);

INSERT INTO matkul (kode, nama, sks) VALUES
('MK001', 'Algoritma dan Pemrograman', 3),
('MK002', 'Struktur Data', 3),
('MK003', 'Basis Data', 3),
('MK004', 'Sistem Operasi', 3),
('MK005', 'Jaringan Komputer', 3),
('MK006', 'Pemrograman Web', 3),
('MK007', 'Pemrograman Mobile', 3),
('MK008', 'Kecerdasan Buatan', 3),
('MK009', 'Rekayasa Perangkat Lunak', 3),
('MK010', 'Keamanan Informasi', 3);
