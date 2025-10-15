package view;

import controller.GajiController;

public class FormLaporanGaji extends javax.swing.JInternalFrame {

    private final GajiController gajiController = new GajiController();

    public FormLaporanGaji() {
        initComponents();
        setItemToComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ruangComboBox = new javax.swing.JComboBox<>();
        cetakButton = new javax.swing.JButton();
        tutupButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Laporan Gaji");

        jLabel1.setText("Ruang");

        cetakButton.setText("Cetak");
        cetakButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakButtonActionPerformed(evt);
            }
        });

        tutupButton.setText("Tutup");
        tutupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cetakButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tutupButton))
                                        .addComponent(ruangComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(ruangComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cetakButton)
                                        .addComponent(tutupButton))
                                .addContainerGap(30, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void tutupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void cetakButtonActionPerformed(java.awt.event.ActionEvent evt) {
        gajiController.cetakLaporan(ruangComboBox);
    }

    private void setItemToComboBox() {
        ruangComboBox.removeAllItems();
        ruangComboBox.addItem("Semua Ruang"); // Opsi untuk menampilkan semua
        for (int i = 1; i <= 14; i++) {
            ruangComboBox.addItem(String.valueOf(i));
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton cetakButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> ruangComboBox;
    private javax.swing.JButton tutupButton;
    // End of variables declaration
}