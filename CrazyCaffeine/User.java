package CrazyCaffeine;

// -------------------------------------------------------------------------
/**
 * Stores the user's sex, height, and weight for the caffeine calculation.
 *
 * @author Luc Tran
 * @version Sep 22, 2026
 */
public class User
{
    /**
     * The user's sex.
     */
    private String sex;

    /**
     * The user's height in inches.
     */
    private double height;

    /**
     * The user's weight in pounds.
     */
    private double weight;

    /**
     * Creates a user from information validated before construction.
     *
     * @param sex
     *            the user's sex
     * @param height
     *            the user's height in inches
     * @param weight
     *            the user's weight in pounds
     */
    public User(String sex, double height, double weight)
    {
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }


    /**
     * Returns the user's sex.
     *
     * @return the user's sex
     */
    public String getSex()
    {
        return sex;
    }


    /**
     * Returns the user's height.
     *
     * @return the user's height in inches
     */
    public double getHeight()
    {
        return height;
    }


    /**
     * Returns the user's weight.
     *
     * @return the user's weight in pounds
     */
    public double getWeight()
    {
        return weight;
    }
}
