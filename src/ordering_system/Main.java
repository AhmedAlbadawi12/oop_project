package ordering_system;

import utils.InOut;
import java.util.Date;
import utils.Parsing;

public class Main {
    public static void main(String[] args) {
        Date expiryDate = Parsing.parseStringToDate("04/22");
        Date currentDate = new Date();

        if (expiryDate != null) {
            if (expiryDate.after(currentDate)) {
                InOut.printInformation("Date is valid");
            } else {
                InOut.printError("Date not valid");
            }
        }
        else {
            InOut.printError("Expiry date is null");
        }
    }
}
