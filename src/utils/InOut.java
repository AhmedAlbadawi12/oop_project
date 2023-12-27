package utils;

import javax.swing.JOptionPane;

public class InOut {
    public static void printInformation(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
