//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: A Simple Shopping Cart
// Files: (a list of all source files used by that program)
// Course: CS 300, Spring, 2019
//
// Author: Jacob Sweis
// Email: jdsweis@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Galen Quinn
// Partner Email: gaquinn@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

/**
 * This class contains the methods that run the shopping cart program.
 * 
 * @author Jacob Sweis
 * @author Galen Quinn
 *
 */
public class ShoppingCart {

    private static final int CART_CAPACITY = 20; // shopping cart max capacity
    private static final double TAX_RATE = 0.05; // sales tax

    // a perfect-size two-dimensional array that stores the available items in the
    // market
    // MARKET_ITEMS[i][0] refers to a String that represents the description of the
    // item
    // identified by index i
    // MARKET_ITEMS[i][1] refers to a String that represents the unit price of the
    // item
    // identified by index i in dollars.
    public static final String[][] MARKET_ITEMS = new String[][] {{"Apple", "$1.59"},
        {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
        {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
        {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
        {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
        {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
        {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};

    /**
     * adds the item with the given identifier index at the end of the cart
     * 
     * @param index of the item within the marketItems array
     * @param cart shopping cart
     * @param count number of items present within the cart before this add method is called
     * @return the number of items present in the cart after the item with identifier index is added
     */
    public static int add(int index, String[] cart, int count) {
        // count cannot be greater than the cart capacity
        if (count >= CART_CAPACITY) {
            System.out.println("WARNING: The cart is full. You cannot add any new item.");
        } else {
            cart[count] = MARKET_ITEMS[index][0]; // add string of item in the market to the cart
            count++;
        }
        return count;
    }

    /**
     * Returns how many occurrences of the item with index itemIndex are present in the shopping
     * cart
     * 
     * @param itemIndex identifier of the item to count its occurrences in the cart
     * @param cart shopping cart
     * @param count number of items present within the cart
     * @return the number of occurrences of item in the cart
     */
    public static int occurrencesOf(int itemIndex, String[] cart, int count) {
        int occurences = 0; // occurrences of the item

        // iterate through cart
        for (int i = 0; i < count; ++i) {
            // item in cart has to match item in market items
            if (cart[i].equals(MARKET_ITEMS[itemIndex][0])) {
                occurences++;
            }
        }
        return occurences;
    }

    /**
     * Removes the first (only one) occurrence of itemToRemove if found and returns the number of
     * items in the cart after remove operation is completed either successfully or not
     * 
     * @param itemToRemove the item to be removed in String form
     * @param cart shopping cart
     * @param count number of items present within the cart
     * @return the number of items in the cart after the itemToRemove is removed
     */

    public static int remove(String itemToRemove, String[] cart, int count) {

        int index = indexOf(itemToRemove, cart, count); // index of desired item

        // index has to be 0 or greater
        if (index >= 0) {
            cart[index] = cart[count - 1]; // replaces the item to remove with the last item in the
                                           // cart
            cart[count - 1] = null; // removes the last item in the cart
            count--;
        } else {
            System.out.println("WARNING: " + itemToRemove + " not found in the shopping cart.");
        }
        return count;
    }

    /**
     * Returns the index of an item within the shopping cart
     * 
     * @param item description
     * @param cart Shopping cart
     * @param count number of items present in the shopping cart
     * @return index of the item within the shopping cart, and -1 if the item does not exist in the
     *         cart
     */
    private static int indexOf(String item, String[] cart, int count) {
        int index = -1; // index of item

        for (int i = 0; i < count; i++) { // iterates through cart
            // assigns index to desired item in cart
            if (cart[i].equals(item)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Returns the price of an item
     *
     * @param index identifier
     * @return price of an item given its index
     * 
     */
    private static double priceOf(int index) {
        String p = MARKET_ITEMS[index][1].substring(1); // price of the item in a string
        double price = Double.parseDouble(p); // price of item in a double
        return price;
    }

    /**
     * Returns the id index of an item in MARKET_ITEMS (identifier)
     *
     * @param item name of item
     * @return id index of the item in MARKET_ITEMS
     * 
     */
    private static int idOfItem(String item) {
        int idIndex = -1; // index of item
        for (int i = 0; i < MARKET_ITEMS.length; i++) { // iterates through market items
            if (MARKET_ITEMS[i][0].equals(item)) { // checks if the market item description matches
                                                   // the item
                return i;
            }
        }
        return idIndex;
    }

    /**
     * Returns the total value (cost) of the cart without tax in $ (double)
     *
     * @param cart Shopping cart
     * @param count number of items present in the shopping cart
     * @return total cost of cart
     * 
     */
    public static double getSubTotalPrice(String[] cart, int count) {
        double cost = 0.0; // base cost of cart

        for (int i = 0; i < count; i++) { // iterates through cart
            cost += priceOf(idOfItem(cart[i])); // adds the price of each item to cost

        }

        return cost;
    }

    /**
     * Prints the Market Catalog (item identifiers, description, and unit prices)
     */
    public static void printMarketCatalog() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Item id     Description      Price");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < MARKET_ITEMS.length; i++) { // iterates through market items's length
            // prints each identifier, description, and unit price
            System.out.println(i + "\t\t" + MARKET_ITEMS[i][0] + "    \t" + MARKET_ITEMS[i][1]);
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

    }

    /**
     * Displays the cart content (items separated by commas)
     *
     * @param cart Shopping cart
     * @param count number of items present in the shopping cart
     * 
     */
    public static void displayCartContent(String[] cart, int count) {
        System.out.print("Cart Content: ");
        for (String item : cart) { // iterates through cart
            if (item != null) { // if the item exists (aka not null), runs loop
                System.out.print(item + ", "); // prints item
            }
        }
        System.out.println();
    }

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        String[] cart = new String[CART_CAPACITY]; // String array with length of constant
                                                   // CART_CAPACITY
        Scanner sc = new Scanner(System.in); // Scanner with input from system
        boolean appRunning = true; // initial condition of the do while loop below
        int count = 0; // number of items in cart
        int index = -1; // index defined by user in command
        String input; // input of user
        char inputChar; // first char of input of user
        String commandPrompt = "COMMAND MENU:\n" + " [P] print the market catalog\n"
            + " [A <index>] add one occurrence of an item to the cart given its identifier\n"
            + " [C] checkout\n" + " [D] display the cart content\n"
            + " [O <index>] number of occurrences of an item in the cart given its identifier\n"
            + " [R <index>] remove one occurrence of an item from the cart given its identifier\n"
            + " [Q]uit the application\n" + "\n" + "ENTER COMMAND: ";

        System.out.println("=============   Welcome to the Shopping Cart App   =============");
        System.out.println();
        System.out.println();

        do {
            System.out.print(commandPrompt); // prints the command prompt
            input = sc.nextLine(); // takes in user input and assigns it to string input
            String[] inputArr = input.split(" "); // string array inputArr split into command and
                                                  // index
            input = input.trim().toUpperCase(); // removes whitespaces and makes uppercase
            inputChar = input.charAt(0); // assigns command at first char of input as inputChar

            switch (inputChar) { // switch statement which checks if inputChar is any of the cases
                                 // below
                case 'P': // case for print command
                    printMarketCatalog(); // calls method
                    System.out.println();
                    break;
                case 'A': // case for add command
                    index = Integer.parseInt(inputArr[1]); // assigns the index command to index
                    count = add(index, cart, count); // calls method and returns new count value
                    System.out.println();
                    break;

                case 'C': // case for checkout command
                    double subCost = getSubTotalPrice(cart, count); // calls method and returns
                                                                    // value to subcost
                    double tax = subCost * TAX_RATE; // assigns subcost * the tax rate to get the
                                                     // tax in $
                    double totalCost = subCost + tax; // assigns the tax added to the subcost to the
                                                      // total cost
                    // prints the checkout items in specified format
                    System.out.println("#items: " + count + " Subtotal: $"
                        + String.format("%.2f", subCost) + " Tax: $" + String.format("%.2f", tax)
                        + " TOTAL: $" + String.format("%.2f", totalCost));
                    System.out.println();
                    break;

                case 'D': // case for display command
                    displayCartContent(cart, count); // calls method
                    System.out.println();
                    break;

                case 'O': // case for occurrence command
                    index = Integer.parseInt(inputArr[1]); // assigns the index command to index
                    // prints the defined occurrences in specified format
                    System.out.println("The number of occurrences of " + MARKET_ITEMS[index][0]
                        + " (id #" + index + ") is: " + occurrencesOf(index, cart, count));
                    System.out.println();
                    break;

                case 'R': // case for remove command
                    index = Integer.parseInt(inputArr[1]); // assigns the index command to index
                    count = remove(MARKET_ITEMS[index][0], cart, count); // calls method and returns
                                                                         // new count value
                    System.out.println();
                    break;

                case 'Q': // case for quit command
                    appRunning = false; // sets loop condition to false when quit is called
                    break;

                default: // default case

                    break;
            }

        } while (appRunning == true);

        System.out.println("=============  Thank you for using this App!!!!!  =============");
    }

}
