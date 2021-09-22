import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class project1 {

    public static void main(String[] args) throws IOException {

        ArrayList<String> productName = new ArrayList<String>(); //creates arraylist for product names
        ArrayList<Float> productPrice = new ArrayList<Float>(); //creates arraylist for product price
        ArrayList<Integer> productAvailable = new ArrayList<Integer>(); //creates arraylist for products available

        try {
            File productsFile = new File("products.txt"); //produces new file instance
            Scanner scanner = new Scanner(productsFile); //calls the scanner
            String[] array;

            while(scanner.hasNextLine()) {
                array = scanner.nextLine().split(","); //separates the values by their commas
                productName.add(array[0]);
                productPrice.add(Float.parseFloat(array[1]));
                productAvailable.add(Integer.parseInt(array[2]));

            }
            scanner.close();





            Scanner userInputscanner = new Scanner(System.in);

            while (true) {

                System.out.println("type EXIT to leave, if not type STAY : ");
                String exitPrompt = userInputscanner.nextLine();

                String enterProduct = new String();
                if (exitPrompt.equals("EXIT")) {
                    System.exit(0);
                } else {
                    System.out.println("please enter the name of the product: ");
                    enterProduct = userInputscanner.next();
                }
                    for (int i = 0; i < productName.size(); i++) {
                        if (productName.get(i).equals(enterProduct)) {

                            System.out.println("the cost of your product is " + productPrice.get(i)+ "dollars");
                            System.out.println("the amount of your product in stock is " + productAvailable.get(i));
                            break;

                        }
                        else {
                            System.out.println("that item is unavailable");
                        }
                    }


                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}