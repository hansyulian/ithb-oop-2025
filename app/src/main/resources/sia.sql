-- ENUM types
CREATE TYPE mahasiswa_tipe_enum AS ENUM ('sarjana', 'magister', 'doktor');
CREATE TYPE karyawan_tipe_enum AS ENUM ('karyawan', 'dosenTetap', 'dosenHonorer');
CREATE TYPE matkul_tipe_enum AS ENUM ('wajib', 'pilihan');
CREATE TYPE status_enum AS ENUM ('hadir', 'alpha', 'sakit');

-- Tables
CREATE TABLE "User" (
    id VARCHAR(50) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    tempatLahir VARCHAR(100) NOT NULL,
    tanggalLahir DATE NOT NULL
);

CREATE TABLE Mahasiswa (
    nim VARCHAR(20) PRIMARY KEY,
    userId VARCHAR(50) NOT NULL,
    tipe mahasiswa_tipe_enum NOT NULL,
    judulPenelitian TEXT,
    FOREIGN KEY (userId) REFERENCES "User"(id)
);

CREATE TABLE Karyawan (
    nik VARCHAR(20) PRIMARY KEY,
    userId VARCHAR(50) NOT NULL,
    tipe karyawan_tipe_enum NOT NULL,
    gajiPokok DECIMAL(10, 2),
    honorPerSks DECIMAL(10, 2),
    FOREIGN KEY (userId) REFERENCES "User"(id)
);

CREATE TABLE MataKuliah (
    kode VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    sks INT NOT NULL,
    tipe matkul_tipe_enum NOT NULL,
    minimumMahasiswa INT
);

CREATE TABLE MatkulAmbil (
    nim VARCHAR(20) NOT NULL,
    kodeMataKuliah VARCHAR(10) NOT NULL,
    nilai1 FLOAT,
    nilai2 FLOAT,
    nilai3 FLOAT,
    PRIMARY KEY (nim, kodeMataKuliah),
    FOREIGN KEY (nim) REFERENCES Mahasiswa(nim),
    FOREIGN KEY (kodeMataKuliah) REFERENCES MataKuliah(kode)
);

CREATE TABLE Presensi (
    nim VARCHAR(20) NOT NULL,
    kodeMataKuliah VARCHAR(10) NOT NULL,
    tanggal DATE NOT NULL,
    status status_enum NOT NULL,
    PRIMARY KEY (nim, kodeMataKuliah, tanggal),
    FOREIGN KEY (nim, kodeMataKuliah)
        REFERENCES MatkulAmbil(nim, kodeMataKuliah)
);

CREATE TABLE MatkulAjar (
    nik VARCHAR(20) NOT NULL,
    kodeMataKuliah VARCHAR(10) NOT NULL,
    PRIMARY KEY (nik, kodeMataKuliah),
    FOREIGN KEY (nik) REFERENCES Karyawan(nik),
    FOREIGN KEY (kodeMataKuliah) REFERENCES MataKuliah(kode)
);

CREATE TABLE PresensiStaff (
    nik VARCHAR(20) NOT NULL,
    tanggal DATE NOT NULL,
    status status_enum NOT NULL,
    PRIMARY KEY (nik, tanggal),
    FOREIGN KEY (nik) REFERENCES Karyawan(nik)
);
