package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormLihatPekerjaan extends javax.swing.JDialog {

    private final DefaultTableModel pekerjaanTableModel;
    private String kodePekerjaanDipilih;

    public FormLihatPekerjaan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pekerjaanTableModel = (DefaultTableModel) pekerjaanTable.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pekerjaanTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        pilihButton = new javax.swing.JButton();
        tutupButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Pekerjaan");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pekerjaan"));

        pekerjaanTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Kode", "Nama Pekerjaan"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(pekerjaanTable);
        if (pekerjaanTable.getColumnModel().getColumnCount() > 0) {
            pekerjaanTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE)));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        pilihButton.setText("Pilih");
        pilihButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihButtonActionPerformed(evt);
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
                                .addGap(88, 88, 88)
                                .addComponent(pilihButton)
                                .addGap(60, 60, 60)
                                .addComponent(tutupButton)
                                .addContainerGap(92, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pilihButton)
                                        .addComponent(tutupButton))
                                .addContainerGap(18, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void tutupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void pilihButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (pekerjaanTable.getSelectedRowCount() > 0) {
            kodePekerjaanDipilih = pekerjaanTable.getValueAt(
                    pekerjaanTable.getSelectedRow(), 0).toString();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Belum ada yang dipilih");
        }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        kodePekerjaanDipilih = "";
        // Object[][] list = {
        // { "1415", "admin" },
        // { "2231", "sales" },
        // { "4444", "direktur" },
        // { "4545", "KULI" }
        // };
        // tampilkanData(list);
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pekerjaanTable;
    private javax.swing.JButton pilihButton;
    private javax.swing.JButton tutupButton;
    // End of variables declaration

    public void tampilkanData(Object[][] list) {
        pekerjaanTableModel.setRowCount(0);
        if ((list != null) && (list.length > 0)) {
            for (int i = 0; i < list.length; i++) {
                pekerjaanTableModel.addRow(list[i]);
            }
        }
    }

    public String getKodePekerjaanDipilih() {
        return kodePekerjaanDipilih;
    }
}