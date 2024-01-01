package ordering_system;

import java.util.Date;
import utils.Validation;
import utils.Parsing;

public class CreditCard implements PaymentMethod {
    private String name, cardNumber;
    private int cvv, balance;
    private Date expiryDate;

    public CreditCard(String name, String cardNumber, int cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = Parsing.parseStringToDate(expiryDate);
    }

    public String getName() {
        return name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public int getBalance() {
        return balance;
    }

    public int getCvv() {
        return cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = Parsing.parseStringToDate(expiryDate);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isValid() {
        return Validation.isValidExpiryDate(expiryDate);
    }

    @Override
    public String pay(int amount) {
        if (isValid()) {
            balance -= amount;
            return "Payment Successful";
        } else {
            return "Payment Failed";
        }
    }
}
