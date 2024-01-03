package ordering_system;

import utils.InOut;

public class ShoppingCart {
    // Constant variable to store capacity of cart
    private static final int MAX_CAPACITY = 10;

    // Initializing item array and variable for current index
    Item[] orderItems = new Item[MAX_CAPACITY];
    private int cartIndex = 0;

    // Default empty constructor
    public ShoppingCart() {
    }

    public String printCart() {
        // Cart index is not empty
        if (cartIndex != 0) {
            // Create a StringBuilder to build the multiline string
            StringBuilder multilineString = new StringBuilder();

            // Append a line to the StringBuilder
            multilineString.append("Items in shopping cart:").append("\n\n");

            // Loop to add lines to the multiline string
            for (int i = 0; i < cartIndex; i++) {
                if (orderItems[i] != null) {
                    String stringToAppend;
                    stringToAppend = (i + 1) + ". " + orderItems[i].getName() + " - Quantity: " + orderItems[i].getQuantity() +
                            " - $" + (orderItems[i].getPrice() * orderItems[i].getQuantity()) + "\n";
                    multilineString.append(stringToAppend);
                }
            }

            return multilineString.toString();
        } else {
            return "Cart is empty!";
        }
    }

    public void add(Item item) {
        if (cartIndex < 10) {
            orderItems[cartIndex] = item;
            cartIndex++;
            InOut.printInformation("Item added successfully");
        } else {
            InOut.printError("Cart is full");
        }
    }

    public void remove(Item item) {
        // Exit the method if the cart is empty
        if (cartIndex == 0) {
            InOut.printWarning("Can't remove an item, Cart is empty!");
            return;
        }

        for (int i = 0; i < cartIndex; i++) {
            if (orderItems[i] != null && orderItems[i].equals(item)) {
                // Shift elements to fill the gap
                for (int j = i; j < cartIndex - 1; j++) {
                    orderItems[j] = orderItems[j + 1];
                }

                // Set the last element to null
                orderItems[cartIndex - 1] = null;
                cartIndex--;

                InOut.printInformation("Item removed successfully");

                return;
            }
        }
    }

    // Method to return the total price for all items in the cart
    public double getTotalAmount() {
        double totalAmount = 0.0;
        for (int i = 0; i < cartIndex; i++) {
            if (orderItems[i] != null) {
                totalAmount += orderItems[i].getPrice() * orderItems[i].getQuantity();
            }
        }
        return totalAmount;
    }

    // Method to check out and pay for all the items in the cart
    public String checkout(PaymentMethod pMethod){
        int amount = (int) getTotalAmount();
        return pMethod.pay(amount);
    }
}
