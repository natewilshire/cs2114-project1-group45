package CrazyCaffeine;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * tests drink class
 * 
 * @author nate
 * @version Sep 22, 2026
 */
public class DrinkTest
    extends TestCase
{
    private Drink coffee;
    private Drink energyDrink;

    /**
     * creates two drinks with different info before each test
     */
    public void setUp()
    {
        coffee = new Drink("Coffee", "medium", 95, 8.5);
        energyDrink = new Drink("Energy Drink", "large", 160, 14);
    }


    /**
     * tests that getDrinkName returns the name given to the constructor
     */
    public void testGetDrinkName()
    {
        assertEquals("Coffee", coffee.getDrinkName());
        assertEquals("Energy Drink", energyDrink.getDrinkName());
    }


    /**
     * tests that getSize returns the size given to the constructor
     */
    public void testGetSize()
    {
        assertEquals("medium", coffee.getSize());
        assertEquals("large", energyDrink.getSize());
    }


    /**
     * tests that getCaffeineAmount returns the amount given to the constructor
     */
    public void testGetCaffeineAmount()
    {
        assertEquals(95.0, coffee.getCaffeineAmount(), 0.01);
        assertEquals(160.0, energyDrink.getCaffeineAmount(), 0.01);
    }


    /**
     * tests that getTimeConsumed returns the time given to the constructor,
     * including a decimal time and midnight
     */
    public void testGetTimeConsumed()
    {
        assertEquals(8.5, coffee.getTimeConsumed(), 0.01);
        assertEquals(14.0, energyDrink.getTimeConsumed(), 0.01);

        Drink midnight = new Drink("Tea", "small", 40, 0);
        assertEquals(0.0, midnight.getTimeConsumed(), 0.01);
    }


    /**
     * tests that two drinks keep their own info and don't change each other
     */
    public void testDrinksAreSeparate()
    {
        Drink secondCoffee = new Drink("Coffee", "small", 60, 10);
        assertEquals("medium", coffee.getSize());
        assertEquals("small", secondCoffee.getSize());
        assertEquals(95.0, coffee.getCaffeineAmount(), 0.01);
        assertEquals(60.0, secondCoffee.getCaffeineAmount(), 0.01);
    }
}
