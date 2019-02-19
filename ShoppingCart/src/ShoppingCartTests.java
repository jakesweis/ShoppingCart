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

/**
 * This class contains test methods testing the ShoppingCart class. These tests are done to help set
 * up the ShoppingCart class, and to also indicate any problematic areas if they arise. 
 * 
 * @author Jacob Sweis
 * @author Galen Quinn
 *
 */
public class ShoppingCartTests {

    /**
     * Checks whether the total number of items within the cart is incremented after adding one item
     * 
     * @return true if the test passes without problems, false otherwise
     */
    public static boolean testCountIncrementedAfterAddingOnlyOneItem() {
        boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
                                   // false otherwise
        String[] cart = new String[20]; // shopping cart
        int count = 0; // number of items present in the cart (initially the cart is empty)

        // Add an item to the cart
        count = ShoppingCart.add(3, cart, count); // add an item of index 3 to the cart
        // Check that count was incremented
        if (count != 1) {
            System.out.println("Problem detected: After adding only one item to the cart, "
                + "the cart count should be incremented. But, it was not the case.");
            testPassed = false;
        }
        return testPassed;
    }

    /**
     * Checks whether add and OccurrencesOf return the correct output when only one item is added to
     * the cart
     * 
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testAddAndOccurrencesOfForOnlyOneItem() {
        boolean testPassed = true; // evaluated to true if test passed without problems, false
                                   // otherwise
        String[] cart = new String[10]; // shopping cart
        int count = 0; // number of items present in the cart (initially the cart is empty)

        // check that OccurrencesOf returns 0 when called with an empty cart
        if (ShoppingCart.occurrencesOf(10, cart, count) != 0) {
            System.out
                .println("Problem detected: Tried calling OccurrencesOf() method when the cart is "
                    + "empty. The result should be 0. But, it was not.");
            testPassed = false;
        }

        // add one item to the cart
        count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

        // check that OccurrencesOf("Apples", cart, count) returns 1 after adding the
        // item with key 0
        if (ShoppingCart.occurrencesOf(0, cart, count) != 1) {
            System.out
                .println("Problem detected: After adding only one item with key 0 to the cart, "
                    + "OccurrencesOf to count how many of that item the cart contains should return 1. "
                    + "But, it was not the case.");
            testPassed = false;
        }

        return testPassed;
    }

    /**
     * Checks whether add and OccurrencesOf return the correct output when duplicate items are added
     * to the cart
     * 
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testAddOccurrencesOfDuplicateItems() {
        boolean testPassed = true; // evaluated to true if test passed without problems, false
                                   // otherwise
        int count = 0; // number of items present in the cart (initially the cart is empty)
        String[] cart = new String[20]; // shopping cart
        
        // adds two items to the cart
        count = ShoppingCart.add(0, cart, count);
        count = ShoppingCart.add(0, cart, count);
        
        // checks that there are two items in the cart
        if (count != 2) {
            System.out.println(
                "Problem detected: 2 duplicate items should have been added, but there is not 2 items.");
            testPassed = false;
        }
        return true;
    }

    /**
     * Checks whether adding more than 20 items does not add additional items, and produces a
     * warning message
     * 
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testAddingTooMuchItems() {
        boolean testPassed = true; // evaluated to true if test passed without problems, false
                                   // otherwise
        int count = 20; // number of items present in the cart (initially the cart is empty)
        String[] cart = new String[20]; // shopping cart

        // adds an item to the cart
        count = ShoppingCart.add(0, cart, count);

        // checks whether the count remains 20 after attempting to add over the maximum
        if (count != 20) {
            System.out.println(
                "Problem detected: The cart should have been at maximum capacity, but was able to add another item.");
            testPassed = false;
        }

        return true;
    }

    /**
     * Checks whether remove is able to properly remove one item with only one occurrence
     * 
     * @return true if the test passes without problems, false otherwise
     */
    public static boolean testRemoveOnlyOneOccurrenceOfItem() {
        boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
                                   // false otherwise
        String[] cart = new String[] {"Eggs", "Apple", "Milk"}; // shopping cart
        int count = 3; // number of items present in the cart (initially the cart is empty)

        // removes apple from the cart
        count = ShoppingCart.remove("Apple", cart, count);

        // checks that apple was removed by lowering the count by 1
        if (count != 2) {
            System.out.println(
                "Problem detected: Item was not removed, and count was not equal to one less than before.");
            testPassed = false;
        }
        return testPassed;
    }

    /**
     * Checks whether remove does not remove items that are not actually in the cart, and produces a
     * warning message
     * 
     * @return true if the test passes without problems, false otherwise
     */
    public static boolean testRemoveItemNotFoundInCart() {
        boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
                                   // false otherwise
        String[] cart = new String[] {"Eggs", "Apple", "Milk"}; // shopping cart
        int count = 3; // number of items present in the cart (initially the cart is empty)

        // removes banana from the cart
        count = ShoppingCart.remove("Banana", cart, count);

        // checks whether the count remains the same because banana is not in the cart
        if (count != 3) {
            System.out.println(
                "Problem detected: Item was removed when no items should have been removed.");
            testPassed = false;
        }
        return testPassed;
    }

    /**
     * Checks whether remove is able to properly remove one item that has multiple items in the cart
     * 
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testRemovingItemWithMultipleOccurences() {
        boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
                                   // false otherwise
        String[] cart = new String[] {"Eggs", "Apple", "Apple"}; // shopping cart
        int count = 3; // number of items present in the cart (initially the cart is empty)

        // removes apple from the cart
        count = ShoppingCart.remove("Apple", cart, count);

        // checks whether count only goes down by 1 after removing apple
        if (count != 2) {
            System.out.println(
                "Problem detected: More than one occurence of the desired item was removed.");
            testPassed = false;
        }
        return testPassed;
    }

    /**
     * Checks whether getSubTotalPrice outputs the correct price of all the items in the cart before
     * tax
     * 
     * @return true if the test passes without problems, false otherwise
     */
    public static boolean testGetSubTotalPrice() {
        boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
                                   // false otherwise
        String[] cart = new String[] {"Eggs", "Apple", "Milk"}; // shopping cart
        int count = 3; // number of items present in the cart (initially the cart is empty)
        double price = 0.0; // subtotal price of cart

        // gets subtotal price of cart
        price = ShoppingCart.getSubTotalPrice(cart, count);

        // checks whether actual subtotal price is equal to the expected price 
        if (Math.abs(6.77 - price) > 0.001) {
            System.out.println(
                "Problem detected: Subtotal of items in cart is different than expected. ");
            testPassed = false;
        }
        return testPassed;
    }

    /**
     * main method used to call the unit tests
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("testCountIncrementedAfterAddingOnlyOneItem(): "
            + testCountIncrementedAfterAddingOnlyOneItem());
        System.out.println(
            "testAddAndOccurrencesOfForOnlyOneItem(): " + testAddAndOccurrencesOfForOnlyOneItem());
        System.out.println(
            "testAddOccurrencesOfDuplicateItems(): " + testAddOccurrencesOfDuplicateItems());
        System.out.println("testAddingTooMuchItems(): " + testAddingTooMuchItems());
        System.out
            .println("testRemoveOnlyOneOccurrenceOfItem(): " + testRemoveOnlyOneOccurrenceOfItem());
        System.out.println("testRemoveItemNotFoundInCart(): " + testRemoveItemNotFoundInCart());
        System.out.println("testRemovingItemWithMultipleOccurences(): "
            + testRemovingItemWithMultipleOccurences());
        System.out.println("testGetSubTotalPrice(): " + testGetSubTotalPrice());
    }
}
