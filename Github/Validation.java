package Github;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author shafiursarker
 * @version Sep 22, 2026
 */
public class Validation
{
    public static final double MAX_VALUE = 1000;   // anything above this is
                                                   // "unreasonably large"
    public static final double MIN_TIME = 0;       // 0:00 (midnight)
    public static final double MAX_TIME = 24;      // exclusive, 24:00 wraps to
                                                   // 0:00
    public static final int MAX_NAME_LENGTH = 50;

    public static final String[] VALID_SIZES = { "small", "medium", "large" };
    public static final String[] VALID_SEXES = { "male", "female" };

    // Drink name must not be blank and must be a reasonable length

    public boolean validDrinkName(String drinkName)
    {
        return !isBlank(drinkName)
            && drinkName.trim().length() <= MAX_NAME_LENGTH;
    }


    // Size must be one of VALID_SIZES
    public boolean validSize(String size)
    {
        return inList(size, VALID_SIZES);
    }


    // Time must be a real clock time: 0 <= time < 24
    public boolean validTime(double time)
    {
        return !Double.isNaN(time) && time >= MIN_TIME && time < MAX_TIME;
    }


    // Weight must be greater than zero and not unreasonably large
    public boolean validWeight(double weight)
    {
        return validPositive(weight);
    }


    // Height must be greater than zero and not unreasonably large
    public boolean validHeight(double height)
    {
        return validPositive(height);
    }

    // ---------- Extra checks the program needs ----------


    // Sex must be one of VALID_SEXES
    public boolean validSex(String sex)
    {
        return inList(sex, VALID_SEXES);
    }


    // Caffeine must be greater than zero and not unreasonably large
    public boolean validCaffeineAmount(double caffeine)
    {
        return validPositive(caffeine);
    }


    // The time asked about can't be before the drink was consumed
    public boolean validRequestedTime(double requestedTime, double timeConsumed)
    {
        return validTime(requestedTime) && requestedTime >= timeConsumed;
    }


    // Shared rule for every number: > 0 and <= MAX_VALUE
    public boolean validPositive(double value)
    {
        return !Double.isNaN(value) && value > 0 && value <= MAX_VALUE;
    }


    // True if the string is null, empty, or only spaces
    public boolean isBlank(String s)
    {
        return s == null || s.trim().isEmpty();
    }


    // Turns text into a number, or returns null if it isn't one
    public Double parseNumber(String text)
    {
        if (isBlank(text))
            return null;
        try
        {
            return Double.parseDouble(text.trim());
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }


    // Turns "14:30" or "14.5" into 14.5. Returns null if the text isn't a time
    public Double parseTime(String text)
    {
        if (isBlank(text))
            return null;
        text = text.trim();
        if (text.contains(":"))
        {
            String[] parts = text.split(":");
            if (parts.length != 2)
                return null;
            try
            {
                int hours = Integer.parseInt(parts[0].trim());
                int minutes = Integer.parseInt(parts[1].trim());
                if (minutes < 0 || minutes >= 60 || hours < 0)
                    return null;
                return hours + minutes / 60.0;
            }
            catch (NumberFormatException e)
            {
                return null;
            }
        }
        return parseNumber(text);
    }


    // Cleans up text input: trims and lowercases (for size / sex)
    public String normalize(String text)
    {
        return text == null ? "" : text.trim().toLowerCase();
    }


    // Turns 14.5 into "2:30 PM" for display
    public String formatTime(double time)
    {
        int totalMinutes = (int)Math.round(time * 60) % (24 * 60);
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        String amPm = hours < 12 ? "AM" : "PM";
        int displayHour = hours % 12 == 0 ? 12 : hours % 12;
        return String.format("%d:%02d %s", displayHour, minutes, amPm);
    }


    private boolean inList(String value, String[] options)
    {
        if (isBlank(value))
            return false;
        for (String option : options)
        {
            if (option.equalsIgnoreCase(value.trim()))
                return true;
        }
        return false;
    }
}
