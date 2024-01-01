package ordering_system;

import utils.InOut;
import java.util.Date;
import utils.Parsing;

public class Main {
    public static void main(String[] args) {
        CreditCard c1 = new CreditCard("Adham", "123456789", 123, "04/22");

        InOut.printInformation(c1.pay(100));
    }
}
