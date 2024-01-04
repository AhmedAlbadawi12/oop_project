package ordering_system;

import utils.InOut;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        String[] productNames = {"Pizza", "Cheeseburger", "Coffee", "Soda", "Water", "Cake"};
        double[] productPrices = {40.0, 20.0, 50., 4.0, 2.0, 50.0};

        while (true) {
            String mainMenuString = """
                    Please make a choice
                                        
                    1. Add food item to cart
                    2. Remove food item to cart
                    3. Check out cart & pay
                    4. Exit
                                        
                    Enter Choice:
                    """;

            int menuChoice = InOut.inputInt(mainMenuString);

            switch (menuChoice) {
                case 1:
                    // Create a new string builder to create multi-line string
                    StringBuilder foodMenu = new StringBuilder();

                    // Append the first line
                    foodMenu.append("Please, select a product:\n\n");

                    // Append the menu of items
                    for (int i = 0; i < productNames.length; i++) {
                        foodMenu.append((i + 1)).append(". ").append(productNames[i]).append(" - $").append(productPrices[i]).append("\n");
                    }

                    // Append the choice line
                    foodMenu.append("\nEnter choice:");

                    String foodMenuString = foodMenu.toString();

                    int foodChoice = InOut.inputInt(foodMenuString);
                    int quantity = InOut.inputInt("Enter Quantity:");
                    Item item = new Item(productNames[foodChoice - 1], quantity, productPrices[foodChoice - 1]);

                    cart.add(item);

                    String checkoutAfterAdd = InOut.inputString("Proceed to checkout? (Y/N)?").toLowerCase();

                    if (checkoutAfterAdd.equals("y")) {
                        initCheckout(cart);
                    }

                    break;

                case 2:
                    if (cart.getCartIndex() != 0) {
                        int removeChoice = InOut.inputInt(cart.printCart() + "\n" + "Select Item to remove:");
                        cart.remove(cart.orderItems[removeChoice - 1]);
                    } else {
                        InOut.printWarning("Can't remove item, Cart is empty");
                    }

                    break;

                case 3:
                    initCheckout(cart);
                    break;

                case 4:
                    return;

                default:
                    InOut.printWarning("Invalid Choice, Try again.");
            }
        }
    }

    private static void initCheckout(ShoppingCart cart) {
        int paymentChoice = InOut.inputInt("""
                Choose Payment Method:
                
                1. PayPal
                2. CreditCard
                
                Enter Choice:
                """);

        // If the user chooses PayPal
        if (paymentChoice == 1) {
            // Ask the user to enter email and password
            String email = InOut.inputString("Enter PayPal email:");
            String password = InOut.inputString("Enter PayPal password");

            // Create new object with the email and password
            PayPal p = new PayPal(email, password);

            p.setBalance(InOut.inputInt("Enter Balance:"));

            // Use the method checkout from ShoppingCart and send the PayPal object to it
            InOut.printInformation(cart.checkout(p));

        } else if (paymentChoice == 2) {
            // Ask the user for credit card details
            String name = InOut.inputString("Enter Credit Card Name");
            String number = InOut.inputString("Enter Credit Card Number");
            int cvv = InOut.inputInt("Enter Credit Card CVV");
            String expDate = InOut.inputString("Enter Credit Card Expiry Date");

            // Create a new credit card object
            CreditCard c = new CreditCard(name, number, cvv, expDate);

            c.setBalance(InOut.inputInt("Enter Balance:"));

            // Use the method checkout from ShoppingCart and send the CreditCard object to it
            InOut.printInformation(cart.checkout(c));
        }
    }
}
