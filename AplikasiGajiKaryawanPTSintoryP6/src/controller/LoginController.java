/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.Enkripsi;
import model.Karyawan;
import view.FormLogin;

/**
 *
 * @author Guci
 */
public class LoginController {
    private final Karyawan karyawan = new Karyawan();
    private final Enkripsi enkripsi = new Enkripsi();

    public boolean validasi(javax.swing.JTextField userIdTextField, javax.swing.JPasswordField passwordField) {
        boolean valid = false;
        boolean userIdSalah = false;
        String hashedInputPassword = "";

        if (!userIdTextField.getText().equals("")) {
            if (karyawan.baca(userIdTextField.getText())) {
                try {
                    hashedInputPassword = enkripsi.hashMD5(new String(passwordField.getPassword()));
                } catch (Exception ex) {
                }

                if (karyawan.getPassword().equalsIgnoreCase(hashedInputPassword)) {
                    valid = true;
                    FormLogin.tipe = "Karyawan";
                } else {
                    userIdSalah = true;
                }
            } else {
                if (karyawan.getPesan().substring(0, 3).equalsIgnoreCase("KTP")) {
                    userIdSalah = true;
                }
            }

            if (!valid) {
                if (userIdSalah) {
                    JOptionPane.showMessageDialog(null, "User Id atau password salah", "Kesalahan",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, karyawan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "User Id (KTP) tidak boleh kosong", "Kesalahan",
                    JOptionPane.ERROR_MESSAGE);
        }

        return valid;
    }
}