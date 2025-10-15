package view;

import controller.GajiController;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class FormGaji extends javax.swing.JInternalFrame {

    private final DefaultTableModel gajiDefaultTableModel;
    private final GajiController gajiController = new GajiController();

    /**
     * Creates new form FormGaji
     */
    public FormGaji() {
        initComponents();
        gajiDefaultTableModel = (DefaultTableModel) gajiTable.getModel();
        setItemToComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        pekerjaanPopupMenu = new javax.swing.JPopupMenu();
        tambahMenuItem = new javax.swing.JMenuItem();
        hapusMenuItem = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ktpTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        lihatButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ruangComboBox = new javax.swing.JComboBox<>();
        simpanButton = new javax.swing.JButton();
        tutupButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gajiTable = new javax.swing.JTable();

        tambahMenuItem.setText("Tambah");
        tambahMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahMenuItemActionPerformed(evt);
            }
        });
        pekerjaanPopupMenu.add(tambahMenuItem);

        hapusMenuItem.setText("Hapus");
        hapusMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusMenuItemActionPerformed(evt);
            }
        });
        pekerjaanPopupMenu.add(hapusMenuItem);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mengelola Gaji Karyawan");

        jLabel1.setText("KTP");

        jLabel2.setText("Nama");

        ktpTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ktpTextFieldKeyPressed(evt);
            }
        });

        lihatButton.setText("Lihat");
        lihatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Ruang");

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        tutupButton.setText("Tutup");

        tutupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        jLabel4.setText("Gaji");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

        gajiTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Kode", "Nama Pekerjaan", "Gaji Bersih", "Gaji Kotor", "Tunjangan"
                }));
        gajiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gajiTableMouseReleased(evt);
            }
        });
        gajiTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                gajiTablePropertyChange(evt);
            }
        });
        gajiTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gajiTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(gajiTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(namaTextField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 200,
                                                                Short.MAX_VALUE)
                                                        .addComponent(ktpTextField))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lihatButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(ruangComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44,
                                                        Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(simpanButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(tutupButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jLabel4))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(ktpTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lihatButton)
                                        .addComponent(jLabel3)
                                        .addComponent(ruangComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(simpanButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tutupButton))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        gajiController.simpan(ktpTextField, gajiTable);
    }

    private void lihatButtonActionPerformed(java.awt.event.ActionEvent evt) {
        gajiController.tampilkanFormLihatKaryawan();
    }

    private void ktpTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            gajiController.cariKaryawan(ktpTextField);
        }
    }

    private void tambahMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        gajiController.tampilkanFormLihatPekerjaan();
    }

    private void hapusMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        if (gajiTable.getSelectedRowCount() > 0) {
            gajiDefaultTableModel.removeRow(
                    gajiTable.getSelectedRow());
        }
    }

    private void gajiTableMouseReleased(java.awt.event.MouseEvent evt) {
        Point p = evt.getPoint();
        int rowNumber = gajiTable.rowAtPoint(p);
        ListSelectionModel model = gajiTable.getSelectionModel();
        model.setSelectionInterval(rowNumber, rowNumber);
        klikKananTabel(evt);
    }

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {
        klikKananTabel(evt);
    }

    private void gajiTableKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gajiTable.getSelectedRow() == (gajiTable.getRowCount() - 1)) {
                if (gajiTable.getSelectedColumn() == 0) {
                    gajiDefaultTableModel.insertRow(gajiDefaultTableModel.getRowCount(), new Object[] {});
                } else {
                    if (gajiTable.getSelectedColumn() == (gajiTable.getColumnCount() - 1)) {
                        gajiDefaultTableModel.insertRow(gajiDefaultTableModel.getRowCount(), new Object[] {});
                        gajiTable.changeSelection(gajiTable.getSelectedRow(), 0, false, false);
                    } else {
                        gajiTable.changeSelection(gajiTable.getSelectedRow() - 1, gajiTable.getSelectedColumn() + 1,
                                false, false);
                    }
                }
            } else {
                if (gajiTable.getSelectedColumn() == (gajiTable.getColumnCount() - 1)) {
                    gajiTable.changeSelection(gajiTable.getSelectedRow() + 1, 0, false, false);
                } else {
                    gajiTable.setColumnSelectionInterval(gajiTable.getSelectedColumn() + 1,
                            gajiTable.getSelectedColumn() + 1);
                    gajiTable.setRowSelectionInterval(gajiTable.getSelectedRow(), gajiTable.getSelectedRow());
                }
            }
        }
    }

    private void gajiTablePropertyChange(java.beans.PropertyChangeEvent evt) {
        if (gajiTable.getSelectedRowCount() > 0) {
            if (gajiTable.getSelectedColumn() == 0) {
                String kodePekerjaan = "";
                try {
                    kodePekerjaan = gajiTable.getValueAt(gajiTable.getSelectedRow(), 0).toString();
                } catch (Exception ex) {
                }

                if (!kodePekerjaan.equals("")) {
                    gajiController.cariPekerjaan(kodePekerjaan);
                }
            }
        }
    }

    private void setItemToComboBox() {
        ruangComboBox.removeAllItems();
        for (int i = 1; i <= 14; i++) {
            ruangComboBox.addItem(String.valueOf(i));
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JTable gajiTable;
    private javax.swing.JMenuItem hapusMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ktpTextField;
    private javax.swing.JButton lihatButton;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JPopupMenu pekerjaanPopupMenu;
    private javax.swing.JComboBox<String> ruangComboBox;
    private javax.swing.JButton simpanButton;
    private javax.swing.JMenuItem tambahMenuItem;
    private javax.swing.JButton tutupButton;
    // End of variables declaration

    public void setKtp(String ktp) {
        ktpTextField.setText(ktp);
    }

    public void setNama(String nama) {
        namaTextField.setText(nama);
    }

    public void setRuang(String ruang) {
        ruangComboBox.setSelectedItem(ruang);
    }

    public void setNamaPekerjaan(String nama) {
        gajiTable.setValueAt(nama, gajiTable.getSelectedRow(), 1);
    }

    public void hapusGaji() {
        for (int i = 2; i <= 4; i++) {
            gajiTable.setValueAt("", gajiTable.getSelectedRow(), i);
        }
    }

    // public void setTambahGaji(Object[] gajiPekerjaan) {
    // int noRecord;
    // if ((noRecord = gajiDefaultTableModel.getRowCount() - 1) >= 0) {
    // while ((((gajiTable.getValueAt(noRecord, 0) == null) ||
    // gajiTable.getValueAt(noRecord, 0).equals(""))
    // && (noRecord > 0))) {
    // noRecord--;
    // }
    // }

    // if (!((gajiTable.getValueAt(noRecord, 0) == null) ||
    // gajiTable.getValueAt(noRecord, 0).equals(""))) {
    // noRecord++;
    // }

    // if (noRecord < gajiDefaultTableModel.getRowCount()) {
    // if ((gajiTable.getValueAt(noRecord, 0) == null) ||
    // gajiTable.getValueAt(noRecord, 0).equals("")) {
    // gajiDefaultTableModel.removeRow(noRecord--);
    // }
    // } else {
    // noRecord--;
    // }

    // gajiDefaultTableModel.insertRow(++noRecord, gajiPekerjaan);
    // }

    public void setTambahGaji(Object[] gajiPekerjaan) {
        if (gajiDefaultTableModel.getRowCount() > 0) {
            if (gajiTable.getValueAt(gajiDefaultTableModel.getRowCount() - 1, 0) == null) {
                gajiDefaultTableModel.removeRow(gajiDefaultTableModel.getRowCount() - 1);
            }
        }
        gajiDefaultTableModel.addRow(gajiPekerjaan);
        gajiDefaultTableModel.addRow(new Object[] {});
    }

    public void clearGajiTable() {
        gajiDefaultTableModel.setRowCount(0);
        gajiDefaultTableModel.addRow(new Object[] {});
    }

    private void klikKananTabel(java.awt.event.MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pekerjaanPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
}