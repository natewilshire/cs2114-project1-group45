package Github;

import java.util.ArrayList;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Collects validated user and drink information and displays a summary.
 * Caffeine calculations and preset drink choices will be connected later.
 *
 * @author Luc Tran
 * @version Sep 22, 2026
 */
public class Main
{
    /**
     * Runs the console program.
     *
     * @param args
     *            command-line arguments, not used
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation();
        ConsoleInput input = new ConsoleInput(scanner, validation);

        ArrayList<Drink> drinks = new ArrayList<>();

        System.out.println("Welcome to the Caffeine Tracker!");
        System.out.println("\nEnter your information.");

        String sex = input.readSex();
        double height = input.readHeight();
        double weight = input.readWeight();

        User user = new User(sex, height, weight);

        System.out.println("\nEnter times as decimal hours.");
        System.out.println("Example: 14.5 means 2:30 PM, not 14.30.");
        System.out.println("All times must be on the same day.");

        double latestConsumed = 0;
        boolean addAnother;

        do
        {
            System.out.println("\nEnter drink information.");

            // R we still doing the preset drinks orrrr? 
            String drinkName = input.readDrinkName();
            String size = input.readSize();
            double caffeineAmount = input.readCaffeineAmount();
            double timeConsumed = input.readTime(
                "Time consumed (0 to less than 24): ");

            Drink drink = new Drink(
                drinkName, size, caffeineAmount, timeConsumed);

            drinks.add(drink);

            if (timeConsumed > latestConsumed)
            {
                latestConsumed = timeConsumed;
            }

            addAnother = input.readYesNo("Add another drink? (y/n): ");
        }
        while (addAnother);

        double requestedTime = input.readTime(
            "\nWhat time do you want to check? ");

        while (!validation.validRequestedTime(
            requestedTime, latestConsumed))
        {
            System.out.println(
                "Rejected: the check time must be at or after "
                    + "your latest drink at " + latestConsumed + ".");

            requestedTime = input.readTime(
                "What time do you want to check? ");
        }

        System.out.println("\n--- User Information ---");
        System.out.println("Sex: " + user.getSex());
        System.out.println("Height: " + user.getHeight() + " inches");
        System.out.println("Weight: " + user.getWeight() + " pounds");

        System.out.println("\n--- Drinks Entered ---");

        double totalConsumed = 0;

        for (int i = 0; i < drinks.size(); i++)
        {
            Drink drink = drinks.get(i);

            System.out.println("\nDrink " + (i + 1) + ":");
            System.out.println("Name: " + drink.getDrinkName());
            System.out.println("Size: " + drink.getSize());
            System.out.println(
                "Caffeine: " + drink.getCaffeineAmount() + " mg");
            System.out.println(
                "Time consumed: " + drink.getTimeConsumed());

            totalConsumed += drink.getCaffeineAmount();
        }

        System.out.printf(
            "%nTotal caffeine consumed: %.2f mg%n", totalConsumed);
        System.out.println("Requested check time: " + requestedTime);

        // STILL NEED THE CaffeineCalculator TO DO THE FINAL THINGS
        System.out.println(
            "Caffeine remaining is not calculated yet.");

        scanner.close();
    }
}