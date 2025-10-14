package view;

import javax.swing.JOptionPane;

// This is a placeholder class required by Model classes.
public class PesanDialog {
    public int tampilkanPilihan(String pesan, String judul, Object[] pilihan) {
        return JOptionPane.showOptionDialog(null, pesan, judul, JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, pilihan, pilihan[0]);
    }
}