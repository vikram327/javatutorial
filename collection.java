import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<collection> productList = new ArrayList<>();

        System.out.println("Enter number of products: ");
        int numOfProducts = scanner.nextInt();

        for (int i = 0; i < numOfProducts; i++) {
            System.out.println("Enter product name: ");
            String name = scanner.next();

            System.out.println("Enter product price: ");
            double price = scanner.nextDouble();

            collection newProduct = new collection(name, price);
            productList.add(newProduct);
        }

        System.out.println("1 : Sort by price");
        System.out.println("2 : Sort by name");

        try {
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    Collections.sort(productList);
                    System.out.println("Sorted product : ");
                    for (collection p : productList) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    Collections.sort(productList, new collection.ProductInnerClass());

                    System.out.println("Sorted product by name: ");
                    for (collection p : productList) {
                        System.out.println(p);
                    }
                    break;

                default:
                    System.out.println("Invalid input. Please enter 1 or 2.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        }

        scanner.close();
    }
}