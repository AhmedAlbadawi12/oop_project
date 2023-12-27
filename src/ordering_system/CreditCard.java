package ordering_system;
import java.util.Date;

public class CreditCard implements PaymentMethod{
    private String name,cardNumber;
    private int cvv,balance;
    private Date expiryDate;

    public CreditCard(String name, String cardNumber, int cvv, Date expiryDate){
        this.name = name; this.cardNumber = cardNumber;
        this.cvv = cvv; this.expiryDate = expiryDate;
    }

    public String getName() {return name;}
    public Date getExpiryDate() {return expiryDate;}
    public int getBalance() {return balance;}
    public int getCvv() {return cvv;}
    public String getCardNumber() {return cardNumber;}

    public void setBalance(int balance) {this.balance = balance;}
    public void setCardNumber(String cardNumber) {this.cardNumber = cardNumber;}
    public void setCvv(int cvv) {this.cvv = cvv;}
    public void setExpiryDate(Date expiryDate) {this.expiryDate = expiryDate;}
    public void setName(String name) {this.name = name;}

    @Override
    public boolean isValid() {return false;}

    @Override
    public String pay(int amount) {
        if(isValid()){
            balance -= amount;
            return "Payment Successful";
        }
        else {
            return "Payment failed";
        }
    }
}
