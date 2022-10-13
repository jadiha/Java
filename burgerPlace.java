/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burgerplace;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;

public class burgerPlace {

    private double number;
    private double amount;
    private String customer;
    private double discount;
    private double total;
    private double newamount;
    private double payment;
    private double balance;
    private double newBalance;
    private int x;

    //main instance variables
    private double numberOfBurgers;
    private double amountOfChange;
    private double priceOfBurger;
    private String typeOfBurger;
    private double mealCalories;

    public burgerPlace(int numberOfBurgers, double amountOfChange, double priceOfBurger, String typeOfBurger, double mealCalories) {
        this.numberOfBurgers = numberOfBurgers;
        this.amountOfChange = amountOfChange;
        this.priceOfBurger = priceOfBurger;
        this.typeOfBurger = typeOfBurger;
        this.mealCalories = mealCalories;
    }

    //Constructors
    public burgerPlace(int priceOfBurger, String typeOfBurger, double mealCalories) {
        this(80, 100.00, priceOfBurger, typeOfBurger, mealCalories);
    }

    public burgerPlace(int numberOfBurgers, double amountOfChange, double priceOfBurger) {
        this(numberOfBurgers, amountOfChange, priceOfBurger, "Crispy Chicken", 140.00);
    }

    public burgerPlace(int numberOfBurgers, double amountOfChange) {
        this(numberOfBurgers, amountOfChange, 5.00, "Double Stacked Cheeseburger", 450.00);
    }

    public void setCustomerName(String customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return this.customer;
    }

    public void greeting() {
        System.out.println("Welcome to Burger Place! Proudly serving the community for 40 years..");
        displayMenu();
    }

    public void displayMenu() {
        System.out.println("\n--- Burger Place Menu --- \n1.Double Stacked Cheeseburger ($5.00)\n2.Crispy Chicken ($5.00)\n3.Veggie Burger ($5.00)\n4.Pulled Pork Burger ($5.00)");
        chooseOptions();
    }

    public void chooseOptions() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nHow many burgers would you like to purchase?: ");
        amount = keyboard.nextDouble();
        numberOfBurgers -= amount;
        if (numberOfBurgers < amount) {
            System.out.println("Sorry, we don't have enough or sold out. Please complete purchase with cashier. ");
            String purchase = keyboard.nextLine();
        } else if (amount.class != double.class) {
            System.out.println("Invalid entry, please pay at front cashier..");
        } else {
            discount();
        }
    }

    public void discount() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Do you have a discount code? (y/n) : ");
        String discount = keyboard.nextLine().toLowerCase();
        if ("y".equals(discount)) {
            System.out.print("Enter how much your discount is: $");
            double number = keyboard.nextDouble();
            this.number = number;
            total -= number;
            printReceipt();
        } else if (discount != "n" || discount != "y") {
            System.out.println("Invalid entry, please pay at front cashier..");
        }
    }

    public void printReceipt() { 
        newamount = amount * 5;
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat oned = new DecimalFormat("#");
        System.out.println("\n   Burger Place  \n-----RECEIPT-----");
        System.out.println(oned.format(amount) + " Burgers - " + "$ " + newamount);
        System.out.println("Discount - $" + number);
        double afterdiscount = (newamount - number);
        System.out.println("Subtotal - $" + (df.format((afterdiscount))));
        double subtotal = afterdiscount * 0.13;
        System.out.println("Tax 13% - $" + (df.format(subtotal)));
        this.total = total;
        total = (subtotal + afterdiscount);
        System.out.println("Total - $" + (df.format(total)));
        payPurchase();

    }

    public void payPurchase() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nHow would you like to pay? (0=Card,1=Cash): ");
        int paymentMethod = keyboard.nextInt();
        if (paymentMethod == 0) {
            card();
        } else if (paymentMethod == 1) {
            cash();
        } else {
            System.out.println("Invalid entry, please pay at front cashier..");
        }

    }

    public void card() {
        System.out.println("\nPlease tap your card.");
        goodbye();
    }

    public void cash() { 
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How much will you be paying?: $");
        payment = keyboard.nextDouble();
        balance = total - payment;
        if (payment > total) {
            coinReturn();
        } else if (balance == 0) {
            goodbye();
        } else if (payment != total) {
            System.out.println("You still have $" + (df.format(balance)) + " to pay!");
            goodbye();
        }
    }

    public void goodbye() {
        System.out.println("\nThank you for ordering from the Buger Place! Please choose which burger(s) you'd like at the front..");
    }

    public void coinReturn() { //If user pays more than needed
        DecimalFormat df = new DecimalFormat("#.##");
        double change = payment - total;
        if (change > amountOfChange) {
            System.out.println("Sorry we don't have enough change. Please proceed to the front.. ");
        } else {
            System.out.println("Your change is $" + (df.format(change)));
            goodbye();
        }
    }

    public void setOrderNumber(int x) {
        this.x = x;
    }

    public Integer getOrderNumber() {
        return this.x;
    }

}
