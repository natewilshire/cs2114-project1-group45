package CrazyCaffeine;

import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * reads input from the console and keeps asking until the validation class
 * accepts the input which would the correct format. should tell the reason for
 * rejection
 * 
 * @author shafiursarker
 * @version Sep 22, 2026
 */
public class ConsoleInput
{
    private Scanner scanner;
    private Validation validation;

    /**
     * creates a new ConsoleInput
     *
     * @param scanner
     *            the scanner to read input from
     * @param validation
     *            the validation object used to check input
     */
    public ConsoleInput(Scanner scanner, Validation validation)
    {
        this.scanner = scanner;
        this.validation = validation;
    }


    /**
     * asks for the user's sex until it is valid
     *
     * @return the sex in lowercase
     */
    public String readSex()
    {
        System.out.print("Sex (male/female): ");
        String sex = scanner.nextLine();
        while (!validation.validSex(sex))
        {
            System.out.println("Rejected: please type male or female.");
            System.out.print("Sex (male/female): ");
            sex = scanner.nextLine();
        }
        return sex.trim().toLowerCase();
    }


    /**
     * asks for the user's height until it is valid
     *
     * @return the height in inches
     */
    public double readHeight()
    {
        double height = readNumber("Height in inches: ");
        while (!validation.validHeight(height))
        {
            System.out.println(
                "Rejected: height must be greater than 0 and at most 1000.");
            height = readNumber("Height in inches: ");
        }
        return height;
    }


    /**
     * asks for the user's weight until it is valid
     *
     * @return the weight in pounds
     */
    public double readWeight()
    {
        double weight = readNumber("Weight in pounds: ");
        while (!validation.validWeight(weight))
        {
            System.out.println(
                "Rejected: weight must be greater than 0 and at most 1000.");
            weight = readNumber("Weight in pounds: ");
        }
        return weight;
    }


    /**
     * asks for the caffeine in a drink until it is valid
     *
     * @return the caffeine amount in mg
     */
    public double readCaffeineAmount()
    {
        double caffeine = readNumber("Caffeine in the drink (mg): ");
        while (!validation.validCaffeineAmount(caffeine))
        {
            System.out.println(
                "Rejected: caffeine must be greater than 0 and at most 1000.");
            caffeine = readNumber("Caffeine in the drink (mg): ");
        }
        return caffeine;
    }


    /**
     * asks for a drink name until it is not blank
     *
     * @return the drink name
     */
    public String readDrinkName()
    {
        System.out.print("Drink name: ");
        String name = scanner.nextLine();
        while (!validation.validDrinkName(name))
        {
            System.out.println("Rejected: drink name can't be blank.");
            System.out.print("Drink name: ");
            name = scanner.nextLine();
        }
        return name.trim();
    }


    /**
     * asks for a drink size until it is valid
     *
     * @return the size in lowercase
     */
    public String readSize()
    {
        System.out.print("Size (small/medium/large): ");
        String size = scanner.nextLine();
        while (!validation.validSize(size))
        {
            System.out
                .println("Rejected: size must be small, medium, or large.");
            System.out.print("Size (small/medium/large): ");
            size = scanner.nextLine();
        }
        return size.trim().toLowerCase();
    }


    /**
     * asks for a time until it is valid. Times use a 24-hour clock
     *
     * @param message
     *            the question to show the user
     * @return the time
     */
    public double readTime(String message)
    {
        double time = readNumber(message);
        while (!validation.validTime(time))
        {
            System.out
                .println("Rejected: time must be at least 0 and less than 24.");
            time = readNumber(message);
        }
        return time;
    }


    /**
     * asks for the time to check until it is valid and not before the first
     * drink
     *
     * @param earliestConsumed
     *            the time of the first drink
     * @return the time to check
     */
    public double readRequestedTime(double earliestConsumed)
    {
        String message = "What time do you want to check (e.g. 18)? ";
        double time = readTime(message);
        while (!validation.validRequestedTime(time, earliestConsumed))
        {
            System.out.println(
                "Rejected: that is before your first drink at "
                    + earliestConsumed + ".");
            time = readTime(message);
        }
        return time;
    }


    /**
     * asks for a menu choice until it is between 1 and max
     *
     * @param message
     *            the question to show the user
     * @param max
     *            the highest menu number
     * @return the menu choice
     */
    public int readMenuChoice(String message, int max)
    {
        System.out.print(message);
        while (true)
        {
            if (scanner.hasNextInt())
            {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= max)
                {
                    return choice;
                }
            }
            else
            {
                scanner.nextLine();
            }
            System.out
                .println("Rejected: pick a number from 1 to " + max + ".");
            System.out.print(message);
        }
    }


    /**
     * asks a yes or no question until the user types y or n
     *
     * @param message
     *            the question to show the user
     * @return true for yes, false for no
     */
    public boolean readYesNo(String message)
    {
        System.out.print(message);
        String answer = scanner.nextLine().trim().toLowerCase();
        while (!answer.equals("y") && !answer.equals("n"))
        {
            System.out.println("Rejected: please type y or n.");
            System.out.print(message);
            answer = scanner.nextLine().trim().toLowerCase();
        }
        return answer.equals("y");
    }


    /**
     * asks for a number until the user types one
     *
     * @param message
     *            the question to show the user
     * @return the number the user typed
     */
    private double readNumber(String message)
    {
        System.out.print(message);
        while (!scanner.hasNextDouble())
        {
            System.out.println("Rejected: please enter a number.");
            scanner.nextLine();
            System.out.print(message);
        }
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }
}
