package ordering_system;

import utils.InOut;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        String[] productNames = {"Pizza", "Cheeseburger", "Coffee", "Soda", "Water", "Cake"};
        double[] productPrices = {40.0, 20.0, 50., 4.0, 2.0, 50.0};

        while (true) {
            String mainMenuString = """
                    Please make a choice
                                        
                    1. Add item
                    2. Remove item
                    3. Checkout
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

                    break;

                case 2:
                    int removeChoice = InOut.inputInt(cart.printCart() + "\n" + "Select Item to remove:");
                    cart.remove(cart.orderItems[removeChoice - 1]);

                    break;

                case 3:
                    break;

                case 4:
                    return;

                default:
                    InOut.printWarning("Invalid Choice, Try again.");
            }
        }
    }
}
