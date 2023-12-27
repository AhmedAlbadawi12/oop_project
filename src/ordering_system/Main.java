package ordering_system;

import utils.InOut;

public class Main {
    public static void main(String[] args) {
//        boolean choice;
//        choice = InOut.inputYesNo("Do you want to print?");
//
//        if (choice) {
//            InOut.printInformation("You choose Yes");
//        } else {
//            InOut.printInformation("You choose No");
//        }

        PayPal p1 = new PayPal("Adham@gmail.com", "Password");

        if (p1.isValid()){
            InOut.printInformation("Valid");
        }
        else {
            InOut.printWarning("Not Valid");
        }
    }
}
