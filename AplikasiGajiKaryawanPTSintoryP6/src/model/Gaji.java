/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
// import net.sf.jasperreports.engine.JRException;
// import net.sf.jasperreports.engine.JRResultSetDataSource;
// import net.sf.jasperreports.engine.JasperCompileManager;
// import net.sf.jasperreports.engine.JasperFillManager;
// import net.sf.jasperreports.engine.JasperPrint;
// import net.sf.jasperreports.engine.JasperReport;
// import net.sf.jasperreports.engine.design.JasperDesign;
// import net.sf.jasperreports.engine.xml.JRXmlLoader;
// import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Guci
 */
public class Gaji {
    private String ktp;
    private String pesan;
    private Object[][] listGaji;
    private final Koneksi koneksi = new Koneksi();

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public Object[][] getListGaji() {
        return listGaji;
    }

    public void setListGaji(Object[][] listGaji) {
        this.listGaji = listGaji;
    }

    public boolean simpan() {
        boolean adaKesalahan = false;
        Connection connection;

        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            String SQLStatemen;
            PreparedStatement preparedStatement;

            try {
                SQLStatemen = "delete from tbgaji where ktp=?";
                preparedStatement = connection.prepareStatement(SQLStatemen);
                preparedStatement.setString(1, ktp);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
            }

            for (Object[] recGaji : listGaji) {
                try {
                    SQLStatemen = "insert into tbgaji(ktp, kodepekerjaan, gajibersih, gajikotor, tunjangan) values (?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(SQLStatemen);
                    preparedStatement.setString(1, ktp);
                    for (int i = 0; i < 4; i++) {
                        preparedStatement.setString(2 + i, recGaji[i].toString());
                    }
                    jumlahSimpan += preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                }
            }

            if (jumlahSimpan > 0) {
                adaKesalahan = false;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }

        return !adaKesalahan;
    }

    public boolean baca(String ktp) {
        boolean adaKesalahan = false;
        Connection connection;
        this.ktp = ktp;
        listGaji = null;

        if ((connection = koneksi.getConnection()) != null) {
            PreparedStatement preparedStatement;
            ResultSet rset;

            try {
                String SQLStatemen = "select * from tbgaji where ktp=?";
                preparedStatement = connection.prepareStatement(SQLStatemen);
                preparedStatement.setString(1, ktp);
                rset = preparedStatement.executeQuery();

                rset.next();
                rset.last();
                listGaji = new Object[rset.getRow()][4];

                rset.first();
                int i = 0;
                do {
                    if (!rset.getString("kodepekerjaan").equals("")) {
                        listGaji[i] = new Object[] {
                                rset.getString("kodepekerjaan"),
                                rset.getObject("gajibersih"),
                                rset.getObject("gajikotor"),
                                rset.getObject("tunjangan") };
                    }
                    i++;
                } while (rset.next());

                if (listGaji.length > 0) {
                    adaKesalahan = false;
                }

                preparedStatement.close();
                rset.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membaca data gaji karyawan\n" + ex.getMessage();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }

        return !adaKesalahan;
    }

    public boolean cetakLaporan(int ruang) {
        // Karena library JasperReports tidak ditambahkan, fitur ini dinonaktifkan.
        pesan = "Fitur cetak laporan tidak aktif karena library JasperReports tidak ditemukan.";
        return false;

    }
};