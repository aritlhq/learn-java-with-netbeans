package view;

import controller.PekerjaanController;
import java.awt.event.KeyEvent;

public class FormPekerjaan extends javax.swing.JInternalFrame {

        private final PekerjaanController pekerjaanController = new PekerjaanController();

        public FormPekerjaan() {
                initComponents();
                setItemComboBox();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                kodePekerjaanTextField = new javax.swing.JTextField();
                namaPekerjaanTextField = new javax.swing.JTextField();
                jumlahTugasComboBox = new javax.swing.JComboBox<>();
                lihatButton = new javax.swing.JButton();
                jPanel2 = new javax.swing.JPanel();
                simpanButton = new javax.swing.JButton();
                hapusButton = new javax.swing.JButton();
                tutupButton = new javax.swing.JButton();

                setClosable(true);
                setIconifiable(true);
                setMaximizable(true);
                setResizable(true);
                setTitle("Master Data Pekerjaan");

                jPanel1.setBackground(new java.awt.Color(153, 255, 204));
                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pekerjaan"));

                jLabel1.setText("Kode Pekerjaan");

                jLabel2.setText("Nama Pekerjaan");

                jLabel3.setText("Jumlah Tugas");

                kodePekerjaanTextField.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                kodePekerjaanTextFieldKeyPressed(evt);
                        }
                });

                lihatButton.setText("Lihat");
                lihatButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                lihatButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel1))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jumlahTugasComboBox,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                130,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(namaPekerjaanTextField,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                200, Short.MAX_VALUE)
                                                                                .addComponent(kodePekerjaanTextField))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lihatButton)
                                                                .addContainerGap(17, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(kodePekerjaanTextField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lihatButton))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(namaPekerjaanTextField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jumlahTugasComboBox,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(20, Short.MAX_VALUE)));

                jPanel2.setBackground(new java.awt.Color(255, 204, 204));

                simpanButton.setText("Simpan");
                simpanButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                simpanButtonActionPerformed(evt);
                        }
                });

                hapusButton.setText("Hapus");
                hapusButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                hapusButtonActionPerformed(evt);
                        }
                });

                tutupButton.setText("Tutup");
                tutupButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                tutupButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(36, 36, 36)
                                                                .addComponent(simpanButton)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(hapusButton)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(tutupButton)
                                                                .addGap(38, 38, 38)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(18, Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(simpanButton)
                                                                                .addComponent(hapusButton)
                                                                                .addComponent(tutupButton))
                                                                .addGap(16, 16, 16)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanel1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jPanel2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pack();
        }// </editor-fold>

        private void tutupButtonActionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
        }

        private void kodePekerjaanTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                        pekerjaanController.cari(kodePekerjaanTextField);
                }
        }

        private void lihatButtonActionPerformed(java.awt.event.ActionEvent evt) {
                pekerjaanController.tampilkanDaftar();
        }

        private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
                pekerjaanController.simpan(kodePekerjaanTextField, namaPekerjaanTextField, jumlahTugasComboBox);
        }

        private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {
                pekerjaanController.hapus(kodePekerjaanTextField);
        }

        // Variables declaration - do not modify
        private javax.swing.JButton hapusButton;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JComboBox<String> jumlahTugasComboBox;
        private javax.swing.JTextField kodePekerjaanTextField;
        private javax.swing.JButton lihatButton;
        private javax.swing.JTextField namaPekerjaanTextField;
        private javax.swing.JButton simpanButton;
        private javax.swing.JButton tutupButton;
        // End of variables declaration

        private void setItemComboBox() {
                jumlahTugasComboBox.removeAllItems();
                for (int i = 1; i <= 6; i++) {
                        if (i != 5) {
                                jumlahTugasComboBox.addItem(Integer.toString(i));
                        }
                }
        }

        public void setKodePekerjaan(String kodePekerjaan) {
                kodePekerjaanTextField.setText(kodePekerjaan);
        }

        public void setNamaPekerjaan(String namaPekerjaan) {
                namaPekerjaanTextField.setText(namaPekerjaan);
        }

        public void setJumlahTugas(int jumlahTugas) {
                jumlahTugasComboBox.setSelectedItem(String.valueOf(jumlahTugas));
        }
}