CREATE TYPE status_enum AS ENUM ('hadir', 'alpha', 'sakit');

CREATE TABLE Presensi (
    nim VARCHAR(20) NOT NULL,
    kodeMataKuliah VARCHAR(10) NOT NULL,
    tanggal DATE NOT NULL,
    status status_enum NOT NULL,
    PRIMARY KEY (nim, kodeMataKuliah, tanggal)
);

INSERT INTO Presensi (nim, kodeMataKuliah, tanggal, status) VALUES
('NIM001', 'MK001', '2025-10-01', 'hadir'),
('NIM001', 'MK001', '2025-10-02', 'alpha'),
('NIM001', 'MK001', '2025-10-03', 'hadir'),
('NIM001', 'MK002', '2025-10-01', 'sakit'),
('NIM001', 'MK002', '2025-10-02', 'hadir'),
('NIM001', 'MK003', '2025-10-01', 'hadir'),
('NIM002', 'MK001', '2025-10-01', 'hadir'),
('NIM002', 'MK001', '2025-10-02', 'sakit'),
('NIM002', 'MK001', '2025-10-03', 'alpha'),
('NIM002', 'MK002', '2025-10-01', 'hadir'),
('NIM002', 'MK002', '2025-10-02', 'hadir'),
('NIM002', 'MK002', '2025-10-03', 'sakit'),
('NIM002', 'MK003', '2025-10-01', 'alpha'),
('NIM003', 'MK001', '2025-10-01', 'hadir'),
('NIM003', 'MK001', '2025-10-02', 'hadir'),
('NIM003', 'MK001', '2025-10-03', 'sakit'),
('NIM003', 'MK002', '2025-10-01', 'hadir'),
('NIM003', 'MK002', '2025-10-02', 'alpha'),
('NIM003', 'MK003', '2025-10-01', 'sakit'),
('NIM003', 'MK003', '2025-10-02', 'hadir'),
('NIM003', 'MK003', '2025-10-03', 'hadir'),
('NIM004', 'MK001', '2025-10-01', 'alpha'),
('NIM004', 'MK001', '2025-10-02', 'hadir'),
('NIM004', 'MK001', '2025-10-03', 'hadir'),
('NIM004', 'MK002', '2025-10-01', 'sakit'),
('NIM004', 'MK002', '2025-10-02', 'hadir'),
('NIM004', 'MK003', '2025-10-01', 'alpha'),
('NIM004', 'MK003', '2025-10-02', 'hadir'),
('NIM004', 'MK003', '2025-10-03', 'sakit'),
('NIM004', 'MK003', '2025-10-04', 'hadir');
