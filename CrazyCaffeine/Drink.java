package CrazyCaffeine;

// -------------------------------------------------------------------------
/**
 * stores the info for drinks name, size, amount if caffeine
 * 
 * @author Nat
 * @version Sep 22, 2026
 */
public class Drink
{
    private String drinkName;
    private String size;
    private double caffeineAmount;
    private double timeConsumed;

    // ----------------------------------------------------------
    /**
     * creates a new drink with the given information
     * 
     * @param drinkName
     *            the name of the drink
     * @param size
     *            the size of the drink
     * @param caffeineAmount
     *            amount of caffeine in the drink (in mg)
     * @param timeConsumed
     *            when the drink is consumed
     */
    public Drink(
        String drinkName,
        String size,
        double caffeineAmount,
        double timeConsumed)
    {
        this.drinkName = drinkName;
        this.size = size;
        this.caffeineAmount = caffeineAmount;
        this.timeConsumed = timeConsumed;
    }


    // ----------------------------------------------------------
    /**
     * gets the name of the drink
     * 
     * @return drink name
     */
    public String getDrinkName()
    {
        return drinkName;
    }


    // ----------------------------------------------------------
    /**
     * gets the size of the drink
     * 
     * @return drink size
     */
    public String getSize()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * gets the amount of caffeine in the drink
     * 
     * @return amount in mg
     */
    public double getCaffeineAmount()
    {
        return caffeineAmount;
    }


    // ----------------------------------------------------------
    /**
     * asks for the time when the drink was consumed
     * 
     * @return time in 24-hour format
     */
    public double getTimeConsumed()
    {
        return timeConsumed;
    }
}
