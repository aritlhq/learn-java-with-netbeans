/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import javax.swing.JOptionPane;
import model.Gaji;
import model.Karyawan;
import model.Pekerjaan;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.FormLihatKaryawan;
import view.FormLihatPekerjaan;
import view.FormUtama;

/**
 *
 * @author Muhammad Faqih Alharits
 */
public class GajiController {
    private final Karyawan karyawan = new Karyawan();
    private final Pekerjaan pekerjaan = new Pekerjaan();
    private final Gaji gaji = new Gaji();
    private FormLihatKaryawan formLihatKaryawan;
    private FormLihatPekerjaan formLihatPekerjaan;

    public void cariKaryawan(javax.swing.JTextField ktp) {
        if (!ktp.getText().equals("")) {
            if (karyawan.baca(ktp.getText())) {
                FormUtama.formGaji.setNama(karyawan.getNama());
                FormUtama.formGaji.setRuang(Integer.toString(karyawan.getRuang()));
                FormUtama.formGaji.clearGajiTable();

                int jumlahGaji = 0;
                if (gaji.baca(ktp.getText())) {
                    Object[][] listGaji = gaji.getListGaji();
                    FormUtama.formGaji.clearGajiTable();

                    if (listGaji.length > 0) {
                        for (int i = 0; i < listGaji.length; i++) {
                            if (listGaji[i][0] != null && !((String) listGaji[i][0]).equals("")) {
                                String namaPekerjaan = "";
                                if (pekerjaan.baca((String) listGaji[i][0])) {
                                    namaPekerjaan = pekerjaan.getNamaPekerjaan();
                                }
                                FormUtama.formGaji.setTambahGaji(new Object[] { listGaji[i][0], namaPekerjaan,
                                        listGaji[i][1], listGaji[i][2], listGaji[i][3] });
                                jumlahGaji++;
                            }
                        }
                    }
                }

                // if (jumlahGaji == 0) {
                // FormUtama.formGaji.setTambahGaji(new Object[] {});
                // }
            } else {
                FormUtama.formGaji.setNama("");
                FormUtama.formGaji.setRuang("");
                FormUtama.formGaji.clearGajiTable();
                FormUtama.formGaji.setTambahGaji(new Object[] {});
                JOptionPane.showMessageDialog(null, karyawan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ktp tidak boleh kosong\n", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tampilkanFormLihatKaryawan() {
        formLihatKaryawan = new FormLihatKaryawan(null, true);
        if (karyawan.bacaData()) {
            formLihatKaryawan.tampilkanData(karyawan.getList());
            formLihatKaryawan.setVisible(true);

            if (formLihatKaryawan.getKtpDipilih() != null && !formLihatKaryawan.getKtpDipilih().equals("")) {
                if (karyawan.baca(formLihatKaryawan.getKtpDipilih())) {
                    FormUtama.formGaji.setKtp(karyawan.getKtp());
                    FormUtama.formGaji.setNama(karyawan.getNama());
                    FormUtama.formGaji.setRuang(Integer.toString(karyawan.getRuang()));
                    FormUtama.formGaji.clearGajiTable();

                    int jumlahGaji = 0;
                    if (gaji.baca(formLihatKaryawan.getKtpDipilih())) {
                        Object[][] listGaji = gaji.getListGaji();
                        FormUtama.formGaji.clearGajiTable();
                        if (listGaji.length > 0) {
                            for (int i = 0; i < listGaji.length; i++) {
                                if (listGaji[i][0] != null && !((String) listGaji[i][0]).equals("")) {
                                    String namaPekerjaan = "";
                                    if (pekerjaan.baca((String) listGaji[i][0])) {
                                        namaPekerjaan = pekerjaan.getNamaPekerjaan();
                                    }
                                    FormUtama.formGaji.setTambahGaji(new Object[] { listGaji[i][0], namaPekerjaan,
                                            listGaji[i][1], listGaji[i][2], listGaji[i][3] });
                                    jumlahGaji++;
                                }
                            }
                        }
                    }

                    if (jumlahGaji == 0) {
                        FormUtama.formGaji.setTambahGaji(new Object[] {});
                    }
                } else {
                    JOptionPane.showMessageDialog(null, karyawan.getPesan());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, karyawan.getPesan());
        }
    }

    public void tampilkanFormLihatPekerjaan() {
        formLihatPekerjaan = new FormLihatPekerjaan(null, true);
        if (pekerjaan.bacaData()) {
            formLihatPekerjaan.tampilkanData(pekerjaan.getList());
            formLihatPekerjaan.setVisible(true);
            if (formLihatPekerjaan.getKodePekerjaanDipilih() != null
                    && !formLihatPekerjaan.getKodePekerjaanDipilih().equals("")) {
                if (pekerjaan.baca(formLihatPekerjaan.getKodePekerjaanDipilih())) {
                    FormUtama.formGaji.setTambahGaji(new Object[] { pekerjaan.getKodePekerjaan(),
                            pekerjaan.getNamaPekerjaan(), "", "", "" });
                } else {
                    FormUtama.formGaji.setTambahGaji(
                            new Object[] { formLihatPekerjaan.getKodePekerjaanDipilih(), "", "", "", "" });
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, pekerjaan.getPesan());
        }
    }

    public void cariPekerjaan(String kodePekerjaan) {
        if (pekerjaan.baca(kodePekerjaan)) {
            FormUtama.formGaji.setNamaPekerjaan(pekerjaan.getNamaPekerjaan());
        } else {
            FormUtama.formGaji.setNamaPekerjaan("");
            FormUtama.formGaji.hapusGaji();
            JOptionPane.showMessageDialog(null, pekerjaan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void simpan(javax.swing.JTextField ktp, javax.swing.JTable gajiTable) {
        if (!ktp.getText().equals("")) {
            gaji.setKtp(ktp.getText());

            int rowCount = gajiTable.getRowCount();
            if (rowCount > 0 && (gajiTable.getValueAt(rowCount - 1, 0) == null
                    || gajiTable.getValueAt(rowCount - 1, 0).toString().isEmpty())) {
                rowCount--;
            }

            Object[][] listGaji = new Object[rowCount][4];

            for (int i = 0; i < rowCount; i++) {
                listGaji[i][0] = gajiTable.getValueAt(i, 0); // Kode
                listGaji[i][1] = gajiTable.getValueAt(i, 2); // Gaji Bersih
                listGaji[i][2] = gajiTable.getValueAt(i, 3); // Gaji Kotor
                listGaji[i][3] = gajiTable.getValueAt(i, 4); // Tunjangan

                if (listGaji[i][1] == null || listGaji[i][1].toString().isEmpty()) {
                    listGaji[i][1] = "0";
                }
                if (listGaji[i][2] == null || listGaji[i][2].toString().isEmpty()) {
                    listGaji[i][2] = "0";
                }
                if (listGaji[i][3] == null || listGaji[i][3].toString().isEmpty()) {
                    listGaji[i][3] = "0";
                }
            }

            gaji.setListGaji(listGaji);
            if (gaji.simpan()) {
                JOptionPane.showMessageDialog(null, "Data gaji berhasil disimpan.", "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);
                FormUtama.formGaji.setKtp("");
                FormUtama.formGaji.setNama("");
                FormUtama.formGaji.setRuang("");
                FormUtama.formGaji.clearGajiTable();
            } else {
                JOptionPane.showMessageDialog(null, gaji.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "KTP tidak boleh kosong\n", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cetakLaporan(javax.swing.JComboBox ruangComboBox) {
        int ruang = 0;
        if (ruangComboBox.getSelectedIndex() > 0) {
            ruang = Integer.parseInt(ruangComboBox.getSelectedItem().toString());
        }

        if (!gaji.cetakLaporan(ruang)) {
            JOptionPane.showMessageDialog(null, gaji.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
}