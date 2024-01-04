package ordering_system;

import utils.Validation;

public class PayPal implements PaymentMethod {
    private String email;
    private String password;
    private int balance;

    public PayPal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean isValid() {
        return Validation.isValidEmail(email) && Validation.isValidPassword(password);
    }

    @Override
    public String pay(int amount) {
        if (isValid()) {
            balance -= amount;
            return "Payment Successful\nNew Balance: " + balance;
        } else {
            return "Payment Failed";
        }
    }
}