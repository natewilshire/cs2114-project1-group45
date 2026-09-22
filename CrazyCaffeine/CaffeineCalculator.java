package CrazyCaffeine;

import java.util.List;

// -------------------------------------------------------------------------
/**
 * calculates how much caffeine is left in the body at a requested time, using
 * exponential half-life decay
 * 
 * @author nate
 * @version Sep 22, 2026
 */
public class CaffeineCalculator
{
    /**
     * caffeine's average half-life in hours
     */
    public static final double half_life_hours = 5.0;

    // ----------------------------------------------------------
    /**
     * calculates how much caffeine from a single drink is left at the requested
     * time. Validation guarantees the requested time is on the same day as, and
     * not before, the drink's time consumed, so no midnight wraparound is
     * needed here.
     *
     * @param drink
     *            the drink to calculate for
     * @param requestedTime
     *            the time to check, on a 24-hour clock
     * @return the remaining caffeine in mg
     */
    public static
        double
        calculateCaffeineRemaining(Drink drink, double requestedTime)
    {
        double hoursPassed = requestedTime - drink.getTimeConsumed();
        // decay formula remaining = initial * (1/2) ^ (time elapsed /
        // half-life)
        return drink.getCaffeineAmount()
            * Math.pow(0.5, hoursPassed / half_life_hours);
    }


    // ----------------------------------------------------------
    /**
     * sums the remaining caffeine from every drink in the list at the requested
     * time
     *
     * @param drinks
     *            the drinks to include
     * @param requestedTime
     *            the time to check, on a 24-hour clock
     * @return the total remaining caffeine in mg
     */
    public static double calculateTotalCaffeineRemaining(
        List<Drink> drinks,
        double requestedTime)
    {
        double total = 0.0;
        for (Drink drink : drinks)
        {
            total += calculateCaffeineRemaining(drink, requestedTime);
        }
        return total;
    }

}
