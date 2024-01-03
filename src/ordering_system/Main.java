package ordering_system;

import utils.InOut;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item i1 = new Item("Pizza", 2, 2.0);
        Item i2 = new Item("Cheeseburger", 2, 2.0);

        cart.add(i1);
        cart.add(i1);
        cart.add(i2);
        cart.add(i1);

        int removeIndex = InOut.inputInt(cart.printCart() + "\n" + "Choose item to remove:");

        cart.remove(cart.orderItems[removeIndex - 1]);

        InOut.printInformation(cart.printCart());

        PayPal p1 = new PayPal("Adham@gmail.com", "Password132");

        InOut.printInformation(cart.checkout(p1));

//        InOut.printInformation(""+cart.getTotalAmount());

    }
}
