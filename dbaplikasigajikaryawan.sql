CREATE DATABASE dbaplikasigajikaryawan;
USE dbaplikasigajikaryawan;

CREATE TABLE tbkaryawan (
  ktp VARCHAR(20) NOT NULL,
  nama VARCHAR(100) NOT NULL,
  ruang INT NOT NULL,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (ktp)
);

CREATE TABLE tbpekerjaan (
  kodepekerjaan VARCHAR(10) NOT NULL,
  namapekerjaan VARCHAR(100) NOT NULL,
  jumlahtugas INT NOT NULL,
  PRIMARY KEY (kodepekerjaan)
);

CREATE TABLE tbgaji (
  ktp VARCHAR(20) NOT NULL,
  kodepekerjaan VARCHAR(10) NOT NULL,
  gajibersih DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  gajikotor DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  tunjangan DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (ktp, kodepekerjaan),
  FOREIGN KEY (ktp) REFERENCES tbkaryawan(ktp) ON DELETE CASCADE,
  FOREIGN KEY (kodepekerjaan) REFERENCES tbpekerjaan(kodepekerjaan) ON DELETE CASCADE
);

INSERT INTO tbkaryawan (ktp, nama, ruang, password) VALUES
('111222333', 'Budi Santoso', 1, '202cb962ac59075b964b07152d234b70'),
('444555666', 'Ani Yudhoyono', 2, '202cb962ac59075b964b07152d234b70');

INSERT INTO tbpekerjaan (kodepekerjaan, namapekerjaan, jumlahtugas) VALUES
('ADM01', 'Admin Staff', 4),
('PRG02', 'Programmer', 6),
('MKT03', 'Marketing', 3);

INSERT INTO tbgaji (ktp, kodepekerjaan, gajibersih, gajikotor, tunjangan) VALUES
('111222333', 'ADM01', 3000000.00, 3500000.00, 500000.00),
('444555666', 'PRG02', 5000000.00, 5800000.00, 1000000.00);