package utils;

import javax.swing.JOptionPane;

public class InOut {
    public static void printInformation(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void printWarning(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void printError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static int inputInt(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));

    }

    public static double inputDouble(String message) {
        return Double.parseDouble(JOptionPane.showInputDialog(message));
    }

    public static String inputString(String message) {
        return JOptionPane.showInputDialog(message);
    }
}
