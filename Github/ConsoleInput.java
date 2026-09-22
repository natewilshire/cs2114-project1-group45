package Github;

import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author shafiursarker
 * @version Sep 22, 2026
 */
public class ConsoleInput
{
    private final Scanner scanner;
    private final Validation validation;

    public ConsoleInput(Scanner scanner, Validation validation)
    {
        this.scanner = scanner;
        this.validation = validation;
    }


    public String readSex()
    {
        while (true)
        {
            String input = prompt("Sex (male/female): ");
            if (validation.validSex(input))
                return validation.normalize(input);
            reject(input, "please type male or female");
        }
    }


    public double readHeight()
    {
        return readPositiveNumber("Height in inches: ", "height");
    }


    public double readWeight()
    {
        return readPositiveNumber("Weight in pounds: ", "weight");
    }


    public double readCaffeineAmount()
    {
        return readPositiveNumber(
            "Caffeine in the drink (mg): ",
            "caffeine amount");
    }


    public String readDrinkName()
    {
        while (true)
        {
            String input = prompt("Drink name: ");
            if (validation.validDrinkName(input))
                return input.trim();
            if (validation.isBlank(input))
                reject(input, "drink name can't be blank");
            else
                reject(
                    input,
                    "drink name must be " + Validation.MAX_NAME_LENGTH
                        + " characters or less");
        }
    }


    public String readSize()
    {
        while (true)
        {
            String input = prompt("Size (small/medium/large): ");
            if (validation.validSize(input))
                return validation.normalize(input);
            reject(input, "size must be small, medium, or large");
        }
    }

    // Reads a clock time such as 14:30 or 14.5


    public double readTime(String message)
    {
        while (true)
        {
            String input = prompt(message);
            Double time = validation.parseTime(input);
            if (time == null)
            {
                reject(input, "enter a time like 14:30 or 14.5");
            }
            else if (!validation.validTime(time))
            {
                reject(input, "time must be between 0:00 and 23:59");
            }
            else
            {
                return time;
            }
        }
    }

    // Reads the time to check, which can't be before the earliest drink


    public double readRequestedTime(double earliestConsumed)
    {
        while (true)
        {
            double time =
                readTime("What time do you want to check (e.g. 18:00)? ");
            if (validation.validRequestedTime(time, earliestConsumed))
                return time;
            System.out.println(
                "  Rejected: that's before your first drink at "
                    + validation.formatTime(earliestConsumed) + ". Try again.");
        }
    }

    // Reads a menu number from 1 to max


    public int readMenuChoice(String message, int max)
    {
        while (true)
        {
            String input = prompt(message);
            Double n = validation.parseNumber(input);
            if (n != null && n == Math.floor(n) && n >= 1 && n <= max)
                return n.intValue();
            reject(input, "pick a number from 1 to " + max);
        }
    }


    public boolean readYesNo(String message)
    {
        while (true)
        {
            String input = validation.normalize(prompt(message));
            if (input.equals("y") || input.equals("yes"))
                return true;
            if (input.equals("n") || input.equals("no"))
                return false;
            reject(input, "please type y or n");
        }
    }


    private double readPositiveNumber(String message, String fieldName)
    {
        while (true)
        {
            String input = prompt(message);
            Double value = validation.parseNumber(input);
            if (value == null)
            {
                reject(input, fieldName + " must be a number");
            }
            else if (value <= 0)
            {
                reject(input, fieldName + " must be greater than zero");
            }
            else if (value > Validation.MAX_VALUE)
            {
                reject(
                    input,
                    fieldName + " is unreasonably large (max "
                        + (int)Validation.MAX_VALUE + ")");
            }
            else
            {
                return value;
            }
        }
    }


    private String prompt(String message)
    {
        System.out.print(message);
        if (!scanner.hasNextLine())
        {
            throw new IllegalStateException("Input ended unexpectedly.");
        }
        return scanner.nextLine();
    }


    private void reject(String input, String reason)
    {
        String shown =
            validation.isBlank(input) ? "(blank)" : "\"" + input.trim() + "\"";
        System.out
            .println("  Rejected " + shown + ": " + reason + ". Try again.");
    }
}
