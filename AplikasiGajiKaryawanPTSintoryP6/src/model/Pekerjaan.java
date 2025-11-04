/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import view.PesanDialog;

/**
 *
 * @author Muhammad Faqih Alharits
 */
public class Pekerjaan {
    private String kodePekerjaan, namaPekerjaan;
    private String kodePekerjaanLama;
    private int jumlahTugas;
    private String pesan;
    private Object[][] list;
    private final Koneksi koneksi = new Koneksi();
    private final PesanDialog pesanDialog = new PesanDialog();

    public String getKodePekerjaan() {
        return kodePekerjaan;
    }

    public void setKodePekerjaan(String kodePekerjaan) {
        this.kodePekerjaan = kodePekerjaan;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    public int getJumlahTugas() {
        return jumlahTugas;
    }

    public void setJumlahTugas(int jumlahTugas) {
        this.jumlahTugas = jumlahTugas;
    }

    public String getPesan() {
        return pesan;
    }

    public Object[][] getList() {
        return list;
    }

    public void setList(Object[][] list) {
        this.list = list;
    }

    public boolean simpan() {
        boolean adaKesalahan = false;
        Connection connection;

        if ((connection = koneksi.getConnection()) != null) {
            PreparedStatement preparedStatement;
            String SQLStatemen;
            int jumlahSimpan = 0;

            try {
                if (this.kodePekerjaanLama != null && !this.kodePekerjaanLama.isEmpty()) {
                    SQLStatemen = "UPDATE tbpekerjaan SET kodepekerjaan=?, namapekerjaan=?, jumlahtugas=? WHERE kodepekerjaan=?";
                    preparedStatement = connection.prepareStatement(SQLStatemen);
                    preparedStatement.setString(1, this.kodePekerjaan);
                    preparedStatement.setString(2, this.namaPekerjaan);
                    preparedStatement.setInt(3, this.jumlahTugas);
                    preparedStatement.setString(4, this.kodePekerjaanLama);

                    jumlahSimpan = preparedStatement.executeUpdate();
                } else {
                    SQLStatemen = "SELECT kodepekerjaan FROM tbpekerjaan WHERE kodepekerjaan=?";
                    preparedStatement = connection.prepareStatement(SQLStatemen);
                    preparedStatement.setString(1, this.kodePekerjaan);
                    ResultSet rset = preparedStatement.executeQuery();

                    if (rset.next()) {
                        adaKesalahan = true;
                        pesan = "Kode Pekerjaan \"" + this.kodePekerjaan + "\" sudah ada!";
                    } else {
                        SQLStatemen = "INSERT INTO tbpekerjaan(kodepekerjaan, namapekerjaan, jumlahtugas) VALUES (?,?,?)";
                        preparedStatement = connection.prepareStatement(SQLStatemen);
                        preparedStatement.setString(1, this.kodePekerjaan);
                        preparedStatement.setString(2, this.namaPekerjaan);
                        preparedStatement.setInt(3, this.jumlahTugas);

                        jumlahSimpan = preparedStatement.executeUpdate();
                    }
                }

                if (jumlahSimpan > 0) {
                    this.kodePekerjaanLama = null;
                } else if (!adaKesalahan) {
                    adaKesalahan = true;
                    pesan = "Gagal menyimpan data pekerjaan";
                }

                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat menjalankan perintah SQL\n" + ex.getMessage();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }

        return !adaKesalahan;
    }

    public boolean baca(String kodePekerjaan) {
        boolean adaKesalahan = false;
        Connection connection;

        if ((connection = koneksi.getConnection()) != null) {
            Statement sta;
            ResultSet rset;

            try {
                String SQLStatemen = "select * from tbpekerjaan where kodepekerjaan='" + kodePekerjaan + "'";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);

                rset.next();
                if (rset.getRow() > 0) {
                    this.kodePekerjaan = rset.getString("kodepekerjaan");
                    this.namaPekerjaan = rset.getString("namapekerjaan");
                    this.jumlahTugas = rset.getInt("jumlahtugas");

                    this.kodePekerjaanLama = this.kodePekerjaan;
                } else {
                    adaKesalahan = true;
                    pesan = "Kode pekerjaan \"" + kodePekerjaan + "\" tidak ditemukan";

                    this.kodePekerjaanLama = null;
                }

                sta.close();
                rset.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpekerjaan\n" + ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }

    public boolean bacaData() {
        boolean adaKesalahan = false;
        Connection connection;
        list = new Object[0][0];

        if ((connection = koneksi.getConnection()) != null) {
            String SQLStatemen;
            Statement sta;
            ResultSet rset;
            try {
                SQLStatemen = "select kodepekerjaan,namapekerjaan from tbpekerjaan";
                sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rset = sta.executeQuery(SQLStatemen);

                rset.last();
                list = new Object[rset.getRow()][2];

                if (rset.getRow() > 0) {
                    rset.beforeFirst();
                    int i = 0;
                    while (rset.next()) {
                        list[i] = new Object[] { rset.getString("kodepekerjaan"),
                                rset.getString("namapekerjaan") };
                        i++;
                    }
                }

                sta.close();
                rset.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membaca tabel tbpekerjaan\n" + ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }

    public boolean hapus(String kodePekerjaan) {
        boolean adaKesalahan = false;
        Connection connection;

        if ((connection = koneksi.getConnection()) != null) {
            int jumlahHapus;
            String SQLStatemen;
            Statement sta;

            try {
                SQLStatemen = "delete from tbpekerjaan where kodepekerjaan='" + kodePekerjaan + "'";
                sta = connection.createStatement();
                jumlahHapus = sta.executeUpdate(SQLStatemen);

                if (jumlahHapus < 1) {
                    pesan = "Kode pekerjaan tidak ditemukan";
                    adaKesalahan = true;
                }

                sta.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpekerjaan\n" + ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }

    public boolean cetakLaporan() {
        boolean adaKesalahan = false;
        Connection connection;
        if ((connection = koneksi.getConnection()) != null) {
            try {
                String reportPath = "src/reports/PekerjaanReport.jrxml";

                JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), connection);

                JasperViewer.viewReport(jasperPrint, false);

            } catch (JRException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat mencetak laporan pekerjaan.\n" + ex.getMessage();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat terhubung ke database.";
        }
        return !adaKesalahan;
    }
}