package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import view.FormGaji;
import view.FormLihatKaryawan;
import view.FormLihatPekerjaan;
import view.FormUtama;

public class GajiController {

    public void simpan(JTextField ktpTextField, JTable gajiTable) {
        JOptionPane.showMessageDialog(null, "Fungsi simpan belum diimplementasikan.");
    }

    public void cariPekerjaan(String kodePekerjaan) {
        if (FormUtama.formGaji != null) {
            FormUtama.formGaji.setNamaPekerjaan("Nama Pekerjaan untuk " + kodePekerjaan);
        }
    }

    public void tampilkanFormLihatKaryawan() {
        if (FormUtama.formGaji != null) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(FormUtama.formGaji);
            FormLihatKaryawan formLihatKaryawan = new FormLihatKaryawan(frame, true);
            formLihatKaryawan.setVisible(true);
        }
    }

    public void cariKaryawan(JTextField ktpTextField) {
        if (FormUtama.formGaji != null && !ktpTextField.getText().trim().isEmpty()) {
            FormUtama.formGaji.setNama("Nama untuk KTP " + ktpTextField.getText());
            FormUtama.formGaji.setRuang("A-1");
        }
    }

    public void tampilkanFormLihatPekerjaan() {
        if (FormUtama.formGaji != null) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(FormUtama.formGaji);
            FormLihatPekerjaan formLihatPekerjaan = new FormLihatPekerjaan(frame, true);
            formLihatPekerjaan.setVisible(true);

            String kodePekerjaanDipilih = formLihatPekerjaan.getKodePekerjaanDipilih();
            if (kodePekerjaanDipilih != null && !kodePekerjaanDipilih.isEmpty()) {
                Object[] dataPekerjaan = { kodePekerjaanDipilih };
                FormUtama.formGaji.setTambahGaji(dataPekerjaan);
            }
        }
    }
}