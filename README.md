### Login Admin
```
User ID (KTP): 111222333
Password: 123
```
### Alur Pengujian Aplikasi Gaji Karyawan

Tujuan kita adalah membuat data baru (pekerjaan dan karyawan), memproses gajinya, lalu melihat hasilnya di laporan.

#### Langkah 1: Membuat Data Master Pekerjaan Baru

Kita mulai dengan menambahkan jenis pekerjaan baru ke dalam sistem.

1.  **Buka Form Pekerjaan:**
    *   Pada menu bar di atas, klik **Master Data** -> **Pekerjaan**. Form "Master Data Pekerjaan" akan muncul.

2.  **Isi Data Pekerjaan Baru:**
    *   **Kode Pekerjaan:** Ketik `HRD04`
    *   **Nama Pekerjaan:** Ketik `Human Resources`
    *   **Jumlah Tugas:** Pilih `3` dari dropdown.

3.  **Simpan Data:**
    *   Klik tombol **Simpan**.

    **Verifikasi:** Form akan otomatis membersihkan semua input, menandakan data berhasil disimpan ke database.

#### Langkah 2: Membuat Data Master Karyawan Baru

Sekarang, kita tambahkan seorang karyawan baru yang nantinya akan kita beri pekerjaan yang baru saja kita buat.

1.  **Buka Form Karyawan:**
    *   Klik **Master Data** -> **Karyawan**. Form "Master Data Karyawan" akan muncul.

2.  **Isi Data Karyawan Baru:**
    *   **KTP:** Ketik `777888999`
    *   **Nama:** Ketik `Citra Lestari`
    *   **Ruang:** Pilih `1`
    *   **Password:** Ketik `456`

3.  **Simpan Data:**
    *   Klik tombol **Simpan**.

    **Verifikasi:** Sama seperti sebelumnya, form akan bersih, menandakan karyawan baru berhasil disimpan.

#### Langkah 3: Melakukan Transaksi Gaji

Ini adalah fitur utama. Kita akan memproses gaji untuk karyawan "Citra Lestari" yang baru saja kita buat.

1.  **Buka Form Gaji:**
    *   Klik **Transaksi** -> **Gaji**. Form "Mengelola Gaji Karyawan" akan muncul.

2.  **Pilih Karyawan:**
    *   Klik tombol **Lihat** di sebelah kolom KTP.
    *   Jendela "Data Karyawan" akan muncul, menampilkan semua karyawan (Budi, Ani, dan Citra).
    *   Pilih baris **Citra Lestari**, lalu klik tombol **Pilih**.

    **Verifikasi:** Form Gaji sekarang akan terisi otomatis dengan data KTP, Nama, dan Ruang milik Citra Lestari.

3.  **Tambahkan Pekerjaan ke dalam Tabel Gaji:**
    *   Di area tabel gaji yang masih kosong, **klik kanan** lalu pilih **Tambah**.
    *   Jendela "Data Pekerjaan" akan muncul.
    *   Pilih pekerjaan **Human Resources** (`HRD04`) yang kita buat di Langkah 1, lalu klik **Pilih**.

    **Verifikasi:** Baris baru akan muncul di tabel gaji dengan Kode dan Nama Pekerjaan terisi.

4.  **Isi Detail Gaji:**
    *   Sekarang, klik pada sel-sel di baris yang sama untuk mengisinya:
        *   **Gaji Bersih:** Ketik `4000000`
        *   **Gaji Kotor:** Ketik `4500000`
        *   **Tunjangan:** Ketik `750000`

5.  **Simpan Transaksi Gaji:**
    *   Klik tombol **Simpan** di pojok kanan atas.

    **Verifikasi:** Seluruh form akan kembali kosong, menandakan transaksi gaji untuk Citra Lestari telah berhasil disimpan.

#### Langkah 4: Melihat Laporan Gaji

Langkah terakhir adalah memastikan semua data yang kita masukkan muncul di laporan.

1.  **Buka Form Laporan:**
    *   Klik **Laporan** -> **Gaji**. Form "Laporan Gaji" akan muncul.

2.  **Cetak Laporan (Semua Ruang):**
    *   Biarkan dropdown "Ruang" pada pilihan default-nya (pilihan pertama).
    *   Klik tombol **Cetak**.

    **Verifikasi:** Jendela **JasperViewer** akan muncul menampilkan "Laporan Gaji Karyawan". Periksa apakah ada 3 baris data: Budi Santoso, Ani Yudhoyono, dan **Citra Lestari** yang baru saja kita tambahkan.

3.  **Coba Filter Laporan (Opsional):**
    *   Tutup jendela JasperViewer.
    *   Di form "Laporan Gaji", ubah dropdown "Ruang" menjadi `1`.
    *   Klik **Cetak** lagi.

    **Verifikasi:** Laporan sekarang hanya akan menampilkan karyawan di Ruang 1, yaitu Budi Santoso dan Citra Lestari.

---

Selamat! Anda telah berhasil menguji semua alur utama dari aplikasi Anda, mulai dari input data master, melakukan transaksi, hingga melihat hasilnya dalam sebuah laporan.
