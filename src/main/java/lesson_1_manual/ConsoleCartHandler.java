package lesson_1_manual;

import java.util.Scanner;

public class ConsoleCartHandler {

    public static void cartHandler(ICart cart) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int id;
        while (true) {
            System.out.println("Add to cart press (a), remove (r), view (v) exit (q)");
            choice = scanner.next();
            switch (choice) {
                case "q":
                    return;
                case "a":
                    System.out.println("Enter product id");
                    id = scanner.nextInt();
                    cart.add(id);
                    System.out.println(cart.toString());
                    break;
                case "r":
                    System.out.println("Enter product id");
                    id = scanner.nextInt();
                    cart.remove(id);
                    System.out.println(cart.toString());
                    break;
                case "v":
                    System.out.println(cart.toString());
            }
        }
    }
}

