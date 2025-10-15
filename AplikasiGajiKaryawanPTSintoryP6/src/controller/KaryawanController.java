/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.Enkripsi;
import model.Karyawan;
import view.FormLihatKaryawan;
import view.FormUtama;

/**
 *
 * @author Guci
 */
public class KaryawanController {
    private final Karyawan karyawan = new Karyawan();
    private FormLihatKaryawan formLihatKaryawan;
    private final Enkripsi enkripsi = new Enkripsi();
    private boolean hashed = false;

    public void setHashed(boolean hashed) {
        this.hashed = hashed;
    }

    public void simpan(javax.swing.JTextField ktpTextField, javax.swing.JTextField namaTextField,
            javax.swing.JComboBox ruangComboBox, javax.swing.JPasswordField passwordField) {
        if (!ktpTextField.getText().equals("")) {
            karyawan.setKtp(ktpTextField.getText());
            karyawan.setNama(namaTextField.getText());
            karyawan.setRuang(Integer.parseInt(ruangComboBox.getSelectedItem().toString()));

            if (hashed) {
                karyawan.setPassword(new String(passwordField.getPassword()));
            } else {
                try {
                    karyawan.setPassword(enkripsi.hashMD5(new String(passwordField.getPassword())));
                } catch (Exception ex) {
                    karyawan.setPassword("");
                }
            }

            if (karyawan.simpan()) {
                FormUtama.formKaryawan.setKtp("");
                FormUtama.formKaryawan.setNama("");
                FormUtama.formKaryawan.setRuang(1);
                FormUtama.formKaryawan.setPassword("");
            } else {
                if (karyawan.getPesan().length() > 0) {
                    JOptionPane.showMessageDialog(null, karyawan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "KTP tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void hapus(javax.swing.JTextField ktpTextField) {
        if (!ktpTextField.getText().equals("")) {
            if (karyawan.hapus(ktpTextField.getText())) {
                FormUtama.formKaryawan.setKtp("");
                FormUtama.formKaryawan.setNama("");
                FormUtama.formKaryawan.setRuang(1);
                FormUtama.formKaryawan.setPassword("");
            } else {
                JOptionPane.showMessageDialog(null, karyawan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "KTP tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cari(javax.swing.JTextField ktpTextField) {
        if (!ktpTextField.getText().equals("")) {
            if (karyawan.baca(ktpTextField.getText())) {
                FormUtama.formKaryawan.setNama(karyawan.getNama());
                FormUtama.formKaryawan.setRuang(karyawan.getRuang());
                FormUtama.formKaryawan.setPassword(karyawan.getPassword());
                hashed = true;
            } else {
                FormUtama.formKaryawan.setNama("");
                FormUtama.formKaryawan.setRuang(1);
                FormUtama.formKaryawan.setPassword("");
                JOptionPane.showMessageDialog(null, karyawan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "KTP tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tampilkanFormLihatKaryawan() {
        formLihatKaryawan = new FormLihatKaryawan(null, true);
        if (karyawan.bacaData()) {
            formLihatKaryawan.tampilkanData(karyawan.getList());
            formLihatKaryawan.setVisible(true);
            if (!formLihatKaryawan.getKtpDipilih().equals("")) {
                FormUtama.formKaryawan.setKtp(formLihatKaryawan.getKtpDipilih());
                if (karyawan.baca(formLihatKaryawan.getKtpDipilih())) {
                    FormUtama.formKaryawan.setNama(karyawan.getNama());
                    FormUtama.formKaryawan.setRuang(karyawan.getRuang());
                    FormUtama.formKaryawan.setPassword(karyawan.getPassword());
                    hashed = true;
                } else {
                    FormUtama.formKaryawan.setNama("");
                    FormUtama.formKaryawan.setRuang(1);
                    FormUtama.formKaryawan.setPassword("");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, karyawan.getPesan());
        }
    }

    public void cetakLaporan() {
        if (!karyawan.cetakLaporan()) {
            JOptionPane.showMessageDialog(null, karyawan.getPesan(), "Kesalahan Laporan", JOptionPane.ERROR_MESSAGE);
        }
    }
}