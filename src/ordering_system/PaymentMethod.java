package ordering_system;

public interface PaymentMethod {
    public boolean isValid();

    public String pay(int amount);

}
