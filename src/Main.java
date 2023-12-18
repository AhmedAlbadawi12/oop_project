import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder obj = new StringBuilder();
        String[] arr = {"Pizza", "Burger", "Coffee", "Water", "Soda"};
        int[] priceArr = {50, 40, 30, 20, 10};

        for (int i = 0; i < arr.length; i++){
            obj.append(i+1).append(". ").append(arr[i]).append(" - $").append(priceArr[i]).append("\n");
        }

        obj.append("\nEnter Choice:");

        String f = obj.toString();
        System.out.println(f);
        JOptionPane.showInputDialog(null, f);
    }
}
