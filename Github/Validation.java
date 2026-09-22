package Github;

// -------------------------------------------------------------------------
/**
 * checks user input before it is used to create users or drinks, true of false
 * or valid usage. If its a bad input asks again
 * 
 * @author shafiursarker
 * @version Sep 22, 2026
 */
public class Validation
{

    /**
     * Largest number accepted for height, weight, or caffeine
     */
    public static final double MAX_VALUE = 1000;

    /**
     * checks that the drink name is not blank
     *
     * @param drinkName
     *            the drink name to check
     * @return true if the drink name is not blank, false otherwise
     */
    public boolean validDrinkName(String drinkName)
    {
        if (drinkName == null)
        {
            return false;
        }
        return !drinkName.trim().equals("");
    }


    /**
     * checks that the size is small, medium, or large
     *
     * @param size
     *            the drink size to check
     * @return true if the size is small, medium, or large, false otherwise
     */
    public boolean validSize(String size)
    {
        if (size == null)
        {
            return false;
        }
        String s = size.trim().toLowerCase();
        return s.equals("small") || s.equals("medium") || s.equals("large");
    }


    /**
     * checks that the time is a real time on a 24-hour clock
     *
     * @param time
     *            the time to check
     * @return true if the time is at least 0 and less than 24, false otherwise
     */
    public boolean validTime(double time)
    {
        return time >= 0 && time < 24;
    }


    /**
     * checks that the weight is above 0
     *
     * @param weight
     *            the weight in pounds to check
     * @return true if the weight is above 0 and at most MAX_VALUE, false
     *             otherwise
     */
    public boolean validWeight(double weight)
    {
        return weight > 0 && weight <= MAX_VALUE;
    }


    /**
     * checks that the height is above 0
     *
     * @param height
     *            the height in inches to check
     * @return true if the height is above 0 and at most MAX_VALUE, false
     *             otherwise
     */
    public boolean validHeight(double height)
    {
        return height > 0 && height <= MAX_VALUE;
    }


    /**
     * checks that the sex is male or female
     *
     * @param sex
     *            the sex to check
     * @return true if the sex is male or female, false otherwise
     */
    public boolean validSex(String sex)
    {
        if (sex == null)
        {
            return false;
        }
        String s = sex.trim().toLowerCase();
        return s.equals("male") || s.equals("female");
    }


    /**
     * checks that the caffeine amount is above 0 and not unreasonably large
     *
     * @param caffeine
     *            the caffeine amount in mg to check
     * @return true if the caffeine is above 0 and at most MAX_VALUE, false
     *             otherwise
     */
    public boolean validCaffeineAmount(double caffeine)
    {
        return caffeine > 0 && caffeine <= MAX_VALUE;
    }


    /**
     * checks that the time the user wants to check is a valid time and is not
     * before the drink was consumed
     *
     * @param requestedTime
     *            the time the user wants to check
     * @param timeConsumed
     *            the time the drink was consumed
     * @return true if the requested time is valid and not before the drink,
     *             false otherwise
     */
    public boolean validRequestedTime(double requestedTime, double timeConsumed)
    {
        return validTime(requestedTime) && requestedTime >= timeConsumed;
    }
}
