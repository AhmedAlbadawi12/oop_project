package ordering_system;

import utils.InOut;

public class Main {
    public static void main(String[] args) {
        boolean choice;
        choice = InOut.inputYesNo("Do you want to print?");

        if (choice) {
            InOut.printInformation("You choose Yes");
        } else {
            InOut.printInformation("You choose No");
        }
    }
}
