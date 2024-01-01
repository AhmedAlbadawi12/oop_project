package ordering_system;

import utils.InOut;

public class Main {
    public static void main(String[] args) {

        String test = "Password@123";

        if (test.contains("#")) {
            InOut.printInformation("Yes");
        }
        else {
            InOut.printInformation("No");
        }

        char t = 'a';

        InOut.printInformation(String.valueOf(test.contains(String.valueOf(t))));
    }
}
